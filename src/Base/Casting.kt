package Base

/**
 * Created by Admin on 2017-07-21.
 */

fun main(args: Array<String>){
    val a: String = "ABC"

    //String을 강제로 형 변환 할 경우에는 castException이 발생하여 이 경우 null이 저장
    val aInt: Int? = a as? Int

    //null이 아닌 0으로 저장
    val bInt: Int? = a as? Int?:0

    println(aInt)
    println(bInt)

    //filterNotNullTest()

    letTest()
}


fun filterNotNullTest(){
    val nullableList : List<Int?> = listOf(1, 2, null, 4)

    for (i in nullableList) {
        print("${i}")
    }
    println("")

    //nullFilter
    val intList: List<Int> = nullableList.filterNotNull()
    for (i in intList){
        print("${i}")
    }
}

fun letTest(){
    val listWithNulls: List<String?> = listOf("A",null,"B")
    for (item in listWithNulls) {
        print("${item}")
    }
    println("")
    for (item in listWithNulls)
        item?.let { print(it) } // prints A and ignores null
}

//코틀린은 null을 기본적으로 허용하지 않습니다. 하지만 개발을 하다 보면 null이 필요한 경우도 있고, null이 예기치 않게 발생할 수 있습니다.
//
//Android Annotations을 활용하면 @Nullable와 @NotNull을 Annotations으로 적용할 수 있습니다.
//
//java에서는 @Nullable이 올 경우 개발자가 if () 등을 활용하여 null을 명시적으로 예외 처리해 주어야 합니다.
//
//코틀린에서는 이를 ?. 또는 ?.let {}을 사용한다면 안전하게 null을 사용할 수 있습니다.
//
//기본 문법에 이어 Kotlin의 null 예외 처리를 정리해보았습니다.