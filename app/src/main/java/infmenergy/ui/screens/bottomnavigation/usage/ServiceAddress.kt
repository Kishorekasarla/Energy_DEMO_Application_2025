package com.infmenergy.ui.screens.bottomnavigation.usage

data class ServiceAddress(
    val street: String?,
    val city: String?,
    val state: String?,
    val postalCode: String?,
    val unitNumber: String? = null, // Add nullable parameter for unitNumber
    val zip: String? = null // Add nullable parameter for zip
)



