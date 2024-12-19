from collections import deque

def water_jug_bfs(capacity_x, capacity_y, target):
    visited = set()
    queue = deque([(0, 0, [])])

    while queue:
        x, y, path = queue.popleft()

        if x == target or y == target:
            return path + [(x, y)]

        if (x, y) in visited:
            continue

        visited.add((x, y))

        # Fill jug X
        queue.append((capacity_x, y, path + [(x, y), ('fill X', '')]))

        # Fill jug Y
        queue.append((x, capacity_y, path + [(x, y), ('fill Y', '')]))

        # Empty jug X
        queue.append((0, y, path + [(x, y), ('empty X', '')]))

        # Empty jug Y
        queue.append((x, 0, path + [(x, y), ('empty Y', '')]))

        # Pour from X to Y
        amount = min(x, capacity_y - y)
        queue.append((x - amount, y + amount, path + [(x, y), ('X to Y', f'{amount}')]))

        # Pour from Y to X
        amount = min(y, capacity_x - x)
        queue.append((x + amount, y - amount, path + [(x, y), ('Y to X', f'{amount}')]))

    return None

def print_solution(solution):
    for i, step in enumerate(solution):
        if isinstance(step[0], str):
            print(f"Step {i}: {step[0]} {step[1]}")
        else:
            print(f"State: Jug X = {step[0]}, Jug Y = {step[1]}")

# Solve the Water Jug Problem
capacity_x, capacity_y, target = 4, 3, 2
solution = water_jug_bfs(capacity_x, capacity_y, target)

if solution:
    print(f"Solution to get {target} gallons:")
    print_solution(solution)
else:
    print("No solution found.")

print("Lab No.: 20")
print("Name: Samir Paudel")
print("Roll No: 114")
print("Section:D")
