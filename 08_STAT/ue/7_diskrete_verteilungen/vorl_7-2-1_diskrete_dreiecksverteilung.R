# Two dice distribution

values <- 2:12
density <- c(1:6,5:1)/36

barplot(density, names.arg=values, ylim=c(0.0,0.2),
        col=c("#FF7046"), xlab="x", ylab="P(X=x)")
