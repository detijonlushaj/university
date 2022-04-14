PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = CartItem.o ShoppingCart.o main.o

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cpp
	g++ $(PARAM) -c $<

CartItem.o: CartItem.h
ShoppingCart.o: ShoppingCart.h CartItem.h
main.o: ShoppingCart.h CartItem.h

clean:
	rm main $(OBJ)