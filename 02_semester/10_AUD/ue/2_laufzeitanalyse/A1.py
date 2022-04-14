import time
def fib(n):
    if (n == 0 or n == 1):
        return 1
    else:
        return fib(n-1) + fib(n-2)

def fibIte(n):
    fib_new = 0
    fib_old = 1
    i = 0
    while (i <= n):
        t = fib_new
        fib_new = fib_new + fib_old
        fib_old = t
        i += 1
    return fib_new

if __name__ == '__main__':
    fibStarttime = time.time()
    n = 35
    fibNum = fib(n)
    fibEndtime = time.time()
    runtime = fibStarttime - fibEndtime
    print(f"Die {n}-te Fibonacci-Zahl ist {fibNum}")
    print(f"Laufzeit: in Sekunden {runtime}")

    fibStarttime = time.time()
    fibNumIte = fibIte(n)
    fibEndtime = time.time()
    runtime = fibStarttime - fibEndtime
    print(f"Die {n}-te Fibonacci-Zahl ist {fibNumIte}")
    print(f"Laufzeit: in Sekunden {runtime}")
