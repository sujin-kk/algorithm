public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] notSelf = new boolean[10001]; // 1...10000

        // 1부터 10000 중에 해당 수를 생성자로 하는 수가 있으면 그 수를 거르면 됨
        for(int i = 1; i <= 10000; i++) {
            int n = d(i); // 생성자 -> i를 생성자로 하는 넘버 n

            if(n < 10001) { // 10000 보다 큰 셀프 넘버는 고려X
                notSelf[n] = true; // 생성자가 존재하는 넘버
            }
        }

        for(int i=1; i<=10000; i++) {
            if(!notSelf[i]) { // self number만 출력
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    // d 함수, n을 생성자로 하는 수 리턴
    public static int d(int n) {
        int sum = n;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
