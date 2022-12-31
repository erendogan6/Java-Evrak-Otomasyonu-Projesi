import java.time.LocalDate;

public class Kullanici {
    private final long tcNo;
    private final String ad;
    private final String soyAd;
    private final String dogumTarihi;
    private final String uyelikTarihi;
    private String sifre;


    //Kayıt ekranı constructor
    public Kullanici(long tcNo, String ad, String soyAd, String dogumTarihi, String sifre) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyAd = soyAd;
        this.dogumTarihi = dogumTarihi;
        this.uyelikTarihi = String.valueOf(LocalDate.now());
        this.sifre = sifre;
    }

    // veritabanı constructor
    public Kullanici(long tcNo, String ad, String soyAd, String dogumTarihi, String sifre,String uyelikTarihi) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyAd = soyAd;
        this.dogumTarihi = dogumTarihi;
        this.uyelikTarihi =uyelikTarihi;
        this.sifre = sifre;
    }

    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public long getTcNo() {
        return tcNo;
    }
    public String getAd() {
        return ad;
    }
    public String getSoyAd() {
        return soyAd;
    }
    public String getDogumTarihi() {
        return dogumTarihi;
    }
    public String getUyelikTarihi() {
        return uyelikTarihi;
    }

    @Override
    public String toString() {
        return "\nTC NO: "+getTcNo()+"\nAd: " +getAd()+"\nSoyad: "+getSoyAd()+"\nDoğum Tarihi: "+
                getDogumTarihi()+"\nÜyelik Tarihi: " + getUyelikTarihi();
    }
}
