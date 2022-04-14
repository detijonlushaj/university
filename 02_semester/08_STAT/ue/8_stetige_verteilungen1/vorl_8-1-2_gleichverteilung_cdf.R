# Gleichverteilung

a <- 0
b <- 60
unif.ts <- ts(punif(-10:70, a, b), start=-10, frequency=1)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(unif.ts, type="l", xlim=c(-10,70), ylim=c(0,1),
     col=c("#3D6999"), lwd=2, xlab="x", ylab="F(x)")

