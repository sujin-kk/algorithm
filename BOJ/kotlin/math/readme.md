
### 나머지 연산
Modular

```
// 덧셈
(A + B) mod M = ((A mod M) + (B mod M)) mod M

// 곱셈
(A x B) mod M = ((A mod M) x (B mod M)) mod M

// 뺄셈
(A - B) mod M = ((A mod M) - (B mod M) + M) mod M
```

*****

### 최대공약수
GCD (Greatest Common Divisor)

- 두 수 A와 B의 최대 공약수 G는 A와 B의 공통 약수 중 가장 큰 정수이다.
- GCD를 구하는 가장 쉬운 방법은 2부터 min(A, B)까지 모든 정수로 나누어 보는 방법
- GCD가 1인 두 수를 서로소(Coprime)이라고 한다.

sol 1)

<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/177326442-7e286f9f-c0e2-4a37-a558-2be0a06e3698.png">

* N = max(A, B) 라고 할때, 시간 복잡도 O(N)

sol 2)

#### 유클리드 호제법 (Euclidean algorithm)

- a mod b = r 이라고 할때,
- ```GCD(a, b) = GCD(b, r)```이 성립한다.
- r이 0이될 때의 b가 최대 공약수이다.

ex)
GCD(24, 16) = GCD(16, 8) = GCD(8, 0) = 8

```재귀함수로 구현한 유클리드 호제법 ```

<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/177327393-3ba54966-80f9-4439-a080-865d1e307e55.png">

```재귀를 사용하지 않은 유클리드 호제법 ```

<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/177327781-e63f79f9-0e2e-4f73-b560-9edcc0b9ed5d.png">

* 시간 복잡도 O(logN)

*****

### 최소공배수
LCM (Least Common Multiple)

- 두 수 A와 B의 최소 공배수는 두 수의 공통된 배수 중에서 가장 작은 정수
- A와 B의 최대 공약수를 ```G```라고 햇을 때, 
- ```A x B = GCD x LCM``` 이 성립
- 최소 공배수 ```L = (A * B) / G ```

*****

### 소수
Prime Number

- 소수 : 약수가 1과 자기 자신 밖에 없는 수
- N이 소수가 되려면, 2 이상 N-1 이하의 자연수로 나누어 떨어지면 안됨

> 소수 알고리즘 두 가지

sol 1) 어떤 수 N이 소수인지 아닌지 판별하는 방법

💡 어떤 수 ```N = A x B```로 나타낼 때, N이 소수가 아니라면 ```A의 최소 = 2``` & ```B의 최대 N/2```

```즉, (N/2 + 1) ~ (N -1) 까지는 절대 약수가 있을 수가 없음```

<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/177329909-99a886a7-35f7-4c36-8b1c-5c15e075b120.png">

* 시간 복잡도 = O(logN/2) = O(logN)

OR

💡 어떤 수 ```N = A x B```로 나타낼 때, N이 소수가 아니라면 ```A < √n, B > √n```

```즉, √n 까지만 검사를 해보면 된다```

ex) 24의 경우에 √24 = 4.xxx를 기준으로 한쪽만 검사하면 됨

<img width="200" alt="image" src="https://user-images.githubusercontent.com/85485290/177331238-e73f2bcc-33ae-4ad9-96cc-45fee36b3589.png">

<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/177331375-327080bf-509c-4c3e-b86b-68abe2b7683e.png">

* 시간 복잡도 = O(√n)



sol 2) N 이하의 소수를 모두 찾아내는 방법


#### 에라토스테네스의 체 (Sieve of Eratosthenes)


- 지워지지 않은 수 중에서 가장 작은 수는 2이다.
- 2는 소수이고 2의 배수를 모두 지운다.

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/177331936-cdb54ef0-15cf-41f1-a5b6-890a21ab0f3b.png">


- 3의 배수를 지운다.
- 3*2 -> 2의 배수 때문에 지워짐, 3*3 부터 지운다.

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/177332183-b3431629-b6b4-4f9b-baaa-3e74b35cb7da.png">


- 5의 배수를 지운다.
- 5*2, 5*3, 5*4 앞에서 지워짐, 5*5 부터 지운다.

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/177332330-9dd4511c-2b60-4527-9ab7-1ad1423280b0.png">


- 7의 배수를 지운다.
- 7*2, 7*3, 7*4, 7*5 앞에서 지워짐, 7*7 부터 지운다.

<img width="250" alt="image" src="https://user-images.githubusercontent.com/85485290/177332435-c025435c-00ae-4d47-96f7-554aa3a6a5b4.png">


- 11 * 11 은 100을 넘기 때문에 생략 가능

<img width="300" alt="image" src="https://user-images.githubusercontent.com/85485290/177332708-0284c346-aa3b-4dff-b012-b73d0f2ce8f4.png">

<img width="550" alt="image" src="https://user-images.githubusercontent.com/85485290/177333532-c49ae62f-94ac-48ed-b334-bf07ef01055b.png">

* 시간 복잡도 = O(NlogN)



#### 골드바흐의 추측 (Goldbach's conjecture)

<img width="350" alt="image" src="https://user-images.githubusercontent.com/85485290/177333805-9731aeda-58ca-4f2b-b5c2-49f7ad6cdb7f.png">

> 백만 이하의 짝수에 대해서 골드 바흐의 추측을 검증할 수 있다.
- ```N = A + B``` 일때, ```N - b``` 가 소수인지 검사가 필요함


💡💡 모든 소수는 ```6n+1``` 또는 ```6n+5```의 형태로 나타난다.

*****







