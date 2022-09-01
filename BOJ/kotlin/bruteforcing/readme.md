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
