#include <iostream> 
#include <cstring> 
#include <stdexcept>

using namespace std;
class MyString { 
	public:
		MyString();
	MyString(const MyString& other);
	MyString(const char chars[]);

	friend ostream& operator << (ostream& out, const MyString& ms); 
    int length() const { return len; }
	bool operator == (const MyString& other) const;

	char& operator [] (int index) const throw (out_of_range); 

    MyString& operator += (const MyString& other);
	MyString& operator = (const MyString& other);
	MyString operator * (int n) const;
	~MyString();
	private: 
		char* ptr; 
	int len;
};
MyString::MyString() { 
	len = 0;
	ptr = new char {'\0'}; 
}
MyString& MyString::operator = (const MyString& other) { 
	delete[] ptr;
	len = other.len;
	ptr = new char[len + 1];
	strcpy(ptr, other.ptr);
	return *this; 
}
MyString::MyString(const MyString& other) { 
	ptr = nullptr;
	*this = other; 
}
MyString::~MyString() { 
	delete[] ptr;
}
MyString::MyString(const char chars[]){
	len = strlen(chars);
	ptr = new char[len + 1]; 
	strcpy(ptr, chars);
}
ostream& operator << (ostream& out, const MyString& ms) { 
	for (int i = 0; i < ms.len; ++i) {
		out << ms.ptr[i];
	}
	return out; 
}
bool MyString::operator == (const MyString& other) const { 
	if (len != other.len)
		return false;
	for (int i = 0; i < len; ++i) {
		if (ptr[i] != other.ptr[i]) return false;
	}
	return true; 
}
char& MyString::operator [] (int index) const throw (out_of_range) { 
	if (index < 0 || index >= len)
		throw out_of_range("MyString index out of bounds"); 
	return ptr[index];
}
MyString operator + (const MyString& ms1, const MyString& ms2) { 
	MyString result(ms1);
	result += ms2;
	return result;
}
MyString& MyString::operator += (const MyString& other) { 
	int newLen = len + other.len;
	char* newPtr = new char[newLen];
	strcpy(newPtr, ptr);
	delete[] ptr;
	strcpy(newPtr + len, other.ptr); 
	len = newLen;
	ptr = newPtr;
	return *this;
}
MyString MyString::operator * (int n) const { 
	MyString result;
	for (int i = 0; i < n; ++i) {
		result += *this; }
	return result; 
}

int main() {
	MyString empty {};
	cout << "The following should be empty: " << empty << endl; // Nothing
	MyString abc {"abc"};
	cout << abc << endl;
	MyString abc2 {abc};
	cout << abc2 << endl;
	cout << abc.length() << endl;
	cout << boolalpha << (abc == abc2) << endl;
	abc[2] = 'd';
	cout << abc2 << endl;
	cout << boolalpha << (abc == abc2) << endl;
	cout << abc << endl;
	abc = abc2;
	abc2[0] = 'X';
	cout << abc << endl;
	MyString def {"def"};
	MyString abcdef {abc + def};
	cout << abcdef << endl;
	abcdef += abc;
	cout << abcdef << endl;
	MyString defdefdef {def * 3};
	cout << defdefdef << endl;
	return 0; 
}