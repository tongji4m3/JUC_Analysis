import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Deque<Character> stack = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch=='[' || ch=='{') {
                stack.push(ch);
            }
            else if (ch == ')') {
                if (stack.isEmpty() || stack.pop()!='(') {
                    System.out.println("false");
                    return;
                }
            }
            else if (ch == '}') {
                if (stack.isEmpty() || stack.pop()!='{') {
                    System.out.println("false");
                    return;
                }
            }
            else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    System.out.println("false");
                    return;
                }
            }
            else {
                throw new RuntimeException("输入不合法");
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("false");
        }
        else {
            System.out.println("true");
        }
    }
}
