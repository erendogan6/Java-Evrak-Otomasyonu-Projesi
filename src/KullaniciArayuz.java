import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class KullaniciArayuz extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_evraklar;
	private JTextField input_seriNo;
	public KullaniciArayuz(int index) {
		setBackground(new Color(126, 217, 87));
		setResizable(false);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setTitle("Evrak Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 217, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_hosgeldiniz = new JLabel("Hoşgeldiniz "+Main.kullanicilar.get(index).getAd()+" "+Main.kullanicilar.get(index).getSoyAd() +" (Kullanıcı)");
		label_hosgeldiniz.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_hosgeldiniz.setHorizontalTextPosition(SwingConstants.CENTER);
		label_hosgeldiniz.setHorizontalAlignment(SwingConstants.CENTER);
		label_hosgeldiniz.setOpaque(true);
		label_hosgeldiniz.setBackground(Color.ORANGE);
		label_hosgeldiniz.setFont(new Font("Arial", Font.BOLD, 20));
		label_hosgeldiniz.setBounds(0, 0, 786, 38);
		contentPane.add(label_hosgeldiniz);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 18));
		tabbedPane.setBounds(0, 39, 786, 524);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Evrak Oluştur", null, panel, null);
		panel.setLayout(null);

		JComboBox<String> comboBox_Evraklar = new JComboBox<String>();
		comboBox_Evraklar.setModel(new DefaultComboBoxModel<String>(new String[]
				{"İkametgah Evrakı", "Ceza Evrakı",
						"Nüfus Evrakı", "Tapu Evrakı", "Taşıt Evrakı", "Gelir Evrakı"}));
		comboBox_Evraklar.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_Evraklar.setBackground(Color.YELLOW);
		comboBox_Evraklar.setBounds(55, 63, 193, 43);
		panel.add(comboBox_Evraklar);

		JLabel arkaplan_kombo = new JLabel("");
		arkaplan_kombo.setOpaque(true);
		arkaplan_kombo.setBackground(Color.DARK_GRAY);
		arkaplan_kombo.setBounds(41, 48, 221, 72);
		panel.add(arkaplan_kombo);

		JButton buton_evrakOlustur = new JButton("");
		buton_evrakOlustur.setBounds(23, 137, 250, 50);
		buton_evrakOlustur.setBorderPainted(false);
		buton_evrakOlustur.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/Evakk.png")));
		buton_evrakOlustur.setToolTipText("Evrak Oluştur");
		panel.add(buton_evrakOlustur);

		JLabel label_olustur = new JLabel("Oluşturmak İstediğiniz Evrak Türünü Seçiniz :");
		label_olustur.setFont(new Font("Arial", Font.BOLD, 20));
		label_olustur.setBounds(11, 5, 458, 50);
		panel.add(label_olustur);

		JLabel arkaPlan = new JLabel("");
		arkaPlan.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/ErenSağ.png")));
		arkaPlan.setBounds(0, 0, 801, 500);
		panel.add(arkaPlan);

		buton_evrakOlustur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String secim="";
					int n= comboBox_Evraklar.getSelectedIndex();
					if (n==0)
						secim ="İkametgah";
					else if (n==1)
						secim ="Ceza";
					else if (n==2)
						secim ="Nüfus";
					else if (n==3)
						secim ="Nüfus";
					else if (n==4)
						secim ="Taşıt";
					else if (n==5)
						secim ="Gelir";
					Main.evraklar.add(new Evrak(secim,Main.kullanicilar.get(index)));
					SQLBaglantisi.evrakKayit();
					JOptionPane.showMessageDialog(null, "Evrak Oluşturuldu");
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Evrak Türü Seçmediniz !");
				}
			}
		});

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Belirli Evrakı Görüntüle", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel label_goruntule2 = new JLabel("Seri Numarasını Giriniz: ");
		label_goruntule2.setOpaque(false);
		label_goruntule2.setFont(new Font("Arial", Font.BOLD, 20));
		label_goruntule2.setBounds(15, 50, 231, 52);
		panel_2.add(label_goruntule2);

		JTextPane label_belirliEvrak = new JTextPane();
		label_belirliEvrak.setOpaque(false);
		label_belirliEvrak.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label_belirliEvrak.setEditable(false);
		label_belirliEvrak.setFont(new Font("Arial", Font.BOLD, 22));
		label_belirliEvrak.setBounds(15, 187, 400, 267);
		panel_2.add(label_belirliEvrak);

		input_seriNo = new JTextField();
		input_seriNo.setFont(new Font("Arial", Font.BOLD, 18));
		input_seriNo.setBackground(Color.ORANGE);
		input_seriNo.setBounds(242, 56, 162, 38);
		input_seriNo.setColumns(10);
		panel_2.add(input_seriNo);


		JButton buton_evrakiGoruntule = new JButton("");
		buton_evrakiGoruntule.setAlignmentX(Component.CENTER_ALIGNMENT);
		buton_evrakiGoruntule.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/evrakgoruntule.png")));
		buton_evrakiGoruntule.setBorderPainted(false);
		buton_evrakiGoruntule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int seriNo = Integer.parseInt(input_seriNo.getText());
					for (int i=0;i<Main.evraklar.size();i++) {
						if (Main.evraklar.get(i).getSeriNo()==seriNo
								&& Main.kullanicilar.get(index).getTcNo()==Main.evraklar.get(i).getOlusturan().getTcNo()) {
							label_belirliEvrak.setText(Main.evraklar.get(i).toString());
							break;
						}
						if (i==Main.evraklar.size()-1) {
							JOptionPane.showMessageDialog(null,"Seri Numara İle Eşleşen Herhangi Bir Evrakınız Bulunamadı!");
						}
					}
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Hatalı Giriş Yaptınız !");
				}
			}
		});
		buton_evrakiGoruntule.setBounds(15, 112, 280, 50);
		panel_2.add(buton_evrakiGoruntule);
		buton_evrakiGoruntule.setToolTipText("Evrakı Görüntüle");
		buton_evrakiGoruntule.setFont(new Font("Arial", Font.BOLD, 26));
		buton_evrakiGoruntule.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		JLabel label_goruntule1 = new JLabel("Görüntülemek İstediğiniz Evrakın ");
		label_goruntule1.setOpaque(false);
		label_goruntule1.setFont(new Font("Arial", Font.BOLD, 20));
		label_goruntule1.setBounds(15, 10, 322, 52);
		panel_2.add(label_goruntule1);

		JLabel arkaplan_2 = new JLabel("");
		arkaplan_2.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/ErenSağ.png")));
		arkaplan_2.setBounds(0, 0, 781, 474);
		panel_2.add(arkaplan_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Hesap Ayarları", null, panel_3, null);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(126, 217, 87));

		JTextPane output_kullaniciBilgileri = new JTextPane();
		output_kullaniciBilgileri.setOpaque(false);
		output_kullaniciBilgileri.setFont(new Font("Arial", Font.BOLD, 22));
		output_kullaniciBilgileri.setEditable(false);
		output_kullaniciBilgileri.setBounds(0, 85, 340, 379);
		panel_3.add(output_kullaniciBilgileri);

		JButton buton_kisiselBilgileriGoster = new JButton("");
		buton_kisiselBilgileriGoster.setBorderPainted(false);
		buton_kisiselBilgileriGoster.setBorder(null);
		buton_kisiselBilgileriGoster.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/kisiselBilgileriGoruntule.png")));
		buton_kisiselBilgileriGoster.setBounds(0, 10, 360, 50);
		buton_kisiselBilgileriGoster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output_kullaniciBilgileri.setText(Main.kullanicilar.get(index).toString());
			}
		});
		panel_3.add(buton_kisiselBilgileriGoster);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(126, 217, 87));
		tabbedPane.addTab("Oluşturulan Evrakları Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);

		JButton buton_EvraklariGoruntule = new JButton("");
		buton_EvraklariGoruntule.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/olusturulanEvraklariGoruntule.png")));
		buton_EvraklariGoruntule.setBorderPainted(false);
		buton_EvraklariGoruntule.setBackground(new Color(0, 255, 0));
		buton_EvraklariGoruntule.setBounds(161, 409, 470, 50);
		panel_1.add(buton_EvraklariGoruntule);
		buton_EvraklariGoruntule.setHorizontalTextPosition(SwingConstants.CENTER);
		buton_EvraklariGoruntule.setFont(new Font("Arial", Font.BOLD, 26));
		buton_EvraklariGoruntule.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 781, 409);
		panel_1.add(scrollPane);

		table_evraklar = new JTable();
		table_evraklar.setFillsViewportHeight(true);
		table_evraklar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_evraklar.setIntercellSpacing(new Dimension(5, 5));

		scrollPane.setViewportView(table_evraklar);
		table_evraklar.setBorder(null);
		table_evraklar.setFont(new Font("Arial", Font.BOLD, 16));
		table_evraklar.setDefaultEditor(Object.class, null);
		table_evraklar.setBackground(new Color(126, 217, 87));

		DefaultTableModel tblModel = (DefaultTableModel)table_evraklar.getModel();
		String[] cols = {"Seri No", "Doğrulama Kod", "Tür", "Tarih", "İmzalayan", "Oluşturan","Geçerlilik"};
		tblModel.setColumnIdentifiers(cols);
		;
		buton_EvraklariGoruntule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblModel.getDataVector().removeAllElements();
				String gecerli;
				//revalidate();
				for (Evrak Evrak : Main.evraklar) {
					if (Evrak.getOlusturan().getTcNo() == Main.kullanicilar.get(index).getTcNo()) {
						if (Evrak.isGecerlilik()) {
							gecerli = "Geçerli";
						}
						else {
							gecerli = "Geçerli Değil";
						}
						String[] tmp = {String.valueOf(Evrak.getSeriNo()),
								String.valueOf(Evrak.getDogrulamaKod()),
								String.valueOf(Evrak.getTur()),
								Evrak.getTarih(),
								Evrak.ImzalayanKim(),
								Evrak.getOlusturan().getAd() + " " + Evrak.getOlusturan().getSoyAd(),
								gecerli};
						tblModel.addRow(tmp);
					}
				}
			}
		});
		table_evraklar.setRowHeight(30);
		table_evraklar.setAutoCreateRowSorter(true);

		JLabel label_eskiSifre = new JLabel("Eski Şifrenizi Giriniz: ");
		label_eskiSifre.setFont(new Font("Arial", Font.BOLD, 20));
		label_eskiSifre.setBounds(401, 10, 205, 52);
		panel_3.add(label_eskiSifre);

		JLabel label_yeniSifre1 = new JLabel("Yeni Şifrenizi Giriniz: ");
		label_yeniSifre1.setFont(new Font("Arial", Font.BOLD, 20));
		label_yeniSifre1.setBounds(401, 72, 213, 52);
		panel_3.add(label_yeniSifre1);

		JLabel lblYeniifreyiiTekrar = new JLabel("Yeni Şifreyi Tekrar Giriniz: ");
		lblYeniifreyiiTekrar.setFont(new Font("Arial", Font.BOLD, 20));
		lblYeniifreyiiTekrar.setBounds(350, 144, 255, 52);
		panel_3.add(lblYeniifreyiiTekrar);

		JPasswordField input_yeniSifre = new JPasswordField();
		input_yeniSifre.setFont(new Font("Arial", Font.PLAIN, 16));
		input_yeniSifre.setColumns(10);
		input_yeniSifre.setBackground(Color.ORANGE);
		input_yeniSifre.setBounds(609, 77, 162, 38);
		panel_3.add(input_yeniSifre);

		JPasswordField input_eskiSifre = new JPasswordField();
		input_eskiSifre.setFont(new Font("Arial", Font.PLAIN, 16));
		input_eskiSifre.setColumns(10);
		input_eskiSifre.setBackground(Color.ORANGE);
		input_eskiSifre.setBounds(607, 17, 162, 38);
		panel_3.add(input_eskiSifre);

		JPasswordField input_yenisifre2 = new JPasswordField();
		input_yenisifre2.setFont(new Font("Arial", Font.PLAIN, 16));
		input_yenisifre2.setColumns(10);
		input_yenisifre2.setBackground(Color.ORANGE);
		input_yenisifre2.setBounds(609, 153, 162, 38);
		panel_3.add(input_yenisifre2);

		JButton buton_sifreDegis = new JButton("");
		buton_sifreDegis.setBorderPainted(false);
		buton_sifreDegis.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/sifreDegistir.png")));
		buton_sifreDegis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String eskisifre =String.valueOf(input_eskiSifre.getPassword());
				String yenisifre1 =String.valueOf(input_yeniSifre.getPassword());
				String yenisifre2 =String.valueOf(input_yenisifre2.getPassword());
				if (eskisifre.isBlank()) {
					JOptionPane.showMessageDialog(null,"Eski Şifre Girişi Yapılmamıştır!");
					return;}
				else if (yenisifre1.length()>253) {
					JOptionPane.showMessageDialog(null,"Yeni Şifre Maksimum Uzunluğu Aşmaktadır !");
					return;}
				else if (yenisifre1.length()<6) {
					JOptionPane.showMessageDialog(null,"Yeni Şifre Minimum 6 Karakter olmalıdır !");
					return;}
				else if(Objects.equals(eskisifre,Main.kullanicilar.get(index).getSifre())){
					if (yenisifre1.isBlank() || yenisifre2.isBlank()) {
						JOptionPane.showMessageDialog(null,"Yeni Şifre İçin Giriş Yapmadınız !");
						return;}
					else if (yenisifre1.equals(yenisifre2)){
						Main.kullanicilar.get(index).setSifre(yenisifre2);
						SQLBaglantisi.kullaniciKayit();
						JOptionPane.showMessageDialog(null,"Şifre Başarıyla Değiştirilmiştir !");
						return;}
					else {
						JOptionPane.showMessageDialog(null,"Yeni Şifreler Uyuşmamaktadır. Lütfen Kontrol Ediniz !");
						return;}
				}
				else {
					JOptionPane.showMessageDialog(null,"Eski Şifre Yanlış Girilmiştir. Lütfen Kontrol Ediniz !");
					return;}
			}
		});
		buton_sifreDegis.setBounds(491, 226, 280, 50);
		panel_3.add(buton_sifreDegis);
		buton_sifreDegis.setToolTipText("Şifre Değiş");
		buton_sifreDegis.setFont(new Font("Arial", Font.BOLD, 26));
		buton_sifreDegis.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		JButton buton_hesaptanCikisYap = new JButton("");

		buton_hesaptanCikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AnaEkran yeni = new AnaEkran();
				yeni.setVisible(true);
				return;
			}
		});
		panel_3.add(buton_hesaptanCikisYap);
		buton_hesaptanCikisYap.setBounds(534, 404, 220, 50);
		buton_hesaptanCikisYap.setIcon(new ImageIcon(KullaniciArayuz.class.getResource("/resimler/hesapCikisYappp.png")));
		buton_hesaptanCikisYap.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
	}
}
