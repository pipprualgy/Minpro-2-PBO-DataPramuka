# Minpro 2 PBO Data Pramuka
## Deskripsi Singkat
Program Manajemen Data Pramuka merupakan sistem berbasis konsol (CLI) yang dikembangkan menggunakan bahasa pemrograman Java untuk membantu proses pengelolaan data administrasi organisasi kepramukaan secara terstruktur. Sistem ini dibangun dengan menerapkan konsep Object-Oriented Programming (OOP) serta menggunakan struktur data ArrayList untuk menyimpan informasi selama program berjalan. Program ini memiliki tiga entitas utama yang direpresentasikan melalui kelas GugusDepan, Kwarran, dan AnggotaPramuka. Khusus untuk entitas AnggotaPramuka, terdapat penerapan pewarisan (inheritance) yang membaginya menjadi dua sub-kelas spesifik, yaitu kelas Siswa dan kelas Pembina. Seluruh alur menu, validasi input, serta operasi CRUD (Create, Read, Update, Delete) dikelola secara terpusat melalui kelas LogicCRUD dan dijalankan melalui kelas utama MinproDataPramuka.

## Alur Program
Program Manajemen Data Pramuka dijalankan melalui class MinproDataPramuka yang bertindak sebagai entry point dengan fungsi utama main() untuk memanggil method logic.mulai() dari class LogicCRUD. Ketika class LogicCRUD dipanggil, konstruktor secara otomatis menginisialisasi Scanner untuk membaca inputan pengguna serta menyiapkan tiga struktur data ArrayList—yaitu gugusDepan, kwarran, dan anggotaPramuka beserta data awal (dummy data) yang sudah terisi di dalamnya. Selanjutnya, method mulai() menampilkan menu utama berbasis teks menggunakan perulangan do-while dan percabangan switch-case yang divalidasi dengan hasNextInt() agar program terus berjalan hingga pengguna memilih opsi keluar.

Jika pengguna memilih menu Gugus Depan (pilihan 1), program akan membuka submenu CRUD yang memungkinkan pengguna untuk menambah data baru dengan memasukkan nomor, nama, dan pangkalan ke dalam objek GugusDepan, melihat seluruh daftar melalui perulangan dan method tampilkanData(), memperbarui data yang ada menggunakan method setter, serta menghapus data berdasarkan nomor urut. Alur yang hampir serupa juga berlaku pada menu Kwartir Ranting (pilihan 2), dimana pengguna dapat mengelola data ID dan nama Kwarran secara interaktif melalui submenu CRUD yang tersedia di dalam ArrayList kwarran
Pada menu Anggota Pramuka (pilihan 3), program menerapkan konsep pewarisan (inheritance) di mana pengguna dapat memilih jenis anggota berupa Siswa atau Pembina sebelum memasukkan data umum seperti ID, nama, jenis kelamin, nomor Gugus Depan, dan ID Kwartir Ranting. Pengguna juga dapat melihat data anggota secara spesifik (khusus siswa, khusus pembina, atau keseluruhan) menggunakan operator instanceof, serta melakukan pembaruan maupun penghapusan data anggota. Terakhir, jika pengguna memilih menu Keluar (pilihan 4), program akan mencetak pesan selesai, menghentikan perulangan, dan menutup aliran scanner menggunakan input.close().

## Penjelasan Penerapan Encapsulation dan Inheritance
### Encapsulation
Penerapan Encapsulation dalam program ini dilakukan dengan cara membungkus atribut kelas menggunakan hak akses private serta menyediakan method getter dan setter publik untuk mengakses atau mengubah nilai atribut tersebut. Sebagai contoh pada program, kelas AnggotaPramuka.java mendeklarasikan atributnya secara privat seperti private int idAnggota; dan private String namaAnggota;, di mana atribut-atribut tersebut hanya dapat diakses maupun dimodifikasi melalui method publik seperti getIdAnggota(), setNamaAnggota(), dan seterusnya. Konsep enkapsulasi ini juga diterapkan secara konsisten pada kelas GugusDepan.java, Kwarran.java, serta pada atribut khusus di kelas-kelas turunannya.

### Inheritance
Penerapan Inheritance (Pewarisan) digunakan untuk menurunkan sifat atau atribut dari kelas induk (superclass) ke kelas anak (subclass) guna menghindari duplikasi kode. Hal ini dapat dilihat pada kelas Siswa.java dan Pembina.java yang mewarisi kelas AnggotaPramuka.java menggunakan kata kunci extends, sehingga kelas anak tersebut secara otomatis memiliki seluruh atribut serta method dasar yang dimiliki oleh AnggotaPramuka seperti ID, nama, jenis kelamin, dan lain-lain—tanpa perlu menulis ulang deklarasinya.

