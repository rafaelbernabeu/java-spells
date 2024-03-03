package demo.sealed.shapes;

public sealed class Shape implements Geometry permits Circle, Rectangle, Square, WeirdShape {

}
