package com.mikunitensai.newsia.model

import java.io.Serializable

class News : Serializable {
    lateinit var title:String
    lateinit var desc:String
    var image:Int = 0
}