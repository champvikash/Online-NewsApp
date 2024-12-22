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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testappjetpackcompose.MainActivity
import com.example.testappjetpackcompose.R
import com.google.firebase.auth.FirebaseAuth
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Facebook
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.Google

@Composable
fun RegisterScreen(navController: NavHostController, mainActivity: MainActivity, auth: FirebaseAuth) {

    var etName by remember { mutableStateOf("") }
    var etEmail by remember { mutableStateOf("") }
    var etPass by remember { mutableStateOf("") }
    var etConfPass by remember { mutableStateOf("") }


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

        Text(text = "Register new account", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = etName, onValueChange = {
            etName = it
            println("Vikash kumar $etName")
        }, label = {
            Text(text = "Name")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = etEmail, onValueChange = {
            etEmail = it
        }, label = {
            Text(text = "Email")
        })

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(value = etPass, onValueChange = {
            etPass = it
        }, label = {
            Text(text = "Password")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = etConfPass, onValueChange = {
            etConfPass = it
        }, label = {
            Text(text = "Confirm Password")
        })



        Button(onClick = {
            signUpUser(etName, etEmail, etPass, etConfPass , mainActivity , auth)

            navController.navigate("third")
        }) {
            Text(text = "Register")
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


fun signUpUser(
    etName: String,
    etEmail: String,
    etPass: String,
    etConfPass: String,
    mainActivity: MainActivity,
    auth: FirebaseAuth
) {
    val name = etName
    val email = etEmail
    val pass = etPass
    val confirmPassword = etConfPass

    // check pass
    if (name.isBlank() || email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
        Toast.makeText(mainActivity, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
        return
    }

    if (pass != confirmPassword) {
        Toast.makeText(mainActivity, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
            .show()
        return
    }

    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(mainActivity) {
        if (it.isSuccessful) {
            //AddUserInDatabase
//            addUserDatabase(name, email, auth.currentUser?.uid!!)
        } else {
            Toast.makeText(mainActivity, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
        }
    }

}



//private fun addUserDatabase(name: String, email: String, uid: String) {
//
//    firebaseDatabase = FirebaseDatabase.getInstance();
//
//    databaseReference = firebaseDatabase.getReference("User")
//
//    databaseReference.child(uid).setValue(User(name, email, uid))
//
//
//
//}

