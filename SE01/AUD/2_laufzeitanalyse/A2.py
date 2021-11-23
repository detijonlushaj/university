import time
def fak(n):
    if (n == 1):
        return 1
    else:
        return n * fak(n-1)

def fakIte(n):
    sum = 1
    i = 2
    while (i <= n):
        sum *= i
        i += 1
    return sum


if __name__ == '__main__':
    fakStarttime = time.time()
    n = 10
    fakNum = fak(n)
    fakEndtime = time.time()
    runtime = fakStarttime - fakEndtime
    print(f"Die {n}-te Fakultät ist {fakNum}")
    print(f"Laufzeit: in Sekunden {runtime}")

    fakIteStarttime = time.time()
    fakIteNum = fakIte(n)
    fakIteEndtime = time.time()
    runtime = fakStarttime - fakEndtime
    print(f"Die {n}-te Fakultät ist {fakIteNum}")
    print(f"Laufzeit: in Sekunden {runtime}")
