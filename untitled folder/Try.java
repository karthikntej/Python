
class A {
    public A() {
        System.out.print("A");
    }
}

class B extends A {
    public B() {
        super();
        System.out.print("B");
        
    }
}

public class Try {
    public static void main(String[] args) {
        new B();
        try {
            System.out.println("k is ");
            int c = 1/0;
            System.out.println("c is " + c);
        } catch (Exception e) {
            System.out.println("E");
        } finally {
            System.out.println("F");
        }
        
        Integer a = 1;
        int b = a;
        System.out.println(b);
    }
}
