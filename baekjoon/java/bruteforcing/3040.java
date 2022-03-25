import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i]; // 전체 합
        }

        // sort
        Arrays.sort(arr);
        int not1 = 0, not2 = 0; // 7난쟁이가 아닌 것들
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (sum - (arr[i] + arr[j]) == 100) {
                    not1 = i;
                    not2 = j;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(i == not1 || i == not2) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
