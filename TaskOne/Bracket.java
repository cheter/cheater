package Task.TaskOne;

import java.util.ArrayList;

/**
 * Created by Cheter on 07.06.2016.
 */
public class Bracket {
    private void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) // invalid statement
            return;

        if (leftRem == 0 && rightRem == 0) { // no more bracket pair remain 
            String s = String.copyValueOf(str);
            list.add(s);
        } else {

        /* Add the left bracket, if remain unused left parentheses */

            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

        /* Add the right bracket, if the expression is true */

            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }
    /*generate all parentheses expressions*/

    public ArrayList<String> generateParens(int counter) {
        char[] str = new char[counter * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, counter, counter, str, 0);
        return list;
    }
}
