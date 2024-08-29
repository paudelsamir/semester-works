# Lab Work 9

## Title: WAP to solve any one Cryptarithmetic Problem (like TWO + TWO = FOUR or SEND + MORE = MONEY)

### Theory:
Cryptarithmetic problems are mathematical puzzles where digits are represented by letters. Each letter represents a unique digit, and the goal is to find the digit assignment that satisfies the given arithmetic equation. This implementation uses a backtracking algorithm to solve the SEND + MORE = MONEY problem.

### Key characteristics of Cryptarithmetic Problem Solving:
1. Completeness: Complete, as it explores all possible digit assignments.
2. Optimality: Optimal, as it finds the correct solution if one exists.
3. Time Complexity: O(10!) in the worst case, as there are 10! possible digit assignments.
4. Space Complexity: O(n), where n is the number of unique letters in the problem.

### Applications of Cryptarithmetic Problem Solving:
Puzzle solving and recreational mathematics,
Code breaking and cryptography education,
Constraint satisfaction problems in artificial intelligence,
Logical reasoning and problem-solving skill development

### Code:
```python
def solve_cryptarithmetic():
    for s in range(1, 10):  # S cannot be 0
        for e in range(10):
            for n in range(10):
                for d in range(10):
                    for m in range(1, 10):  # M cannot be 0
                        for o in range(10):
                            for r in range(10):
                                for y in range(10):
                                    if len(set([s, e, n, d, m, o, r, y])) == 8:  # All digits are different
                                        send = 1000 * s + 100 * e + 10 * n + d
                                        more = 1000 * m + 100 * o + 10 * r + e
                                        money = 10000 * m + 1000 * o + 100 * n + 10 * e + y
                                        
                                        if send + more == money:
                                            return {
                                                'S': s, 'E': e, 'N': n, 'D': d,
                                                'M': m, 'O': o, 'R': r, 'Y': y
                                            }
    return None

solution = solve_cryptarithmetic()

if solution:
    print("Solution found:")
    for letter, digit in solution.items():
        print(f"{letter} = {digit}")
    
    # Verify the solution
    send = 1000 * solution['S'] + 100 * solution['E'] + 10 * solution['N'] + solution['D']
    more = 1000 * solution['M'] + 100 * solution['O'] + 10 * solution['R'] + solution['E']
    money = 10000 * solution['M'] + 1000 * solution['O'] + 100 * solution['N'] + 10 * solution['E'] + solution['Y']
    
    print(f"\nVerification:")
    print(f"  {send}")
    print(f"+ {more}")
    print(f"-------")
    print(f" {money}")
else:
    print("No solution found")

print("\nLab No.: 9")
print("Name: Samir Paudel")
print("Roll No./Section: 114/079 / D")
```

### Graph Visualization:
```
```


### Output:
[Insert screenshot of the program's output here]