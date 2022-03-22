import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i=0; i<N; i++) {
            int number = i; // 생성자 (1-N대입)
            int sum = 0; // 각 자릿수의 합

            while(number > 0) {
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == N) { // 생성자를 찾았을 경우 (i가 생성자)
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
