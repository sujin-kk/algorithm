import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int S = 0;
        String a = br.readLine();
        String b = br.readLine();

        StringTokenizer st = new StringTokenizer(a, " ");
        StringTokenizer st2 = new StringTokenizer(b, " ");

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        // A에서 가장 작은 값과 B에서 가장 큰 값 곱
        for(int i = 0; i<N; i++) {
            S += (A[i] * B[N-1-i]);
        }
        System.out.println(S);
    }
}
