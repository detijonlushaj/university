results <- c(rep(1,10), rep(2,8), rep(3,11), rep(4,9), rep(5,14), rep(6,8))

freqs <- c(0.167, 0.133, 0.183, 0.15, 0.233, 0.133) # gerundet

mymean <- sum(freqs * 1:6)
print(mymean)
print(mean(results))

mysd <- sqrt((60/59) * sum(freqs * (1:6 - mean(results))^2))
print(mysd)
print(sd(results))

print(median(results))
