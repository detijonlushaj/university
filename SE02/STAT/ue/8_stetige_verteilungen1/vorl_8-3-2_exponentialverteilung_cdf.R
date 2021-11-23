# Gleichverteilung

lambda1 <- 1
lambda2 <- 1/2
exp1.ts <- ts(pexp(seq(0, 5, by=0.02), lambda1), start=0, frequency=50)
exp2.ts <- ts(pexp(seq(0, 5, by=0.02), lambda2), start=0, frequency=50)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(exp1.ts, type="l", xlim=c(0,5), ylim=c(0,1),
     col=c("#FF7046"), lwd=2, xlab="x", ylab="F(x)")
par(new=TRUE)
plot(exp2.ts, type="l", xlim=c(0,5), ylim=c(0,1),
     col=c("#3D6999"), lwd=2, xlab="", ylab="")

