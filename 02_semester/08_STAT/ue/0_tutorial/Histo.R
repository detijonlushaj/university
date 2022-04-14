data <- read.table("data.txt", header = TRUE, dec = ",")
h <- hist(data$Groesse,  main="Histogramm in m", ylab="Häufigkeit", xlab="Größe in m", col="steelblue", breaks = 12,
          xaxt="n")
axis(side=1, at=seq(1.4, 2.1, 0.05))
text(h$mids, h$counts, label = h$counts, adj = c(0.5, -0.5))     
     