## Polymorphism (Overriding)
Penerapan method overriding dalam program ini dapat dilihat di dalam kelas-kelas anakannya, yaitu pada kelas Siswa.java dan kelas Pembina.java, melalui penggunaan method tampilkanData(). Cara kerjanya bermula dari kelas induk AnggotaPramuka.java yang memiliki method dasar tampilkanData() untuk mencetak informasi umum keanggotaan. Kelas anak seperti Siswa dan Pembina kemudian menulis ulang method tersebut dengan menyematkan anotasi @Override di atasnya guna menyesuaikan output data. Di dalam method yang dioverride tersebut, kelas anak memanggil kembali method milik kelas induknya menggunakan perintah super.tampilkanData(), lalu menambahkan baris kode spesifik untuk mencetak atribut tambahan masing-masing—seperti mencetak "Tingkat Pramuka Siswa" pada kelas Siswa dan "Sertifikat Hak Bina" pada kelas Pembina. Lebih lanjut, ketika program melakukan iterasi dan memanggil f.tampilkanData() pada objek yang bersifat polimorfisme (meskipun secara deklarasi bertipe AnggotaPramuka), Java secara dinamis akan mengeksekusi versi tampilkanData() yang paling sesuai dengan bentuk objek aslinya, baik itu sebagai Siswa maupun Pembina.

## Dokumentasi Output

### Menu Utama
<img width="278" height="137" alt="image" src="https://github.com/user-attachments/assets/9bc88d4d-a0bb-4ad2-952b-a33ddddfdd70" />

## ================================

### Menu Gugus Depan
<img width="295" height="176" alt="image" src="https://github.com/user-attachments/assets/1109beac-1ec7-4b3d-8560-66296c7f935e" />

#### Create Gugus Depan
<img width="508" height="260" alt="image" src="https://github.com/user-attachments/assets/91441c8d-8ef9-4bbb-a187-37092118df45" />

#### Read Gugus Depan
<img width="501" height="347" alt="image" src="https://github.com/user-attachments/assets/5a12bf72-dbc3-4401-99e5-3e050aa5b577" />

#### Update Gugus Depan
<img width="558" height="305" alt="image" src="https://github.com/user-attachments/assets/1ddfe806-36ac-41d6-8b56-1dd8ed91b39b" />

#### Delete Gugus Depan
<img width="562" height="455" alt="image" src="https://github.com/user-attachments/assets/374531ea-b03a-4de9-ace3-fd7797055134" />

## ================================

### Menu Kwartir Ranting (Kwarran)
<img width="356" height="282" alt="image" src="https://github.com/user-attachments/assets/22d4c7bc-abe5-417e-ac2b-3f2fdc6b9d1a" />

#### Create Kwartir Ranting
<img width="388" height="220" alt="image" src="https://github.com/user-attachments/assets/ad1f5ef3-e609-40e8-abd2-3b08e732d63e" />

#### Read Kwartir Ranting
<img width="373" height="302" alt="image" src="https://github.com/user-attachments/assets/8f0389b1-ae5f-4330-8661-8b3199ebeedf" />

#### Update Kwartir Ranting
<img width="498" height="537" alt="image" src="https://github.com/user-attachments/assets/88959cce-0308-4d65-a3f3-782f3ee92c9b" />

#### Delete Kwartir Ranting
<img width="457" height="423" alt="image" src="https://github.com/user-attachments/assets/964b60f8-1d63-4d39-92cd-fba720ab68e2" />

## ================================

### Menu Anggota Pramuka
<img width="233" height="130" alt="image" src="https://github.com/user-attachments/assets/fe6437bc-585a-4390-8c30-c5f282e8288c" />

#### Create Anggota Pramuka (Siswa)
<img width="450" height="391" alt="image" src="https://github.com/user-attachments/assets/c9773015-f777-43fe-989e-aa26d4fe7b4c" />

#### Create Anggota Pramuka (Pembina)
<img width="441" height="390" alt="image" src="https://github.com/user-attachments/assets/390090c8-7ed7-40ab-98a5-4d86947e4be7" />

#### Read Anggota Pramuka (Siswa)
<img width="373" height="677" alt="image" src="https://github.com/user-attachments/assets/aaa8c4ce-0d93-44fc-a850-25919154fd6f" />

#### Read Anggota Prmauka (Pembina)
<img width="370" height="532" alt="image" src="https://github.com/user-attachments/assets/63ea829b-9608-43f3-8ab8-12b37b39a406" />

#### Read Semua Anggota Pramuka (Siswa & Pembina)
<img width="495" height="852" alt="image" src="https://github.com/user-attachments/assets/d54c14a9-3ac3-42d3-8193-0ba94ff60f69" />

#### Update Anggota Pramuka
<img width="497" height="847" alt="image" src="https://github.com/user-attachments/assets/61020234-ba49-4c5f-b700-58cf4c5238bd" />

#### Delete Anggota Pramuka
<img width="403" height="198" alt="image" src="https://github.com/user-attachments/assets/6c969ba5-e13c-4773-87e4-f0f57dd671d1" />

<img width="638" height="861" alt="image" src="https://github.com/user-attachments/assets/c51795cb-44f9-46ff-a31a-622250b651d4" />




