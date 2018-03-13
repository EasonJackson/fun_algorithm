/**
 * Created by easonjackson on 3/12/18.
 */
public class Thing {
    private int priority;
    private String content;

    Thing(int priority) {
        this.priority = priority;
        this.content = null;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return this.priority;
    }
}
