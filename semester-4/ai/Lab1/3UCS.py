import heapq

def ucs(graph, start, goal):
    queue = [(0, start, [])]
    visited = set()

    while queue:
        (cost, node, path) = heapq.heappop(queue)
        
        if node not in visited:
            visited.add(node)
            path = path + [node]

            if node == goal:
                return cost, path

            for neighbor, step_cost in graph[node].items():
                if neighbor not in visited:
                    heapq.heappush(queue, (cost + step_cost, neighbor, path))
    
    return float('inf'), []

graph = {
    'A': {'B': 4, 'C': 2},
    'B': {'D': 3, 'E': 1},
    'C': {'B': 1, 'D': 5},
    'D': {'E': 2},
    'E': {'Goal': 5},
    'Goal': {}
}

cost, path = ucs(graph, 'A', 'Goal')
print(f"Shortest path: {' -> '.join(path)}")
print(f"Total cost: {cost}")

print("\nLab No.: 1.3")
print("Name: Samir Paudel")
print("Roll No./Section: 114-079 / D")
