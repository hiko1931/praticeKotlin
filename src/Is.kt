/**
 * Created by Admin on 2017-07-17.
 */
fun getStringLengthFirstMethod(obj: Any): Int?{
    if(obj is String){
        return obj.length
    }

    return null
}

fun getStringLengthSecondMethod(obj: Any): Int?{
    if(obj !is String)
        return null

    //'obj'는 이 브랜치에서 자동으로 'String'으로 변환
    return obj.length
}

fun getStringLengthThirdMethod(obj: Any): Int?{
    //'&&'의 우측에서 자동으로 'String'으로 변환
    if (obj is String && obj.length > 0)
        return obj.length

    return null
}