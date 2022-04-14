men   <- c(50, 60, 70, 80, 85, 90, 90, 90, 100)
women <- c(60, 65, 70, 80, 80, 90, 180)

print(mean(men))
print(mean(women))

print(median(men))
print(median(women))

boxplot(men, women, names = c("Männer", "Frauen"))
