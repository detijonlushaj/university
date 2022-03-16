vels <- read.table("geschwindigkeiten.dat", col.names="Vel")

breaks.15 <- c(40, 55, 70, 85, 100)
breaks.4 <- seq(from=40, to=100, by=4)

bins.15 <- cut(vels$Vel, breaks.15)
bins.4 <- cut(vels$Vel, breaks.4)

print(table(bins.15))

relfreqs.15 <- table(bins.15) / nrow(vels)
relfreqs.4 <- table(bins.4) / nrow(vels)

heights.15 <- relfreqs.15 / 15
heights.4 <- relfreqs.4 / 4
print(heights.15)

hist(vels$Vel, breaks.15, freq=FALSE, col=c("lightgray"), xlab=expression(a[j]), ylab=expression(f[j]/d[j]), main="")
hist(vels$Vel, breaks.4, freq=FALSE, col=c("lightgray"), xlab=expression(a[j]), ylab=expression(f[j]/d[j]), main="")
