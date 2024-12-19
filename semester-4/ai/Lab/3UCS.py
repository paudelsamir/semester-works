import heapq

def ucs(graph, start, goal):
    queue = [(0, start, [])]
    visited = set()

    while queue:
        (cost, node, path) = heapq.heappop(queue)

        if node not in visited:
            visited.add(node)
            path = path + [node]
            print(node, end=" ")

            if node == goal:
                print("\nGoal found!")
                return cost, path

            for neighbor, step_cost in graph[node].items():
                if neighbor not in visited:
                    heapq.heappush(queue, (cost + step_cost, neighbor, path))

    return float("inf"), []


graph = {
    "A": {"B": 4, "C": 2},
    "B": {"D": 3, "E": 1},
    "C": {"B": 1, "D": 5},
    "D": {"E": 2},
    "E": {"F": 5},
    "F": {},
}

start = input("Enter the start node: ")
goal = input("Enter the goal node: ")

print(f"Uniform Cost Search (from {start} to {goal}):")
cost, path = ucs(graph, start, goal)

if path:
    print(f"Shortest path: {' -> '.join(path)}")
    print(f"Total cost: {cost}")
else:
    print("No path found")

print("\nLab No.: 3")
print("Name: Samir Paudel")
print("Roll No./Section: 114/ D")
