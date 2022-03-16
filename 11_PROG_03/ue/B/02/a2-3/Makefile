PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = main.o int20.o

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cpp
	g++ $(PARAM) -c $<

main.o: int20.h
int20.o: int20.h

clean:
	rm main $(OBJ)