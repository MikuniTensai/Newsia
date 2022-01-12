package com.mikunitensai.newsia.model

class ResponModel {
    var success = 0
    lateinit var message:String
    var user = User()
    var news:ArrayList<News> = ArrayList()
}