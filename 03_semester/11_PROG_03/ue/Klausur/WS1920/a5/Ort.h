
#include <string>
#ifndef ORT
#define ORT

class Ort{
    public:
    Ort(std::string name, int w, int b);
    
    private:
    std::string name;
    int laenge;
    int breite;
};
#endif