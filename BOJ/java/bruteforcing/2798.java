import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]); // 카드 개수
        int M = Integer.parseInt(str[1]); // 외치는 수

        String str2 = br.readLine();
        StringTokenizer st = new StringTokenizer(str2, " ");

        int[] num = new int[N];
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i< N - 2; i++) { // 5 6 7 8 9
            for(int j = i+1; j < N - 1; j++) { //  6 7 8 9
                for(int k = j+1; k<N; k++) { // 7 8 9
                    int sum = num[i] + num[j] + num[k];

                    if(sum == M) {
                        System.out.println(sum);
                        return;
                    }

                    if(sum > max && sum < M) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
