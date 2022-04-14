#!/bin/bash

# Game launcher der Programmierprojektgruppe 6.
# Insgesamt stehen 6 Spiele zur Verfügung, die ausgewählt und gespielt werden können.
# Das Skript erwartet als Eingabeargument eine Zahl, welcher für ein Spiel steht
# z.B.: ./game_launcher.sh 1

# Bedienungsanleitung: 

# Für die Benutung von allen Spielen ist die java jdk 1.8 notwendig  

# Hier die Liste der Spieler mit den dazugehörigen Ziffern
# 1: Construct - ist ein Klon des Spiels World Hardest Game, welcher im Matrix Universum spielt 
# 2:
# 3: Snake - basiert auf das classic Snake spiel im Matrix Universum
# 4: Pacman - basiert auf das classic Pacman Spiel im Matrix Universum
#
# 6: SpaceInvders
if [ $# -ne 1 ] 
then
	echo 'bitte geben Sie einen Paramter an (1 bis 6). Benutzung z.B. ./game_launcher.sh 1';
	exit 1;
fi

if [ $1 -ge 6 ] || [ $1 -lt 1 ]
then 
    echo 'bitte geben Sie als Paramter eine Zahl von 1 bis 6 an';
	exit 1;
fi

num=$1;

if [ $1 -eq 1 ]
then
    java -jar jars/Construct.jar
fi 

if [ $1 -eq 2 ]
then
    java -jar jars/WHG.jar
fi 

if [ $1 -eq 3 ]
then
    java -jar jars/SNAKE.jar
fi

if [ $1 -eq 4 ]
then
    java -jar jars/pacmanGame.jar
fi

if [ $1 -eq 5 ]
then
    java -jar jars/HackerGradius.jar
fi

if [ $1 -eq 6 ]
then
    java -jar jars/SpaceInvaders.jar
fi

