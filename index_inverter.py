import sqlite3
from nltk.tokenize import word_tokenize
from indexer.index_cleaner import Cleaning
import time

class InvertedIndex:
    def __init__(self):
        self.start_time = time.time()
        self.conn = sqlite3.connect('database.db')
        self.cursor = self.conn.cursor()
        self.cursor.execute("""
            CREATE TABLE IF NOT EXISTS inverted_index (
                index_id INTEGER PRIMARY KEY AUTOINCREMENT,
                word TEXT NOT NULL,
                frequency INTEGER NOT NULL,
                websiteID INTEGER NOT NULL,
                FOREIGN KEY(websiteID) REFERENCES websites(websiteID))
        """)
    def index_websites(self): # Cleaning & Indexing then Create table 
        self.cursor.execute("SELECT websiteID, title, content FROM websites")
        websites = self.cursor.fetchall()
        try:
            for website in websites: # get data from table
                website_id = website[0]
                title = website[1]
                content = website[2]
                words = []
                if title:
                    title_words = Cleaning(title)
                    words += title_words.process_text()
                if content:
                    content_words = Cleaning(content)
                    words += content_words.process_text()
                word_freq = {}
                counter = 0
                for word in words:
                    counter += 1 
                    if word in word_freq:
                        word_freq[word] += 1
                    else:
                        word_freq[word] = 1
                for word, frequency in word_freq.items():
                    self.cursor.execute("INSERT INTO inverted_index (word, websiteID, frequency) VALUES (?, ?, ?)", (word, website_id, frequency))
            self.conn.commit()
        except KeyboardInterrupt:
            self.conn.commit()
        print('finished')
        print("--- %s seconds ---" % (time.time() - self.start_time))

    def search(self, query):
            word = Cleaning(query)
            words=word.process_text()
            # Build the SQL query
            sql_query = "SELECT SUM(inverted_index.tf_idf) as score, websites.* FROM inverted_index JOIN websites ON inverted_index.websiteID = websites.websiteID WHERE inverted_index.word in ("
            for i, word in enumerate(words):
                sql_query += "?"
                if i != len(words) - 1:
                    sql_query += ", "
            sql_query += ") GROUP BY inverted_index.websiteID ORDER BY score DESC"

            # Execute the query
            self.cursor.execute(sql_query, words)
            results = self.cursor.fetchall()

            # Display the results
            for result in results:
                score = result[0]
                website_id = result[1]
                URL = result[2]
                title = result[3]
                print("Website ID :", website_id,' , ',"Score::", score)
            print('finished')
            print("--- %s seconds ---" % (time.time() - self.start_time))

a=InvertedIndex()
#.index_websites()
a.search("Card")
print('done')