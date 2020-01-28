package shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeRefactor  {

    private List<Point> points = new ArrayList<>();
    private int down, right;

    public void add(Point point) {
        points.add(point);
        point.update();

    }





}
