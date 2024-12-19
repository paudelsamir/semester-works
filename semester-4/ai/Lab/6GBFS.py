import heapq

def best_first_search(graph, start, goal, heuristic):
    queue = [(heuristic[start], start)]
    visited = set()
    while queue:
        _, vertex = heapq.heappop(queue)
        print(vertex, end=" ")
        if vertex == goal:
            print("\nGoal found!")
            return
        if vertex not in visited:
            visited.add(vertex)
            for neighbor in graph[vertex]:
                if neighbor not in visited:
                    heapq.heappush(queue, (heuristic[neighbor], neighbor))
    print("\nGoal not found!")

graph = {'A': ['B', 'C'], 'B': ['D', 'E'], 'C': ['F'], 'D': [], 'E': [], 'F': []}
heuristic = {'A': 3, 'B': 2, 'C': 1, 'D': 6, 'E': 4, 'F': 0}

start = input("Enter the start node: ")
goal = input("Enter the goal node: ")

print(f"Best First Search (from {start} to {goal}):")
best_first_search(graph, start, goal, heuristic)

print("\nLab No.:6")
print("Name: Samir Paudel")
print("Roll No./Section: 114 / D")
