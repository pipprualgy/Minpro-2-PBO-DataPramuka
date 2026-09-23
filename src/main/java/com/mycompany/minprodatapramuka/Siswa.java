package com.mycompany.minprodatapramuka;

public class Siswa extends AnggotaPramuka {
    private String tingkatPramuka;
    
    public Siswa(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String tingkatPramuka) {
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.tingkatPramuka = tingkatPramuka;
    }
    
    public String getTingkatPramuka() {return tingkatPramuka;}
    public void setTingkatPramuka(String tingkatPramuka) {
        this.tingkatPramuka = tingkatPramuka;
    }
    
    @Override
    public void tampilkanData(){
        System.out.println("===Data Pramuka Siswa===");
        super.tampilkanData();
        System.out.println("Tingkat Pramuka Siswa: " + tingkatPramuka);
    }
}
