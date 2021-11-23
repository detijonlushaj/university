public class ABCMain {
    public static void main(String[] args) {
        A a= new A();
        B b= new B();
        C c= new C();

        b.a();
        c.a();
        //a.b();
        b.b();
        c.b();

        //a.c();
        //b.c();
        c.c();

        A x= new B();
        x.a();
        //x.b();
        //x.c();

        ((A)x).a();
        ((B)x).b();
        //((C)x).c();
    }
}