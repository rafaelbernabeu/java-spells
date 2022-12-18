package spells.jdk17.sealed;

import spells.jdk17.sealed.shapes.Circle;
import spells.jdk17.sealed.shapes.Rectangle;
import spells.jdk17.sealed.shapes.Square;
import spells.jdk17.sealed.shapes.WeirdShape;

public sealed class Shape implements Geometry permits Circle, Rectangle, Square, WeirdShape {

}
