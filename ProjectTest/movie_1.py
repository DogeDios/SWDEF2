import pandas as pd
from bs4 import BeautifulSoup
import requests

class themovieDB():
    def __init__(self,link):
        self.url = requests.get(link)
        self.html_doc = BeautifulSoup(self.url.text,'html.parser')

    def get_movies_names(self):
        #Function to get movies names from website. 

        movies_names_tags = self.html_doc.find_all('h2')[4:]  #ข้างใน web header 4 ตัวแรกจะเป็นอย่างอื่นที่ไม่ใช่ชื่อ
        movies_names = []

        # Loop through the page to get all the movie names from the page
        for h2 in movies_names_tags:
            movies_names.append(h2.a.text.strip())

        return movies_names

    def get_movies_rating(self):
        #Function to get rateing from website through bs4. 

        desc_selector = 'user_score_chart'
        movies_rating_tags = self.html_doc.find_all('div', {'class': desc_selector})
        movies_rating = []

        # Loop through the webpage to get the ratings of all the movies in the page.
        for tag in movies_rating_tags:
            movies_rating.append(tag.attrs['data-percent'])
        return movies_rating

    def Movie_CSV(self):
        # Function to make a CSV file of Data from the website

        d = {'Movies':self.get_movies_names,'Rate':self.get_movies_rating}
        df = pd.DataFrame([d], columns=['Movies','Rate'])
        df.to_csv('movies.csv', index=False)
        df

movie = themovieDB('https://www.themoviedb.org/movie')
movie.Movie_CSV()