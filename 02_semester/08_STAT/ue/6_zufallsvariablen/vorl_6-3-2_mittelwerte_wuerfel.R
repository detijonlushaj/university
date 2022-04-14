means <- vector(length=1000)

sum <- 0
for (n in 1:1000) {
  sum <- sum + sample(1:6, 1)
  means[n] <- sum / n
}

par(mai=c(1.2,1.3,0.5,0.2), cex=1.5)
plot(ts(means, start=1), type="l", ylim=c(2.0,5.0),
     col=c("#3D6999"), lwd=2, xlab="n", ylab=expression(bar(X)))
