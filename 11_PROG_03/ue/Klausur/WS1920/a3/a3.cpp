#include <iostream>
using namespace std;
class A {
public:
    int data;
    int id;
    static int counter;
    A() {
        data = 0;
        id = counter++;
    }
    A(const A &other) {
        data = other.data;
        id = counter++;
    }
};
int A::counter = 0;
void foo(A &a1, A a2) {
    cout << a1.data << a1.id << a2.data << a2.id << endl;
    ++a1.data;
    ++a2.data;
    cout << a1.data << a1.id << a2.data << a2.id << endl;
}
int main(void) {
    A x, y;
    foo(x, y);
    foo(x, y);
    return 0;
}