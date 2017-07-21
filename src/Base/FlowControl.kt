package Base

import java.lang.Integer.parseInt

val a = 55
val b = 51

fun ifClassic() {
    var max = a

    if (a < b)
        max = b

    var max2: Int
    if (a > b)
        max = a
    else
        max = b

    var max3 = if (a > b) a else b
}

fun ifBranch(): Unit {
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
    var x = if (1 < 2) 1 else 2
    var s = "1";
    //C나 Java에서 switch문이라고 생각하면 된다. Branch조건으로 임의 식을 사용할 수 있다.
    when (x) {
        1 -> print("X==1")
        2 -> print("X==2")
    //임의 식을 사용한 경우
        parseInt(s) -> print("s encodes x")

    //범위나 콜렉션에 대해 in이나 !in으로 검사할 수도 있다.
        in 1..10 -> print("x is in the range")
        !in 1..10 -> print("x is outside the range")
        else -> {
            print("default message")
        }
    }
    var x2 = "test"
    //is나 !is로 특정 타입의 값인지 검사할 수 있다. 스마트 변환 덕에 추가 검사 없이 타입의 프로퍼티와 메서드에 접근할 수 있다.
    val hasPrefix = when (x2) {
        is String -> x2.startsWith("prefix")
        else -> false
    }
    print(x2)

    //when으로 if - else if 를 대체할 수 있음.
    when {
        x2.equals("test") -> print("equal!")
        else -> print("different")
    }
}

fun iteratorFun() {
    for (x in 1..10)
        println("현재의 x값 : " + x)

    println("인덱스 반복문")

    val arr = arrayOf("test1","test2")

    for (x in arr.indices)
        println(arr[x])

    //인덱스번호랑 값 둘다 표현하는 방법
    val arr2 = arrayOf("test1","test2","test3")
    for ((index,value) in arr2.withIndex()){
        println("the element at $index is $value")
    }

    var initVal = 100
    while(initVal > 0) {
        initVal--
        println("현재 initVal의 값은 :"+initVal)
    }

//    //do-while
//    do {
//        val y = ifClassic()
//    }while (y != null)
}

fun main(args: Array<String>) {
    iteratorFun()

    ifBranch()
}

