import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int score = 0;
            int cnt = 0; // 연속 O 개수
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) == 'X') {
                    cnt = 0;
                }
                else {
                    cnt++;
                }
                score += cnt;
            }
            sb.append(score).append('\n');
        }
        System.out.println(sb);
    }
}
