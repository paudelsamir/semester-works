from collections import deque

def bfs(graph, start, goal):
    visited = set()
    queue = deque([(start, [start])])
    visited.add(start)
    
    while queue:
        (vertex, path) = queue.popleft()
        print(vertex, end=" ")
        
        if vertex == goal:
            print("\nGoal found!")
            return path
        
        for neighbor in graph[vertex]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append((neighbor, path + [neighbor]))
    
    return None

graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

start = input("Enter the start node: ").upper()
goal = input("Enter the goal node: ").upper()

print(f"\nBreadth First Traversal (from {start} to {goal}):")
path = bfs(graph, start, goal)

if path:
    print("Path found:", ' -> '.join(path))
else:
    print("No path found")

print("\nLab No.: 2")
print("Name:Samir Paudel ")
print("Roll No./Section:114/D ")