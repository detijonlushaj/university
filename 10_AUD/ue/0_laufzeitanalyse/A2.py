import datetime
import random
def maxTwo(a):
    if len(a) >= 2:
        maxVal = a[0] + a[1]
        maxPos = a[0]
    else:
        quit()

    for i in range(1, len(a)-2):
        if maxVal < a[i] + a[i+1]:
            maxVal = a[i] + a[i+1]
            maxPos = i
    return maxVal, maxPos

if __name__ == '__main__':
    a = []
    for i in  range(10000000):
        a.append(random.randint(-1000, 1000))
    start = datetime.datetime.now()
    maxVal, maxPos = maxTwo(a)
    end = datetime.datetime.now()
    time = (end-start)
    print("maxVal = " + str(maxVal) + ", maxPos = " + str(maxPos) + ", Zeit: " + str(time.microseconds))
