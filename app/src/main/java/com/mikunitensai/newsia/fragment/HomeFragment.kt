package com.mikunitensai.newsia.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.adapter.AdapterNews
import com.mikunitensai.newsia.adapter.AdapterSlider
import com.mikunitensai.newsia.app.ApiConfig
import com.mikunitensai.newsia.model.News
import com.mikunitensai.newsia.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvnewNews: RecyclerView
    lateinit var rvbestNews: RecyclerView
    lateinit var rvNews: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)
        getnews()

        return view
    }

    private var listNews: ArrayList<News> = ArrayList()
    fun getnews(){
        ApiConfig.instanceRetrofit.getnews().enqueue(object : Callback<ResponModel>{
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                var res = response.body()!!
                if (res.success == 1){
                    Log.i(TAG, "onResponse: Halo")
                    listNews = res.news
                    displayLayout()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Log.i(TAG, "onFailure: Hola $t")
            }

        })
    }

    fun init(view: View){
        vpSlider = view.findViewById(R.id.vp_slider)
        rvnewNews = view.findViewById(R.id.rv_newnews)
        rvbestNews = view.findViewById(R.id.rv_bestnews)
        rvNews = view.findViewById(R.id.rv_news)
    }

    private fun displayLayout() {

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvnewNews.adapter = AdapterNews(requireActivity(), listNews)
        rvnewNews.layoutManager = layoutManager

        rvbestNews.adapter = AdapterNews(requireActivity(), listNews)
        rvbestNews.layoutManager = layoutManager2

        rvNews.adapter = AdapterNews(requireActivity(), listNews)
        rvNews.layoutManager = layoutManager3
    }

