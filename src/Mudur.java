public class Mudur extends Calisan implements EvrakIslem{

    // constructor
    public Mudur(long tcNo, String ad, String soyAd, String dogumTarihi, double maas, String sifre) {
        super(tcNo, ad, soyAd, dogumTarihi, maas,sifre);
    }

    @Override
    public void evrakIptalEt(Evrak belge) {
        belge.setGecerlilik(false);
    }

    @Override
    public void evrakAktifEt(Evrak belge) {
        belge.setGecerlilik(true);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
