def dls(graph, start, goal, depth_limit):
    def dls_util(node, goal, depth):
        if node == goal:
            return [node]
        if depth == 0:
            return None
        
        for neighbor in graph[node]:
            path = dls_util(neighbor, goal, depth - 1)
            if path:
                return [node] + path
        
        return None
    
    return dls_util(start, goal, depth_limit)

graph = {
    0: [1, 2],
    1: [3, 4],
    2: [5, 6],
    3: [], 4: [], 5: [], 6: []
}

start = 0
goal = 6
depth_limit = 2

result = dls(graph, start, goal, depth_limit)
if result:
    print(f"Path found within depth limit {depth_limit}: {result}")
else:
    print(f"No path found within depth limit {depth_limit}")

print("\nLab No.: 1.5")
print("Name: Samir Paudel")
print("Roll No./Section: 114-079 / D")
