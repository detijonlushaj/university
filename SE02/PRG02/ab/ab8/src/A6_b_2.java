public class A6_b_2 {

    public static void main1(String[] args) {
//        C v1= new A(); // implicit upcast
//        C v2= (C)new B(); // upcast
//        C v3= new C();
//        v2.c();
//        ((B)v1).b(); //downcast
//        ((B)v1).a(); // downcast & Compile error
//        ((A)v2).a(); // downcast & Runtime error
//        v2.b(); //Compile error
    }

    public class C {
        public void c() {
        }
    }
    public class B extends C {
        public void b() {
        }
    }
    public class A extends B {
        public void a() {
        }
    }
}
