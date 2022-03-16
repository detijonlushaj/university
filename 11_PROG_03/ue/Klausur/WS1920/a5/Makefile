PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = Ort.o Person.o Baby.o main.o 

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cpp
	g++ $(PARAM) -c $<

Person.o: Person.h Ort.h
main.o: Person.h Baby.h Ort.h
Baby.o: Person.h Ort.h

clean:
	rm main $(OBJ)