//    val arrnewNews: ArrayList<News>get(){
//        val arr = ArrayList<News>()
//        val n1 = News()
//        n1.title = "Kabar Thailand Didiskualifikasi dari Piala AFF 2020 karena Doping"
//        n1.desc = "DALAM satu hari terakhir ramai pemberitaan di media sosial bahwa Thailand didiskualifikasi dari Piala AFF 2020 karena ada salah satu pemain mereka yang positif menggunakan doping, obat yang dapat menaikkan performa si pesepakbola di lapangan. Sejumlah akun YouTube seperti Gila Bola dan banyak lagi memberitakan hal di atas. Tentunya kabar di atas langsung menaikkan optimisme pencinta sepakbola Indonesia. Jika Thailand didiskualifikasi, otomatis Timnas Indonesia keluar sebagai juara Piala AFF 2020"
//        n1.image = R.drawable.n1
//        val n2 = News()
//        n2.title = "Deretan Nama Pemain Timnas Indonesia yang Masih Bisa Tampil di Piala AFF U-23 2022"
//        n2.desc = "Sejumlah pemain timnas Indonesia yang saat ini tampil di ajang Piala AFF 2020 masih memiliki peluang untuk tampil pada ajang Piala AFF U-23 2022. Sebab, sebagian besar pemain yang dibawa oleh pelatih timnas Indonesia, Shin Tae-yong, pada ajang Piala AFF 2020 ini masih berusia muda. Dari 30 nama yang dibawa oleh Shin Tae-yong, sebagian nama pemain yang mengisi timnas Indonesia adalah pemain muda yang usianya tak lebih dari 23 tahun. Kondisi itu membuat mereka masih bisa dibawa Shin Tae-yong untuk memperkuat timnas Indonesia di Piala AFF U-23 2022."
//        n2.image = R.drawable.n2
//        val n3 = News()
//        n3.title = "3 Alasan Timnas Indonesia Bisa Juara Piala AFF U-23 Lagi"
//        n3.desc = "Piala AFF U-23 2022 akan digelar pada 14 sampai 26 Februari tahun depan. Kompetisi antar pemain muda di Asia Tenggara ini bakal digelar di Kamboja. Selain Malaysia, ada dua negara lain yang tergabung di Grup B bersama timnas Indonesia, yakni Myanmar serta Laos. Sementara Grup A dihuni oleh tuan rumah Kamboja, Timor Leste, Filipina, dan Brunei Darussalam. Kemudian Grup C terbilang dihuni tim-tim kuat yaitu Thailand, Vietnam, dan Singapura. Indonesia sendiri berstatus sebagai juara bertahan setelah di edisi 2018 lalu berhasil mengalahkan Thailand di laga final. Berikut alasan-alasan Indonesia bisa mempertahankan gelar juara Piala AFF U-23."
//        n3.image = R.drawable.n3
//        val n4 = News()
//        n4.title = "Masa Depan Cerah, 14 Pemain Timnas Senior Ini Bisa Main di Piala AFF U-23 2022"
//        n4.desc = "Sejumlah pemain timnas Indonesia yang saat ini tampil di ajang Piala AFF 2020 masih memiliki peluang untuk tampil pada ajang Piala AFF U-23 2022. Sebab, sebagian besar pemain yang dibawa oleh pelatih timnas Indonesia, Shin Tae-yong, pada ajang Piala AFF 2020 ini adalah pemain-pemain muda. Baca Juga 5 Penyebab Indonesia Kalah Telak dari Thailand pada Leg Pertama Final Piala AFF Bali United dan PSM Makassar Wakili Indonesia di Piala AFC 2022 Tampil di Piala Afrika, Mesir Panggil Mohamed Salah dan Trezeguet Jika Gagal Dapatkan Erling Haaland, Real Madrid Pertimbangkan Victor Osimhen Arsenal dan Tottenham Hotspur Incar Patrik Schick Dari 30 nama yang dibawa oleh Shin Tae-yong, mayoritas nama pemain yang mengisinya ialah pemain-pemain muda. Mereka pun masih berpeluang tampil saat skuad Garuda terjun di ajang Piala AFF U-23 2022. Setidaknya, masih ada pemain berusia di bawah 23 tahun yang bisa dibawa oleh Shin Tae-yong untuk tampil di Piala AFF U-23 2022."
//        n4.image = R.drawable.n4
//        val n5 = News()
//        n5.title = "Timnas U-23 Segrup dengan Malaysia di Piala AFF U-23 2022"
//        n5.desc = "masuk Grup B bersama Malaysia, Myanmar, dan Laos, di Piala AFF U-23 2022. Kejuaraan dengan kategori U-23 ini akan menjadi edisi pertama. Ada 11 peserta yang akan ambil bagian dalam kejuaraan ini. AFF membaginya ke dalam tiga grup yakni Grup A, B, dan C. Grup A berisi 4 tim, Grup B 4 tim, dan Grup C 3 tim. Grup A diisi Kamboja, Timor Leste, Filipina, dan Brunei. Grup C diisi Thailand, Vietnam, dan Singapura. Baca artikel sepakbola, \"Timnas U-23 Segrup dengan Malaysia di Piala AFF U-23 2022"
//        n5.image = R.drawable.n5
//        val n6 = News()
//        n6.title = "Timnas Indonesia di Final Piala AFF 2020: Mungkinkah Keajaiban Itu Ada"
//        n6.desc = "Kalah telak 0-4 pada leg pertama final Piala AFF 2020 membuat asa timnas Indonesia seperti selembar tisu terkena air, tipis dan mudah sobek. Melawan timnas Thailand dengan modal margin empat gol bukan perkara gol. Hanya keajaiban layaknya remontada Barcelona mengalahkan Paris Saint-Germain (PSG) di babak 16 besar Liga Champions 2017. Kala itu, Barcelona kalah 0-4 dari PSG pada leg pertama. Tetapi, pasukan Luis Enrique mampu membalas kemenangan 6-1 di Camp Nou. Tetapi, buka mata dan hati, timnas Indonesia bukanlah Barcelona meski Thailand juga bukan PSG Artikel ini telah tayang di Kompas.com dengan judul \"Timnas Indonesia di Final Piala AFF 2020: Mungkinkah Keajaiban Itu Ada?\", "
//        n6.image = R.drawable.n6
//
//        arr.add(n1)
//        arr.add(n2)
//        arr.add(n3)
//        arr.add(n4)
//        arr.add(n5)
//        arr.add(n6)
//
//        return arr
//    }

