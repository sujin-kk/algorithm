import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // an = a1 + (n-1)d
        int result = 0;
        if(N < 100) {
            result = N;
        }
        else {
            result = 99;
            if(N == 1000) { // 예외처리, case 1000 = 999
               N = 999;
            }

            for(int i=100; i<=N; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;
                if((hun - ten) == (ten - one)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
