data <- read.table("data.text")

data1 <- subset(data, select=c(Note, Geschlecht))
data2 <- subset(data, select=c(-Note, -Geschlecht))
data3 <- subset(data, Fach="Mathe", select=c(Note, Geschlecht))
