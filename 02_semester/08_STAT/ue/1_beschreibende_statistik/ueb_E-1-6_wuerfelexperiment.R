n <- 60
k <- 20

# Generating reproducible random numbers:
# set.seed(42)

results <- sample(1:6, n, replace = TRUE)
# sample.int(6, n, replace = TRUE)
results.part <- results[1:k]

print(results)
print(sort(results))

absfreqs <- table(factor(results, levels = 1:6))
# absfreqs <- table(results)
print(absfreqs)

relfreqs <- absfreqs / n
relfreqs.part <- table(factor(results.part, levels = 1:6)) / k
print(relfreqs)

freqmat <- t(matrix(as.vector(c(relfreqs.part, relfreqs)), nrow=6, ncol=2))

barplot(freqmat, beside=TRUE, space=c(0.2,1), col=c("#3D6999","#FF7046"),
        xlab=expression(a[j]), ylab=expression(f[j]))

# Optional: cumulative frequencies

cumabsfreqs <- cumsum(absfreqs)
print(cumabsfreqs)

cumrelfreqs <- cumabsfreqs / n
print(cumrelfreqs)

plot(ecdf(results))
# plot(cumrelfreqs, ylim=c(0, 1), pch=19, xlab=expression(a[j]), ylab=expression(F[j]))
