package se.vbgt.ean13

class EAN13(number: String) {
    val code: String = number.replace("\\s*".toRegex(),"")

    init {
        if(code.length != 13)
            throw IllegalArgumentException("""EAN-13-koden måste bestå av 13 siffror. "$code" har ${code.length} siffor.""")
        if(!validCheckdigit(code))
            throw IllegalArgumentException("""EAN-13-koden har ogiltig checksumma""")
    }

    private fun validCheckdigit(code: String): Boolean {
        fun char2Int(c: Char): Int = c.toString().toInt()
        val code12 = code.substring(0,12)
        val suppiedCheckDigit = char2Int(code[12])
        val checkSum = code12.foldIndexed(0) {index, acc, c -> acc + char2Int(c) * if(index%2==0) 1 else 3}
        return (10-checkSum%10)%10 == suppiedCheckDigit
    }

    fun groups(): String =
        when (code[0]) {
            '0' -> "LLLLLLRRRRRR"
            '1' -> "LLGLGGRRRRRR"
            '2' -> "LLGGLGRRRRRR"
            '3' -> "LLGGGLRRRRRR"
            '4' -> "LGLLGGRRRRRR"
            '5' -> "LGGLLGRRRRRR"
            '6' -> "LGGGLLRRRRRR"
            '7' -> "LGLGLGRRRRRR"
            '8' -> "LGLGGLRRRRRR"
            '9' -> "LGGLGLRRRRRR"
            else -> throw java.lang.IllegalArgumentException("Ogiltig första siffra: $code[0]")
        }

    fun modules(): String = TODO()

    companion object {
        fun mapModule(group: Char, digit: Char): String = TODO()
    }

    fun saveImageTo(path: String): Unit = TODO("Bonus")
}
