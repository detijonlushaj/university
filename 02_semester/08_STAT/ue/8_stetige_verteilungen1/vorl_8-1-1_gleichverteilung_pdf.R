# Gleichverteilung

a <- 0
b <- 60
unif.ts <- ts(dunif(seq(-10, 70, by=0.1), a, b), start=-10, frequency=10)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(unif.ts, type="l", xlim=c(-10,70), ylim=c(0,0.02),
     col=c("#3D6999"), lwd=2, xlab="x", ylab="f(x)")

