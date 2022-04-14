results <- sample(1:6, 10000, replace=TRUE)
relfreq <- table(results) / length(results)

barplot(relfreq, ylim=c(0.0,1.0),
        col=c("#FF7046"), xlab=expression(a[j]), ylab=expression(f[j]))
print(mean(results))
