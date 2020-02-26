package shape;

import javafx.scene.paint.Color;

public enum ShapeColorType {
    BLUE(Color.BLUE),
    RED(Color.RED),
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    PURPLE(Color.PURPLE);

     Color color;

    ShapeColorType(Color color) {
     this.color=color;
    }
}
