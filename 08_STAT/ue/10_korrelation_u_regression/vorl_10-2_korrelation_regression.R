x <- c(1, 2, 3, 5)
y <- c(7, 5, 3, 2)
plot(x, y)

r.xy <- cor(x, y)
rs.xy <- cor(x, y, method="spearman")

linReg <- lm(y ~ x)
abline(linReg)

linReg2 <- lm(y ~ x + I(x^2))
xSeq = seq(1, 5, length=100)
lines(xSeq, predict(linReg2, data.frame(x=xSeq)))
