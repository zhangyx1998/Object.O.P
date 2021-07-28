public class ClassTest {
    public static void main(String[] args) {
        if (args.length > 0)
            new ChildClass(args[0]);
        else
            new ChildClass();
    }

    public static class ParentClass {
        String s;
        private int x;
        protected int y;

        ParentClass() {
            this.x = 1;
            this.y = 2;
            System.out.println("ParentClass Default Constructor");
        }

        ParentClass(String s) {
            this.x = 3;
            this.y = 4;
            this.s = s;
            System.out.println("ParentClass Custom Constructor with string: " + s);
        }
    }

    public static class ChildClass extends ParentClass {
        ChildClass() {
            super();
            System.out.println("ChildClass Default Constructor");
            System.out.println("super.x = " + super.x);
            System.out.println("this.x  = " + /*this.x*/ "NOT VISIBLE");
            System.out.println("super.y = " + super.y);
            System.out.println("this.y  = " + this.y);
        }

        ChildClass(String s) {
            super(s);
            System.out.println("ChildClass Custom Constructor with string: " + s);
            System.out.println("super.s = " + super.s);
            System.out.println("this.s  = " + this.s);
            System.out.println("super.x = " + super.x);
            System.out.println("this.x  = " + /*this.x*/ "NOT VISIBLE");
            System.out.println("super.y = " + super.y);
            System.out.println("this.y  = " + this.y);
        }
    }
}