n <- 5

exp.cdf <- ts(1-exp(-seq(0, 5, by=0.02)), start=0, frequency=50)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(exp.cdf, type="l", xlim=c(0,5), ylim=c(0,1),
     col=c("#FF7046"), lwd=2, xlab="x", ylab="F(x)")
par(new=TRUE)
plot(ecdf(rexp(n)), verticals=FALSE, pch=16, cex.points=0.66, xlim=c(0,5), ylim=c(0,1),
     col=c("#3D6999"), lwd=2, main="", xlab="", ylab="")
