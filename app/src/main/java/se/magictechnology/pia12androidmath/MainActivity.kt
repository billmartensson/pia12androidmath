package se.magictechnology.pia12androidmath

import android.os.Bundle
import android.view.ViewManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import se.magictechnology.pia12androidmath.ui.theme.Pia12androidmathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pia12androidmathTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Mathscreen()
                }
            }
        }
    }
}

@Composable
fun Mathscreen(mathvm : MathViewmodel = viewModel()) {

    val mathresult by mathvm.mathresult.collectAsState()

    var number1text by remember { mutableStateOf("") }
    var number2text by remember { mutableStateOf("") }

    Column {
        Text("Math")

        if(mathresult != null) {
            Text(mathresult.toString())
        }

        TextField(
            value = number1text,
            onValueChange = { number1text = it },
            modifier = Modifier.semantics { contentDescription = "textfield1" }
        )

        TextField(
            value = number2text,
            onValueChange = { number2text = it },
            modifier = Modifier.semantics { contentDescription = "textfield2" }
        )

        Button(onClick = {
            mathvm.addnumbers(number1text, number2text)
        }) {
            Text("Add")
        }
        Button(onClick = {
            mathvm.multi(number1text, number2text)
        }) {
            Text("Multi")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MathscreenPreview() {
    Pia12androidmathTheme {
        Mathscreen()
    }
}