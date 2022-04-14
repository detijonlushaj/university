all: simple-c-program

simple-c-programm.o: simple-c-program.c
	gcc -g -Wall -c simple-c-program.c

simple-c-program: simple-c-program.o
	gcc -g -Wall simple-c-program.o -o simple-c-program
	
clean:
	/bin/rm -f simple-c-program.o simple-c-program
	
