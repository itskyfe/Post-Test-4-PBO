package controller;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private ArrayList<Surat> daftarSurat = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void tambahSurat() {
        System.out.println("1. Surat Masuk");
        System.out.println("2. Surat Keluar");
        System.out.print("Pilih jenis surat:");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan Judul Surat: ");
        String judulSurat = input.nextLine();
        if (judulSurat.isEmpty()){
            System.out.println("Input tidak boleh kosong! Silahkan coba lagi");
            return;
        }

        System.out.print("Masukkan Nomor Surat: ");
        String nomorSurat = input.nextLine();
        if (nomorSurat.isEmpty()){
            System.out.println("Input tidak boleh kosong! Silahkan coba lagi");
            return;
        }

        System.out.print("Masukkan Tanggal Surat (dd/mm/yyyy): ");
        String tanggalSurat = input.nextLine();
        if (tanggalSurat.isEmpty()){
            System.out.println("Input tidak boleh kosong! Silahkan coba lagi");
            return;
        }

        switch (jenis) {
            case 1:
                System.out.print("Masukkan Asal Surat: ");
                String asal = input.nextLine();
                daftarSurat.add(new SuratMasuk(judulSurat, nomorSurat, tanggalSurat, asal));
                break;
            case 2:
                System.out.print("Masukkan Tujuan Surat: ");
                String tujuan = input.nextLine();
                daftarSurat.add(new SuratKeluar(judulSurat, nomorSurat, tanggalSurat, tujuan));
                break;
            default:
                System.out.println("Jenis surat tidak valid!");
                return;
        }

        System.out.println("Surat berhasil ditambahkan!");
    }

    public void tampilkanSurat() {
        if (daftarSurat.isEmpty()) {
            System.out.println("Belum ada surat.");
        } else {
            for (Surat s : daftarSurat) {
                System.out.println("-- Daftar Surat Masuk --");
                s.tampilkanInfo();
                System.out.println("-------------------");
            }
        }
    }

    public void updateSurat() {
        System.out.print("Masukkan Nomor Surat yang ingin diupdate: ");
        String nomor = input.nextLine();

        for (Surat s : daftarSurat) {
            if (s.getNomorSurat().equalsIgnoreCase(nomor)) {
                System.out.print("Masukkan Status Baru: ");
                String statusBaru = input.nextLine();
                if (statusBaru.isEmpty()){
                   System.out.println("Input tidak boleh kosong! Silahkan coba lagi");
                    return;
                }else{
                    s.setStatusSurat(statusBaru);
                    System.out.println("Status surat masuk berhasil diupdate!");
                    return;
                }
            }
        }
        System.out.println("Surat tidak ditemukan.");
    }

    public void hapusSurat() {
        System.out.print("Masukkan Nomor Surat yang ingin dihapus: ");
        String nomor = input.nextLine();

        for (int i = 0; i < daftarSurat.size(); i++) {
            if (daftarSurat.get(i).getNomorSurat().equalsIgnoreCase(nomor)) {
                daftarSurat.remove(i);
                System.out.println("Surat masuk berhasil dihapus!");
                return;
            }
        }
        System.out.println("Surat tidak ditemukan.");
    }

    public void cariSurat() {
        System.out.print("Masukkan Nomor Surat yang dicari: ");
        String nomorCari = input.nextLine();

        for (Surat s : daftarSurat) {
            if (s.getNomorSurat().equalsIgnoreCase(nomorCari)) {
                s.tampilkanInfo();
                return;
            }
        }
        System.out.println("Surat tidak ditemukan.");
    }
}
