## - [2675](https://www.acmicpc.net/problem/2675)

BufferReader은 Line 단위로 문자열을 받기 때문에 문자열을 분리해야 할 상황이 올 수 있음
# StringTokenizer
1. 띄어쓰기 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열); 

2. 구분자를 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열, 구분자);

3. 구분자를 기준으로 문자열을 분리할 때 구분자도 포함O. (true)
구분자를 분리된 문자열 토큰에 포함X. (false, default) 
StringTokenizer st = new StringTokenizer(문자열 , 구분자 , true/false);

4. StringTokenizer st = new StringTokenizer(str, "!:");
와 같이 여러개의 구분자를 이용할 수 있음!

- 자주쓰는 메소드 정리

| return | method | what |
| ------ | ------ | ---- |
| boolean | hasMoreTokens() | 남아 있는 token이 있는지 |
| String | nextToken() | 다음 토큰을 반환 |
| String | nextToken(String delim) | delim을 기준으로 다음 토큰을 반환 |
| int | countTokens() | 총 토큰 개수 리턴 |

- StringTokenizer와 split의 차이?
    - ST는 문자or문자열로 구분하지만, split은 정규표현식으로 구분
    - ST는 빈 문자열을 토큰으로 인식X, split은 빈 문자열을 토큰으로 인식O
    - ST는 결과값이 문자열(String), split은 결과값이 문자열 배열(String[])
    - ST를 이용할 경우 전체 토큰을 보고싶다면 반복문을 이용해 하나하나 뽑아야 함

```
    // sol 1)
    String str = br.readLine(); // 2 ABC
    StringTokenizer st = new StringTokenizer(str, " ");
    int R = Integer.parseInt(st.nextToken());
    String S = st.nextToken();
```

```
    // sol 2)
    String[] str = br.readLine().split(" "); // 3, ABC
    int R = Integer.parseInt(str[0]); // 3
    String S = str[1]; // ABC
```


# for each문
```sh
for (각 요소 : 배열 or 컨테이너) {
    반복 수행 작업
}
```

