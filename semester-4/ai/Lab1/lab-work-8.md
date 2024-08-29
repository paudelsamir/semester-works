# Lab Work 8

## Title: WAP to implement Hill Climbing (Steepest Ascent) Search

### Theory:
Hill Climbing is a local search algorithm that continuously moves in the direction of increasing value to find the peak of the mountain or the best solution to the problem. The Steepest Ascent variant evaluates all neighbors and selects the one with the best value. While simple and memory-efficient, hill climbing can get stuck in local maxima.

### Key characteristics of Hill Climbing (Steepest Ascent):
1. Completeness: Not complete, can get stuck in local maxima.
2. Optimality: Not optimal, finds local maxima but not necessarily global maxima.
3. Time Complexity: O(n) in the best case, O(∞) in the worst case where n is the number of states.
4. Space Complexity: O(1), as it only needs to store the current state.

### Applications of Hill Climbing:
Optimization problems in machine learning (e.g., training neural networks),
Job scheduling and resource allocation,
Circuit design and layout optimization,
Image processing and computer vision tasks

### Code:
```python
def hill_climbing(graph, start, goal, heuristic):
    current = start
    path = [current]
    
    while current != goal:
        neighbors = graph[current]
        if not neighbors:
            print("Reached a local maximum/stalemate at node:", current)
            return path
        next_node = min(neighbors, key=lambda n: heuristic[n], default=None)
        if heuristic[next_node] >= heuristic[current]:
            print("Reached a local maximum at node:", current)
            return path
        current = next_node
        path.append(current)
    
    print("Goal reached!")
    return path

graph = {
    'A': ['B', 'C'],
    'B': ['D'],
    'C': ['D'],
    'D': ['E', 'F'],
    'E': [],
    'F': ['G'],
    'G': [] 
}

heuristic = {
    'A': 6,
    'B': 4,
    'C': 5,
    'D': 3,
    'E': 2,
    'F': 1,
    'G': 0 
}

start = 'A'
goal = 'G'
path = hill_climbing(graph, start, goal, heuristic)

print("Path:", " -> ".join(path))

print("\nLab No.: 1.8")
print("Name: Samir Paudel")
print("Roll No./Section: 114079 / D")

```

### Graph Visualization:
```
    A(6)
   /  \
  B(4) C(5)
   \  /
    D(3)
   /  \
  E(2) F(1)
       |
       G(0)  <- Goal
```


### Output:
[Insert screenshot of the program's output here]
