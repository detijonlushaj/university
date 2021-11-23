grades <- read.table("schulnoten.dat", col.names="Grade")

ordgrades <- sort(grades$Grade)
print(ordgrades)

absfreqs <- table(grades$Grade)
print(absfreqs)

relfreqs <- absfreqs / nrow(grades)
print(relfreqs)

cumabsfreqs <- cumsum(absfreqs)
print(cumabsfreqs)

cumrelfreqs <- cumabsfreqs / nrow(grades)
print(cumrelfreqs)

barplot(relfreqs, xlab=expression(a[j]), ylab=expression(f[j]))
