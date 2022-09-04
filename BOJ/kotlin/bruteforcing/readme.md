### 순열

- 크기가 N인 수열의 서로 다른 순열은 총 `N!`개

- **다음 순열 (Next Permutation)**
  - 사전순으로 다음 or 이전에 오는 순열을 찾는 방법?
  - c++은 STL의 `next_permutation` or `prev_permutation` 사용 
  - ex) 1423의 다음 순열은 1432

  - 시간복잡도 `O(N)`
  <img width="332" alt="image" src="https://user-images.githubusercontent.com/85485290/187842996-410806d9-a384-4793-82a0-07f2215a790b.png">

  <img width="326" alt="image" src="https://user-images.githubusercontent.com/85485290/187843540-eb15a503-e69b-4d12-b2c3-c344a717570b.png">


- **이전 순열**
  - 다음 순열을 구할 때 부등호를 반대로 해주면 됨

- **모든 순열**
 
  - 시간복잡도 `O(N*N!)`
  - do-while문 많이 사용
  <img width="460" alt="image" src="https://user-images.githubusercontent.com/85485290/187843896-a61861e7-aef4-42b2-90d6-56012768e7a6.png">

---

### 재귀

### 비트마스크

#### 비트 연산

- 비트 연산을 사용해서 부분 집합 표현 가능
- & (and), | (or), ~ (not), ^(xor)

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85485290/188313072-08b321b7-7566-42df-8cd8-06fd899dffd9.png">

- 두 수 A와 B를 비트 연산 하는 경우에는, 가장 뒤의 자리부터 하나씩 연산을 수행하면 된다.
- A = 27, B = 83인 경우
- A = 11011(2), B = 1010011(2)
- A&B = 19, A|B = 91, A^B = 72

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85485290/188313190-d8c3e0e0-889d-4265-9753-bb9c909343e8.png">

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85485290/188313272-a09efefa-4dea-4e00-a74c-140eddce1b0e.png">

- shift left(`<<`) 와 shift right(`>>`) 연산 존재
- `A << B` (A를 왼쪽으로 B 비트만큼 민다.)
- `A << B` = `A * 2^B`
<img width="240" alt="image" src="https://user-images.githubusercontent.com/85485290/188313353-85e74067-0a17-4d16-b834-3f0bd4e2d3bf.png">

- `A > B` (A를 오른쪽으로 B 비트만큼 민다.)
- `A >> B` = `A / 2^B`
<img width="240" alt="image" src="https://user-images.githubusercontent.com/85485290/188313445-70eb9b13-0578-4ac0-98e4-f3b899a52022.png">

- 2^N 이 필요한 경우 1<<N 하면 됨.
- (A + B) / 2는 (A + B) >> 1로 쓸 수 있음.

- 연산자 우선순위 주의 -> 괄호로 해결 가능

#### 비트마스크

- 정수로 집합을 나타낼 수 있다.
- {1, 3, 4, 5, 9} = 570 = 2^1 + 2^3 + 2^4 + 2^5 + 2^9

<img width="255" alt="image" src="https://user-images.githubusercontent.com/85485290/188313656-5567391b-9b88-4a14-aa9b-9099eb12ce61.png">

- 장점 1. 배열을 사용했다면 10개 공간 필요 (0~9), 비트마스크는 정수 1개만 필요!
- 장점 2. 정수라는 것이 중요! 시간과 공간 매우 절약

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85485290/188313669-12fd7451-44e2-4adb-862f-5fe8bedbb9cb.png">

- ex) 검사 연산
<img width="360" alt="image" src="https://user-images.githubusercontent.com/85485290/188313705-1f5371b4-fbb6-462c-9689-eec06faf4a3d.png">

- ex) 추가 연산
<img width="360" alt="image" src="https://user-images.githubusercontent.com/85485290/188313751-018a1876-863d-4a73-98c6-4b20bf264f6d.png">

- ex) 제거 연산
<img width="360" alt="image" src="https://user-images.githubusercontent.com/85485290/188313785-53735328-6e42-4a6d-be74-b2dfac024cba.png">

- ex) 토글 연산
<img width="360" alt="image" src="https://user-images.githubusercontent.com/85485290/188313799-2ce25952-0c35-4360-aa10-7028d70b5480.png">

- 전체집합 & 공집합
<img width="150" alt="image" src="https://user-images.githubusercontent.com/85485290/188313813-4e80205f-1251-4a01-a6ed-cfc2ef57e561.png">

<img width="193" alt="image" src="https://user-images.githubusercontent.com/85485290/188313835-135470f8-6ad6-4f9c-aeb8-689667614d8d.png">



