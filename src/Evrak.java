
import java.time.LocalDate;
import java.util.Random;

public class Evrak {
    static private int no =0;
    private final int seriNo;
    private int dogrulamaKod;
    private final String tarih;
    private String tur;
    private Gorevli imzalayan;
    private Kullanici olusturan;
    private boolean gecerlilik;
    Random rnd = new Random();

    //Kullanici constructor
    public Evrak(String tur, Kullanici olusturan) {
        for (int i=0;i<Main.evraklar.size();i++) {
            if (Main.evraklar.get(i).getSeriNo()==no) {
                no++;
                i=0;
            }
        }
        int tmp = rnd.nextInt(10000);
        if (no == 0)
            this.dogrulamaKod=tmp;
        else {
            for (int i =0;i<Main.evraklar.size();i++) {
                if (Main.evraklar.get(i).getDogrulamaKod() == tmp) {
                    tmp = rnd.nextInt(10000);
                    i=0;
                }
                if (i==Main.evraklar.size()-1) {
                    this.dogrulamaKod=tmp;
                    break;
                }
            }
        }
        this.tarih = String.valueOf(LocalDate.now());
        this.seriNo =no++;
        this.tur = tur;
        this.olusturan = olusturan;
        this.gecerlilik = true;
        this.imzalayan=null;
    }

    // veritabanı constructor
    public Evrak(int seriNo,int dogrulamaKod,String tarih,String tur,boolean gecerlilik) {
        this.seriNo=seriNo;
        this.dogrulamaKod=dogrulamaKod;
        this.tarih = tarih;
        this.tur =tur;
        this.gecerlilik = gecerlilik;
        this.olusturan = null;
        this.imzalayan=null;
        no = seriNo+1;
    }


    @Override
    public String toString() {
        String tmp = "\nSeri Numarası = " + getSeriNo() +
                "\nDoğrulama Kodu = " + getDogrulamaKod() +
                "\nTarih = " + getTarih()  +
                "\nTür = " + getTur()  +
                "\nOluşturan TC NO = " + olusturan.getTcNo();
        if (isGecerlilik())
            tmp += "\nGeçerlilik = Belge Geçerlidir";
        else
            tmp += "\nGeçerlilik = Belge Geçerli Değildir";
        if (getImzalayan()==null)
            tmp+="\nİmzalayan = Yok";
        else
            tmp+="\nİmzalayan ="+imzalayan.getAd()+" "+imzalayan.getSoyAd();
        return tmp;
    }

    public int getSeriNo() {
        return seriNo;
    }
    public void setOlusturan(Kullanici olusturan) {
        this.olusturan = olusturan;
    }
    public int getDogrulamaKod() {
        return dogrulamaKod;
    }
    public String getTarih() {
        return tarih;
    }

    public String getTur() {
        return tur;
    }
    public Gorevli getImzalayan() {
        return imzalayan;
    }
    public String ImzalayanKim() {
        String tmp;
        try {
            if (imzalayan !=null) {
                tmp = imzalayan.getAd()+ " "+imzalayan.getSoyAd();
                return tmp;
            }
            else {
                tmp = "Yok";
                return tmp;
            }} catch(Exception e) {
            tmp = "Yok";
            return tmp;
        }
    }

    public void setImzalayan(Gorevli imzalayan) {
        this.imzalayan = imzalayan;
    }

    public Kullanici getOlusturan() {
        return olusturan;
    }
    public boolean isGecerlilik() {
        return gecerlilik;
    }

    public void setGecerlilik(boolean gecerlilik) {
        this.gecerlilik = gecerlilik;
    }
}
