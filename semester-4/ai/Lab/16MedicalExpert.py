class MedicalExpertSystem:
    def __init__(self):
        self.knowledge_base = {
            "fever": ["flu", "covid-19", "malaria"],
            "cough": ["flu", "covid-19", "bronchitis"],
            "fatigue": ["flu", "covid-19", "anemia"],
            "shortness_of_breath": ["covid-19", "asthma", "heart disease"],
            "headache": ["flu", "migraine", "stress"],
            "rash": ["allergic reaction", "measles", "chickenpox"]
        }
    
    def diagnose(self, symptoms):
        possible_diseases = set()
        for symptom in symptoms:
            if symptom in self.knowledge_base:
                possible_diseases.update(self.knowledge_base[symptom])
        
        return list(possible_diseases)

# Create the expert system
expert_system = MedicalExpertSystem()

# Get symptoms from user
symptoms = input("Enter symptoms (comma-separated): ").lower().split(',')
symptoms = [s.strip() for s in symptoms]

# Get diagnosis
diagnosis = expert_system.diagnose(symptoms)

print(f"\nBased on the symptoms {', '.join(symptoms)}, possible conditions are:")
for disease in diagnosis:
    print(f"- {disease}")

print("\nPlease consult with a medical professional for accurate diagnosis.")

print("\nLab No.: 16")
print("Name: Samir Paudel")
print("Roll No./Section: 114/D")