def is_safe(board, row, col, n):
    # Check this row on left side
    for i in range(col):
        if board[row][i] == 1:
            return False

    # Check upper diagonal on left side
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    # Check lower diagonal on left side
    for i, j in zip(range(row, n, 1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    return True

def solve_nq_util(board, col, n):
    if col >= n:
        return True

    for i in range(n):
        if is_safe(board, i, col, n):
            board[i][col] = 1
            if solve_nq_util(board, col + 1, n):
                return True
            board[i][col] = 0

    return False

def solve_nq(n):
    board = [[0 for _ in range(n)] for _ in range(n)]

    if not solve_nq_util(board, 0, n):
        print("Solution does not exist")
        return False

    print_solution(board)
    return True

def print_solution(board):
    for row in board:
        print(" ".join(["Q" if x else "." for x in row]))

# Solve 8-Queens problem
n = int(input("how many queens you want to place:"))
solve_nq(n)

print("Lab No.: 19")
print("Name: Samir Paudel")
print("Roll No: 114")
print("Section:D")
