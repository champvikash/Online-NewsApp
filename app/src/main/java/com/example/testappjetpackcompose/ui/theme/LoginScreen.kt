package com.example.testappjetpackcompose.ui.theme

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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testappjetpackcompose.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Google


@Composable
fun LoginScreen() {
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

        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "Email address")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "Password")
        })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {}) {
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