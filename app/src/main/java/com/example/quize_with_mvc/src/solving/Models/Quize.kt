package com.example.quize_with_mvc.src.solving.Models

data class Quize(
   val img_question : Int,
   val answer : String,
   val title : String,
   val choice1 : String,
   val choice2 : String,
   val choice3 : String,
   val choice4 : String
)
