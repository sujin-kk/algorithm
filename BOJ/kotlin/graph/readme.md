[그래프 표현](#그래프-표현)
* [1. 인접 행렬 (Adjacency-matrix)](#1.-인접-행렬-(adjacency-matrix))
* [2. 인접 리스트(Adjacency-list) ✨](#2.-인접-리스트(adjacency-list)-✨)
* [3. 간선 리스트 (Edge List)](#3.-간선-리스트-(edge-list))

[그래프 탐색](#그래프-탐색)
* [DFS (깊이 우선 탐색, Depth First Search)](#dfs------------depth-first-search-)
* [BFS (넓이 우선 탐색, Breadth First Search) ✨](#bfs------------breadth-first-search---)
  + [연결 요소 (Connected Component)](#-------connected-component-)
  + [이분 그래프 (Bipartitie Graph)](#--------bipartitie-graph-)
 
[BFS에 대해서](#bfs에-대해서)

[트리에 대해서](#트리에-대해서)
* [2진 트리 (Binary Tree)](#2------binary-tree-)
* [포화 2진 트리 (Perfect Binary Tree)](#---2------perfect-binary-tree-)
* [완전 2진 트리 (Complete Binary Tree)](#---2------complete-binary-tree-)

[트리의 표현](#트리의-표현)

[트리의 순회](#트리의-순회)
* [프리오더 (Pre-order)](#------pre-order-)
* [인오더 (In-order)](#-----in-order-)
* [포스트오더 (Post-order)](#-------post-order-)
* [트리의 탐색](#------)
* [트리의 지름 (Diamater)](#--------diamater-)


---

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



---

### BFS에 대해서

- BFS의 목적
```
임의의 정점에서 시작해서, 모든 점점을 한 번씩 방문하는 것
```
- DFS도 목적은 같지만, 차이점은
```
BFS는 최단 거리를 구하는 알고리즘 이란 것!
```

- BFS를 이용해 해결할 수 있는 문제는 다음과 같은 조건을 만족해야 함

1. **최소 비용** 문제여야 함
2. **간선의 가중치**가 1이어야 함
3. 정점과 간선의 개수가 적어야 함 (적다는 것 = 문제의 조건에 맞춰서 해결할 수 있다는 것)

- 간선의 가중치가 문제에서 구하라고 하는 최소 비용과 의미가 일치해야 함
  - 거리의 최소값을 구하는 문제 -> **가중치 = 거리**
  - 시간의 최소값을 구하는 문제 -> **가중치 = 시간**


---

### 트리에 대해서

- 자료구조의 일종
- **사이클이 없는 연결 그래프**
- 정점의 개수 : `V`
- 간선의 개수 : `V-1`

<img width="260" alt="image" src="https://user-images.githubusercontent.com/85485290/187129877-4dae5f5d-4647-4d17-a31a-17be5ced8f52.png">

- 루트가 있는 트리 (Rooted Tree)
<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/187130283-422b28e6-dd55-49f0-8e58-50e224a39cce.png">

- 1번이 루트라고 하자 (Parent가 없다 = `Root`)
- 1은 2의 부모 -> 2는 4의 부모 `(Parent)`
- 2는 1의 자식 -> 4는 2의 자식 `(Child)`
- `Leaf Node (Termianl Node)` : 4, 5, 6, 7
- `Sibling(형제)` : 4와 5는 형제, 2와 3은 형제 -> 같은 부모를 가지면 형제
- `Depth(깊이)` : 루트에서 부터의 거리 (루트의 깊이는 0 or 1)
- `Height(높이)` : 깊이의 최대값 -> 2 or 3
- `Ancestor(조상), Descendent(자손)`
  - p -> q로 루트를 통과하지 않고 갈 수 있을 때
  - p가 q보다 루트가 가까우면
  - p는 q의 조상 (ex. 4의 조상은 4, 2, 1 / 1의 조상은 1 (자기 자신 포함_)
  - q는 p의 자손 (ex. 3의 자손은 3, 6, 7)

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85485290/187130862-0eb46a2b-441d-443e-9894-d6afe12af00b.png">

#### 2진 트리 (Binary Tree)
- 자식을 최대 2개만 가지고 있는 트리

#### 포화 2진 트리 (Perfect Binary Tree)
- 리프 노드를 제외한 노드의 자식의 수 : 2
- 리프 노드의 자식의 수 : 0
- 모든 리프 노드의 깊이가 같아야 함
- 높이가 h인 트리의 노두 개수 = $2^h -1$

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/187131735-16033a3e-03cc-4eac-b042-fb319df2daa4.png">

#### 완전 2진 트리 (Complete Binary Tree)
- 리프 노드를 제외한 노드의 자식의 수 : 2
- 리프 노드의 자식의 수 : 0
- 마지막 레벨에는 노드가 일부는 없을 수도 있음
- 오른쪽에서부터 몇 개가 사라진 형태

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/187131706-0ef4b3e7-d822-43d0-a7ad-b25a80f9a156.png">

---

### 트리의 표현
- 트리는 그래프이기 때문에, 그래프의 표현과 같은 방식으로 저장 가능
- 또는 트리의 모든 노드는 부모를 하나 또는 0개만 가지기 때문에, 부모만 저장하는 방식도 가능
- 부모가 0개인 경우는 트리의 루트인데, 이 경우 부모를 -1이나 0으로 처리

- 트리의 부모만 저장하는 방식
- `Union-Find`

<img width="500" alt="image" src="https://user-images.githubusercontent.com/85485290/187132610-6aabf825-68a1-4f5e-b9a5-aa1d06d3d49b.png">

- 완전 이진 트리의 경우 배열로 표현 가능
- `Heap`, `Segment Tree`

<img width="500" alt="image" src="https://user-images.githubusercontent.com/85485290/187132702-8a51e015-251b-43f0-94b0-6cc18d019f43.png">

- 그냥 이진 트리의 경우 -> 구조체나 클래스 이용
```c++
  struct Node {
    Node *left;
    Node *right;
  }
```

---

### 트리의 순회

<img width="380" alt="image" src="https://user-images.githubusercontent.com/85485290/187133007-4d51a682-4444-4dbc-b766-6bc1aa61794f.png">

<img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133233-5d1de65b-4c14-4f8a-8bd3-df722666fce7.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133208-7624de17-93cc-41d4-bc10-4aaa57c75de5.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133259-638f4007-f9f7-4dab-98fe-5d2bb7f6e074.png">

#### 프리오더 (Pre-order)
- 이진트리 아니어도 O

- `노드 방문` : A

- `왼쪽 자식 프리오더 `: BDE
  - 노드 방문 : B
  - 왼쪽 자식 프리오더 : D
  - 오른쪽 자식 프리오더 : E

- `오른쪽 자식 프리오더` : CFG

➡️ 순회 순서 : ABDECFG (DFS와 순서가 같다)


<img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133622-9cb45009-f915-4196-9744-09942ee587ba.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133647-78e0680f-9234-4985-97b5-418a7ed15043.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133807-2fc76d7c-f0b8-4204-839f-4291f6a8f9f0.png">

#### 인오더 (In-order)
- 이진트리가 아닌 경우 정의가 되지 않음
- 잘 안씀 -> BST (Binary Search Tree) 삭제 구현 시 인오더 successor

- `왼쪽 자식 인오더` : BDE
  - 왼쪽 자식 인오더 : D
  - 노드 방문 : B
  - 오른쪽 자식 인오더 : E

- `노드 방문` : A

- `오른쪽 자식 인오더` : FCG
  - 왼쪽 자식 인오더 : F
  - 노드 방문 : C
  - 오른쪽 자식 인오더 : G

➡️ 순회 순서 : DBEAFCG

<img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133647-78e0680f-9234-4985-97b5-418a7ed15043.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133622-9cb45009-f915-4196-9744-09942ee587ba.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133807-2fc76d7c-f0b8-4204-839f-4291f6a8f9f0.png">


#### 포스트오더 (Post-order)
- 이진트리 아니어도 O
- ⭐️ 자주 씀 -> 자식 노드를 이용해, 현재 노드 값을 구해야 할 때

- `왼쪽 자식 포스트오더` : DEB
  - 왼쪽 자식 포스트오더 : D
  - 오른쪽 자식 포스트오더 : E
  - 노드 방문 : B

- `오른쪽 자식 포스트오더` : FGC
  - 왼쪽 자식 포스트오더 : F
  - 오른쪽 자식 포스트오더 : G
  - 노드 방문 : C

- `노드 방문` : A

➡️ 순회 순서 : DEBFGCA

<img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133647-78e0680f-9234-4985-97b5-418a7ed15043.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133807-2fc76d7c-f0b8-4204-839f-4291f6a8f9f0.png"><img height="110" alt="image" src="https://user-images.githubusercontent.com/85485290/187133622-9cb45009-f915-4196-9744-09942ee587ba.png">

ex) 
- 프리오더 : ABDEGCF
- 인오더 : DBGEACF
- 포스트오더 : DGEBFCA

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/187137340-6f3a3c67-b26f-4271-baff-532381915234.png">

---

#### 트리의 탐색

- DFS/BFS 알고리즘을 이용해서 할 수 있음
- 트리는 사이클이 없는 그래프이기 때문
- 임의의 두 정점 사이 경로는 1개
- 따라서, BFS 알고리즘을 이용해서 최단 거리를 구할 수 O
- 이유 : 경로가 1개라 찾은 그 경로가 최단 경로!

---

#### 트리의 지름 (Diamater)

<img width="540" alt="image" src="https://user-images.githubusercontent.com/85485290/187138676-ba4a5775-025a-4c0d-b85d-46e34721c782.png">

<img width="480" alt="image" src="https://user-images.githubusercontent.com/85485290/187138821-873e3a61-82df-4243-937f-74dd774786a5.png">


<img width="608" alt="image" src="https://user-images.githubusercontent.com/85485290/187138863-742d4b37-68f1-4578-8bfc-35423ec82e45.png">

<img width="571" alt="image" src="https://user-images.githubusercontent.com/85485290/187138914-757f2593-7df7-4396-ba40-250e73134b69.png">




