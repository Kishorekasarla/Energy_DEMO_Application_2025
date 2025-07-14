package com.infmenergy.ui.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.runtime.SideEffect

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun LoginScreen(navController: NavController) {
    val viewModel = hiltViewModel<LoginScreenViewModel>()
    val emailState = remember { mutableStateOf("John12@gmail.com") }
    val passwordState = remember { mutableStateOf("John@123") }
    var checked by remember { mutableStateOf(false) }

    val bgColor = colorResource(R.color.white) // Outer background
    val formBgColor = colorResource(R.color.Theme_color)
    val accentFocused = colorResource(R.color.Bkv_theme_color2) // #08b894
    val accentUnfocused = colorResource(R.color.Bkv_theme_color1) // #04b49c
    val labelColor = colorResource(R.color.Bkv_theme_color5) // #104c8c
    val textWhite = Color.White
    val textError = Color.Red

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor)
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.bkv_energy_logo),
                    contentDescription = null,
                    Modifier.size(230.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .fillMaxHeight(0.72f)
            ) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    elevation = CardDefaults.cardElevation(12.dp),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(formBgColor)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        val isEmailValid = viewModel.isEmailValid(emailState.value)
                        val isPasswordValid = viewModel.isPasswordValid(passwordState.value)

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(R.string.login_to_your_account),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = textWhite,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold)),
                                modifier = Modifier.padding(vertical = 12.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = stringResource(R.string.e_mail),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = textWhite,
                                fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = emailState.value,
                                onValueChange = { emailState.value = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 5.dp),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(R.drawable.mail_id),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = stringResource(R.string.your_e_mail),
                                        color = if (isEmailValid) textWhite else textError,
                                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                                    )
                                },
                                shape = RoundedCornerShape(28.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = accentFocused,
                                    unfocusedBorderColor = accentUnfocused,
                                    cursorColor = textWhite,
                                    focusedTextColor = textWhite,
                                    unfocusedTextColor = textWhite,
                                    focusedLabelColor = labelColor,
                                    unfocusedLabelColor = labelColor
                                ),
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = stringResource(R.string.password),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = textWhite,
                                fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = passwordState.value,
                                onValueChange = { passwordState.value = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 5.dp),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(R.drawable.password),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = stringResource(R.string.password_outfield),
                                        color = if (isPasswordValid) textWhite else textError,
                                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                                    )
                                },
                                shape = RoundedCornerShape(28.dp),

                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = accentFocused,
                                    unfocusedBorderColor = accentUnfocused,
                                    cursorColor = textWhite,
                                    focusedTextColor = Color.Black,
                                    unfocusedTextColor = Color.Black,
                                    focusedLabelColor = textWhite,
                                    unfocusedLabelColor = textWhite,
                                ),
                                visualTransformation = PasswordVisualTransformation()
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                CheckBoxWithTitle(
                                    checked = checked,
                                    onCheckedChange = { checked = it }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = stringResource(R.string.remember_me),
                                    fontSize = 20.sp,
                                    color = textWhite,
                                    fontFamily = FontFamily(Font(R.font.sf_pro_regular))
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Button(
                                    onClick = { /* register logic */ },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(48.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = textWhite),
                                    border = BorderStroke(2.dp, accentFocused),
                                    shape = RoundedCornerShape(40.dp)
                                ) {
                                    Text(
                                        text = stringResource(R.string.register),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = formBgColor
                                    )
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Button(
                                    onClick = {
                                        if (isEmailValid && isPasswordValid) {
                                            viewModel.login(emailState.value, passwordState.value)
                                            navController.navigate(Screen.Home.route)
                                        }
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(48.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = accentFocused),
                                    shape = RoundedCornerShape(40.dp)
                                ) {
                                    Text(
                                        text = stringResource(R.string.login_button),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = formBgColor
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
fun PreviewLoginScreen() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}


@Composable
fun setStatusBarColor(color: Color = Color.Transparent, useDarkIcons: Boolean) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = color, darkIcons = useDarkIcons)
    }
}
