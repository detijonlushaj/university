# Poisson distribution
# Po(2)

par(mai=c(1.2,1.2,0.5,0.2), cex=1.5)
barplot(dpois(0:10, 2), names.arg=0:10, ylim=c(0.0,0.3),
        col=c("#FF7046"), xlab="k", ylab="P(X=k)")

