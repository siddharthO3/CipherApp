package com.example.cipherapp


fun extractCipherCode(text: String): String {
	if (!text.contains('-')) return ""

	return text.substring(0, text.indexOf('-'))
}

fun extractCipherText(text: String): String {
	if (!text.contains('-')) return ""

	return text.substring(startIndex = text.indexOf('-') + 1)
}

fun decipherText(text: String): String {
	val str = extractCipherText(text)
	val code = extractCipherCode(text)
	var decipheredText = when (code) {
		"CC" -> caesarDecipher(str)
		"CA" -> atbashDecipher(str)
		"CT" -> transpositionDecipher(str)
		"CP" -> polyalphabeticDecipher(str)
		else -> ""
	}
	return decipheredText
}


fun caesarDecipher(text: String): String {
	var original = ""
	for (ch in text) {
		if (ch.isLetter()) {
			val c = ch.code
			val x = (((c - A) + (26 - 5)) % 26) + A
			original += x.toChar()
		}
		else
			original+=ch
	}
	return original
}

fun atbashDecipher(text: String): String {
	var original = ""

	for (ch in text) {
		if (ch.isLetter()) {
			val c: Char = ((ALPHACOMPLEMENT - (ch - 'A')) + A).toChar()
			original += c
		} else original += ch
	}
	return original
}

fun transpositionDecipher(text: String): String {
	var original = ""
	val len = text.length
	val LENOFCIPHER = "CIPHER".length
	val rows = (len / LENOFCIPHER).toInt()
	var charMatrix = Array(rows + 1) { CharArray(LENOFCIPHER) }

	//Initialise the last x blocks to be \0
	var offset = LENOFCIPHER * (rows + 1) - len
	for (i in 0..LENOFCIPHER - 1) {
		if(offset==0) break

		charMatrix[rows][LENOFCIPHER - 1 - i] = (-1).toChar()
		offset--

	}

	//Fill elements in order
	var index = 0
	for (i in 0..LENOFCIPHER-1) {
		for (j in 0..rows) {
			if (charMatrix[j][i] == (-1).toChar()) continue
			charMatrix[j][i] = text[index++]
		}
	}

	//Decipher text
	for (i in 0..rows) {
		for (j in 0..LENOFCIPHER-1) {
			if (charMatrix[i][j] == (-1).toChar()) continue
			else original += charMatrix[i][j]
		}
	}

	return original
}

fun polyalphabeticDecipher(text: String): String {
	var key = "CIPHER"
	var original = ""
	var i = 0
	while (i < text.length) {

		if(text[i].isLetter()){
			// converting in range 0-25
			var x = (text[i] -
					key[i%key.length] + 26) % 26

			// convert into alphabets(ASCII)
			x += 'A'.code
			original += x.toChar()
			i++
		}
		else
			original += text[i++]
	}
	return original
}