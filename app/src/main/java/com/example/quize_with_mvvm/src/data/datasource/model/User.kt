package com.example.quize_with_mvvm.src.data.datasource.model

import java.io.Serializable

data class User(
    var name:String,
    var score:Int=0
):Serializable
