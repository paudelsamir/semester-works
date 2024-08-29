def solve_cryptarithmetic():
    for s in range(1, 10):
        for e in range(10):
            for n in range(10):
                for d in range(10):
                    for m in range(1, 10):
                        for o in range(10):
                            for r in range(10):
                                for y in range(10):
                                    if len(set([s, e, n, d, m, o, r, y])) == 8: 
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

print("\nLab No.: 1.9")
print("Name: Samir Paudel")
print("Roll No./Section: 114/079 / D")