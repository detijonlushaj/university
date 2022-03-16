distances <- read.table("A3_Messdaten.txt")

x <- sort(distances$V1)
print(x)
print(table(x))

xm   <- mean(x)
xvar <- var(x)
xsd  <- sd(x)
xmed <- median(x)
xqs  <- quantile(x, probs = c(0.05, 0.95), type = 2)

cat(xm, xvar, xsd, xmed, sep = ", ")

print(xqs)

hist(x, freq=FALSE, ylim=c(0, 0.12),
     col=c("#FF7046"), main="", 
     xlab=expression(a[j]), ylab=expression(f[j]/d[j]))

axis(1, at=c(xm-xsd, xmed, xm, xm+xsd), labels=rep("", 4),
     lwd.ticks=3, col.ticks="#3D6999")
text(x=c(xm-xsd, xmed, xm, xm+xsd), y=0.003,
     labels=c(expression(bar(x) - s[x]), expression(tilde(x)),
     expression(bar(x)), expression(bar(x) + s[x])),
     col="#3D6999", font=2)

