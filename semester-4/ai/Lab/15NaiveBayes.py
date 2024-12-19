from sklearn.naive_bayes import BernoulliNB
from sklearn.preprocessing import LabelEncoder
import numpy as np

# Data
data = np.array(
    [
        ["young", "high"],
        ["young", "low"],
        ["middle-aged", "low"],
        ["old", "high"],
        ["old", "low"],
    ]
)
target = ["no", "no", "no", "yes", "no"]

# Label Encoding
le = LabelEncoder()
age = le.fit_transform(data[:, 0])    # Transform age column
income = le.fit_transform(data[:, 1])  # Transform income column
features = np.vstack((age, income)).T  # Stack both encoded columns as features
target_encoded = le.fit_transform(target)  # Encode the target (no/yes)

# Bernoulli Naive Bayes Classifier
nb = BernoulliNB()
nb.fit(features, target_encoded)  # Corrected to 'features'

# Prediction
predictions = nb.predict(features)
accuracy = np.mean(predictions == target_encoded)
print(f"Accuracy: {accuracy * 100:.2f}%")

# Prediction for new data (young, high income)
new_data = np.array([[0, 0]])  # Corresponds to [young, high]
predicted = nb.predict(new_data)
predicted_label = le.inverse_transform(predicted)
print(f"Predicted class for new data (young, high income): {predicted_label[0]}")

print("Lab no: 15")
print("Name: Samir Paudel")
print("Roll No: 114")
print("Section: D")
