#include <iostream>
using namespace std;

// Hier die Implementierung von class MyString einfuegen

int main() {
  MyString empty {};
  cout << "The following should be empty: " << empty << endl;  // Nothing
  MyString abc {"abc"};
  cout << abc << endl;                                         // abc
  MyString abc2 {abc};
  cout << abc2 << endl;                                        // abc
  cout << abc.length() << endl;                                // 3
  cout << boolalpha << (abc == abc2) << endl;                  // true
  abc[2] = 'd';                                                
  cout << abc2 << endl;                                        // abc
  cout << boolalpha << (abc == abc2) << endl;                  // false
  cout << abc << endl;                                         // abd
  abc = abc2;
  abc2[0] = 'X';
  cout << abc << endl;                                         // abc
  MyString def {"def"};
  MyString abcdef {abc + def};
  cout << abcdef << endl;                                      // abcdef
  abcdef += abc;
  cout << abcdef << endl;                                      // abcdefabc
  MyString defdefdef {def * 3};
  cout << defdefdef << endl;                                   // defdefdef

  return 0;
}