//    val arrbestNews: ArrayList<News>get(){
//        val arr = ArrayList<News>()
//        val n1 = News()
//        n1.title = "Kabar Thailand Didiskualifikasi dari Piala AFF 2020 karena Doping"
//        n1.desc = "DALAM satu hari terakhir ramai pemberitaan di media sosial bahwa Thailand didiskualifikasi dari Piala AFF 2020 karena ada salah satu pemain mereka yang positif menggunakan doping, obat yang dapat menaikkan performa si pesepakbola di lapangan. Sejumlah akun YouTube seperti Gila Bola dan banyak lagi memberitakan hal di atas. Tentunya kabar di atas langsung menaikkan optimisme pencinta sepakbola Indonesia. Jika Thailand didiskualifikasi, otomatis Timnas Indonesia keluar sebagai juara Piala AFF 2020"
//        n1.image = R.drawable.n1
//        val n2 = News()
//        n2.title = "Deretan Nama Pemain Timnas Indonesia yang Masih Bisa Tampil di Piala AFF U-23 2022"
//        n2.desc = "Sejumlah pemain timnas Indonesia yang saat ini tampil di ajang Piala AFF 2020 masih memiliki peluang untuk tampil pada ajang Piala AFF U-23 2022. Sebab, sebagian besar pemain yang dibawa oleh pelatih timnas Indonesia, Shin Tae-yong, pada ajang Piala AFF 2020 ini masih berusia muda. Dari 30 nama yang dibawa oleh Shin Tae-yong, sebagian nama pemain yang mengisi timnas Indonesia adalah pemain muda yang usianya tak lebih dari 23 tahun. Kondisi itu membuat mereka masih bisa dibawa Shin Tae-yong untuk memperkuat timnas Indonesia di Piala AFF U-23 2022."
//        n2.image = R.drawable.n2
//        val n3 = News()
//        n3.title = "3 Alasan Timnas Indonesia Bisa Juara Piala AFF U-23 Lagi"
//        n3.desc = "Piala AFF U-23 2022 akan digelar pada 14 sampai 26 Februari tahun depan. Kompetisi antar pemain muda di Asia Tenggara ini bakal digelar di Kamboja. Selain Malaysia, ada dua negara lain yang tergabung di Grup B bersama timnas Indonesia, yakni Myanmar serta Laos. Sementara Grup A dihuni oleh tuan rumah Kamboja, Timor Leste, Filipina, dan Brunei Darussalam. Kemudian Grup C terbilang dihuni tim-tim kuat yaitu Thailand, Vietnam, dan Singapura. Indonesia sendiri berstatus sebagai juara bertahan setelah di edisi 2018 lalu berhasil mengalahkan Thailand di laga final. Berikut alasan-alasan Indonesia bisa mempertahankan gelar juara Piala AFF U-23."
//        n3.image = R.drawable.n3
//        val n4 = News()
//        n4.title = "Masa Depan Cerah, 14 Pemain Timnas Senior Ini Bisa Main di Piala AFF U-23 2022"
//        n4.desc = "Sejumlah pemain timnas Indonesia yang saat ini tampil di ajang Piala AFF 2020 masih memiliki peluang untuk tampil pada ajang Piala AFF U-23 2022. Sebab, sebagian besar pemain yang dibawa oleh pelatih timnas Indonesia, Shin Tae-yong, pada ajang Piala AFF 2020 ini adalah pemain-pemain muda. Baca Juga 5 Penyebab Indonesia Kalah Telak dari Thailand pada Leg Pertama Final Piala AFF Bali United dan PSM Makassar Wakili Indonesia di Piala AFC 2022 Tampil di Piala Afrika, Mesir Panggil Mohamed Salah dan Trezeguet Jika Gagal Dapatkan Erling Haaland, Real Madrid Pertimbangkan Victor Osimhen Arsenal dan Tottenham Hotspur Incar Patrik Schick Dari 30 nama yang dibawa oleh Shin Tae-yong, mayoritas nama pemain yang mengisinya ialah pemain-pemain muda. Mereka pun masih berpeluang tampil saat skuad Garuda terjun di ajang Piala AFF U-23 2022. Setidaknya, masih ada pemain berusia di bawah 23 tahun yang bisa dibawa oleh Shin Tae-yong untuk tampil di Piala AFF U-23 2022."
//        n4.image = R.drawable.n4
//        val n5 = News()
//        n5.title = "Timnas U-23 Segrup dengan Malaysia di Piala AFF U-23 2022"
//        n5.desc = "masuk Grup B bersama Malaysia, Myanmar, dan Laos, di Piala AFF U-23 2022. Kejuaraan dengan kategori U-23 ini akan menjadi edisi pertama. Ada 11 peserta yang akan ambil bagian dalam kejuaraan ini. AFF membaginya ke dalam tiga grup yakni Grup A, B, dan C. Grup A berisi 4 tim, Grup B 4 tim, dan Grup C 3 tim. Grup A diisi Kamboja, Timor Leste, Filipina, dan Brunei. Grup C diisi Thailand, Vietnam, dan Singapura. Baca artikel sepakbola, \"Timnas U-23 Segrup dengan Malaysia di Piala AFF U-23 2022"
//        n5.image = R.drawable.n5
//        val n6 = News()
//        n6.title = "Timnas Indonesia di Final Piala AFF 2020: Mungkinkah Keajaiban Itu Ada"
//        n6.desc = "Kalah telak 0-4 pada leg pertama final Piala AFF 2020 membuat asa timnas Indonesia seperti selembar tisu terkena air, tipis dan mudah sobek. Melawan timnas Thailand dengan modal margin empat gol bukan perkara gol. Hanya keajaiban layaknya remontada Barcelona mengalahkan Paris Saint-Germain (PSG) di babak 16 besar Liga Champions 2017. Kala itu, Barcelona kalah 0-4 dari PSG pada leg pertama. Tetapi, pasukan Luis Enrique mampu membalas kemenangan 6-1 di Camp Nou. Tetapi, buka mata dan hati, timnas Indonesia bukanlah Barcelona meski Thailand juga bukan PSG Artikel ini telah tayang di Kompas.com dengan judul \"Timnas Indonesia di Final Piala AFF 2020: Mungkinkah Keajaiban Itu Ada?\", "
//        n6.image = R.drawable.n6
//
//        arr.add(n1)
//        arr.add(n2)
//        arr.add(n3)
//        arr.add(n4)
//        arr.add(n5)
//        arr.add(n6)
//
//        return arr
//    }

