# Hypergeometrical distribution
# Hyp(20,5,8)

par(mai=c(1.2,1.2,0.5,0.2), cex=1.5)
barplot(dhyper(0:8, 5, 15, 8), names.arg=0:8, ylim=c(0.0,0.5),
        col=c("#FF7046"), xlab="k", ylab="P(X=k)")
