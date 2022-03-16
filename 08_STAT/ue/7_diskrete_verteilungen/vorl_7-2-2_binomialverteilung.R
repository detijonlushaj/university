# Binomial distribution
# B(10,0.5)

barplot(dbinom(0:10, 10, 0.5), names.arg=0:10, ylim=c(0.0,0.25),
        col=c("#FF7046"), xlab="k", ylab="P(X=k)")
