<p align="center"><a href="https://laravel.com" target="_blank"><img src="https://blogger.googleusercontent.com/img/a/AVvXsEhifZHnzMvtFrEmH1b3QIVMM409aa7VFqzds_QaLfUMYk_3vwP0LNnOSU8oxKC_21IMAs0pChNMhtIsf4G6JAJMRh-UMHyjgML9_JIHCspBFp1mD3s-u2Z-5Juhv7CUpa4h53GTMM5oUZcZ8p5TyGVnBCIHUe-tQeQFQjpXYoQ82CzM5fU4J6LoY0vmTw=w640-h360" width="400"></a></p>

<p align="center">
<a href="https://travis-ci.org/laravel/framework"><img src="https://travis-ci.org/laravel/framework.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/dt/laravel/framework" alt="Total Downloads"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/v/laravel/framework" alt="Latest Stable Version"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/l/laravel/framework" alt="License"></a>
</p>

## Newsia RESTful API

Newsia adalah website penyedia berita Indonesia sebagai wadah informasi baru atau informasi mengenai sesuatu yang sedang terjadi, dibuat menggunakan framework laravel 8. Lalu apa keunggulannya? 

- [Simple, fast routing engine](https://laravel.com/docs/routing).
- [Powerful dependency injection container](https://laravel.com/docs/container).
- Multiple back-ends for [session](https://laravel.com/docs/session) and [cache](https://laravel.com/docs/cache) storage.
- Expressive, intuitive [database ORM](https://laravel.com/docs/eloquent).
- Database agnostic [schema migrations](https://laravel.com/docs/migrations).
- [Robust background job processing](https://laravel.com/docs/queues).
- [Real-time event broadcasting](https://laravel.com/docs/broadcasting).

Laravel dapat diakses dan menyediakan alat yang diperlukan develeper.
Database bisa menggunakan migrate atau import dari file db_newsia.sql yang sudah disediakan

## Auth 

Berikut adalah authentication untuk registrasi di API Newsia

<p align=“center”>
<a href="https://i.imgur.com/PqMB4Ou.png"><img src="https://i.imgur.com/PqMB4Ou.png" alt=“Build Status”></a>
</br>

Setelah berhasil registrasi, admin bisa melakukan login dan akan mendapatkan token dengan tipe bearir

<p align=“center”>
<a href="https://i.imgur.com/dgwVF08.png"><img src="https://i.imgur.com/dgwVF08.png" alt=“Build Status”></a>
</br>

Setelah berhasil login, admin bisa mengakses profile, dengan memasukan access token yang sudah didapat

<p align=“center”>
<a href="https://i.imgur.com/pSJYt7j.png"><img src="https://i.imgur.com/pSJYt7j.png" alt=“Build Status”></a>
</br>

Dengan access token yang didapat, admin bisa melakukan post berita terbaru

<p align=“center”>
<a href="https://i.imgur.com/LTPB5lJ.png"><img src="https://i.imgur.com/LTPB5lJ.png" alt=“Build Status”></a>
</br>

Atau bisa melakukan fetch data

<p align=“center”>
<a href="https://i.imgur.com/Ex3fUn6.png"><img src="https://i.imgur.com/Ex3fUn6.png" alt=“Build Status”></a>
</br>

Maupun mencari fetch/mencari data tertentu

<p align=“center”>
<a href="https://i.imgur.com/B2OoEzZ.png"><img src="https://i.imgur.com/B2OoEzZ.png" alt=“Build Status”></a>
</br>

lalu admin juga bisa mengeditnya

<p align=“center”>
<a href="https://i.imgur.com/eDIxfHD.png"><img src="https://i.imgur.com/eDIxfHD.png" alt=“Build Status”></a>
</br>

dan juga menghapusnya

<p align=“center”>
<a href="https://i.imgur.com/6rE9dTT.png"><img src="https://i.imgur.com/6rE9dTT.png" alt=“Build Status”></a>
</br>

Setelah itu admin bisa melakukan logout

<p align=“center”>
<a href="https://i.imgur.com/DmfQxKf.png"><img src="https://i.imgur.com/DmfQxKf.png" alt=“Build Status”></a>
</br>


## License

The Laravel framework is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).
