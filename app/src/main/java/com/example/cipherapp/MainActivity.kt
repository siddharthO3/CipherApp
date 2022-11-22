package com.example.cipherapp


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cipherapp.ui.theme.BrailleTheme
import com.example.cipherapp.ui.theme.CipherAppThemeWithBackground
import java.util.*

var clipboardManager: ClipboardManager? = null


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

		setContent {

			CipherAppThemeWithBackground {
				Screen()
			}
		}
	}
}


var page: MutableState<String> = mutableStateOf("0")

@Composable
fun Screen() {
	var text by rememberSaveable {
		mutableStateOf("")
	}
	when (page.value) {
		"0" -> {
			IntroScreen()
			text = ""
		}
		"1a" -> {
			CipherOptions()
		}
		"1b" -> {
			DecipherUI(text = text, { text = it.uppercase(Locale.getDefault()) })
		}
		"CC", "CA", "CT", "CP" -> {
			CipherUI(option = page.value, text = text, { text = it.uppercase(Locale.getDefault()) })
		}

	}

}


@Composable
fun IntroScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.wrapContentSize(Alignment.Center),
		verticalArrangement = Arrangement.spacedBy(128.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Button(onClick = { page.value = "1a" }) {
			Text(
				textAlign = TextAlign.Center,
				text = "Cipher",
				style = MaterialTheme.typography.button,
				modifier = Modifier.padding(24.dp)
			)
		}
		Button(onClick = { page.value = "1b" }) {
			Text(
				textAlign = TextAlign.Center,
				text = "Decipher",
				style = MaterialTheme.typography.button,
				modifier = Modifier.padding(24.dp)
			)
		}
	}
}


@Composable
fun NavBar() {
	TopAppBar(title = { Text(textAlign = TextAlign.Center, text = "") }, navigationIcon = {
		IconButton(onClick = {
			when (page.value) {
				"1a", "1b" -> page.value = "0"
				"CC", "CA", "CT", "CP" -> page.value = "1a"
			}
		}) {
			Icon(
				imageVector = Icons.Filled.ArrowBack, contentDescription = "Back"
			)
		}
	})
}

@Composable
fun CipherOptions() {
	NavBar()
	Column(
		modifier = Modifier
			.fillMaxSize()
			.wrapContentSize(Alignment.Center),
		verticalArrangement = Arrangement.spacedBy(64.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		Button(onClick = { page.value = "CC" }, modifier = Modifier.fillMaxWidth()) {
			Text(
				textAlign = TextAlign.Center,
				text = "Caesar Cipher",
				style = MaterialTheme.typography.button,
				fontSize = 32.sp,
				modifier = Modifier.padding(0.dp, 4.dp)
			)
		}
		Button(onClick = { page.value = "CA" }, modifier = Modifier.fillMaxWidth()) {
			Text(
				textAlign = TextAlign.Center,
				text = "Atbash Cipher",
				style = MaterialTheme.typography.button,
				fontSize = 32.sp,
				modifier = Modifier.padding(0.dp, 4.dp)
			)
		}
		Button(onClick = { page.value = "CT" }, modifier = Modifier.fillMaxWidth()) {
			Text(
				textAlign = TextAlign.Center,
				text = "Transposition Cipher",
				style = MaterialTheme.typography.button,
				fontSize = 32.sp,
				modifier = Modifier.padding(0.dp, 4.dp)
			)
		}
		Button(onClick = { page.value = "CP" }, modifier = Modifier.fillMaxWidth()) {
			Text(
				textAlign = TextAlign.Center,
				text = "Polyalphabetic Substitution Cipher",
				style = MaterialTheme.typography.button,
				fontSize = 32.sp,
				modifier = Modifier.padding(0.dp, 4.dp)
			)
		}
	}
}

@Composable
fun CipherUI(option: String, text: String, onTextChange: (String) -> Unit) {
	var modifiedText = when (option) {
		"CC" -> caesarCipher(text)
		"CA" -> atbashCipher(text)
		"CT" -> transpositionCipher(text)
		"CP" -> polyalphabeticCipher(text)
		else -> ""
	}
	var cipher = "$option-$modifiedText"

	var ifTextCopied by remember {
		mutableStateOf(false)
	}
	var onTextCopy: String = if (ifTextCopied) "Cipher copied to clipboard" else ""


	val clipData = ClipData.newPlainText("cipher", cipher)

	NavBar()
	Column(
		modifier = Modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceEvenly,
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		Text(textAlign = TextAlign.Center, text = "Cipher", style = MaterialTheme.typography.h2)

		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			TextField(value = text, onValueChange = onTextChange, label = {
				Text(textAlign = TextAlign.Center, text = "Enter Text")
			})
			Spacer(modifier = Modifier.padding(8.dp))

			Text(
				textAlign = TextAlign.Center,
				text = cipher,
				modifier = Modifier
					.wrapContentWidth(Alignment.CenterHorizontally)
					.clickable {
						clipboardManager?.setPrimaryClip(clipData)
						ifTextCopied = true
					})
		}
		if (onTextCopy != null) {
			Text(
				text = onTextCopy,
				fontSize = 16.sp,
				color = Color.Red,
				modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
			)
		}
		Spacer(modifier = Modifier.height(32.dp))
	}

}


@Composable
fun DecipherUI(text: String, onTextChange: (String) -> Unit) {
	var originalText = decipherText(text)

	val clipData = ClipData.newPlainText("decipher", originalText)

	var ifTextCopied by remember {
		mutableStateOf(false)
	}
	var onTextCopy: String = if (ifTextCopied) "Cipher copied to clipboard" else ""

	NavBar()
	Column(
		modifier = Modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceEvenly,
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		BrailleTheme {
			Text(
				textAlign = TextAlign.Center,
				text = "Decipher",
				style = MaterialTheme.typography.h2
			)
		}

		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			TextField(value = text, onValueChange = onTextChange, label = {
				Text(textAlign = TextAlign.Center, text = "Enter Coded Text")
			})
			Spacer(modifier = Modifier.padding(8.dp))

			Text(
				textAlign = TextAlign.Center,
				text = originalText,
				modifier = Modifier
					.wrapContentWidth(Alignment.CenterHorizontally)
					.clickable {
						clipboardManager?.setPrimaryClip(clipData)
						ifTextCopied = true
					})

		}
		if (onTextCopy != null) {
			Text(
				text = onTextCopy,
				fontSize = 16.sp,
				color = Color.Red,
				modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
			)
		}
		Spacer(modifier = Modifier.height(32.dp))
	}
}

