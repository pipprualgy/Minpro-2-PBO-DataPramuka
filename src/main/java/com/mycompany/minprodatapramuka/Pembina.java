package com.mycompany.minprodatapramuka;

public class Pembina extends AnggotaPramuka{
    private String hakBina;
    
    public Pembina(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String hakBina){
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.hakBina = hakBina;
    }
    public String getHakBIna(){return hakBina;}
    public void setHakBina(String hakBina){
        this.hakBina = hakBina;
    }
    
    @Override
    public void tampilkanData(){
        System.out.println("===Data Pembina Pramuka===");
        super.tampilkanData();
        System.out.println("Sertifikat Hak Bina: " + hakBina);
    }
}
