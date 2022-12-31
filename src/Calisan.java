
public abstract class Calisan {
    private final long tcNo;
    private final String ad;
    private final String soyAd;
    private final String dogumTarihi;
    private double maas;
    private String sifre;

    //constructor
    public Calisan(long tcNo, String ad, String soyAd, String dogumTarihi, double maas,String sifre) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyAd = soyAd;
        this.dogumTarihi = dogumTarihi;
        this.maas = maas;
        this.sifre=sifre;
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

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "\nTC NO: " + getTcNo() + "\nAd: " + getAd() +"\nSoyad: "+ getSoyAd() + "\nDoğum Tarihi: "+getDogumTarihi()
                + "\nMaaş: " + getMaas();
    }
}
