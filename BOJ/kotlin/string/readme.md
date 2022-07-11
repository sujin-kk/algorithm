## 자주쓰이는 문법들
[참고링크](https://keichee.tistory.com/396)


## 정렬
[참고링크](https://codechacha.com/ko/kotlin-sorting-list/)

#### 오름차순, 내림차순 정렬 : sorted() & sort()

```
sorted() : Immutable list에서 사용, 원본을 변경하지 않고 정렬된 리스트를 생성하여 리턴
sort() : Mutable list에서 사용, 원본의 요소 순서를 변경
```


#### 역순 정렬 : reversed() & reverse()

```
reversed() : Immutable list에서 사용, 리스트 순서를 역순으로 변경
reverse() : Mutable list에서 사용
```

ex)
```
    val list = listOf(10, 100, 50, 2, 77, 4)
    val sorted = list.sorted().reversed()
```

#### 정렬 규칙이 필요한 경우 : sortedWith() 함수의 람다식 & Comparator에 대한 사용 방법이 핵심

```
sortedWith() : Immutable list에서 사용
sortWith() : Mutable list에서 사용
```

ex)
```
fun main(args: Array<String>) {
    var list = listOf(2,9,6,1,7,4,3)
    list = list.sortedWith(Comparator<Int>{ a, b ->
        when {
            a > b -> 1 // 오름차순 반환
            a < b -> -1
            else -> 0
        }
    })
    println(list)
}
```

두 변수의 비교에 따라 comparator는 ```1, -1, 0```을 반환하고  sortedWith 에서는 반환값에 따라 List를 정렬

#### 리스트 요소의 데이터 타입이 1개가 아니라, 여러 객체를 가지고 있을 때, 특정 객체를 기준으로 비교하여 정렬 : sortedBy() & sortBy()

```
sortedBy() : Immutable list에서 사용
sortBy() : Mutable list에서 사용
```

ex)
```
fun main(args: Array<String>){

    val list = mutableListOf("d" to 4, "a" to 10, "c" to 8, "h" to 5)
    println("list: $list")

    list.sortBy { it.first }
    println("sortByFirst: $list")

    list.sortBy { it.second }
    println("sortBySecond: $list")
}
```

## Swap

자바에서는 두 변수값을 swap 할 때 임시 변수 temp 등을 만들어서 swap하는 것이 일반적이지만, 코틀린에서는 ```also```를 사용

ex)
```
var a = 1
var b = 2
a = b.also { b = a }
```

## 필터링

람다식을 이용해 리스트에서 특정 조건에 해당하는 것만 선별하여 반환 할 수 있음

ex)
```
val positives = list.filter { x -> x > 0 }

or 

val positives = list.filter { it > 0 }
```


## 범위

ex)
```
for (i in 1..100) { } // closed range : 100포함
for (i in 1 until 100) { } // half-open range : 100 미포함
for (x in 2..10 step 2) { } // 2부터 2씩 증가하며 10까지
for(x in 10 downTo 1) { } // 10부터 1씩 증가하며 1까지
for(x in 1..10) { } // x가 1 이상 10 이하일 때
```

## 문자열 치환

- 코틀린의 replace 메소드는 자바의 replaceAll 처럼 사용 가능

```
fun main(args: Array<String>) {
    val str = "Java with Android"
    val r = str.replace("Java", "Kotlin")
    
    print(r) // Kotlin with Android
}
```

replace의 첫번째 인수에는 검색할 문자열을 설정하고, 두번째 인수에는 치환할 문자열을 설정.

- 정규식 표현을 사용하여 문자열을 치환하고 싶은 경우, replaceAll() & toRegex()

```
fun main(args: Array<String>) {
    val str = "Java with Android"
    val re = ".a.\\w".toRegex()
    val r = str.replace(re,"Kotlin")
    
    print(r) // Kotlin with Android
}
```


- 컬렉션 타입을 이용해 for 문을 작성할 때, 인덱스 값은 indices를 이용하면 되는데, 어떤 경우에는 인덱스 값과 컬렉션 타입의 객체에 저장된 데이터를 함께 얻고 싶을 때가 있다.

- 이 때, ```withIndex()``` 함수를 이용하여 인덱스와 값을 함께 얻을 수 있음.

```
val list = listOf("One", "Two")

for ((index, value) in list.withIndex()) {
   
}
```


ex) 프로그래머스 문제

<img width="500" alt="image" src="https://user-images.githubusercontent.com/85485290/178220774-961e8634-8e73-4814-aaa2-6782c805eb5d.png">

```
class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var str = s
        val numSet = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

        for((index, num) in numSet.withIndex()) {
            str = str.replace(num, index.toString())
        }
        answer = str.toInt()
        return answer
    }
}
```

