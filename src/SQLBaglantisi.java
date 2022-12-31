import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLBaglantisi {
	static String DB_URL = "jdbc:mysql://localhost:3306/evrakotomasyon";
	static String USER = "root";
	static String PASS = "123456";
	static Connection con = null;

	public static void sifirKurulum() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",USER,PASS);
			PreparedStatement dbOlustur = con.prepareStatement("CREATE DATABASE IF NOT EXISTS `evrakotomasyon` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci");
			PreparedStatement dbKullan = con.prepareStatement("USE `evrakotomasyon`");
			PreparedStatement dbTablo1 = con.prepareStatement("CREATE TABLE IF NOT EXISTS `Evrak` (\r\n"
					+ "  `seriNo` int NOT NULL,\r\n"
					+ "  `dogrulamaKod` int NOT NULL,\r\n"
					+ "  `tarih` varchar(255) NOT NULL,\r\n"
					+ "  `tur` varchar(255) NOT NULL,\r\n"
					+ "  `imzalayan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,\r\n"
					+ "  `olusturan` varchar(255) NOT NULL,\r\n"
					+ "  `gecerlilik` tinyint(1) NOT NULL,\r\n"
					+ "  UNIQUE KEY `dogrulamaKod` (`dogrulamaKod`),\r\n"
					+ "  UNIQUE KEY `seriNo` (`seriNo`)\r\n"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;");
			PreparedStatement dbTablo2 = con.prepareStatement("CREATE TABLE IF NOT EXISTS `Gorevli` (\r\n"
					+ "  `tcNo` varchar(255) NOT NULL,\r\n"
					+ "  `ad` varchar(255) NOT NULL,\r\n"
					+ "  `soyAd` varchar(255) NOT NULL,\r\n"
					+ "  `dogumTarihi` varchar(255) NOT NULL,\r\n"
					+ "  `maas` double NOT NULL,\r\n"
					+ "  `sifre` varchar(255) NOT NULL,\r\n"
					+ "  `isGirisTarihi` varchar(255) NOT NULL,\r\n"
					+ "  `isCikisTarihi` varchar(255) DEFAULT NULL,\r\n"
					+ "  `calismaDurumu` tinyint(1) DEFAULT NULL,\r\n"
					+ "  UNIQUE KEY `tcNo` (`tcNo`)\r\n"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;");
			PreparedStatement dbTablo3 = con.prepareStatement("CREATE TABLE IF NOT EXISTS `Kullanici` (\r\n"
					+ "  `tcNo` varchar(255) NOT NULL,\r\n"
					+ "  `ad` varchar(255) NOT NULL,\r\n"
					+ "  `soyAd` varchar(255) NOT NULL,\r\n"
					+ "  `dogumTarihi` varchar(255) NOT NULL,\r\n"
					+ "  `sifre` varchar(255) NOT NULL,\r\n"
					+ "  `uyelikTarihi` varchar(255) NOT NULL,\r\n"
					+ "  UNIQUE KEY `tcNo` (`tcNo`)\r\n"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;");
			PreparedStatement dbTablo4 = con.prepareStatement("CREATE TABLE IF NOT EXISTS `Mudur` (\r\n"
					+ "  `tcNo` varchar(255) NOT NULL,\r\n"
					+ "  `ad` varchar(255) NOT NULL,\r\n"
					+ "  `soyAd` varchar(255) NOT NULL,\r\n"
					+ "  `dogumTarihi` varchar(255) NOT NULL,\r\n"
					+ "  `maas` double NOT NULL,\r\n"
					+ "  `sifre` varchar(255) NOT NULL,\r\n"
					+ "  UNIQUE KEY `tcNo` (`tcNo`)\r\n"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;");

			dbOlustur.execute();
			dbKullan.execute();
			dbTablo1.execute();
			dbTablo2.execute();
			dbTablo3.execute();
			dbTablo4.execute();
			System.out.println("İlk Kurulum Tamamlandı");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void kullaniciCek() {
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			java.sql.Statement st =  con.createStatement();
			ResultSet data = st.executeQuery("SELECT * FROM Kullanici");
			Long tcNo;
			String ad;
			String soyAd;
			String dogumTarihi;
			String sifre;
			String uyelikTarihi;
			while (data.next()) {
				tcNo=Long.valueOf(data.getString(1));
				ad = data.getString(2);
				soyAd = data.getString(3);
				dogumTarihi= data.getString(4);
				sifre = data.getString(5);
				uyelikTarihi= data.getString(6);
				Main.kullanicilar.add(new Kullanici(tcNo,ad,soyAd,dogumTarihi,sifre,uyelikTarihi));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void mudurCek() {
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			java.sql.Statement st =  con.createStatement();
			ResultSet data = st.executeQuery("SELECT * FROM Mudur");
			Long tcNo;
			String ad;
			String soyAd;
			String dogumTarihi;
			double maas;
			String sifre;
			while (data.next()) {
				tcNo=Long.valueOf(data.getString(1));
				ad = data.getString(2);
				soyAd = data.getString(3);
				dogumTarihi= data.getString(4);
				maas = data.getDouble(5);
				sifre = data.getString(6);
				Main.mudurler.add(new Mudur(tcNo,ad,soyAd,dogumTarihi,maas,sifre));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void gorevliCek() {
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			java.sql.Statement st =  con.createStatement();
			ResultSet data = st.executeQuery("SELECT * FROM Gorevli");
			Long tcNo;
			String ad;
			String soyAd;
			String dogumTarihi;
			double maas;
			String sifre;
			String isGirisTarihi;
			String isCikisTarihi;
			boolean calismaDurumu;
			while (data.next()) {
				tcNo=Long.valueOf(data.getString(1));
				ad = data.getString(2);
				soyAd = data.getString(3);
				dogumTarihi= data.getString(4);
				maas = data.getDouble(5);
				sifre = data.getString(6);
				isGirisTarihi = data.getString(7);
				isCikisTarihi = data.getString(8);
				calismaDurumu = data.getBoolean(9);
				Main.gorevliler.add(new Gorevli(tcNo,ad,soyAd,dogumTarihi,
						maas,sifre,isGirisTarihi,isCikisTarihi,calismaDurumu));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void evrakCek() {
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			java.sql.Statement st =  con.createStatement();
			ResultSet data = st.executeQuery("SELECT * FROM `Evrak` ORDER BY `seriNo` ASC");
			int seriNo;
			int dogrulamaKod;
			String tarih;
			String tur;
			boolean gecerlilik;
			while (data.next()) {
				long imzalayan = -1;
				long olusturan = -1;
				int index = -1;
				seriNo=data.getInt(1);
				dogrulamaKod=data.getInt(2);
				tarih = data.getString(3);
				tur = data.getString(4);
				if (data.getString(5)!=null) {
					imzalayan = Long.parseLong(data.getString(5));
				}
				olusturan = Long.parseLong( data.getString(6));
				gecerlilik = data.getBoolean(7);
				Main.evraklar.add(new Evrak(seriNo,dogrulamaKod,tarih,tur,gecerlilik));

				int n = -1;
				for (int i=0;i<Main.evraklar.size();i++){
					if (seriNo==Main.evraklar.get(i).getSeriNo()){
						n = i;
					}
				}

				if (imzalayan!=-1) {
					for (int i=0;i<Main.gorevliler.size();i++) {
						if (imzalayan== Main.gorevliler.get(i).getTcNo()) {
							index = i;
							break;
						}
						if (i==Main.gorevliler.size()-1) {
							index = -1;
							break;
						}
					}
					if (index!=-1) {
						Main.evraklar.get(n).setImzalayan(Main.gorevliler.get(index));
					}
				}


				for (int i=0;i<Main.kullanicilar.size();i++) {
					if (olusturan== Main.kullanicilar.get(i).getTcNo()) {
						index = i;
						break;
					}
				}
				Main.evraklar.get(n).setOlusturan(Main.kullanicilar.get(index));
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}


	public static void evrakKayit() {
		String sql ="INSERT INTO `Evrak` (`seriNo`, `dogrulamaKod`, `tarih`, "
				+ "`tur`, `imzalayan`, `olusturan`, `gecerlilik`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		String sql2= "DELETE FROM Evrak";
		try {
			PreparedStatement temizle = con.prepareStatement(sql2);
			temizle.execute();
			for (int i=0;i<Main.evraklar.size();i++) {
				PreparedStatement kayit = con.prepareStatement(sql);
				kayit.setInt(1,Main.evraklar.get(i).getSeriNo());
				kayit.setInt(2,Main.evraklar.get(i).getDogrulamaKod());
				kayit.setString(3,Main.evraklar.get(i).getTarih());
				kayit.setString(4,Main.evraklar.get(i).getTur());
				if (Main.evraklar.get(i).getImzalayan()!=null)
					kayit.setString(5,String.valueOf( Main.evraklar.get(i).getImzalayan().getTcNo()));
				else
					kayit.setNull(5, 0);
				kayit.setString(6,String.valueOf( Main.evraklar.get(i).getOlusturan().getTcNo()));
				kayit.setBoolean(7,Main.evraklar.get(i).isGecerlilik());
				kayit.executeUpdate();
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
	}


	public static void gorevliKayit() {
		String sql = "INSERT INTO `Gorevli` (`tcNo`, `ad`, `soyAd`, `dogumTarihi`,"
				+ " `maas`, `sifre`, `isGirisTarihi`, "
				+ "`isCikisTarihi`, `calismaDurumu`) VALUES (?,?,?,?,?,?,?,?,?)";
		String sql2= "DELETE FROM Gorevli";
		try {
			PreparedStatement temizle = con.prepareStatement(sql2);
			temizle.execute();
			for (int i=0;i<Main.gorevliler.size();i++) {
				PreparedStatement kayit = con.prepareStatement(sql);
				kayit.setString(1,String.valueOf( Main.gorevliler.get(i).getTcNo()));
				kayit.setString(2,Main.gorevliler.get(i).getAd());
				kayit.setString(3,Main.gorevliler.get(i).getSoyAd());
				kayit.setString(4,Main.gorevliler.get(i).getDogumTarihi());
				kayit.setDouble(5,( Main.gorevliler.get(i).getMaas()));
				kayit.setString(6,Main.gorevliler.get(i).getSifre());
				kayit.setString(7,Main.gorevliler.get(i).getIsGirisTarihi());
				kayit.setString(8,Main.gorevliler.get(i).getIsCikisTarihi());
				kayit.setBoolean(9,Main.gorevliler.get(i).isCalismaDurumu());
				kayit.executeUpdate();
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
	}

	public static void mudurKayit() {
		String sql = "INSERT INTO `Mudur` (`tcNo`, `ad`, `soyAd`, `dogumTarihi`,"
				+ " `maas`, `sifre`) VALUES (?,?,?,?,?,?)";
		String sql2= "DELETE FROM Mudur";
		try {
			PreparedStatement temizle = con.prepareStatement(sql2);
			temizle.execute();
			for (int i=0;i<Main.mudurler.size();i++) {
				PreparedStatement kayit = con.prepareStatement(sql);
				kayit.setString(1,String.valueOf( Main.mudurler.get(i).getTcNo()));
				kayit.setString(2,Main.mudurler.get(i).getAd());
				kayit.setString(3,Main.mudurler.get(i).getSoyAd());
				kayit.setString(4,Main.mudurler.get(i).getDogumTarihi());
				kayit.setDouble(5,( Main.mudurler.get(i).getMaas()));
				kayit.setString(6,Main.mudurler.get(i).getSifre());
				kayit.executeUpdate();
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
	}
	public static void kullaniciKayit() {
		String sql = "INSERT INTO `Kullanici` (`tcNo`, `ad`, `soyAd`, "
				+ "`dogumTarihi`, `sifre`, `uyelikTarihi`) VALUES (?,?,?,?,?,?);";
		String sql2= "DELETE FROM Kullanici";
		try {
			PreparedStatement temizle = con.prepareStatement(sql2);
			temizle.execute();
			for (int i=0;i<Main.kullanicilar.size();i++) {
				PreparedStatement kayit = con.prepareStatement(sql);
				kayit.setString(1,String.valueOf( Main.kullanicilar.get(i).getTcNo()));
				kayit.setString(2,Main.kullanicilar.get(i).getAd());
				kayit.setString(3,Main.kullanicilar.get(i).getSoyAd());
				kayit.setString(4,Main.kullanicilar.get(i).getDogumTarihi());
				kayit.setString(5,Main.kullanicilar.get(i).getSifre());
				kayit.setString(6,Main.kullanicilar.get(i).getUyelikTarihi());
				kayit.executeUpdate();
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
	}
}
