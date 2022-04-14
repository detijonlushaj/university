PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = Ort.o 

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cpp
	g++ $(PARAM) -c $<

main.o: Ort.h


clean:
	rm main $(OBJ)