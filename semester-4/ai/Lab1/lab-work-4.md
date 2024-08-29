
## Title: WAP to implement DFS for a graph

### Theory:
Depth-First Search (DFS) is a graph traversal algorithm that explores as far as possible along each branch before backtracking. Unlike BFS, which uses a queue, DFS typically uses a stack (or recursion) to keep track of the nodes to be explored. DFS is often simpler to implement than BFS, but it doesn't guarantee the shortest path in an unweighted graph.

### Key characteristics of DFS:
1. Memory Efficiency: DFS is typically more memory-efficient than BFS, especially for deep graphs.
2. Completeness: DFS is complete for finite graphs, meaning it will find a solution if one exists.
3. Non-optimality: DFS does not guarantee finding the shortest path in an unweighted graph.
4. Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
5. Space Complexity: O(h), where h is the maximum depth of the recursion stack.

### Applications of DFS:
Topological sorting
Finding connected components in a graph
Maze solving algorithms
Cycle detection in graphs

### Code:
```python
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

```
### Graph Visualization:
[Insert a hand-drawn or computer-generated image of the graph used in this example]

### Output:
[Insert screenshot of the program's output here]


