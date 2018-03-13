/**
 * Created by easonjackson on 2/22/18.
 */
public class ColorSorter {

    public void sortColor(char[] colorSet, Color[] method) {
        // method example:
        // ['b', 'r', 'g']
        // [0, 1, 2]

        // Mapping colors to integers
        int[] checkIndex = new int[256];
        int index = 0;
        for (Color c : method) {
            checkIndex[c.color] = index++;
        }

        // Each pointer represents a color
        int[] pointers = new int[method.length];
        for (int i = 0; i < pointers.length; i++) {
            pointers[i] = -1;
        }

        for (int scanner = 0; scanner < colorSet.length; scanner++) {
            // Get current color's integer
            int colorId = checkIndex[colorSet[scanner]];

            // For all colors behind the current one, move pointers right by 1
            for (int pId = pointers.length - 1; pId >= colorId; pId--) {
                pointers[pId]++;
                colorSet[pointers[pId]] = method[pId].color;
            }
        }

        for (int i : pointers) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println(print(colorSet));
    }

    private String print(char[] colorSet) {
        StringBuilder sb = new StringBuilder();
        for (char c : colorSet) {
            sb.append(c).append(' ');
        }

        return sb.toString().trim();
    }
}
