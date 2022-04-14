import datetime
def maxTwo():
    a = [31, -41, 59, 26, -53, 58, 97, -93, -23, 84]
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
    start = datetime.datetime.now()
    maxVal, maxPos = maxTwo()
    end = datetime.datetime.now()
    time = (end-start)
    print("maxVal = " + str(maxVal) + ", maxPos = " + str(maxPos) + ", Zeit: " + str(time.microseconds))
