const int N = 5;
class Vektor {   
    private:     
    double* elems;
    public:     
    Vektor() {       
        elems = new double[N];    
    }
    Vektor(const Vektor & copy){
        delete[] elems;
        for (int i = 0; i < N; i++){
            elems[i] = copy.elems[i];
        }
    }
    ~Vektor() {       
        delete[] elems;     
    }

    Vektor operator + (const Vektor &o){
        Vektor res;
        for (int i = 0; i < N; i++) {
            res.elems[i] = this->elems[i] + o.elems[i];
        }
        return res;
    }

    Vektor &operator += (const Vektor &o){
        for (int i = 0; i < N; i++) {
            this->elems[i] += o.elems[i];
        }
        return *this;
    }

    bool operator == (const Vektor &o){
        for (int i = 0; i < N; i++) {
            if (this->elems[i] != o.elems[i]) {
                return false;
            }
        }
        return true;
    }

};
