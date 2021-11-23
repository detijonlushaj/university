data <- read.table("streudiagramm.txt", header = TRUE, dec = ",")
plot(data$Gewicht, data$Groessee, xlab="Gewicht in kg", ylab="Größe in m", main="Streudiagramm zum Gewicht und der Größe der Probanden", pch=16, cex=2, cex.axis=1.50, cex.lab=1.50, cex.main=1.50)
