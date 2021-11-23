semester <- read.table("semester.dat", col.names="Sem")

# order statistic
print(sort(semester$Sem))

# absolute frequencies
print(table(semester))

# relative frequencies
relfreqs <- table(semester) / nrow(semester)
print(relfreqs)

# barplot
barplot(relfreqs , col=c("#FF7046"), xlab=expression(a[j]), ylab=expression(f[j]))
