package Base

/**
 * Created by Admin on 2017-07-21.
 */

//return. 리턴하는거
//break. 끝내는거
//continue 반복문의 다음으로 넘어간다.

//다 비슷한데 좀특이점이 있다면 @이용하는 부분

fun main(args: Array<String>){

    //사용 예
    loop@ for(i in 1..100){
        for (j in 1..100){
            println(j)
            if (j == 50) {
                break@loop //이렇게 지정해주면 break 한 시점에서 loop@으로 선언된 지점 다음으로 넘어감. 뭐이건 별 다를게 없다.
            }
        }
    }

    foo()
    foo2()
}

//return 비교
fun foo(){
    var ints = arrayOf(1,2,3,4,5)

    ints.forEach {
        if(it == 0) return
        println(it)                //it 포인터라고해야하나 커서라고해야하나 현재 가르치는 값인 것 같음. int반환형
    }
}
//람다식에서 리턴하고 싶다면 아래를 이용해야한다고 함. 와닿지 않음.
fun foo2(){
    var ints = arrayOf(1,2,3,4,5)

    ints.forEach lit@{
        if(it == 0) return@lit
        println(it)
    }
}

//return@a 1 이러면 라벨 @a에 1을 리턴한다라는 의미가 됨.