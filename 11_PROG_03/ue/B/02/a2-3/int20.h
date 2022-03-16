#ifndef INT20
#define INT20
#include <string>

class Int20{
friend std::ostream& operator << (std::ostream& out, const Int20& v);

public:
    Int20();
    Int20(const std::string val);
    Int20(const Int20 &old);
    Int20 &operator=(const Int20 &other);
    Int20 operator+(const Int20 &other);
    Int20 &operator+=(const Int20 &other);
    bool operator<(const Int20 &other);
    void print();

private:
    std::string number;
};
#endif
