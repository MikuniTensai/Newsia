package com.mikunitensai.newsia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.model.News
import com.mikunitensai.newsia.room.MyDatabase
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailActivity : AppCompatActivity() {
    lateinit var tv_title: TextView
    lateinit var tv_desc: TextView
    lateinit var image: ImageView
    lateinit var btn_favorit:ImageView
    lateinit var news: News

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        init()
        getInfo()
        mainButton()
    }

    private fun mainButton() {
        insert()
    }

    private fun insert() {
        btn_favorit.setOnClickListener {
            val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database

            CompositeDisposable().add(Observable.fromCallable { myDb.daoNews().insert(news) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("respons", "data inserted")
                })

            getdata()
        }
    }

    private fun getdata() {
        val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database
        val listNote = myDb.daoNews().getAll() // get All data
        for(note :News in listNote){
            println("-----------------------")
            println(note.title)
            println(note.desc)
        }
    }

    fun init(){
        tv_title = findViewById(R.id.tv_title)
        tv_desc = findViewById(R.id.tv_desc)
        image = findViewById(R.id.image)
        btn_favorit = findViewById(R.id.btn_favorit)
    }

    private fun getInfo() {
        val newsData = intent.getStringExtra("extra")
        news = Gson().fromJson<News>(newsData, News::class.java)

        tv_title.text = news.title
        tv_desc.text = Html.fromHtml(news.desc)
        var img = "http://192.168.1.6/newsia-serverApi/public/uploads/image/"+news.image
        Picasso.get()
            .load(img)
            .placeholder(R.drawable.slider1)
            .error(R.drawable.slider1)
            .centerCrop()
            .fit()
            .into(image)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = news.title
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}