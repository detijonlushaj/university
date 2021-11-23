# Comparison of hypergeometric Hyp(20,5,4) and binmoial B(4,0.25) distributions

d <- 0:4
h <- dhyper(d, 5, 15, 4)

b <- dbinom(d, 4, 0.25)

m = t(matrix(c(h,b), nrow=5, ncol=2))
colnames(m) <- d

par(mai=c(1.2,1.2,0.5,0.2), cex=1.5)
barplot(m, ylim=c(0,0.5), beside=TRUE, space=c(0.2,1),
        col=c("#3D6999","#FF7046"), xlab="k", ylab="P(X=k)")
