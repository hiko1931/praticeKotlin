package Base

/**
 * Created by Admin on 2017-07-21.
 */

//프로퍼티 선언
public class Address{
    public var name: String = "ildo2dong"
    public var street: String = "gomaro"
    public var city: String = "jeju"
}

//자바필드처럼 단순한 이름으로 참조하면 됨.
fun copyAddress(address: Address): Address{
    val result = Address() // 코틀린은 new가 없다.
    result.name = address.name //accessor 실행
    result.street = address.street

    return result
}