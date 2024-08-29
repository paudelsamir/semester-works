import heapq

def best_first_search(graph, start, goal, heuristic):
    queue = [(heuristic[start], start)]
    visited = set()

    while queue:
        _, vertex = heapq.heappop(queue)
        print(vertex, end=" ")
        if vertex == goal:
            return
        if vertex not in visited:
            visited.add(vertex)
            for neighbor in graph[vertex]:
                heapq.heappush(queue, (heuristic[neighbor], neighbor))

# Example usage:
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': [],
    'F': []
}
heuristic = {
    'A': 3,
    'B': 2,
    'C': 1,
    'D': 6,
    'E': 4,
    'F': 0
}
print("Best First Search (starting from vertex A):")
best_first_search(graph, 'A', 'F', heuristic)


print("\nLab No.: 1.6")
print("Name: Samir Paudel")
print("Roll No./Section: 114079 / D")