//    val arrNews: ArrayList<News>get(){
//        val arr = ArrayList<News>()
//        val n1 = News()
//        n1.title = "Kabar Thailand Didiskualifikasi dari Piala AFF 2020 karena Doping"
//        n1.desc = "DALAM satu hari terakhir ramai pemberitaan di media sosial bahwa Thailand didiskualifikasi dari Piala AFF 2020 karena ada salah satu pemain mereka yang positif menggunakan doping, obat yang dapat menaikkan performa si pesepakbola di lapangan. Sejumlah akun YouTube seperti Gila Bola dan banyak lagi memberitakan hal di atas. Tentunya kabar di atas langsung menaikkan optimisme pencinta sepakbola Indonesia. Jika Thailand didiskualifikasi, otomatis Timnas Indonesia keluar sebagai juara Piala AFF 2020"
//        n1.image = R.drawable.n1
//        val n2 = News()
//        n2.title = "Deretan Nama Pemain Timnas Indonesia yang Masih Bisa Tampil di Piala AFF U-23 2022"
//        n2.desc = "Sejumlah pemain timnas Indonesia yang saat ini tampil di ajang Piala AFF 2020 masih memiliki peluang untuk tampil pada ajang Piala AFF U-23 2022. Sebab, sebagian besar pemain yang dibawa oleh pelatih timnas Indonesia, Shin Tae-yong, pada ajang Piala AFF 2020 ini masih berusia muda. Dari 30 nama yang dibawa oleh Shin Tae-yong, sebagian nama pemain yang mengisi timnas Indonesia adalah pemain muda yang usianya tak lebih dari 23 tahun. Kondisi itu membuat mereka masih bisa dibawa Shin Tae-yong untuk memperkuat timnas Indonesia di Piala AFF U-23 2022."
//        n2.image = R.drawable.n2
//        val n3 = News()
//        n3.title = "3 Alasan Timnas Indonesia Bisa Juara Piala AFF U-23 Lagi"
//        n3.desc = "Piala AFF U-23 2022 akan digelar pada 14 sampai 26 Februari tahun depan. Kompetisi antar pemain muda di Asia Tenggara ini bakal digelar di Kamboja. Selain Malaysia, ada dua negara lain yang tergabung di Grup B bersama timnas Indonesia, yakni Myanmar serta Laos. Sementara Grup A dihuni oleh tuan rumah Kamboja, Timor Leste, Filipina, dan Brunei Darussalam. Kemudian Grup C terbilang dihuni tim-tim kuat yaitu Thailand, Vietnam, dan Singapura. Indonesia sendiri berstatus sebagai juara bertahan setelah di edisi 2018 lalu berhasil mengalahkan Thailand di laga final. Berikut alasan-alasan Indonesia bisa mempertahankan gelar juara Piala AFF U-23."
//        n3.image = R.drawable.n3
//        val n4 = News()
//        n4.title = "Masa Depan Cerah, 14 Pemain Timnas Senior Ini Bisa Main di Piala AFF U-23 2022"
//        n4.desc = "Sejumlah pemain timnas Indonesia yang saat ini tampil di ajang Piala AFF 2020 masih memiliki peluang untuk tampil pada ajang Piala AFF U-23 2022. Sebab, sebagian besar pemain yang dibawa oleh pelatih timnas Indonesia, Shin Tae-yong, pada ajang Piala AFF 2020 ini adalah pemain-pemain muda. Baca Juga 5 Penyebab Indonesia Kalah Telak dari Thailand pada Leg Pertama Final Piala AFF Bali United dan PSM Makassar Wakili Indonesia di Piala AFC 2022 Tampil di Piala Afrika, Mesir Panggil Mohamed Salah dan Trezeguet Jika Gagal Dapatkan Erling Haaland, Real Madrid Pertimbangkan Victor Osimhen Arsenal dan Tottenham Hotspur Incar Patrik Schick Dari 30 nama yang dibawa oleh Shin Tae-yong, mayoritas nama pemain yang mengisinya ialah pemain-pemain muda. Mereka pun masih berpeluang tampil saat skuad Garuda terjun di ajang Piala AFF U-23 2022. Setidaknya, masih ada pemain berusia di bawah 23 tahun yang bisa dibawa oleh Shin Tae-yong untuk tampil di Piala AFF U-23 2022."
//        n4.image = R.drawable.n4
//        val n5 = News()
//        n5.title = "Timnas U-23 Segrup dengan Malaysia di Piala AFF U-23 2022"
//        n5.desc = "masuk Grup B bersama Malaysia, Myanmar, dan Laos, di Piala AFF U-23 2022. Kejuaraan dengan kategori U-23 ini akan menjadi edisi pertama. Ada 11 peserta yang akan ambil bagian dalam kejuaraan ini. AFF membaginya ke dalam tiga grup yakni Grup A, B, dan C. Grup A berisi 4 tim, Grup B 4 tim, dan Grup C 3 tim. Grup A diisi Kamboja, Timor Leste, Filipina, dan Brunei. Grup C diisi Thailand, Vietnam, dan Singapura. Baca artikel sepakbola, \"Timnas U-23 Segrup dengan Malaysia di Piala AFF U-23 2022"
//        n5.image = R.drawable.n5
//        val n6 = News()
//        n6.title = "Timnas Indonesia di Final Piala AFF 2020: Mungkinkah Keajaiban Itu Ada"
//        n6.desc = "Kalah telak 0-4 pada leg pertama final Piala AFF 2020 membuat asa timnas Indonesia seperti selembar tisu terkena air, tipis dan mudah sobek. Melawan timnas Thailand dengan modal margin empat gol bukan perkara gol. Hanya keajaiban layaknya remontada Barcelona mengalahkan Paris Saint-Germain (PSG) di babak 16 besar Liga Champions 2017. Kala itu, Barcelona kalah 0-4 dari PSG pada leg pertama. Tetapi, pasukan Luis Enrique mampu membalas kemenangan 6-1 di Camp Nou. Tetapi, buka mata dan hati, timnas Indonesia bukanlah Barcelona meski Thailand juga bukan PSG Artikel ini telah tayang di Kompas.com dengan judul \"Timnas Indonesia di Final Piala AFF 2020: Mungkinkah Keajaiban Itu Ada?\", "
//        n6.image = R.drawable.n6
//
//        arr.add(n1)
//        arr.add(n2)
//        arr.add(n3)
//        arr.add(n4)
//        arr.add(n5)
//        arr.add(n6)
//
//        return arr
//    }

}