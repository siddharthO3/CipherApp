# CipherApp
 An Android app which can cipher and decipher some basic ciphers in an interactive way

<hr>
A Cipher App made using Kotlin and Jetpack Compose in Android Studio.

### What it is..

The App is made to cipher text that the user enters, and also has an option to decipher the same.
The user can cipher any text in one of the 4 formats I have included, and can copy the ciphered text, and send to someone else, who can use the same app to decipher it. The user deciphering it doesn't need to know what kind of cipher algorithm the cipher is using, the app will figure that out itself.

### Cipher's used:

- [**Caesar Cipher**]([Caesar cipher - Wikipedia](https://en.wikipedia.org/wiki/Caesar_cipher))
	This cipher shifts some alphabet ***'a'*** by some ***'x'*** letters, thus ciphered alphabet being ***'a+x'***. Here I have implemented *'x'* to be ***5***
- [Atbash Cipher]([Atbash - Wikipedia](https://en.wikipedia.org/wiki/Atbash))
	This cipher takes the complement of some alphabet **'a'**, thus the ciphered alphabet being 
	***'26-a'***.
- [Transposition Cipher]([Transposition Cipher (tutorialspoint.com)](https://www.tutorialspoint.com/cryptography_with_python/cryptography_with_python_transposition_cipher.htm))
	This cipher takes all letters of the entered text, enters them into a matrix of dimensions 
	(rows)\*("Word".length) rowise, where the word chosen was **"CIPHER"**. 
	Then the ciphered text is determined by reading the matrix columnwise.
- [Polyalphabetic Substitution Cipher]([Vigenère cipher - Wikipedia](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher))
	This cipher shifts some alphabet **'a'** in the text by some letter **'z'** from a key, thus the ciphered letter being **'z+a'**.

<hr>
## How to use
- The first screen gives the option to ***Cipher*** or ***Decipher***
- **Cipher:**
	- Here you can choose any one of the 4 options.
	- After that, you can enter the text in the TextField area.
	  The Ciphered result is generated automatically.
	- Long tap on the ciphered text and select the whole ciphered text. Thereafter, you can copy the text. 
	  **Copying the code along with the ciphered text is necessary for the deciphering to work.**
- **Decipher:** 
	- Enter the text along with the code (or just paste in the TextField). If the Code entered is valid, then the deciphered text is displayed immediately.
- **Navigation within screens can only be done by clicking buttons or using the back button on the NavBar.**

<hr>
## Inspiration

I got the inspiration to do this project from:
- [The Imitation Game(2014)](https://www.imdb.com/title/tt2084970/)
- [CS50x Week 2 Problem Set based on Ciphers]([Problem Set 2 - CS50x 2022 (harvard.edu)](https://cs50.harvard.edu/x/2022/psets/2/))
- [Da Vinci Code(2003)]([The Da Vinci Code - Wikipedia](https://en.wikipedia.org/wiki/The_Da_Vinci_Code))
and more..

<hr>
## References
- *Da Vinci Code* for cipher ideas.
- The aforementioned links for understanding and implementation of those ideas.
- [Android Basics with Compose course](https://developer.android.com/courses/android-basics-compose/course)  to learn how to implement the things in Kotlin and Jetpack Compose
- StackOverFlow for doubt clearances in methodologies like 
  *rememberSaveable* and *MutableState*
<hr>
