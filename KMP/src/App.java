import java.util.List;

/**
 * Created by easonjackson on 2/5/18.
 */
public class App {

    public static void main(String[] args) {
        KMP solution = new KMP();
        List<Integer> index = solution.searchPattern("abcabcabcdddd", "abcd");

    }
}
