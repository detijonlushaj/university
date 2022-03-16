// IntBig.cpp
#include <cstring>
#include <iostream>
#include <vector>
using namespace std;

class IntBig {
	private:
		vector<char> c;  // Einerstelle an Index 0
		public:
			IntBig(const char* val);
		// IntBig(const IntBig& other);
		// IntBig& operator=(const IntBig& other); // unnoetig: siehe unten
		size_t size() const; // size_t überall, da Typ von vector::size() 
		char get_digit(size_t pos) const;
		void set_digit(size_t pos, char digit);
		IntBig& operator+=(const IntBig& summand2);
		void print(ostream& os = cout) const;
};

IntBig::IntBig(const char* val) {
	int len = strlen(val);
	for (int i = 0; i < len; i++) {
		c.push_back(val[len - i - 1]);
	}
}

// liefert eine Zahl zwischen 0 und 9
char IntBig::get_digit(size_t pos) const { if (pos >= c.size())
	return 0;
return (c.at(pos) - (char) '0');
}

void IntBig::print(ostream& os) const {
	for (int i= c.size()-1; i>=0; i--) {
		os << c.at(i);
	}
}

IntBig& IntBig::operator+=(const IntBig& summand2) { 
	if (this == &summand2) return *this;
	size_t len = size();
	if (len < summand2.size())
		len = summand2.size();
	int uebertrag = 0;
	for (size_t i = 0; i < len; i++) {
		int sum = get_digit(i) + summand2.get_digit(i) + uebertrag; if (sum > 9)
			uebertrag = 1;
		else
			uebertrag = 0;
		set_digit(i, sum % 10);
	}
	return *this;
}

IntBig operator+(const IntBig& summand1, const IntBig& summand2) { 
	IntBig result(summand1);
	result += summand2;
	return result;
}

ostream& operator<<(ostream& os, const IntBig& i) { 
	i.print(os);
	return os;
}
bool operator<(const IntBig& a, const IntBig& b) { 
	size_t len = a.size();
	if (len < b.size())
		len = b.size();
	for (size_t i = len - 1;
			/* i >= 0 would be useless, since a size_t is always >= 0 */;
			i--) {
		if (a.get_digit(i) != b.get_digit(i)) {
			return a.get_digit(i) < b.get_digit(i); }
		if (len == 0)
			return false;
	}
	return false;
}

// liefert 20 für eine 20-stellige Zahl
size_t IntBig::size() const {
	return c.size();
}

void IntBig::set_digit(size_t pos, char digit) { // ggf. 0en auffüllen
	while (c.size() <= pos) {
		c.push_back('0');
	}
	c[pos] = digit + (char) '0';
	// Führende 0en entfernen
	while (c.size() > 0 && c.at(c.size()-1) == '0') { c.pop_back();
	}
}

int main() {
	IntBig a {"1000000000000000000000000000000000000000"};
	IntBig b {"100"};
	IntBig c {"0"};
	cout << a << endl;
	cout << b << endl;
	a += b;
	cout << a << endl;
	cout << (a+b) << endl;
	cout << c << endl;
	cout << (c+b) << endl;
	cout << "a < b = " << (a < b) << endl;
	cout << "b < a = " << (b < a) << endl;
	cout << "a < a = " << (a < a) << endl;
	return 0;
	  
}