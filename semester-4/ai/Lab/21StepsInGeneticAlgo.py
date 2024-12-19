import random

# Example problem: Maximize f(x) = x^2 where 0 <= x <= 31
# We'll represent x as a 5-bit binary number

def fitness(individual):
    x = int(''.join(map(str, individual)), 2)
    return x ** 2

def create_individual():
    return [random.randint(0, 1) for _ in range(5)]

def create_population(size):
    return [create_individual() for _ in range(size)]

def selection(population, k=3):
    return max(random.choices(population, k=k), key=fitness)

def crossover(parent1, parent2):
    point = random.randint(1, len(parent1) - 1)
    child = parent1[:point] + parent2[point:]
    return child

def mutation(individual, rate=0.1):
    return [bit if random.random() > rate else 1 - bit for bit in individual]

def genetic_algorithm(population_size, generations):
    population = create_population(population_size)

    for gen in range(generations):
        new_population = []

        for _ in range(population_size):
            parent1 = selection(population)
            parent2 = selection(population)
            child = crossover(parent1, parent2)
            child = mutation(child)
            new_population.append(child)

        population = new_population

        best = max(population, key=fitness)
        print(f"Generation {gen+1}: Best = {int(''.join(map(str, best)), 2)}, Fitness = {fitness(best)}")

    return max(population, key=fitness)

# Run the genetic algorithm
best_solution = genetic_algorithm(population_size=50, generations=20)
x = int(''.join(map(str, best_solution)), 2)
print(f"nBest solution: x = {x}, f(x) = {x**2}")

print("Lab No.: 21")
print("Name: Samir Paudel")
print("Roll No: 114")  
print("Section:D")