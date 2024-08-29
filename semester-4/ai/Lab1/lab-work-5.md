
## Title: WAP to implement Depth limited search for a graph

### Theory:
Depth Limited Search (DLS) is a variant of depth-first search where the search is limited to a maximum depth. This addresses the issue of DFS potentially getting stuck in infinite loops or very deep paths. DLS is particularly useful when we know that all solutions will be at a limited depth from the root.
### Key characteristics of Depth Limited Search:
1. Completeness: Complete only if the solution is within the depth limit.
2. Optimality: Not optimal, as it may not find the shallowest goal state.
3. Time Complexity: O(b^L), where b is the branching factor and L is the depth limit.
4. Space Complexity: O(bL), linear space relative to the depth limit.

### Applications of Depth Limited Search:

Game playing algorithms with a fixed number of moves,
Puzzle solving with known maximum solution depth,
Network routing with hop limits,
Web crawling with depth restrictions
### Code:
```python
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

```
### Graph Visualization:


### Output:
[Insert screenshot of the program's output here]



