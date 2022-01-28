#include <iostream>

using namespace std;

class MyInt {
public:
    MyInt(int i) : i(i) {
        cout << "MyInt(" << i << ") constructed." << endl;
    }
    MyInt(const MyInt &m) : i(m.i) {
        cout << "MyInt(" << i << ") constructed." << endl;
    }
    ~MyInt() {
        cout << "MyInt(" << i << ") destructed." << endl;
    }

private:
    int i;
};
void foo(MyInt m) {
    cout << "foo invoked." << endl;
}

MyInt global{1};

int main(void) {
    MyInt *heap;                                        // "MyInt _ constructed."
    cout << "Right before MyInt local" << endl;         //"Right before MyInt local"
    MyInt local{2};                                     //"MyInt 2 constructed."
    heap = new MyInt{3};                                //"MyInt 3 constructed."        
    foo(local);                                         //"MyInt 2 constructed."        //"foo invoked."        //"MyInt 2 destructed."
    foo(MyInt{4});                                      //"MyInt 4 constructed."        //"foo invoked."        //"MyInt 4 destructed."
    // foo(new MyInt{5}); // Compiler error - why?      //"Cleaning up now..." 
    cout << "Cleaning up now..." << endl;
    delete heap;                                        //"MyInt 3 destructed."     
    return 0;                                           //"MyInt 2 destructed."     //"MyInt _ destructed."
}

//b.) new MyInt{5} liefert einen MyInt* und kein Objekt und er erwartet ein Objekt