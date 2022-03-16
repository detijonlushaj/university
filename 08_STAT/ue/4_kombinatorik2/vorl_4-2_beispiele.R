# Beispiel: Fußballspiele
teams <- c("Hannover 96", "Werder Bremen", "Hamburger SV", "Eintracht Braunschweig")
nmatches <- choose(length(teams), 2)         # Anzahl Spiele
matches <- combn(teams, 2, simplify=FALSE)   # Spielplan

# Beispiel: USB-Sticks
prob.2 <- dhyper(2, 3, 7, 5)          # genau 2 defekte Sticks
prob.1plus <- 1 - dhyper(0, 3, 7, 5) 	# mind. 1 defekter Stick
sticks <- factor(c(rep("d", 3), rep("f", 7)))
sample(sticks, 5)                     # Stichprobe 1
sample(sticks, 5)                     # Stichprobe 2 ...
