def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    
    visited.add(start)
    print(start, end=' ')
    
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)

graph = {
    0: [1, 2],
    1: [2],
    2: [0, 3],
    3: [3]
}

print("Depth First Traversal (starting from vertex 2):")
dfs(graph, 2)

print("\n\nLab No.: 1.4")
print("Name: Samir Paudel")
print("Roll No./Section: 114-079 / D")
