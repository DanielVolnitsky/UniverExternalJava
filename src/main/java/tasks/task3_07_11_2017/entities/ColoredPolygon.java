package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.Color;
import tasks.task3_07_11_2017.interfaces.Colored;

public class ColoredPolygon extends Polygon implements Colored {
    private Color color;

    public ColoredPolygon(Point[] points, Color color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toString() {
        return "coloredPolygon {" + "color: " + color + ", " + super.toString() + "} ";
    }
}