

## Title: WAP to implement BFS for a graph

### Theory:
Breadth-First Search (BFS) is a graph traversal algorithm that explores all the vertices of a graph or tree at the present depth before moving on to the vertices at the next depth level. It uses a queue data structure to keep track of the vertices to be explored next.

BFS is particularly useful for finding the shortest path between two vertices in an unweighted graph, as it explores vertices in order of their distance from the starting vertex.

### Key characteristics of BFS:
1. Completeness: BFS is complete, meaning it will find a solution if one exists.
2. Optimality: For unweighted graphs, BFS finds the shortest path between the start node and any other node.
3. Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
4. Space Complexity: O(V), as in the worst case, all vertices might be in the queue.

### Code:
```python
from collections import deque

def bfs(graph, start):
    visited = set()
    queue = deque([start])
    visited.add(start)
    
    while queue:
        vertex = queue.popleft()
        print(vertex, end=" ")
        
        for neighbor in graph[vertex]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)

graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

print("Breadth First Traversal (starting from vertex A):")
bfs(graph, 'A')

print("\n\nLab No.: 1.2")
print("Name: Samir Paudel")
print("Roll No./Section: 114-079 / D")

```
### Graph Visualization:
[Insert a hand-drawn or computer-generated image of the graph used in this example]

### Output:
[Insert screenshot of the program's output here]

