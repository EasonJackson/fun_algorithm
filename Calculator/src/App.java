/**
 * Created by easonjackson on 2/22/18.
 */
public class App {

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        String input1 = "1 - 1";
        System.out.println(input1 + " = " + calculator.calculate(input1));

        String input2 = "-1 + 10 * 2";
        System.out.println(input2 + " = " + calculator.calculate(input2));

        String input3 = "(-1) + -10 * 2";
        System.out.println(input3 + " = " + calculator.calculate(input3));

        //System.out.println('*' & '*' | '/');
    }
}
