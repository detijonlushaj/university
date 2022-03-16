data <- read.table("streudiagramm.txt", dec = ",")

dataM <- subset(data, Groesse > 1.7  & Gewicht > 70)

data100W <- subset(data, Groesse < 1.7 | Gewicht == 50)