package com.example.myapplicationnumber

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform