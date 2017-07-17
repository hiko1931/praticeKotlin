import java.util.*

/**
 * Created by Admin on 2017-07-17.
 */
/*
@author song
 */

fun main(args: Array<String>){
    if (args.size < 2){
        print("Two integers expected")
        return
    }

    val x = parseInt(args[0])
    val y = parseInt(args[1])

//    //두 값이 null일 수 있으므로 x*y가 에러를 발생할 수 있음.
//    if(x != null && y != null){
//        print(x*y)
    }

    //널 값 체크로는 아래의 방법이 더 좋아보임...
    if(x==null){
        print("Wrong number format in '${args[0]}'")
        return
    }
    if(y==null){
        print("Wrong number format in '${args[0]}'")
        return
    }

    print(x*y)
}

fun parseInt(str: String): Int?{
    //...
    return 0;
}

