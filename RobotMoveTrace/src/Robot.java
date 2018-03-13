/**
 * Created by easonjackson on 2/22/18.
 */
public class Robot {

    int x;
    int y;

    Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void moveUp() {
        this.x -= 1;
    }

    void moveDown() {
        this.x += 1;
    }

    void moveRight() {
        this.y += 1;
    }

    void moveLeft() {
        this.y -= 1;
    }

    void printLocation() {
        System.out.print("(" + x + ", " + y + ") -> ");
    }
}
