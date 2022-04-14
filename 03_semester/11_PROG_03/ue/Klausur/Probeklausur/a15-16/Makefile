GCC_ARGS = -std=c++14 -Wall -pedantic-errors
OBJ = Frau.o Mann.o Person.o

main : $(OBJ)
	g++ $(GCC_ARGS) -o $@ $(OBJ)

*.o : *.cpp
	g++ $(GCC_ARGS)  -c $< 

Person.o : Person.h
Mann.o : Mann.h
Frau.o : Frau.h

clean:
	rm main $(OBJ)