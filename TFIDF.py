import sqlite3
import math

class TfIdfCalculator:
    def __init__(self):
        self.conn = sqlite3.connect('database.db')
        self.cursor = self.conn.cursor()

    def calculate_tf_idf(self):
        # Get the number of documents in the inverted index table
        self.cursor.execute("SELECT COUNT(DISTINCT websiteID) FROM inverted_index")
        total_documents = self.cursor.fetchone()[0]
        # Add the new tf_idf column to the inverted index table
        self.cursor.execute("ALTER TABLE inverted_index ADD COLUMN tf_idf REAL")
        self.conn.commit()

        # Calculate the TF-IDF for each word in each document
        self.cursor.execute("SELECT word, websiteID, frequency FROM inverted_index")
        words = self.cursor.fetchall()
        for word in words:
            word_text = word[0]
            website_id = word[1]
            frequency = word[2]
            print(website_id,'===',frequency)
            # TF weight
            self.cursor.execute("SELECT SUM(frequency) FROM inverted_index WHERE websiteID=?", (website_id,))
            total_words_in_document = self.cursor.fetchone()[0]
            tf = frequency / total_words_in_document

            # IDF weight
            self.cursor.execute("SELECT COUNT(DISTINCT websiteID) FROM inverted_index WHERE word=?", (word_text,))
            num_documents_with_word = self.cursor.fetchone()[0]
            idf = math.log10(total_documents / num_documents_with_word)

            #TF-IDF weight
            tf_idf = tf * idf

            self.cursor.execute("UPDATE inverted_index SET tf_idf=? WHERE word=? AND websiteID=?", (tf_idf, word_text, website_id))

        self.conn.commit()
        self.conn.close()

a = TfIdfCalculator()
a.calculate_tf_idf()