import time
def start ():
    starttime = time.time()

    zahlen = [31, -41, 59, 26, -53, 58, 97, -93, -23, 84]
    maxsum = 0
    maxvon = 1
    maxbis = 1

    anz = len(zahlen)
    von = 0
    '''
    Alle Startpositionen durchlaufen
    '''
    while (von < anz):
        bis = von
        '''
        Alle Endpositionen durchlaufen
        '''
        while (bis < anz):
            calcnr = von
            calcsum = 0
            '''
            Summe aller Elemente zwischen Start- und Endposition berechnen
            '''
            while (calcnr < bis):
                calcsum = calcsum + zahlen[calcnr]
                calcnr = calcnr + 1
            '''
            Falls neues Maximum gefunden wurde, Start und Ende merken
            '''
            if calcsum>maxsum:
                maxsum = calcsum
                maxvon = von
                maxbis = bis
            bis = bis + 1
        von = von + 1

    finishtime = time.time()
    '''
    Ergebnis ausgeben
    '''
    print(f"Maximale Teilsumme ist {maxsum} (Elemente {maxvon} - {maxbis})")
    runtime = finishtime - starttime
    print(f"Laufzeit: in Sekunden {runtime}")

if __name__ == '__main__':
    start()
