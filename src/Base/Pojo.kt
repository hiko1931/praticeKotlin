package Base

/**
 * Created by Admin on 2017-07-25.
 */

//코틀린은 get/set을 하지 않아도 됨.
//코틀린에서는 data class를 별도로 제공함.

//아래의 email은 val로 선언되어졌기 때문에 초기화 이후 Read-Only
data class Sample (var name: String, val email: String){
    var abc: String = ""
}

class Sample2 (){               //이런식으로 초기화도 가능.
    var name: String = ""
    var email: String = ""
    var abc: String = ""
}

fun main(args: Array<String>) {
//    ex) JAVA
//    //이러한 data class를 자바에서 접근 시에 아래와 표현 val로 선언하면 get메서드만 참조가능.
//    Sample sample = new Sample("Name","a@a.c");
//    sample.getEmail();
//    sample.setName();

//    ex) KOTLIN
    var sample: Sample = Sample("aaa","a@t.c") //이렇게 생성자로 초기화 하는 방법도 있지만 데이터 클래스 함수 내부정의로 초기화도 가능.
    sample.email
}


//함수에서의 기본값 정의

fun sample(name: String,email: String = "default"){

}

fun test(){
    sample("aaa") //sample 메서드 호출했는데 왜 두번째 매개변수를 넘겨주지 않아도 되냐면 이미 함수에서 기본값으로 "default"라고 정의했기때문
}//단 자바에서 접근했을 경우에는 default값을 정의해도 적용이 되지 않음.