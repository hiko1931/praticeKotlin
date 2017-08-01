package Base

/**
 * Created by Admin on 2017-07-21.
 */
//class의 헤더와 몸체는 필수가 아님. 몸체를 갖고 있지 않다면 생략가능

//이것이 주요 생성자
class ClassNObject constructor(firstName: String){
    init {
        println("initialized with value $firstName")
    }
    val customerKey = firstName.toUpperCase()
}

open class Base{        //다른 클래스에서 상속받게 하고 싶으면 open 선언해줘야함. override도 마찬가지
    open fun v(){}
    fun nv(){}
}
class Derived(p: Int) : Base() //상속받는다는 의미로 : Base(p) 붙임
{
    override fun v() {
        super.v()
    }
}
fun main(args:Array<String>){
    val ClassNObject = ClassNObject("song"); //코틀린은 new 없음
}

//오버라이딩 규칙
//코틀린에서 구현 상속은 다음 규칙을 따른다. 클래스가 바로가 바로 상위의 여러 상위클래스에서 같은 멤버 구현을 상속하면, 반드시 이 멤버
//를 오버라이딩하고 자신의 구현을 제공해야 한다(대게 상속받은 것 중의 하나를 사용하는 구현을 제공). 사용할 상위타입의 구현을 지
//정하려면 화살괄호에 상위타입 이름을 지정한 super를 사용한다(예, super<Base> ).
open class A{
    open fun f(){
        println("A")
    }
    fun a(){
        println("a")
    }
}
interface B{ //인터페이스에서 선언된 함수들은 기본적으로 'open'이다.
    fun f() {
        println("B")
    }
    fun b(){
        println("b")
    }
}

class C() : A(), B {
    override fun f() { //상위 클래스에서 중복되는 멤버를 구현하면 반드시! override해줘야함. 애초에 에러띄우니까 수정하면댐.

    }
}

//추상 클래스
abstract class Derived2 : Base(){
    override fun v() {
        super.v()
    }

    companion object fun staticFun(){ //코틀린에는 정적 메서드가 없는 대신 컴패니언 오브젝트로 선언하면 접근가능함.

    }
}

//상속을 제한할 목적이라면 sealed

sealed class Expr {
    class const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}

fun eval(expr: Expr): Double = when(expr){
    is Expr.const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    Expr.NotANumber -> Double.NaN
    //모든 경우를 다루기 때문에 'else' 절이 필요없다.
}

