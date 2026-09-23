package com.mycompany.minprodatapramuka;

import java.util.ArrayList;
import java.util.Scanner;

public class LogicCRUD {
    private Scanner input;
    
    ArrayList<AnggotaPramuka>anggotaPramuka = new ArrayList<>();
    ArrayList<GugusDepan>gugusDepan = new ArrayList<>();
    ArrayList<Kwarran>kwarran = new ArrayList<>();
    
    public LogicCRUD(){
        input = new Scanner(System.in);
        gugusDepan = new ArrayList<>();
        kwarran = new ArrayList<>();
        anggotaPramuka = new ArrayList<>();
        
        gugusDepan.add(new GugusDepan(1122, "Ki Hajar Dewantara - Dewi Sartika", "SMAN 1 Berau"));
        kwarran.add(new Kwarran(170301, "Tanjung Redeb"));
        anggotaPramuka.add(new Siswa(1001, "Farel Awaluddin", "Laki-Laki", 0102, 170301, "Penegak"));
        anggotaPramuka.add(new Pembina(2001, "Pak Kaspul Anwar", "Laki-Laki", 0102, 170301, "KMD"));
    }
    
    public void mulai(){
        int pilihan = 0;
        
        do {
            System.out.println("=== Keanggotaan Pramuka ===");
            System.out.println("1. Gugus Depan");
            System.out.println("2. Kwartir Ranting");
            System.out.println("3. Anggota Pramuka");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan: ");
            
            if (input.hasNextInt()){
                pilihan = input.nextInt();
                input.nextLine();
            }
            else {
                System.out.println("Input harus angka");
                input.nextLine();
                continue;
            }
            
            switch (pilihan) {
                case 1:
                    menuGudep();
                    break;
                
                case 2: 
                    menuKwarran();
                    break;
                
                case 3:
                    menuAnggota();
                    break;
                
                case 4:
                    System.out.println("Program Selesai");
                    break;
                    
                default:
                    System.out.println("Input Tidak Valid");
            }
            
        }while (pilihan != 4);
        input.close();
    }
    
    
    
    
    //Menu Gugus Depan
    private void menuGudep(){
        int pilihanGudep = 0;

        do {
            System.out.println("=== GUGUS DEPAN ===");
            System.out.println("1. Tambah Gugus Depan");
            System.out.println("2. Lihat Gugus Depan");
            System.out.println("3. Update Gugus Depan");
            System.out.println("4. Hapus Gugus Depan");
            System.out.println("5. Kembali");
            System.out.print("Pilih Menu: ");
            
            if (input.hasNextInt()) {
            pilihanGudep = input.nextInt();
            input.nextLine();
        } else {
            System.out.println("Input harus angka!");
            input.nextLine();
            continue;
        }
            switch (pilihanGudep) {
                case 1:
                    tambahGudep();
                    break;
                    
                case 2:
                    lihatGudep();
                    break;
                    
                case 3:
                    updateGudep();
                    break;
                    
                case 4:
                    hapusGudep();
                    break;
                    
                case 5:
                    System.out.println("Kembali ke menu utama");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
    } while (pilihanGudep !=5);
    
}
    
//Create Gugus Depan
private void tambahGudep(){
    System.out.println("Nomor Gugus Depan: ");
    
    if (!input.hasNextInt()) {
            System.out.println("Nomor Gugus Depan harus berupa angka");
            input.nextLine();
            return;
        }
    
    int kodeGugusDepan = input.nextInt();
    input.nextLine();
    
    System.out.print("Nama Gugus Depan: ");
    String namaGugusDepan = input.nextLine();
    while (namaGugusDepan.trim().isEmpty()) {
        System.out.print("Nama gugus depan tidak boleh kosong");
        System.out.print("Masukkan ulang nama gugus depan: ");
        namaGugusDepan = input.nextLine();
        
    }
        System.out.print("Pangkalan: ");
        String pangkalan = input.nextLine();
        while (pangkalan.trim().isEmpty()) {
            System.out.print("Nama pangkalan tidak boleh kosong");
            System.out.print("Masukkan ulang nama pangkalan: ");
            pangkalan = input.nextLine();
        }
        gugusDepan.add(
            new GugusDepan(kodeGugusDepan, namaGugusDepan, pangkalan)
        );

        System.out.println("Data Gugus Depan Berhasil Ditambahkan");
    }


//Read Gugus Depan
private void lihatGudep(){
    if(gugusDepan.isEmpty()){
        System.out.println("Belum Ada Gugus Depan yang Terdaftar");
    }else{
        System.out.println("Daftar Gugus Depan: ");

        for(int i=0; i < gugusDepan.size(); i++){
            GugusDepan f = gugusDepan.get(i);

            System.out.println(
            (i+1)+ ".");
            f.tampilkanData();
        }
    }
    }

//Update Gugus Depan
private void updateGudep(){
    if(gugusDepan.isEmpty()){
        System.out.println("Belum Ada Gugus Depan yang Terdaftar");
    }else{
        System.out.print("Nomor Gugus Depan yang Ingin Diubah: ");
        if (!input.hasNextInt()) {
            System.out.println("Nomor harus berupa angka");
            input.nextLine();
            return;
        }
        int no = input.nextInt();
        input.nextLine();

        if (no >= 1 && no <= gugusDepan.size()){
            GugusDepan f = gugusDepan.get(no-1);
            System.out.print("Nomor Gugus Depan Baru: ");
            if (!input.hasNextInt()) {
                System.out.println("Nomor harus berupa angka");
                input.nextLine();
                return;
            }
            f.setKodeGugusDepan (input.nextInt());
            input.nextLine();

            System.out.print("Nama Gugus Depan Baru: ");
            f.setNamaGugusDepan  (input.nextLine());

            System.out.print("Pangkalan Baru: ");
            f.setPangkalan (input.nextLine());

            System.out.println("Data Gugus Depan Telah Diubah");
        }else{
            System.out.println("Data Gugus Depan Tidak Tersedia");
        }
    }
}

// Hapus Gugus Depan
private void hapusGudep(){
    if(gugusDepan.isEmpty()){
        System.out.println("Belum ada Gudep yang Terdaftar");
    }else{
        System.out.print("Nomor Gugus Depan: ");
        int no = input.nextInt();

        if(no >= 1 && no <= gugusDepan.size()){
            gugusDepan.remove(no-1);
            System.out.println("Data Gugus Depan Telah Dihapus");
        }else{
            System.out.println("Gugus Depan Tidak Tersedia");
        }
    }
}


//Menu Kwartir Rnting
private void menuKwarran(){
    int pilihanKwarran = 0;

    do{
        System.out.println("=== KWARTIR RANTING ===");
        System.out.println("1. Tambah Kwarran");
        System.out.println("2. Lihat Kwarran");
        System.out.println("3. Update Kwarran");
        System.out.println("4. Hapus Kwarran");
        System.out.println("5. Kembali");
        System.out.print("Pilih Menu: ");

        if (input.hasNextInt()) {
            pilihanKwarran = input.nextInt();
            input.nextLine();
        } else {
            System.out.println("Input harus angka");
            input.nextLine();
            continue;
        }
        
        switch (pilihanKwarran){
            case 1:
                tambahKwarran();
                break;
                
            case 2:
                lihatKwarran();
                break;
                
            case 3:
                updateKwarran();
                break;
                
            case 4:
                hapusKwarran();
                break;
                
            case 5:
                System.out.println("Kembali ke menu utama");
                break;
                
            default:
                System.out.println("Pilihan tidak tersedia");
        }
    }while (pilihanKwarran !=5);
}

//Create Kwarran
private void tambahKwarran(){
    System.out.print("ID Kwarran: ");
    int idKwarran = input.nextInt();
    input.nextLine();

    System.out.print("Nama Kwarran: ");
    String namaKwarran = input.nextLine();
    while (namaKwarran.trim().isEmpty()) {
    System.out.print("Nama Kwartir Ranting tidak boleh kosong");
    System.out.print("Masukkan ulang nama Kwartir Ranting: ");
    namaKwarran = input.nextLine();
    }

    kwarran.add(
    new Kwarran(idKwarran, namaKwarran)
    );
    System.out.println("Data Kwartir Ranting Telah Ditambahkan");
}

//Read Kwarran
private void lihatKwarran(){
    if(kwarran.isEmpty()){
        System.out.println("Belum Ada Kwartir Ranting yang Terdaftar");
    }else{
        System.out.println("Daftar Kwartir Ranting:");

        for(int i=0; i < kwarran.size(); i++){
            Kwarran f = kwarran.get(i);

            System.out.println(
            (i+1)+ "." );
            f.tampilkanData();
        }
    }
}

//Update Kwarran
private void updateKwarran(){
    if(kwarran.isEmpty()){
        System.out.println("Belum Ada Kwartir Ranting yang Terdaftar");
    }else{
        System.out.print("Nomor Kwartir Ranting yang Ingin Diubah: ");
        int no = input.nextInt();
        input.nextLine();

        if (no >= 1 && no <= kwarran.size()){
            Kwarran f = kwarran.get(no-1);

            System.out.print("Nomor Kwartir Ranting Baru: ");
            if (!input.hasNextInt()) {
                System.out.println("Nomor harus berupa angka");
                input.nextLine();
                return;
            }
            f.setIdKwarran (input.nextInt());
            input.nextLine();

            System.out.print("Nama Kwartir Ranting Baru: ");
            f.setNamaKwarran (input.nextLine());

            System.out.println("Data Kwartir Ranting Telah Diubah");
        }else{
            System.out.println("Data Kwartir Ranting Tidak Tersedia");
        }
    }
}

// Delete Kwarran
private void hapusKwarran(){
    if(kwarran.isEmpty()){
        System.out.println("Belum ada Kwarran yang Terdaftar");
    }else{
        System.out.print("Nomor Kwartir Ranting: ");
        if (!input.hasNextInt()) {
                System.out.println("Nomor harus berupa angka");
                input.nextLine();
                return;
            }
        int no = input.nextInt();
        input.nextLine();

        if(no >= 1 && no <= kwarran.size()){
            kwarran.remove(no-1);
            System.out.println("Kwartir Ranting Telah Dihapus");
        }else{
            System.out.println("Data Kwartir Ranting Tidak Tersedia");
        }
    }
}

// Menu Anggota Pramuka
private void menuAnggota(){
    int pilihanAnggotaPramuka = 0;
    
    do{
        System.out.println("=== ANGGOTA PRAMUKA ===");
        System.out.println("1. Tambah Anggota");
        System.out.println("2. Lihat Anggota");
        System.out.println("3. Update Anggota");
        System.out.println("4. Hapus Anggota");
        System.out.println("5. Kembali");
        System.out.print("Masukkan Pilihan: ");
        
        
        if (input.hasNextInt()) {
            pilihanAnggotaPramuka = input.nextInt();
            input.nextLine();
        } else {
            System.out.println("Input harus berupa angka");
            input.nextLine();
            continue;
        }

            switch (pilihanAnggotaPramuka){
                case 1:
                    tambahAnggota();
                    break;
                    
                case 2:
                    lihatAnggota();
                    break;
                    
                case 3:
                    updateAnggota();
                    break;
                    
                case 4:
                    hapusAnggota();
                    break;
                    
                case 5:
                    System.out.println("Kembali ke menu utama");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
    } while (pilihanAnggotaPramuka !=5);
}

//Create Anggota Pramuka
private void tambahAnggota(){
    int jenis = 0;
    do{
        System.out.println("Jenis Anggota: ");
        System.out.println("1. Siswa");
        System.out.println("2. Pembina");
        System.out.print("Masukkan Pilihan: ");

        if (input.hasNextInt()){
            jenis = input.nextInt();
            input.nextLine();

            if (jenis !=1 && jenis !=2){
                System.out.println("Input hanya angka 1 atau 2");
                jenis = 0;
            }
        }
        else{
            System.out.println("Input harus angka");
            input.nextLine();
            jenis = 0;
        }
    }while (jenis !=1 && jenis !=2);


        System.out.print("ID Anggota: ");
        if (!input.hasNextInt()) {
                System.out.println("ID harus berupa angka");
                input.nextLine();
                return;
            }
        int idAnggota = input.nextInt();
        input.nextLine();

        System.out.print("Nama Anggota Pramuka: ");
        String namaAnggota = input.nextLine();
        while(namaAnggota.trim().isEmpty()) {
            System.out.print("Nama tidak boleh kosong");
            System.out.print("Masukkan ulang: ");
            namaAnggota = input.nextLine();
        }

        System.out.print("Jenis Kelamin: ");
        String jenisKelamin = input.nextLine();
        while(jenisKelamin.trim().isEmpty()) {
            System.out.println("Harus Punya Jenis Kelamin");
            System.out.print("Masukkan ulang: ");
            jenisKelamin = input.nextLine();
        }

        System.out.print("Nomor Gugus Depan: ");
        if (!input.hasNextInt()) {
                System.out.println("Nomor harus berupa angka");
                input.nextLine();
                return;
            }
        int kodeGugusDepan = input.nextInt();
        input.nextLine();

        System.out.print("ID Kwartir Ranting: ");
        if (!input.hasNextInt()) {
                System.out.println("ID harus berupa angka");
                input.nextLine();
                return;
            }
        int idKwarran = input.nextInt();
        input.nextLine();

        if (jenis == 1) {
            System.out.print("Tingkat Siaga/Penggalang/Penegak: ");
            String tingkatPramuka = input.nextLine();
            anggotaPramuka.add(new Siswa(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, tingkatPramuka));
            System.out.println("Data Anggota Berhasil Ditambahkan!");
            }   
            else{
            System.out.print("Hak Bina: ");
            String hakBina = input.nextLine();
            anggotaPramuka.add(new Pembina(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, hakBina));
            System.out.println("Data Anggota Berhasil Ditambahkan!");
            }
}
        
        //Read Anggota Pramuka
        private void lihatAnggota(){
        if(anggotaPramuka.isEmpty()){
            System.out.println("Belum Ada Anggota yang Terdaftar");
        }else{
        int menuLihat = 0;
        do{
            System.out.println("Lihat Anggota Pramuka");
            System.out.println("1. Lihat Siswa");
            System.out.println("2. Lihat Pembina");
            System.out.println("3. Lihat Keseluruhan");
            System.out.println("4. Kembali");
            System.out.print("Masukkan Pilihan: ");

            if (input.hasNextInt()) {
                menuLihat = input.nextInt();
                input.nextLine();
            } else {
                    System.out.println("Input Harus Angka");
                    input.nextLine();
                    continue;
                    }
            if (menuLihat < 1 || menuLihat > 4){
                System.out.println("Invalid, Pilih Angka 1-4");
                continue;
            }
        
        

        switch (menuLihat){
            case 1: 
                System.out.println("Daftar Siswa");
                boolean adaSiswa = false;
                for (int i = 0; i < anggotaPramuka.size(); i++) {
                    AnggotaPramuka f = anggotaPramuka.get(i);
                    if (f instanceof Siswa) {
                        System.out.println("Nomor: " + (i + 1));
                        f.tampilkanData();
                        System.out.println("===========================");
                        adaSiswa = true;
                    }
                }
                if (!adaSiswa){
                System.out.println("Tidak ada siswa yang terdaftar");
                }
                break;
                

            case 2:
                System.out.println ("Daftar Pembina");
                boolean adaPembina = false;
                for (int i = 0; i < anggotaPramuka.size(); i++) {
                    AnggotaPramuka f = anggotaPramuka.get(i);
                    if (f instanceof Pembina) {
                        System.out.println("Nomor: " + (i + 1));
                        f.tampilkanData();
                        System.out.println("===========================");
                        adaPembina = true;
                    }
                }
                if (!adaPembina){
                System.out.println("Tidak ada pembina yang terdaftar");
                }
                break;
                
                
            case 3:
                System.out.println("Daftar Keseluruhan Anggota Pramuka");
                for (int i = 0; i < anggotaPramuka.size(); i++) {
                    AnggotaPramuka f = anggotaPramuka.get(i);
                    System.out.println("Nomor: " + (i + 1));
                    f.tampilkanData();
                    System.out.println("===========================");
                }
                break;
                
                
            case 4:
                System.out.println("Kembali ke menu sebelumnya");
                break;
                
        }
                }while (menuLihat != 4);
            }
        }        
        
        //Update Anggota Pramuka
        private void updateAnggota(){
            if(anggotaPramuka.isEmpty()){
                System.out.println("Belum Ada Anggota yang Terdaftar");
            }else{
                System.out.print("Nomor Urut Anggota yang Ingin Diubah: ");
                if (!input.hasNextInt()) {
                System.out.println("Nomor harus berupa angka");
                input.nextLine();
                return;
            }
                int no = input.nextInt();
                input.nextLine();

                if (no >= 1 && no <= anggotaPramuka.size()){
                    AnggotaPramuka f = anggotaPramuka.get(no-1);

                    System.out.print("ID Anggota Pramuka Baru: ");
                    if (!input.hasNextInt()) {
                    System.out.println("ID harus berupa angka");
                    input.nextLine();
                    return;
                }
                    f.setIdAnggota (input.nextInt());
                    input.nextLine();

                    System.out.print("Nama Anggota Pramuka Baru: ");
                    f.setNamaAnggota (input.nextLine());

                    System.out.print("Jenis Kelamin: ");
                    f.setJenisKelamin  (input.nextLine());

                    System.out.print("Nomor Gugus Depan Baru: ");
                    f.setKodeGugusDepan (input.nextInt());
                    input.nextLine();

                    System.out.print("ID Kwartir Ranting Baru: ");
                    f.setIdKwarran (input.nextInt());
                    input.nextLine();


                    System.out.println("Data Anggota Pramuka Telah Diubah");
                }else{
                    System.out.println("Data Anggota Pramuka Tidak Tersedia");
                }
            }
        }
        
        //Delete Anggota Pramuka
        private void hapusAnggota(){
            if(anggotaPramuka.isEmpty()){
                System.out.println("Belum ada Anggota yang Terdaftar");
            }else{
                System.out.print("Nomor Urut Anggota Pramuka: ");
                if (!input.hasNextInt()) {
                System.out.println("Nomor harus berupa angka");
                input.nextLine();
                return;
            }
                int no = input.nextInt();

                if(no >= 1 && no <= anggotaPramuka.size()){
                    anggotaPramuka.remove(no-1);
                    System.out.println("Anggota Telah Dihapus");
                }else{
                    System.out.println("Anggota Tidak Tersedia");
                    return;
                }
            }
        }
        
        
    }
