GCC_ARGS = -std=c99 -Wall -pedantic-errors
OBJ = add20.o create20.o main.o print20.o

main: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

add20.c: int20.h
create20.c: int20.h
print20.c: int20.h
main: add20.h create20.h print20.h int20.h

clean:
	rm $(OBJ)