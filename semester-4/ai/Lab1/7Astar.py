import heapq

def a_star_search(graph, start, goal, heuristic):
    queue = [(0, start)]
    costs = {start: 0}
    parents = {start: None}
    visited = set()

    while queue:
        _, vertex = heapq.heappop(queue)
        if vertex == goal:
            # Reconstruct the path from start to goal
            path = []
            while vertex:
                path.append(vertex)
                vertex = parents[vertex]
            path.reverse()
            return costs[goal], path
        
        visited.add(vertex)
        for neighbor, weight in graph[vertex]:
            new_cost = costs[vertex] + weight
            if neighbor not in costs or new_cost < costs[neighbor]:
                costs[neighbor] = new_cost
                parents[neighbor] = vertex
                heapq.heappush(queue, (new_cost + heuristic[neighbor], neighbor))

# Example usage:
graph = {
    'A': [('B', 1), ('C', 2)],
    'B': [('D', 4), ('C', 3)],
    'C': [('D', 1)],
    'D': [('E', 2)],
    'E': []
}
heuristic = {
    'A': 6,
    'B': 4,
    'C': 2,
    'D': 1,
    'E': 0
}

cost, path = a_star_search(graph, 'A', 'E', heuristic)
print("Cost to reach goal:", cost)
print("Path:", " -> ".join(path))



print("\nLab No.: 1.7")
print("Name: Samir Paudel")
print("Roll No./Section: 114-079 / D")



