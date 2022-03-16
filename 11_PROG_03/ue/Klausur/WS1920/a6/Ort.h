
#include <string>
#ifndef ORT
#define ORT

class Ort{
    public:
    Ort(std::string name, int w, int b);
    Ort( const Ort& copy);
    Ort& operator = (const Ort& copy);
    bool operator == (const Ort& copy);
    
    private:
    std::string name;
    int laenge;
    int breite;
};
#endif