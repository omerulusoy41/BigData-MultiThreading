import csv
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize


def cleanStopWordAndPunction(row):
    stopWord = set(stopwords.words('english'))
    punc = {";","-","_","/",",",".","\"","?","!","(",")",":","%","*"}
    word_tokens = word_tokenize(row)
    result = ''
    for word in word_tokens:
        if word.lower() not in stopWord and word not in punc:
            result += word + " "
    if (result == ''):
        return row
    return result.strip()
                        
def dataClearing():
    with open("../../rows.csv",encoding='utf-8') as readingFile:
        csvReader = csv.reader(readingFile)
        with open("../../temiz.csv","w",encoding='utf-8') as writingFile:
            csvWriter = csv.writer(writingFile)
            for row in csvReader:
                if row != '' and  row[1] !="" and row[3] !="" and row[7] !="" and row[9] !="" and row[8] !="" and row[17]!="":
                    writingRow = [
                    cleanStopWordAndPunction(row[1]),
                    cleanStopWordAndPunction(row[3])
                    ,cleanStopWordAndPunction(row[7]),
                    cleanStopWordAndPunction(row[8]),
                    cleanStopWordAndPunction(row[9]),
                    cleanStopWordAndPunction(row[17])]
                    csvWriter.writerow(writingRow)

dataClearing()





    