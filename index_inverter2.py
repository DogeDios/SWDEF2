import sqlite3
import re
import nltk
from nltk.tokenize import word_tokenize
from indexer.index_cleaner import Cleaning
import time

class InvertedIndex:
    def __init__(self):
        self.start_time = time.time()
        self.conn = sqlite3.connect('database.db')
        self.cursor = self.conn.cursor()
        self.cursor.execute("""
            CREATE TABLE IF NOT EXISTS inverted_index2 (
                index_id INTEGER PRIMARY KEY AUTOINCREMENT,
                word TEXT NOT NULL,
                website_frequency_dict TEXT NOT NULL
            )
        """)

    def index_websites(self):
        self.cursor.execute("SELECT websiteID, title, content FROM websites")
        websites = self.cursor.fetchall()
        for website in websites:
            website_id = website[0]
            print("Id = "+ str(website_id))
            title = website[1]
            content = website[2]
            # Tokenize
            words = []
            if title:
                title_words = Cleaning(title)
                words += title_words.process_text()
            if content:
                content_words = Cleaning(content)
                words += content_words.process_text()
            word_freq = {}
            for word in words:
                if word in word_freq:
                    word_freq[word] += 1
                else:
                    word_freq[word] = 1
            for word, frequency in word_freq.items():
                self.cursor.execute("SELECT * FROM inverted_index2 WHERE word=?", (word,))
                result = self.cursor.fetchone()
                if result:
                    website_frequency_dict = eval(result[2])
                    if website_id in website_frequency_dict:
                        website_frequency_dict[website_id] += frequency
                        print(website_id,frequency)
                    else:
                        website_frequency_dict[website_id] = frequency
                    self.cursor.execute("UPDATE inverted_index2 SET website_frequency_dict=? WHERE word=?", (str(website_frequency_dict), word))
                else:
                    website_frequency_dict = {website_id: frequency}
                    self.cursor.execute("INSERT INTO inverted_index2 (word, website_frequency_dict) VALUES (?, ?)", (word, str(website_frequency_dict)))
        self.conn.commit()
        print('finished')
        print("--- %s seconds ---" % (time.time() - self.start_time))

    def search(self,query):
        word = Cleaning(query)
        words=word.process_text()
        sql_query = "SELECT website_frequency_dict FROM inverted_index2   WHERE inverted_index2.word in ("
        for i, word in enumerate(words):
            sql_query += "?"
            if i != len(words) - 1:
                sql_query += ", "
        sql_query += ")"
        self.cursor.execute(sql_query, words)
        results = self.cursor.fetchall()
        result=eval(results[0][0])
        sorted_result = sorted(result.items(), key=lambda x: x[1], reverse=True)
        for web_id, freq in sorted_result:
            print("Website ID: {}, Frequency: {}".format(web_id, freq))
        print('finished')
        print("--- %s seconds ---" % (time.time() - self.start_time))


inv=InvertedIndex()
#inv.index_websites()

inv.search('card')