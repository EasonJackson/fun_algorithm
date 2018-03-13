import java.util.Random;

/**
 * Created by easonjackson on 2/22/18.
 */
public class App {

    public static void main(String[] args) {
        Color c1 = new Color('b');
        Color c2 = new Color('r');
        Color c3 = new Color('g');
        Color c4 = new Color('w');

        Color[] method = new Color[4];
        // 'b', 'w', 'r', 'g'
        method[0] = c1;
        method[1] = c4;
        method[2] = c2;
        method[3] = c3;

        char[] colors = new char[20];
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            colors[i] = method[random.nextInt(4)].color;
        }

        for (char c : colors) {
            System.out.print(c + " ");
        }

        System.out.println("");

        ColorSorter sorter = new ColorSorter();
        sorter.sortColor(colors, method);
    }
}
