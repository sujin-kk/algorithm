import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {

            String[] str = br.readLine().split(" "); // 3, ABC
            int R = Integer.parseInt(str[0]); // 3
            String S = str[1]; // ABC

            for(int j=0; j<S.length(); j++) {
                for(int k=0; k<R; k++) {
                    sb.append(S.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
