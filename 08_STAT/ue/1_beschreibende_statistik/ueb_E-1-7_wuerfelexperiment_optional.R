# throw dice n times and return relative frequency of result 1
experiment <- function(n) {
  results <- sample(1:6, n, replace=TRUE)
  relfreqs <- table(factor(results, levels = 1:6)) / n
  as.vector(relfreqs)[1]
}

# counters
cnt60 <- 0
cnt20 <- 0

for (i in 1:1000) {
  if (experiment(60) < 0.1)
    cnt60 <- cnt60 + 1
  if (experiment(20) < 0.1)
    cnt20 <- cnt20 + 1
}

# print results
print(cnt60)
print(cnt20)
