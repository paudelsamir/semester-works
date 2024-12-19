def dls(graph, start, goal, depth_limit):
    def dls_util(node, goal, depth, path):
        print(node, end=' ')
        if node == goal:
            print("\nGoal found!")
            return path
        if depth == 0:
            return None
        for neighbor in graph[node]:
            result = dls_util(neighbor, goal, depth - 1, path + [neighbor])
            if result:
                return result
        return None
    return dls_util(start, goal, depth_limit, [start])

graph = {
    0: [1, 2],
    1: [3, 4],
    2: [5, 6],
    3: [],
    4: [],
    5: [],
    6: []
    }

start = int(input("Enter the start node: "))
goal = int(input("Enter the goal node: "))
depth_limit = int(input("Enter the depth limit: "))

print(f"Depth Limited Search (from {start} to {goal}, depth limit {depth_limit}):")
result = dls(graph, start, goal, depth_limit)

if result:
    print(f"Path found within depth limit {depth_limit}: {' -> '.join(map(str, result))}")
else:
    print(f"No path found within depth limit {depth_limit}")

print("\nLab No.:5")
print("Name: Samir Paudel")
print("Roll No./Section: 114 / D")
