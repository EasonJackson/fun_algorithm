/**
 * Created by easonjackson on 3/11/18.
 *
 * Find the greatest common divisor between two non-negtive integers p and q
 * If q == 0, then the answer is p
 * If q != 0, take the remainder p % q, and the answer is gcd(q, r)
 */
public class GreatestCommonDivisor {

    public static int greatestCommonDivisor(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;

        return greatestCommonDivisor(q, r);
    }
}
