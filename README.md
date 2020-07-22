# TheMeal

Aplikasi ini adalah aplikasi untuk melihat resep masakan. Data pada apikasi ini didapat dari API https://www.themealdb.com/ oleh karena itu dibutuhkan akses internet untuk dapat digunakan. Berikut endpoint yang digunakan :

Untuk halaman utama, data yang ditampilkan berdasarkan lokasi 'Canadian' https://www.themealdb.com/api/json/v1/1/filter.php?a=Canadian 

Untuk halaman detail, data yang ditampilkan berdasarkan id, berikut salah satu contoh id '52928' https://www.themealdb.com/api/json/v1/1/lookup.php?i=52928 


Aplikasi ini telah ditambahkan fitur connection error berupa fragment pada halaman utama dan toast pada halaman detail apabila request fail/RTO.


Catatan : Jika ada data yang kosong/tidak tampil itu dikarenakan data dari API nya memang kosong. Terimakasih.
