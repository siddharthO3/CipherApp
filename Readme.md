# CipherApp

An Android app designed to cipher and decipher various basic ciphers interactively.

<hr>

CipherApp is an Android application developed using Kotlin and Jetpack Compose in Android Studio.

### What is it?

The app is designed to cipher text entered by the user and offers an option to decipher it as well. Users can encrypt text in one of the four formats included in the app. They can copy the ciphered text and send it to others, who can use the same app to decipher it without needing to know the specific cipher algorithm. The app handles this automatically.

### Ciphers Used:

- [**Caesar Cipher**](https://en.wikipedia.org/wiki/Caesar_cipher)
  This cipher shifts each alphabet 'a' by a fixed number 'x', resulting in a ciphered alphabet 'a+x'. In this implementation, 'x' is set to 5.

- [**Atbash Cipher**](https://en.wikipedia.org/wiki/Atbash)
  The Atbash cipher takes the complement of each alphabet 'a', resulting in a ciphered alphabet '26-a'.

- [**Transposition Cipher**](https://www.tutorialspoint.com/cryptography_with_python/cryptography_with_python_transposition_cipher.htm)
  This cipher takes all the letters of the entered text, arranges them in a matrix with dimensions (rows) \* ("Word".length) row-wise. Here, the word chosen is "CIPHER". The ciphered text is then determined by reading the matrix column-wise.

- [**Polyalphabetic Substitution Cipher**](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher)
  This cipher shifts each alphabet 'a' in the text by a letter 'z' from a key, resulting in a ciphered letter 'z+a'.

<hr>

## How to Use

- The initial screen offers the options to "Cipher" or "Decipher".
- **Cipher:**

  - Here, you can choose one of the four options.
  - Then, you can enter the text in the TextField area. The ciphered result is generated automatically.
  - To copy the text, long-tap on the ciphered text, select the entire ciphered text, and then copy it. **Copying the code along with the ciphered text is necessary for deciphering to work.**

- **Decipher:**
  - Enter the text along with the code (or paste it in the TextField). If the entered code is valid, the deciphered text is displayed immediately.
- **Navigation between screens can be done only by clicking buttons or using the back button on the NavBar.**

<hr>

## Inspiration

I drew inspiration for this project from:

- [The Imitation Game (2014)](https://www.imdb.com/title/tt2084970/)
- [CS50x Week 2 Problem Set based on Ciphers](https://cs50.harvard.edu/x/2022/psets/2/)
- [The Da Vinci Code (2003)](https://en.wikipedia.org/wiki/The_Da_Vinci_Code)
  and more...

<hr>

## References

- _Da Vinci Code_ for cipher ideas.
- The aforementioned links for understanding and implementing those ideas.
- [Android Basics with Compose course](https://developer.android.com/courses/android-basics-compose/course) to learn how to implement these concepts using Kotlin and Jetpack Compose.
- Stack Overflow for clarifications on methodologies like `rememberSaveable` and `MutableState`.

<hr>
