package shape;

import javafx.scene.Group;

public interface Shapes {
    void moveLeft();

    void moveRight();

    void moveDown();

    void rotate();

    Group getGroup();

}
