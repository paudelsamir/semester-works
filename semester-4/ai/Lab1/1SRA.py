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
