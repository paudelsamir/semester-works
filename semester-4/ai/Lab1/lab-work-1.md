

## Title: Program to simulate Simple Reflex Agent for detecting source of water leakage in a house

### Theory:
A Simple Reflex Agent is a type of artificial intelligence agent that makes decisions based on the current perceived state of the environment, without considering past states or future consequences. In this case, we're using a simple reflex agent to detect the source of water leakage in a house.

The agent uses a set of predefined rules to determine the source of the leak based on sensor inputs. These sensors detect wetness in different areas of the house (hall, kitchen, bathroom) and the state of the window (open/closed) and whether it's raining.

The rules for our agent are:
1. If the hall is wet and the kitchen is dry, then there's a leak in the bathroom.
2. If the hall is wet and the bathroom is dry, then there's a problem in the kitchen.
3. If the window is closed or it's not raining, then it's confirmed that water is not from outside.
4. If there's no water from outside and the problem is in the kitchen, then the leak is in the kitchen.

### Code:
```python
def detect_leak(hall_wet, kitchen_wet, bathroom_wet, window_closed, raining):
    if hall_wet and not kitchen_wet:
        return "Leak in bathroom"
    elif hall_wet and not bathroom_wet:
        return "Problem in kitchen"
    elif window_closed or not raining:
        if kitchen_wet:
            return "Leak in kitchen"
        else:
            return "No leak detected"
    else:
        return "Water might be coming from outside"
    
hall_wet = input("Is the hall wet? (yes/no): ").lower() == 'yes'
kitchen_wet = input("Is the kitchen wet? (yes/no): ").lower() == 'yes'
bathroom_wet = input("Is the bathroom wet? (yes/no): ").lower() == 'yes'
window_closed = input("Is the window closed? (yes/no): ").lower() == 'yes'

raining = input("Is it raining? (yes/no): ").lower() == 'yes'

#run agent
result = detect_leak(hall_wet, kitchen_wet, bathroom_wet, window_closed, raining)

print("\nAgent's conclusion:", result)

print("\nLab No.: 1.1")
print("Name: Samir Paudel")
print("Roll No./Section: 114-079 / D")

```

### Graph Visualization:



### Output:
[Insert screenshot of the program's output here]

