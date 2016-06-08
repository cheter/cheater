package Task.TaskOne;
import Task.TaskOne.Bracket;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Cheter on 07.06.2016.
 */
public class BracketApp {
    public static void main(String[] args) {
        Bracket s = new Bracket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        ArrayList<String> EndList = s.generateParens(N);
        System.out.println(EndList);
        System.out.print("The number of parentheses: ");
        System.out.println(EndList.size());
    }
}
