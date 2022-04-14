# Comparison of binmoial B(100,0.05) and poisson Po(5) distributions

d <- 0:15
b <- dbinom(d, 100, 0.05)

p <- dpois(d, 5)

m = t(matrix(c(b,p), nrow=16, ncol=2))
colnames(m) <- d

par(mai=c(1.2,1.2,0.5,0.2), cex=1.5)
barplot(m, ylim=c(0,0.2), beside=TRUE, space=c(0.2,1), col=c("#3D6999","#FF7046"),
        xlab="k", ylab="P(X=k)")
