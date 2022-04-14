x <- c(1.5, 5.2, 4.5, 0.5, 2.4, 2.6, 1.8, 4.2, 6.2, 3.6, 2.5, 5.1)
y <- c(30, 68, 90, 12, 100, 62, 21, 112, 230, 120, 56, 109)

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(x, y, type = "p", xlim=c(0,6.5), ylim=c(0,250), xlab="x / a", ylab="y / 1000 km",
     pch=21, cex=1.3, lwd=3, col="#3D6999")

# linear regression with linear model
linreg.1 <- lm(y ~ x)
#abline(linreg.1, col=c("#FF7046"), lwd=2)

# linear regression with square model
linreg.2 <- lm(y ~ x + I(x^2))
xseq = seq(-1, 7, length=100)
lines(xseq, predict(linreg.2, data.frame(x=xseq)), col=c("#FF7046"), lwd=2)
