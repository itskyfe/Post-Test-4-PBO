package model;

public class SuratMasuk extends Surat {
    private String asalSurat;

    public SuratMasuk(String judulSurat, String nomorSurat, String tanggalSurat, String asalSurat) {
        super(judulSurat, nomorSurat, tanggalSurat);
        this.asalSurat = asalSurat;
    }

    public String getAsalSurat() {
        return asalSurat;
    }

    public void setAsalSurat(String asalSurat) {
        this.asalSurat = asalSurat;
    }

//  Override
    @Override
    public void tampilkanInfo() {
        System.out.println("Judul   : " + getJudulSurat());
        System.out.println("Nomor   : " + getNomorSurat());
        System.out.println("Tanggal : " + getTanggalSurat());
        System.out.println("Status  : " + getStatusSurat());
        System.out.println("Asal    : " + asalSurat);
    }
}
