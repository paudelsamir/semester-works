

## Title: WAP to implement Uniform-cost search

### Theory:
Uniform-cost search is a graph search algorithm that finds the lowest-cost path from a starting node to a goal node. It's similar to Breadth-First Search but uses a priority queue instead of a regular queue. The priority is determined by the cumulative cost of reaching the node. Uniform-cost search is complete and optimal when the cost of each step is non-negative.

### Key characteristics of Uniform-cost search:
1. Optimality: It always finds the lowest-cost path to the goal.
2. Completeness: It's complete if the cost of each step is non-negative.
3. Time Complexity: O(b^(C*/ε)), where b is the branching factor, C* is the cost of the optimal solution, and ε is the minimum cost of an action.
4. Space Complexity: O(b^(C*/ε)), as it needs to store all generated nodes.

### Applications of Uniform-cost search:

Route planning in navigation systems
Network routing protocols
Resource allocation in systems with varying costs

### Code:
```python
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

```
### Graph Visualization:


### Output:
[Insert screenshot of the program's output here]

