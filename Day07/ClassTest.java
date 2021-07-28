public class ClassTest {
    public static void main(String[] args) {
        if (args.length > 0)
            new ChildClass(args[0]);
        else
            new ChildClass();
    }

    public static class ParentClass {
        String s;

        ParentClass() {
            System.out.println("ParentClass Default Constructor");
        }

        ParentClass(String s) {
            this.s = s;
            System.out.println("ParentClass Custom Constructor with string: " + s);
        }
    }

    public static class ChildClass extends ParentClass {
        ChildClass() {
            super();
            System.out.println("ChildClass Default Constructor");
        }

        ChildClass(String s) {
            super(s);
            System.out.println("ChildClass Custom Constructor with string: " + s);
            System.out.println("super.s = " + super.s);
            System.out.println("this.s  = " + this.s);
        }
    }
}