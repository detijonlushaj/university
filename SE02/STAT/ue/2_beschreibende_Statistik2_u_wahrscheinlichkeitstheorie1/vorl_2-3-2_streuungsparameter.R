semester <- c(6, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 20)

# five-number summary (minimum, lower-hinge, median, upper-hinge, maximum)
print(fivenum(semester))

# interquartile range
print(IQR(semester, type = 2))
print(IQR(semester[1:14], type = 2))

# sample variance
print(var(semester))

# sample standard deviation
print(sd(semester))
