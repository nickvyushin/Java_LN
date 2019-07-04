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


        Point p1 = new Point(30, 40);
        Point p2 = new Point(10, 20);

        printDistance(distance(p1, p2));
        System.out.println("Расстояние между точками: " + distance(p1, p2));
        System.out.println("Расстояние между точками: " + p1.distance(p2));
    }


    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double distance(Point p1, Point p2){
        return Math.sqrt((Math.pow((p1.x - p2.x), 2)) + (Math.pow((p1.y - p2.y), 2)));
    }
    public static void printDistance (double distance) {
        System.out.println("Расстояние между точками: " + distance);

    }
}