# Lab Work 7

## Title: WAP to implement A* search

### Theory:
A* (A-star) search is an informed search algorithm that combines the benefits of both Uniform Cost Search and Greedy Best-First Search. It uses a heuristic function to estimate the cost from the current node to the goal, and also considers the cost of the path from the start to the current node. A* is complete and optimal when using an admissible heuristic.
### Key characteristics of A* Search:
1. Completeness: Complete if the branching factor is finite and every action has a cost greater than some small positive constant.
2. Optimality: Optimal if the heuristic function is admissible (never overestimates the cost to the goal).
3. Time Complexity: Exponential in the worst case, but often performs much better in practice.
4. Space Complexity: Exponential, as it stores all generated nodes in memory.

### Applications of A* Search:
Pathfinding in maps and navigation systems,
Robot motion planning,
Game AI for strategy games,
Network routing optimization
### Code:
```python
import heapq

def a_star_search(graph, start, goal, heuristic):
    queue = [(0, start)]
    costs = {start: 0}
    parents = {start: None}
    visited = set()

    while queue:
        _, vertex = heapq.heappop(queue)
        if vertex == goal:
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

print("\nLab No.: 7")
print("Name: Samir Paudel")
print("Roll No./Section: 114/079 / D")
```

### Graph Visualization:
```
      A
     / \
    1   2
   /     \
  B---3---C
   \     /
    4   1
     \ /
      D
       \
        2
         \
          E
```         
### Output:
[Insert screenshot of the program's output here]

