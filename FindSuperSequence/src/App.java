/**
 * Created by easonjackson on 2/8/18.
 */
public class App {

    public static void main(String[] args) {
        SuperSequence sse = new SuperSequence();
        String[] input1 = {"cba", "ad", "ce"};
        System.out.println(sse.findSuperSequence(input1));

        String[] input2 = {"ab", "bc", "cz"};
        System.out.println(sse.findSuperSequence(input2));

        String[] input3 = {"abcdp", "fbegdh", "bzjk", "hk"};
        System.out.print(sse.findSuperSequence(input3));
    }
}
