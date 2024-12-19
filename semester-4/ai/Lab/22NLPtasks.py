import nltk
from nltk.corpus import stopwords
from nltk.tokenize import sent_tokenize, word_tokenize
from nltk.stem import PorterStemmer
from nltk import pos_tag

# Specify the nltk_data path
nltk.data.path.append('C:/Users/samir/AppData/Roaming/nltk_data')

# Ensure required NLTK resources are available
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('averaged_perceptron_tagger')

# Sample text for NLP tasks
sample_text = "Artificial Intelligence is rapidly transforming various industries, making processes smarter and more efficient."

# Tokenizing sentences
tokenized_sentences = sent_tokenize(sample_text)
print("Sentences after tokenization:")
for sent in tokenized_sentences:
    print(sent)

# Tokenizing words
tokenized_words = word_tokenize(sample_text)
print("\nWords after tokenization:")
print(tokenized_words)

# Removing stop words
stop_words_set = set(stopwords.words('english'))
cleaned_words = [w for w in tokenized_words if w.lower() not in stop_words_set]
print("\nWords after removing stop words:")
print(cleaned_words)

# Applying word stemming
stemmer = PorterStemmer()
stemmed_output = [stemmer.stem(w) for w in cleaned_words]
print("\nStemmed words:")
print(stemmed_output)

# Part-of-speech tagging
pos_tagged_words = pos_tag(tokenized_words)
print("\nPOS Tags:")
print(pos_tagged_words)

print("Lab Task: 22")
print("Prepared by: Samir Paudel")
print("Roll Number: 114")
print("Section: D")
