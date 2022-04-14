GCC_ARGS = -Wall -pedantic-errors -std=c99
OBJ = a.o b.o

main: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

b.o: a.h

clean: 
	rm $(OBJ) main