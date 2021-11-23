# arithmetic mean
data <- c(3, 6, 4, 1, 5, 7, 2, 4, 9)
am <- mean(data)
print(am)

# geometric mean
# gm <- prod(data)^(1/length(data))
gm <- exp(mean(log(data)))
print(gm)

# median
semester <- c(6, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 20)
print(median(semester))
print(median(semester[1:14]))

print(mean(semester))
print(mean(semester[1:14]))

# p-quantile
x <- c(2, 2, 3, 5, 7, 8, 9)
print(quantile(x, probs = c(0.1, 0.25, 0.5, 0.75, 0.9), type = 2))

# five-number summary
print(fivenum(x))

# boxplot
boxplot(x, ylab=expression(a[j]))

v <- rnorm(1000)
boxplot(v)
