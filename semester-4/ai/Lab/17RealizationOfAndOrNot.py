import numpy as np

def step_function(x):
    return 1 if x >= 0 else 0

class LogicGate:
    def __init__(self, weights, bias):
        self.weights = weights
        self.bias = bias

    def predict(self, inputs):
        sum_inputs = np.dot(inputs, self.weights) + self.bias
        return step_function(sum_inputs)

# AND Gate
and_gate = LogicGate(weights=[1, 1], bias=-1.5)

# OR Gate
or_gate = LogicGate(weights=[1, 1], bias=-0.5)

# NOT Gate
not_gate = LogicGate(weights=[-1], bias=0.5)

# Test the gates
print("AND Gate:")
print(f"0 AND 0 = {and_gate.predict([0, 0])}")
print(f"0 AND 1 = {and_gate.predict([0, 1])}")
print(f"1 AND 0 = {and_gate.predict([1, 0])}")
print(f"1 AND 1 = {and_gate.predict([1, 1])}")

print("\nOR Gate:")
print(f"0 OR 0 = {or_gate.predict([0, 0])}")
print(f"0 OR 1 = {or_gate.predict([0, 1])}")
print(f"1 OR 0 = {or_gate.predict([1, 0])}")
print(f"1 OR 1 = {or_gate.predict([1, 1])}")

print("\nNOT Gate:")
print(f"NOT 0 = {not_gate.predict([0])}")
print(f"NOT 1 = {not_gate.predict([1])}")

print("\nLab No.: 17")
print("Name: Samir Paudel")
print("Roll No: 114")
print("Section:D")
