def hill_climbing(graph, start, goal, heuristic):
    current = start
    path = [current]
    
    while current != goal:
        neighbors = graph[current]
        if not neighbors:
            print("Reached a local maximum/stalemate at node:", current)
            return path
        next_node = min(neighbors, key=lambda n: heuristic[n], default=None)
        
        if heuristic[next_node] >= heuristic[current]:
            print("Reached a local maximum at node:", current)
            return path

        current = next_node
        path.append(current)
    
    print("Goal reached!")
    return path

graph = {
    'A': ['B', 'C'],
    'B': ['D'],
    'C': ['D'],
    'D': ['E', 'F'],
    'E': [],
    'F': ['G'],
    'G': [] 
}

heuristic = {
    'A': 6,
    'B': 4,
    'C': 5,
    'D': 3,
    'E': 2,
    'F': 1,
    'G': 0 
}

start = 'A'
goal = 'G'
path = hill_climbing(graph, start, goal, heuristic)

print("Path:", " -> ".join(path))

print("\nLab No.: 1.8")
print("Name: Samir Paudel")
print("Roll No./Section: 114079 / D")
