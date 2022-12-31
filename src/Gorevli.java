import java.time.LocalDate;
public class Gorevli extends Calisan {
    private String isGirisTarihi;
    private String isCikisTarihi;
    private boolean calismaDurumu;

    //Mudur kayit constructor
    public Gorevli(long tcNo, String ad, String soyAd, String dogumTarihi, double maas,String sifre) {
        super(tcNo, ad, soyAd, dogumTarihi, maas,sifre);
        this.isGirisTarihi = String.valueOf(LocalDate.now());
        this.calismaDurumu = true;
    }

    // Veritabanı kayıt cons
    public Gorevli(long tcNo, String ad, String soyAd, String dogumTarihi, double maas,String sifre,
                   String isGirisTarihi,String isCikisTarihi, boolean calismaDurumu) {
        super(tcNo, ad, soyAd, dogumTarihi, maas,sifre);
        this.isGirisTarihi = isGirisTarihi;
        this.isCikisTarihi = isCikisTarihi;
        this.calismaDurumu = calismaDurumu;
    }

    public String getIsGirisTarihi() {
        return isGirisTarihi;
    }

    public String getIsCikisTarihi() {
        return isCikisTarihi;
    }

    public void setIsGirisTarihi(String isGirisTarihi) {
        this.isGirisTarihi = isGirisTarihi;
    }

    public void setIsCikisTarihi(String isCikisTarihi) {
        this.isCikisTarihi = isCikisTarihi;
    }

    public boolean isCalismaDurumu() {
        return calismaDurumu;
    }

    public void setCalismaDurumu(boolean calismaDurumu) {
        this.calismaDurumu = calismaDurumu;
    }

    @Override
    public String toString() {
        String txt = "\nİş Giriş Tarihi: "+getIsGirisTarihi();
        if (isCalismaDurumu()){
            txt+="\nÇalışma Durumu: Aktif";
        }
        else{
            txt+="\nÇalışma Durumu: Pasif";
            txt+="\nİş Çıkış Tarihi: "+getIsCikisTarihi();
        }
        return super.toString()+txt;
    }
}
