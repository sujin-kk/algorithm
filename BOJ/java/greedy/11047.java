import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] coin = new int[N];
        int result = 0;

        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int j = N-1; j >= 0; j--) {
            if(K >= coin[j]){
                result += (K / coin[j]);
                K = K % coin[j];
            }
        }
        System.out.println(result);
    }
}
