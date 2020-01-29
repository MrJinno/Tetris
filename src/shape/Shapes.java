package shape;

import javafx.scene.Group;

public interface Shapes {
    public void moveLeft();
    public void moveRight();
    public void moveDown();
    public void rotate();
    public Group getGroup();

}
