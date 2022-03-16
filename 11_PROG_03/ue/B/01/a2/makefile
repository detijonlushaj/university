PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = person.o main.o

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cc
	g++ $(PARAM) -c $<

Person.o: person.h
main.o: person.h

clean:
	rm main $(OBJ)
