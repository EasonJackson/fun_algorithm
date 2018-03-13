/**
 * Created by easonjackson on 2/6/18.
 */
public class Sub extends Super {
    String name;
    public Sub() {
        this.name = "Default Name";
    }
    // This is called a one argument constructor.
    public Sub(String name) { this.name = name;
    }
    public static void main(String[] args) { Sub sub = new Sub();
    }
}
