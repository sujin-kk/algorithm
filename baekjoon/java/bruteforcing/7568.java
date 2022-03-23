import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 내 풀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2]; // 몸무게, 키 저장
        int[] result = new int[N]; // 결과 저장

        String[] str;
        for(int i=0; i<arr.length; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        for(int i=0; i<arr.length-1; i++) {
            int rank = 1;
            for(int j=i+1; j<N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    result[i]++;
                }
                else if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    result[j]++;
                }
                else {
                    continue;
                }
            }
        }
        for(int i=0; i<N; i++) {
            sb.append(result[i]+1).append(" ");
        }
        System.out.println(sb);
    }
}

// 모범답안
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2]; // 몸무게, 키 저장

        String[] str;
        for(int i=0; i<arr.length; i++) {
            str = br.readLine().split(" "); // 1명의 몸무게와 키
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        for(int i=0; i<N; i++) {
            int rank = 1;
            for(int j=0; j<N; j++) {
                if (i==j) {
                    continue;
                }
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}
