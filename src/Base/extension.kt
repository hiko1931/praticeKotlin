package Base

/**
 * Created by Admin on 2017-07-26.
 */

fun main(args: Array<String>) {

    val l = mutableListOf(1, 2, 3)
    l.swap(1,2)
}

//기존에 있던 메서드에 .메서드명 하면 확장시킬 수 있음.
fun MutableList<Int>.swap(index1: Int, index2: Int){
    print("$index1 + $index2 : ")
}


