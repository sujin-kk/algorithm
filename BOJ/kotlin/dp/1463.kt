
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val bw = System.`out`.bufferedWriter()
   val N = readLine().toInt()

   var counts = IntArray(N + 1){ 0 }

   // Key : counts[i] -> i를 1로 만들기 위한 최소 연산 횟수
   // i가 2와 3으로 나누어 질때
   // counts[i] = min(counts[i/2], counts[i/3]) + 1
   for(i in 2..N) {

       // Base : 1을 빼는 연산
       counts[i] = counts[i - 1] + 1

       if(i % 2 == 0){
           counts[i] = counts[i].coerceAtMost(counts[i / 2] + 1)
       }
       if(i % 3 == 0) {
           counts[i] = counts[i].coerceAtMost(counts[i / 3] + 1)
       }
   }
   bw.write("${counts[N]}")
   bw.flush()
   bw.close()
}

