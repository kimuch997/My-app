package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
// The onCreate() method is used here to provide a bridge between the containing activity and
//the Compose-based user interfaces that are to appear within it:
        super.onCreate(savedInstanceState)
        setContent {
// method declares that the content of the activity’s user
//interface will be provided by a composable function named MyAugustApp3Theme
            MyAppTheme {
                // A surface container using the 'background' color from the theme
//Surface is a built-in Compose component designed to provide a background for other composables:
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Login()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun Login(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val context = LocalContext.current
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 50.sp,


                        )
                ){
                    append("W")
                }
                append("Welcome")
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 50.sp,


                        )
                ){
                    append("C")
                }
                append("u stomer")

            },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            textDecoration = TextDecoration.Underline,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxSize()
        )

//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_background),
//            contentDescription = null
//        )
        var name by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = name,
            onValueChange ={name = it},
            label = {Text(text ="Weka jina lako sahihi")}
        )

        Spacer(modifier = Modifier.height(30.dp))

        var email by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = email,
            onValueChange ={email = it},
            label = {Text(text ="Weka email lako sahihi")}
        )

        Spacer(modifier = Modifier.height(30.dp))

        var password by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Enter password...")}
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = { /*TODO*/
                Toast.makeText(context, "You have registered as ${name.text}", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Register")

        }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {
//        Greeting("Android")
//        if it has parameters it has to have arguments e.g greeting function
        Login()
    }
}