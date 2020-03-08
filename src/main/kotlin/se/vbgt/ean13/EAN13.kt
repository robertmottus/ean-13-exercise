package se.vbgt.ean13

class EAN13(number: String) {

    init {
        if(number.length != 13)
            throw IllegalArgumentException("""EAN-13-koden måste bestå av 13 siffror. "$number" har ${number.length} siffor.""")
    }

    fun groups(): String = TODO()
    fun modules(): String = TODO()

    companion object {
        fun mapModule(group: Char, digit: Char): String = TODO()
    }

    fun saveImageTo(path: String): Unit = TODO("Bonus")
}
