package com.example.testappjetpackcompose.ui.uiscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testappjetpackcompose.MainActivity
import com.example.testappjetpackcompose.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Google

@Composable
fun LoginScreen(
    navController: NavHostController,
    auth: FirebaseAuth,
    db: FirebaseDatabase,
    mainActivity: MainActivity
) {
    var etEmail by remember { mutableStateOf("") }
    var etPass by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(value = false) }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.intro_logo),
            modifier = Modifier.size(200.dp),
            contentDescription = "Login Image"
        )

        Text(text = "Welcome", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to your account", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = etEmail, onValueChange = {
            etEmail = it
        }, label = {
            Text(text = "Email address")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = etPass, onValueChange = {
            etPass = it
        },
            label = {
                Text(text = "Password")
            },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }

        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            login(etEmail, etPass, auth, db, mainActivity, navController)
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        TextButton(onClick = {}) {
            Text(text = "Forget Password")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Or sign in with", modifier = Modifier.clickable {

        })

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Icon(
                imageVector = FontAwesomeIcons.Brands.Github,
                modifier = Modifier.size(40.dp),
                contentDescription = "Github Icon"
            )

            Spacer(modifier = Modifier.width(32.dp))


            Icon(
                imageVector = FontAwesomeIcons.Brands.Google,
                modifier = Modifier.size(40.dp),
                contentDescription = "Google Icon"
            )

            Spacer(modifier = Modifier.width(32.dp))

            Icon(
                imageVector = FontAwesomeIcons.Brands.Facebook,
                modifier = Modifier.size(40.dp),
                contentDescription = "Facebook Icon"
            )
        }

    }
}


private fun login(
    etEmail: String,
    etPass: String,
    auth: FirebaseAuth,
    db: FirebaseDatabase,
    mainActivity: MainActivity,
    navController: NavHostController
) {
    auth.signInWithEmailAndPassword(etEmail, etPass).addOnCompleteListener(mainActivity) {
        if (it.isSuccessful) {
            Toast.makeText(mainActivity, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
            navController.navigate("four")
        } else
            Toast.makeText(mainActivity, "Log In failed ", Toast.LENGTH_SHORT).show()
    }
}
