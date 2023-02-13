import re
from nltk.corpus import stopwords
from nltk.stem.porter import PorterStemmer
from nltk.stem import WordNetLemmatizer
from nltk.corpus import wordnet 
from nltk.tokenize import word_tokenize

class Cleaning:
    def __init__(self):
        pass
        #print(self.content)
    def Normalize(self,doc):
        return doc.lower()

    def Remove_uni(self,doc):
        doc_no_uni = re.sub(r"(@\[A-Za-z0-9]+)|([^0-9A-Za-z \t])|(\w+:\/\/\S+)|^rt|http.+?", "", doc)
        return doc_no_uni

    def Remove_stopw(self,doc):
        stop=stopwords.words('english')
        remove_stop=" ".join([word for word in word_tokenize(doc) if word not in (stop)])
        return remove_stop
        
    def Lemma(self,doc):
        lemmatizer = WordNetLemmatizer()
        dum=[]
        list_of_word=word_tokenize(doc)
        list_of_word.sort()
        for word in list_of_word:
            if word[-2:]=='ed' or word[-3:]=='ing':
                dum.append(lemmatizer.lemmatize(word,'v'))
            else:
                dum.append(lemmatizer.lemmatize(word))
        return dum

    def cleantext(self,doc):
        self.contents=doc
        self.content=''
        for word in self.contents:
            self.content += word
        self.Normalize()