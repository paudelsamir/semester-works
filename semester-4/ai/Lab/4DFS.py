def dfs(graph, start, goal):
    visited = set()
    path = []
    
    def dfs_helper(vertex):
        visited.add(vertex)
        path.append(vertex)
        print(vertex, end=" ")
        if vertex == goal:
            print("\nGoal found!")
            return True
        for neighbor in graph[vertex]:
            if neighbor not in visited:
                if dfs_helper(neighbor):
                    return True
        path.pop()
        return False
    
    if dfs_helper(start):
        return path
    else:
        return None

graph = {0: [1, 2], 1: [2], 2: [0, 3], 3: [3]}
start = int(input("Enter the start node: "))
goal = int(input("Enter the goal node: "))

print(f"Depth First Traversal (from {start} to {goal}):")
result = dfs(graph, start, goal)

print("\nLab No.: 4")
print("Name: Samir Paudel")
print("Roll No./Section: 114/ D")
