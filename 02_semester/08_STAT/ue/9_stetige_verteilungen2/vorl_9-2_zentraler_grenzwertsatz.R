# Central limit theorem

m <- 5000
n <- 50

a <- 0; b <- 10
mu <- (a + b) / 2
sigma <- sqrt((b - a)^2 / 12)

z <- vector(length=m)
for (i in 1:m) { z[i] = (mean(runif(n, a, b)) - mu) / (sigma/sqrt(n)) }

hist(z, freq=FALSE, breaks=30, xlim=c(-5, 5), ylim=c(0, 0.6),
     main="", xlab=expression(Z[n]), ylab="Density")
curve(dnorm(x), from=-5, to=5, add=TRUE, lwd=2, col=c("#FF7046"))
