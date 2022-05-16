import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // init
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        String S = br.readLine();

        for(int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);

            if(arr[ch -'a'] == -1) {
                arr[ch -'a'] = i;
            }
        }

        for(int val : arr) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}
