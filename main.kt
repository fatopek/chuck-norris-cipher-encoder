package chucknorris

fun encode() {
    println("Input string:")
    val string = readln().toCharArray()
    var code = ""
    for (i in string) {
        code += Integer.toBinaryString(i.code).padStart(7, '0')
    }
    code = code.replace("01", "0 1").replace("10", "1 0")
    val result = code.split(" ")
    println("Encoded string:")
    for (j in result) {
        print(if (j.contains('1')) "0 " else "00 ")
        print("0".repeat(j.length))
        print(" ")
    }
    println("\n")
}
fun decode() {
    println("Input encoded string:")
    val s = readln().split(" ")
    for (l in s.indices step 2) {
        if (s[l].length > 2) {
            print("Encoded string is not valid.")
            println("\n")
            return
        }
    }
    if (s.all {it.all { it == '0' || it == ' ' } } && s.size % 2 == 0) {
        var c = ""
        for (i in 0 until s.lastIndex step 2) {
            if (s[i] == "00") repeat(s[i + 1].length) { c += "0" } else repeat(s[i + 1].length) { c += "1" }
        }
        if (c.length % 7 != 0) {
            print("Encoded string is not valid.")
            println("\n")
            return
        }
        println("Decoded string:")
        for (j in c.chunked(7)) {
            print("${j.toInt(2).toChar()}")
        }
    } else print("Encoded string is not valid.")
    println("\n")
}
fun main() {
    while (true) {
        println("Please input operation (encode/decode/exit):")
        when (val input = readln()) {
            "decode" -> decode()
            "encode" -> encode()
            "exit" -> break
            else -> println("There is no '$input' operation\n")
        }
    }
    print("Bye!")
}
