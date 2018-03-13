import java.util.Stack;

/**
 * Created by easonjackson on 2/22/18.
 *
 * BasicCalculator calculates results of string expression
 * The input expression is assumed always valid
 * Expression contains operators: +, -, *, and /.
 * Expression contains parenthesis: ( and ) only
 * Expression contains white space, which is always omitted
 */
public class BasicCalculator {

    public int calculate(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int pre = 0;
        boolean neg = false;
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            switch (curr) {
                case '(': operators.push('(');
                          neg = false;
                          break;
                case ')': nums.push(pre); // Push in the pre num
                          neg = false;
                          while (operators.peek() != '(') {
                              char op = operators.pop();
                              int num2 = nums.pop();
                              int num1 = nums.pop();
                              nums.push(calc(op, num1, num2));
                          }
                          operators.pop(); // Pop out the '('
                          pre = nums.pop(); // Pop out pre num
                          break;
                case '*' :
                case '/' : nums.push(pre);
                             neg = false;
                             pre = 0;
                             while (!operators.isEmpty() && operators.peek() != '+' && operators.peek() != '-') {
                                 char op = operators.pop();
                                 int num2 = nums.pop();
                                 int num1 = nums.pop();
                                 nums.push(calc(op, num1, num2));
                             }
                             operators.push(curr);
                             break;
                case '-':  if (i == 0 || expression.charAt(i - 1) == ('+' | '-' | '*' | '/')) {
                                neg = true;
                                continue;
                           }
                case '+':   nums.push(pre);
                            pre = 0;
                            neg = false;
                            while (!operators.isEmpty() && operators.peek() != '(') {
                                char op = operators.pop();
                                int num2 = nums.pop();
                                int num1 = nums.pop();
                                nums.push(calc(op, num1, num2));
                            }
                            operators.push(curr);
                            break;
                case ' ': continue;
                default: if (neg) {
                            pre = pre * 10 - (curr - '0');
                         } else {
                            pre = pre * 10 + (curr - '0');
                         }
            }
        }

        nums.push(pre);
        //System.out.println(operators.peek());
        while (!operators.isEmpty()) {
            char op = operators.pop();
            int num2 = nums.pop();
            int num1 = nums.pop();
            nums.push(calc(op, num1, num2));
        }

        return nums.peek();
    }

    private int calc(char op, int num1, int num2) {
        int res = 0;
        switch (op) {
            case '+': res = num1 + num2; break;
            case '-': res = num1 - num2; break;
            case '*': res = num1 * num2; break;
            case '/': res = num1 / num2; break;
        }
        //System.out.println(res);
        return res;
    }
}
