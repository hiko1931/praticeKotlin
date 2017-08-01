package Base

import sun.rmi.runtime.Log

/**
 * Created by Admin on 2017-07-25.
 */
//자바에서 for문에서 조건 걸기
//fun main(args: Array<String>) {
//    for (Integer integer : list){
//        if(integer > 5){
//            integer *= 2;
//            Log.e("TAG","Index" + integer)
//        }
//    }
//}
// 아래는 코틀린
fun main(args: Array<String>) {
    val list = ArrayList<Int>()
    list.add(4)
    list.add(5)
    list.add(6)
    list.add(7)

    list.filter { it > 5 }.map { println("index : "+ it) }

    //코틀린 null 처리 List에서는 null이 포함이 가능함!

    val list2: List<Int?> = listOf(1,2,null,3,4,5) //이런식으로 <> 안에 ? 처리해주면됨.
    val intList: List<Int> = list2.filterNotNull() //이런식으로 널을 배제하고 다시 재정의함.
    intList.map { println("NotNull it"+it) }

    updateKeyword("index")

    printMap()
}


//Java에서 문자열을 합칠때 StringBuilder 코틀린에서 Interpolation $를 사용하면 된다.
fun updateKeyword(keyword: String?){
    println("Keyword : $keyword") //물론 +로 합쳐줄 수도 있다.
}


fun printMap(){
    //Map 정의 val로 선언했으니 ReadOnly
    val map = mapOf("A" to 1, "B" to 2, "C" to 3)

    //foreach를 사용하는 방법
    map.forEach { println("${it.key} -> ${it.value}") }
    
    //별도의 for를 이용하는 방법
    for ((k,v) in map){
        println("$k -> $v")
    }
}