package demo.jdk17.sealed.shapes;

public sealed class Shape implements Geometry permits Circle, Rectangle, Square, WeirdShape {

}
