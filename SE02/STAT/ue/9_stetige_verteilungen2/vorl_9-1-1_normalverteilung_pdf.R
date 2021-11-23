# Normal distribution (PDF)

mu <- 2
sigma1 <- 1
sigma2 <- 2
norm1.ts <- ts(dnorm(seq(-2, 6, by=0.02), mu, sigma1), start=-2, frequency=50)
norm2.ts <- ts(dnorm(seq(-2, 6, by=0.02), mu, sigma2), start=-2, frequency=50)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(norm1.ts, type="l", xlim=c(-2,6), ylim=c(0,0.4),
     col=c("#FF7046"), lwd=2, xlab="x", ylab="f(x)")
par(new=TRUE)
plot(norm2.ts, type="l", xlim=c(-2,6), ylim=c(0,0.4),
     col=c("#3D6999"), lwd=2, xlab="", ylab="")

