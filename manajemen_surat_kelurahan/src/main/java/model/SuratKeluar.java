package model;

public class SuratKeluar extends Surat {
    private String tujuanSurat;

    public SuratKeluar(String judulSurat, String nomorSurat, String tanggalSurat, String tujuanSurat) {
        super(judulSurat, nomorSurat, tanggalSurat);
        this.tujuanSurat = tujuanSurat;
    }

    public String getTujuanSurat() {
        return tujuanSurat;
    }

    public void setTujuanSurat(String tujuanSurat) {
        this.tujuanSurat = tujuanSurat;
    }

//  Overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("Judul   : " + getJudulSurat());
        System.out.println("Nomor   : " + getNomorSurat());
        System.out.println("Tanggal : " + getTanggalSurat());
        System.out.println("Status  : " + getStatusSurat());
        System.out.println("Tujuan  : " + tujuanSurat);
    }
}
