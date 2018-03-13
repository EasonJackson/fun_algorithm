import java.util.ArrayList;
import java.util.List;

/**
 * Created by easonjackson on 2/5/18.
 *
 * An implementation of Knuth–Morris–Pratt algorithm.
 */
public class KMP {

    public List<Integer> searchPattern(String source, String pattern) {
        List<Integer> res = new ArrayList<>();

        if (source == null || source.length() == 0) {
            return res;
        }

        int[] helpPattern = getHelpIndex(pattern);

        int sId = 0, pId = 0;
        while (sId <= source.length() - pattern.length()) {
            if (source.charAt(sId) == pattern.charAt(pId)) {
                sId++;
                pId++;
                if (pId == pattern.length()) {
                    res.add(sId - pattern.length());
                    System.out.println("Pattern found at " + (sId - pattern.length()));
                    pId = helpPattern[pId - 1];
                }

                if (sId > source.length() - pattern.length()) {
                    return res;
                }
            } else if (pId == 0){
                sId++;
            } else {
                pId = helpPattern[pId - 1];
            }
        }

        return res;
    }

    private int[] getHelpIndex(String pattern) {
        int[] res = new int[pattern.length()];

        int i = 1, j = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                res[i++] = ++j;
            } else if (j == 0) {
                res[i] = 0;
                i++;
            } else {
                j = res[j - 1];
            }
        }
        System.out.println("Finish helping array.");
        return res;
    }
}
