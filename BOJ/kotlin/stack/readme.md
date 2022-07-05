
#### [17298 오큰수](https://www.acmicpc.net/problem/17298)

<img width="500" alt="image" src="https://user-images.githubusercontent.com/85485290/177319751-71d89472-4344-4a0b-a47e-08aad1dacca3.png">

> 💡 수열의 index를 차례로 stack에 넣고, 그 다음번째 수열의 값이 스택에 있는 수열들의 값보다 크면 오큰수를 찾은 것!

```
    A.mapIndexed { idx, it ->
        // stack이 비어있지 않는동안 오큰수를 찾아내면 -> 왼쪽에 있는 값들의 오큰수를 업데이트
        while(stack.isNotEmpty() && it > A[stack.peek()]) {
            NGE[stack.peek()] = it
            stack.pop()
        }
        stack.push(idx)
    }
    
```

ex)

*****************
it = 5, idx = 1

A = [ 3 5 2 7 ]

stack = [ 0 ]

5 > 3(=A[0]) 이므로 3의 NGE는 5

*****************
it = 2, idx = 2

stack = [ 1 ]

2 < 5(=A[1]) 이므로 5의 오큰수 모름, 다음으로 넘어감

*****************
it = 7, idx = 3

stack = [ 1, 2 ]

7 > 2(=A[2]) 이므로 2의 NGE는 7

7 > 5(=A[1]) 이므로 5의 NG는 7





