package Base

/**
 * Created by Admin on 2017-07-18.
 */

//자바 플랫폼에서는 물리적으로 JVM 기본 타입으로 숫자를 보관한다. nullable 숫자 참조 (예. Int?) 가 필요하거나 제네릭 연관이 있다면 박싱 타입

fun main(args: Array<String>):Unit{
    //값의 참조 동일성은 유지 안됨.
    val a: Int = 10000
    println(a===a) //'true'를 출력하겠지
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // 'false'를 출력!!

    //값의 동등성은 유지됨.
    println(boxedA == anotherBoxedA) //'true'를 출력

    //명시적 변환
    //표현이 다르기 때문에 작은 범위 타입은 큰 범위 타입의 하위타입이 아니다. 만약 하위타입이 된다면 다음과 같은 상황에서 문제가 됨.
    val aa: Int? = 1
    //val bb: Long? = aa 코틀린 업데이트 되면서 에러띄워버리는 듯.
    //print(aa==bb)   //동일성은 물론 동등성까지 잃어버리는 경우가 생길 수 있음. Demotion은 애초에 막아버리는 듯 코틀린에서는

    val b: Byte = 1 //OK, 리터럴은 정적으로 검사한다.
    val i: Int = b.toInt() //OK: 명시적으로 큰 범위 타입으로 변환 Promotion은 되는 듯

    //사실 코틀린에서는 문맥에서 타입을 추론할 수 있고 수치 연산자를 각 타입 변환에 맞게 오버로딩했기 때문에, 자동 타입 변환이 없어도
    //거의 문제가 되지 않는다.


    //비트 연산 예시
    val x = (1 shl 2) and 0x000FF000
    //shl(bits) - 좌측 쉬프트 자바의 <<
    //shr(bits) - 우측 쉬프트 자바의 >>
    //ushr(bits) - 부호없는 오른쪽 쉬프트 자바의 >>>
    //and - and 비트연산
    //or - or 비트연산
    //xor - xor 비트연산
    //inv - 역 비트연산
}

//fun check(c: Char){
//    if (c==1){     //이러면 보는 바와 같이 에러를 띄운다.
//        //...
//    }
//}
//문자 리터럴은 ''을 사용하여 포장해주고 특수문자는 역슬래시를 이용해서 표시한다.
//지원하는 이스케이프 시퀀스는 \t \b \n \r \' \" \\ 그리고 \$

//하지만 특정 메서드를 이용해서 변환은 가능하다.
fun decimalDigitalValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of Range")
    return c.toInt() - '0'.toInt() //숫자로 변환
}
//숫자처럼 nullable 참조가 필요하다면 문자를 박싱한다. 박싱 연산은 동일성(identity)를 유지하지 않는다.
//동일성이란 같은 주소값을 갖지않는다라는 이야기인 듯

//부울타입
//true or false값을 갖는다. nullable 참조가 필요하다면 Boolean을 박싱한다.
//기본적인 내장 연산은 다음과 같다.
//|| - lazy 논리 합
//&& - lazy 논리 곱
//!  - 부정
//lazy는 늦은 초기화 즉 처음에 null로 초기화하고 호출시점에서 갖다가 매번 다시 초기화하는 경우가 있는데
//lazy를 선언함으로서 호출시점에서 초기화가 가능해진다.


//배열
//코틀린은 Array 클래스를 이용하여 배열을 표현한다. 이 클래스는 get set함수와 size 프로퍼티를 가지며 몇 개의 다른
//유용한 멤버 함수가 있다.(get set함수는 연산자 오버로딩 규칙에 따라 []로 바뀐다.)
//참조 예시는 공식 문서 19페이지 배열에 있음!

//arrayOf() 라이브러리 함수를 이용하여 배열을 생성할 수 있음. 이 함수에 값 목록을 제공한다.
//예를 들어 arrayOf(1, 2, 3)은 [1, 2, 3] 배열을 생성한다. arrayOfNulls() 라이브러리 함수를 사용하면 null을 값으로 갖는
//지정한 크기의 배열을 생성한다.

//주의 :: 자바와 달리 코틀린의 배열은 무공변이다. Array<String>을 Array<Any>에 할당할 수 없음을 의미한다.
//이는 런타임 실패를 가능한 방지한다.

//코틀린은 기본 타입 배열을 위해 박싱 오버헤드가 없는 ByteArray, ShortArray, IntArray 등의 클래스를 제공한다.
//이 클래스는 Array 클래스 상속 관계를 갖지 않지만, 동일한 메서드와 프로퍼티를 갖는다. 또한 각 클래스르 ㄹ위한 팩토리
//존재한다.
fun arrayExpression(){
    val x: IntArray = intArrayOf(1,2,3)
    x[0] = x[1] + x[2]
}

//코틀린은 두 종류의 문자열 리터럴을 갖는다. 하나는 이스케이프드 문자를 가질 수 있는 이스케이프드 문자열이고, 다른 하나는
//뉴라인과 임의 텍스트를 가질 수 있는 raw 문자열이다. 이스케이프드 문자열은 자바와 흡사하다.
//사용 예)
fun escapedEx(){
    val s = "Hello, world! \n"
}
//raw문자열은 세 따옴표로 구분한다. 이스케이프는 안되고 뉴라인과 모든 다른 문자를 포함가능
fun rawEx(){
    val text = """
        for (c in  "foo")
            print(c)
    """

    val text2 = """
    |Tell me and I forget.
    |Teach me and I remeber.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    //|가 접두사로 사용되어 있는데 접두사를 바꾸고싶다면 trimMargin("바꿀 문자")를 이용해서 변경이 가능하다.
}

//문자열 템플릿
fun templateEx(){
    //문자열 중간에 변수를 추가시키고 싶을떄 $변수명으로 추가시켜준다.
    var i = 10
    var str = "i = $i" // result -> "i = 10"

    val s = "abc"
    val string = "$s.length is ${s.length}" // result -> abc.length is 3

    //템플릿은 raw 문자열과 이스케이프드 문자열에서 모두 지원한다. (역슬래시를 이용한 특수 문자 표기를 지원하지 않는) raw 문자열에
    //서 $ 문자를 표현하고 싶다면 다음 구문을 사용한다.

    val price = """
    ${'$'}9.99
    """
}

