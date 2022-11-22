package com.example.cipherapp

val A: Int = 'A'.code
val ALPHACOMPLEMENT: Int = 'Z'.code - 'A'.code

fun cipherText(option: String, text: String): String {
    var cipheredText = when (option) {
        "CC" -> caesarCipher(text)
        "CA" -> atbashCipher(text)
        "CT" -> transpositionCipher(text)
        "CP" -> polyalphabeticCipher(text)
        else -> "Invalid Choice"
    }
    return cipheredText
}

fun caesarCipher(text: String): String {
    var cipherText = ""
    for (ch in text) {
        if (ch.isLetter()) {
            val c: Int = ch.code

            cipherText += (((c - A) + 5) % 26 + A).toChar()
        } else cipherText += ch
    }
    return "$cipherText"
}

fun atbashCipher(text: String): String {
    var cipherText = ""
    for (ch in text) {
        if (ch.isLetter()) {
            val c: Char = ((ALPHACOMPLEMENT - (ch.code - A))+ A).toChar()
            cipherText += c
        } else cipherText += ch
    }
    return "$cipherText"
}

fun transpositionCipher(text: String): String {
    var cipherText = ""
    val len = text.length
    val LENOFCIPHER = "Cipher".length
    val rows = (len / LENOFCIPHER).toInt()
    var charMatrix = Array(rows+1) { CharArray(LENOFCIPHER) }

    var index = 0
    for (i in 0..rows) {
        for (j in 0..LENOFCIPHER - 1) {
            if (index < len) charMatrix[i][j] = text[index++]
            else charMatrix[i][j] = 0.toChar()
        }
    }

    for (i in 0..LENOFCIPHER - 1) {
        for (j in 0..rows) {
            if (charMatrix[j][i] == 0.toChar()) continue
            else cipherText += charMatrix[j][i]
        }
    }

    return "$cipherText"
}

fun polyalphabeticCipher(text: String): String {
    val key = "CIPHER"
    val lenKey = key.length
    var cipherText = ""

    for (i in 0..text.length - 1) {
        if (text[i].isLetter()) {
            var x = (text[i].code + key[i % lenKey].code) % 26
            cipherText += (x + A).toChar()
        }
        else cipherText+=text[i]
    }

    return "$cipherText"
}
