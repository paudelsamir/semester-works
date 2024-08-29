
## Title: WAP to implement greedy best first search

### Theory:
Greedy Best-First Search is an informed search algorithm that uses a heuristic function to estimate the cost from the current node to the goal. It always expands the node that appears to be closest to the goal, based on the heuristic function. While this can be very efficient, it does not guarantee the optimal solution.
### Key characteristics of Greedy Best-First Search:
1. Completeness: Not complete, may get stuck in loops or fail to find a solution.
2. Optimality: Not optimal, as it may not find the best solution.
3. Time Complexity: O(b^m) in the worst case, but often much faster in practice.
4. Space Complexity: O(b^m), where b is the branching factor and m is the maximum depth of the search space.

### Applications of Greedy Best-First Search:

Pathfinding in video games,
Solving puzzles like the 8-puzzle or 15-puzzle,
Network routing protocols,
Resource allocation in constrained environments

### Code:
```python
import heapq

def best_first_search(graph, start, goal, heuristic):
    queue = [(heuristic[start], start)]
    visited = set()

    while queue:
        _, vertex = heapq.heappop(queue)
        print(vertex, end=" ")
        if vertex == goal:
            return
        if vertex not in visited:
            visited.add(vertex)
            for neighbor in graph[vertex]:
                heapq.heappush(queue, (heuristic[neighbor], neighbor))

# Example usage:
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': [],
    'F': []
}
heuristic = {
    'A': 3,
    'B': 2,
    'C': 1,
    'D': 6,
    'E': 4,
    'F': 0
}
print("Best First Search (starting from vertex A):")
best_first_search(graph, 'A', 'F', heuristic)


print("\nLab No.: 1.6")
print("Name: Samir Paudel")
print("Roll No./Section: 114079 / D")

```
### Graph Visualization:
```
         A
        /  \
       B    C
      / \  / \
     D   E F  G
```
### Output:
[Insert screenshot of the program's output here]
