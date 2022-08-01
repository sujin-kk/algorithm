
### 그래프 표현

ex)
- 정점 : {1, 2, 3, 4, 5, 6}
- 간선 : {(1,2), (1,5), (2,5), (2,3), (3,4), (2,4), (4,5), (4,6)}
<img width="350" alt="image" src="https://user-images.githubusercontent.com/85485290/182104487-c88cef6e-12af-429f-8d6b-a518e9d64a30.png">

- 그래프 저장 방법
한 정점 X와 연결된 간선을 효율적으로 찾는 구조

#### 1. 인접 행렬 (Adjacency-matrix)

정점의 개수 : ```V```, 간선 개수 : ```E```

```
A[i][j] = 1 (i -> j 간선이 있을 때, 가중치 1)
A[i][j] = 0 (간선이 없을 때)
```

한 정점과 연결 된 모든 간선을 구하는데 걸리는 시간복잡도 : ```O(V)```
공간 복잡도 : ```O(V^2)``` -> (VxV 크기의 이차원 배열 이용)

ex) 가중치 존재 O

<img width="460" alt="image" src="https://user-images.githubusercontent.com/85485290/182105190-e553661b-c7ea-4703-91d2-35a8a8dd69a9.png">


---


#### 2. 인접 리스트(Adjacency-list) ✨

A[i] = i와 연결된 정점을 리스트로 포함
```LinkedList``` 와 같이 크기를 동적으로 변경할 수 있는 배열 사용

한 정점과 연결 된 모든 간선을 구하는데 걸리는 시간복잡도 : ```O(차수)```
공간 복잡도 : ```O(E)``` -> (간선의 개수 E와 동일)


ex) 가중치 존재 X

<img width="414" alt="image" src="https://user-images.githubusercontent.com/85485290/182105834-eafc51ca-0681-4c95-9f53-f88df7995ca2.png">

ex) 가중치 존재 O

<img width="415" alt="image" src="https://user-images.githubusercontent.com/85485290/182106063-0cdcb623-f682-47d8-b2d9-9cf6b0d99b67.png">


---


#### 3. 간선 리스트 (Edge List)

인접 리스트를 사용해야 하는데 라이브러리를 쓰지 않을 때,
링크드리스트로 구현하자니 링크드리스트를 직접 구현하기 싫을 때 !

시간 복잡도 : O(차수)

배열을 이용해서 구현, 간선을 E라는 배열에 모두 저장하고 있다. -> 정렬 필요

<img width="440" alt="image" src="https://user-images.githubusercontent.com/85485290/182107141-fe7a396b-d170-4010-839e-e2a0d94b6fb3.png">

---


### 그래프 탐색

- 목적 : 임의의 정점에서 시작해서, 연결되어 있는 모든 정점을 1번씩 방문하는 것

#### DFS (깊이 우선 탐색, Depth First Search)

<img width="450" alt="image" src="https://user-images.githubusercontent.com/85485290/182112316-02c268c2-caee-45d5-bb50-13a5e8242385.png">

- ```스택```을 이용해서 최대한 깊이 가고, 갈 수 없으면 이전 정점으로 돌아감.
- 재귀 함수로 구현 (dfs(x) : x를 방문 했을 때)

<img width="310" alt="image" src="https://user-images.githubusercontent.com/85485290/182112516-4db5a47c-640a-4f1b-ae32-3c738223e26a.png">

- 인접 행렬로 구현 : O(E)
<img width="267" alt="image" src="https://user-images.githubusercontent.com/85485290/182114144-bd99cf39-536f-48c7-bc16-07659b0d8770.png">


---


#### BFS (넓이 우선 탐색, Breadth First Search) ✨

<img width="450" alt="image" src="https://user-images.githubusercontent.com/85485290/182113801-a936e987-2e17-4d22-9e87-7931dc4b80df.png">

- ```큐```를 이용해서 구현

- 인접 행렬로 구현 : O(E)
<img width="316" alt="image" src="https://user-images.githubusercontent.com/85485290/182113881-37bb52df-8213-49b5-a27c-19837775ee82.png">

---

##### 연결 요소 (Connected Component)

- 그래프가 하나일 수도, 두개일 수도 있다.
- 아래의 그래프는 2개의 연결 요소로 이루어짐.

<img width="570" alt="image" src="https://user-images.githubusercontent.com/85485290/182122944-29118c5b-e8c7-4bec-9006-13c8303a7635.png">


##### 이분 그래프 (Bipartitie Graph)

- 아래의 그래프는 그룹1 / 그룹2로 나눌 수 있음.

<img width="570" alt="image" src="https://user-images.githubusercontent.com/85485290/182123430-e39c63df-2d4c-4915-9fc0-8a575329409c.png">













