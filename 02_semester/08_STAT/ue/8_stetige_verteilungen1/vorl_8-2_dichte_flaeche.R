# Dichte und Flaeche

lambda <- 1
exp.ts <- ts(dexp(seq(0, 5, by=0.02), lambda), start=0, frequency=50)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(exp.ts, type="l", xlim=c(0,5), ylim=c(0,1),
     col=c("#FF7046"), lwd=2, xlab="x", ylab="f(x)")

exp1.ts <- ts(c(0,dexp(seq(0.51, 0.99, by=0.01), lambda),0), start=0.5, frequency=100)
polygon(exp1.ts, col="#3D6999")

exp2.ts <- ts(c(0,dexp(seq(2.51, 2.99, by=0.01), lambda),0), start=2.5, frequency=100)
polygon(exp2.ts, col="#3D6999")
