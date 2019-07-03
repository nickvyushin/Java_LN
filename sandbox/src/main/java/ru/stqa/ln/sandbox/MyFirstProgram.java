package ru.stqa.ln.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("World");
        hello("user");
        hello("Nickolas");

        Square s = new Square(5);
        System.out.println("Площадь квадратат со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}