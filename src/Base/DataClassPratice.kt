package Base

data class User(val name: String, val age: Int)

fun main(args: Array<String>) {
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)         //이런식으로 복사가능함 age값만 바뀐 객체

    //데이터 클래스와 분해선언
    val jane = User("Jane",35)
    val (name,age) = jane
    println("$name,$age year of age") //올 객체가 갖고있는 값을 변수로도 사용할 수 있음ㅋ

    class Box<T>(t: T)
}
