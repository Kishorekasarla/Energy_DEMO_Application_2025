package com.infmenergy.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.infmenergy.navigation.Screen
import com.infmenergy.ui.theme.InfmEnergyTheme
import infmenergy.ui.screens.widgets.CheckBoxWithTitle

@Composable
fun LoginScreen(navController: NavController) {
    val loginScreenViewModel = hiltViewModel<LoginScreenViewModel>()
    val emailState = remember { mutableStateOf("info@gmail.com") }
    val passwordState = remember { mutableStateOf("Info@123") }
    var checked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.Theme_color))
    ) {
        Column(
            modifier = Modifier
                .padding(top = 2.dp, start = 72.dp, end = 74.dp, bottom = 50.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(R.drawable.summitlogowhite),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(210.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .fillMaxSize(0.71f)
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val isEmailValid = loginScreenViewModel.isEmailValid(emailState.value)
                        val isPasswordValid = loginScreenViewModel.isPasswordValid(passwordState.value)

                        Text(
                            text = stringResource(R.string.login_to_your_account),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.sf_pro_semibold)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                        )

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(R.string.e_mail),
                            fontSize = 13.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .height(58.dp)
                                .fillMaxWidth(),
                            value = emailState.value,
                            onValueChange = { emailState.value = it },
                            leadingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.mail_id),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 7.dp)
                                        .size(40.dp),
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.your_e_mail),
                                    fontSize = 14.sp,
                                    color = if (isEmailValid) Color.Gray else Color.Red,
                                    fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                                )
                            },
                            shape = RoundedCornerShape(28.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = colorResource(R.color.Theme_color),
                                unfocusedIndicatorColor = Color.Gray
                            )
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            text = stringResource(R.string.password),
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .height(58.dp)
                                .fillMaxWidth(),
                            value = passwordState.value,
                            onValueChange = { passwordState.value = it },
                            leadingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.password),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 7.dp)
                                        .size(40.dp),
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.password_outfield),
                                    fontSize = 13.sp,
                                    color = Color.Gray,
                                    fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                                )
                            },
                            shape = RoundedCornerShape(28.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = colorResource(R.color.Theme_color),
                                unfocusedIndicatorColor = Color.Gray
                            )
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            CheckBoxWithTitle(
                                checked = checked,
                                onCheckedChange = { checked = it }
                            )
                            Text(
                                text = stringResource(R.string.remember_me),
                                modifier = Modifier.padding(start = 8.dp),
                                fontSize = 12.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_regular))
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        ) {
                            Button(
                                onClick = { /* TODO: Register */ },
                                modifier = Modifier
                                    .height(32.dp)
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                border = BorderStroke(2.dp, colorResource(R.color.Theme_color)),
                                shape = RoundedCornerShape(40.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.register),
                                    fontSize = 12.sp,
                                    color = colorResource(R.color.Theme_color)
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Button(
                                onClick = {
                                    val email = emailState.value
                                    val password = passwordState.value
                                    if (loginScreenViewModel.isEmailValid(email) &&
                                        loginScreenViewModel.isPasswordValid(password)
                                    ) {
                                        loginScreenViewModel.login(email, password)
                                        navController.navigate(Screen.Home.route)
                                    }
                                },
                                modifier = Modifier
                                    .height(32.dp)
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.Theme_color)),
                                border = BorderStroke(2.dp, colorResource(R.color.Theme_color)),
                                shape = RoundedCornerShape(40.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.login_button),
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}
