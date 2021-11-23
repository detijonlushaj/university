import time


def ln_opt(x, n):
    zaehler = x - 1
    nenner = x + 1
    summe = zaehler / nenner
    k = 1
    while (k <= n):
        zaehler *= (x - 1) * (x - 1)
        nenner *= (x + 1) * (x + 1)
        summe += zaehler / ((2 * k + 1) * nenner)
        k += 1
    return 2*summe


if __name__ == '__main__':
    starttime = time.time()
    n = 30
    x = 10
    summe = ln_opt(x, n)
    endtime = time.time()
    runtime = starttime - endtime
    print(f"ln({x}) ist abegeschätzt bei n = {n} mit {summe}")
    print(f"Laufzeit: in Sekunden {runtime}")
