import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int[] stack;
    public static int size = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scan.nextInt();
        stack = new int[N];
        for(int i=0; i<N; i++) {
            String str = scan.next();

            switch(str) {
                case "push":
                    push(scan.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int X) {
        stack[size] = X;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        }
        else {
            int temp = stack[size-1];
            stack[size-1] = 0;
            size--;
            return temp;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size-1];
        }
    }
}
