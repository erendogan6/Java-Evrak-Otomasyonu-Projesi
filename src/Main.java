import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
public class Main {
    static ArrayList<Evrak> evraklar = new ArrayList<>();
    static ArrayList<Gorevli> gorevliler = new ArrayList<>();
    static ArrayList<Kullanici> kullanicilar = new ArrayList<>();
    static ArrayList<Mudur> mudurler = new ArrayList<>();

    public static void main(String[] args) throws URISyntaxException {

        //Eğer Program dizini altında ilkKurulum.txt dosyası mevcut ise SQL Kurulumu Kodlarını çalıştırarak
        //Gerekli Veri tabanını ve tabloları oluşturur. Müdür kayıt ekranını açarak, ilk müdürün kaydını sağlar.
        //Birden fazla müdür kaydı için istendiği kadar ilk kurulum yapılabilir. İlk kurulum sonunda ilkKurulum.txt dosyası
        //Otomatik olarak silinmektedir.
        URL dizin = null;
        File f = null;
        try{
            dizin = Main.class.getResource("/ilkKurulum.txt");
            assert dizin != null;
            f = new File(dizin.toURI());
        }
        catch (Exception ee){
        }


        if (f!=null&&f.exists()) {
            SQLBaglantisi.sifirKurulum();
            IlkKurulum kurulum = new IlkKurulum();
            kurulum.setVisible(true);
        }


        //Kullanıcı Bilgilerini Veri tabanınıdan çekerek ArrayList'e Kaydeder
        SQLBaglantisi.kullaniciCek();

        //Görevli Bilgilerini Veri tabanınıdan çekerek ArrayList'e Kaydeder
        SQLBaglantisi.gorevliCek();

        //Müdür Bilgilerini Veri tabanınıdan çekerek ArrayList'e Kaydeder
        SQLBaglantisi.mudurCek();

        //Evrak Bilgilerini Veri tabanınıdan çekerek ArrayList'e Kaydeder
        SQLBaglantisi.evrakCek();

        //Eğer ilk kurulum durumu yoksa programı normal olarak çalıştır
        if (f==null) {
            AnaEkran.main(args);
        }

        return;
    }
}