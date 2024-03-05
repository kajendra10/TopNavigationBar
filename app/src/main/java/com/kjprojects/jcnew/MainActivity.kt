package com.kjprojects.jcnew
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kjprojects.jcnew.ui.theme.GreenJC
import com.kjprojects.jcnew.ui.theme.JCNEWTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            JCNEWTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    //modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    JCNewTopAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JCNewTopAppBar(){

    val context = LocalContext.current.applicationContext

    TopAppBar(title = { Text(text = "Whatsapp") },
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "Whatsapp", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.whtasappicon), contentDescription = "whatsapp icon" )
                
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White

        ), actions = {
            IconButton(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
            }
            IconButton(onClick = { Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Profile", tint = Color.White)
            }
            IconButton(onClick = { Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Profile", tint = Color.White)
            }
        }
    )
}

@Preview
@Composable
fun TopAppBarPreview(){
    JCNEWTheme {
        JCNewTopAppBar()
    }
}