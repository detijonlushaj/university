GCC_ARGS = -Wall -std=c99 -pedantic-errors
OBJ = math.o summe.o differenz.o input.o

main: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

main.c: summe.h differenz.h
summe.c: input.h
differenz.c: input.h

clean:
	rm main $(OBJ)