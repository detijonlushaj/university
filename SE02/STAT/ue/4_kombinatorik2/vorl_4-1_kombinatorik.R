n <- 6
k <- 3

# n!
factorial(n)

# binomial coefficient ("n choose k") -- combination (with/without repetition)
choose(n, k)
choose(n+k-1, k)

# product n*(n-1)*...*(n-k+1) -- k-permutation of n (without repetition)
prod((n-k+1):n)

# exponentiation n^k -- k-permutation of n with repetition
n^k

# generating combinations
x <- c("A","B","C","D")
combn(x, k)
