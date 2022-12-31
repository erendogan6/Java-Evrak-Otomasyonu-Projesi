import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.Random;

public class IlkKurulum extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input_ad;
	private JTextField input_soyad;
	private JTextField input_TC;
	private JPasswordField input_sifre;
	private JTextField input_tarih;
	private JTextField input_guvenlik;
	private JTextField input_maas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IlkKurulum frame = new IlkKurulum();
					frame.setVisible(true);
					URL resim = AnaEkran.class.getResource("/resimler/ikon.png");
					Image icon = Toolkit.getDefaultToolkit().getImage(resim);
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IlkKurulum() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				JOptionPane.showMessageDialog(null,"Müdür Kayıt Ekranına Hoşgeldiniz.\nLütfen Tüm Bilgileri Eksiksiz Ve Doğru Bir Şekilde Doldurunuz.\nŞifreniz En Az 6 Karakter olmaladır.");
			}
		});

		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		setResizable(false);
		setTitle("Evrak Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		input_maas = new JTextField();
		input_maas.setFont(new Font("Arial", Font.BOLD, 18));
		input_maas.setColumns(10);
		input_maas.setBackground(Color.ORANGE);
		input_maas.setBounds(314, 94, 108, 38);
		contentPane.add(input_maas);

		JLabel label_uye7 = new JLabel("Maaş:");
		label_uye7.setOpaque(false);
		label_uye7.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye7.setBounds(248, 93, 70, 39);
		contentPane.add(label_uye7);

		JLabel label_uye = new JLabel("Lütfen Müdür Kaydını Yapınız");
		label_uye.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye.setBounds(10, 43, 443, 32);
		contentPane.add(label_uye);

		JLabel label_uyee = new JLabel("İlk Kurulum Ekranına Hoş Geldiniz.");
		label_uyee.setFont(new Font("Arial", Font.BOLD, 20));
		label_uyee.setBounds(10, 10, 443, 32);
		contentPane.add(label_uyee);

		JLabel label_uye1 = new JLabel("Ad:");
		label_uye1.setOpaque(false);
		label_uye1.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye1.setBounds(16, 93, 70, 39);
		contentPane.add(label_uye1);

		input_ad = new JTextField();
		input_ad.setFont(new Font("Arial", Font.BOLD, 18));
		input_ad.setColumns(10);
		input_ad.setBackground(Color.ORANGE);
		input_ad.setBounds(104, 94, 130, 38);
		contentPane.add(input_ad);

		JLabel label_uye2 = new JLabel("Soyad:");
		label_uye2.setOpaque(false);
		label_uye2.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye2.setBounds(16, 154, 70, 39);
		contentPane.add(label_uye2);

		input_soyad = new JTextField();
		input_soyad.setFont(new Font("Arial", Font.BOLD, 18));
		input_soyad.setColumns(10);
		input_soyad.setBackground(Color.ORANGE);
		input_soyad.setBounds(104, 155, 130, 38);
		contentPane.add(input_soyad);

		JLabel label_uye3 = new JLabel("T.C. No:");
		label_uye3.setOpaque(false);
		label_uye3.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye3.setBounds(16, 215, 83, 39);
		contentPane.add(label_uye3);

		input_TC = new JTextField();
		input_TC.setFont(new Font("Arial", Font.BOLD, 18));
		input_TC.setColumns(10);
		input_TC.setBackground(Color.ORANGE);
		input_TC.setBounds(104, 216, 130, 38);
		contentPane.add(input_TC);

		JLabel label_uye4 = new JLabel("Şifre:");
		label_uye4.setOpaque(false);
		label_uye4.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye4.setBounds(16, 280, 70, 39);
		contentPane.add(label_uye4);

		input_sifre = new JPasswordField();
		input_sifre.setFont(new Font("Arial", Font.BOLD, 18));
		input_sifre.setColumns(10);
		input_sifre.setBackground(Color.ORANGE);
		input_sifre.setBounds(104, 281, 130, 38);
		contentPane.add(input_sifre);

		JLabel label_uye5 = new JLabel("Doğum Tarihi:");
		label_uye5.setOpaque(false);
		label_uye5.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye5.setBounds(16, 336, 154, 39);
		contentPane.add(label_uye5);

		input_tarih = new JTextField();
		input_tarih.setFont(new Font("Arial", Font.BOLD, 18));
		input_tarih.setColumns(10);
		input_tarih.setBackground(Color.ORANGE);
		input_tarih.setBounds(166, 337, 130, 38);
		contentPane.add(input_tarih);

		JLabel label_uye6 = new JLabel("Güvenlik Kodu:");
		label_uye6.setOpaque(false);
		label_uye6.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye6.setBounds(16, 387, 154, 39);
		contentPane.add(label_uye6);

		input_guvenlik = new JTextField();
		input_guvenlik.setFont(new Font("Arial", Font.BOLD, 18));
		input_guvenlik.setColumns(10);
		input_guvenlik.setBackground(Color.RED);
		input_guvenlik.setBounds(166, 388, 130, 38);
		contentPane.add(input_guvenlik);

		JLabel output_guvenlik = new JLabel("");
		output_guvenlik.setOpaque(false);
		output_guvenlik.setHorizontalTextPosition(SwingConstants.CENTER);
		output_guvenlik.setHorizontalAlignment(SwingConstants.CENTER);
		output_guvenlik.setFont(new Font("Arial", Font.BOLD, 20));
		output_guvenlik.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		output_guvenlik.setBounds(312, 387, 108, 39);
		contentPane.add(output_guvenlik);

		JCheckBox checkbox_kosullar = new JCheckBox("Üyelik Koşullarını Kabul Ediyor, Onaylıyorum.");
		checkbox_kosullar.setOpaque(false);
		checkbox_kosullar.setFont(new Font("Arial", Font.BOLD, 17));
		checkbox_kosullar.setBounds(12, 441, 399, 28);
		contentPane.add(checkbox_kosullar);

		Random rand = new Random();
		String tmp = String.valueOf(rand.nextInt(999999));
		String kod = "";
		final String Kodd;

		for (int i=0;i<tmp.length();i++ ) {
			if (tmp.charAt(i)=='2') {
				kod+='F';
			}
			else if (tmp.charAt(i)=='4') {
				kod+='Z';
			}
			else if (tmp.charAt(i)=='6') {
				kod+='R';
			}
			else if (tmp.charAt(i)=='8') {
				kod+='Y';
			}
			else if (tmp.charAt(i)=='0') {
				kod+='J';
			}
			else {
				kod+=tmp.charAt(i);
			}
		}
		Kodd=kod;

		output_guvenlik.setText(kod);

		JButton buton_uyeOl = new JButton();
		buton_uyeOl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long TCNo;
				double maas;
				try {
					String Ad = input_ad.getText();
					String Soyad = input_soyad.getText();
					String Tc = input_TC.getText();
					String Tarih = input_tarih.getText();
					String Sifre = String.valueOf( input_sifre.getPassword());
					String Guvenlik = input_guvenlik.getText();
					String Maas = input_maas.getText();
					if (Ad.isBlank()) {
						JOptionPane.showMessageDialog(null,"Ad Girmediniz !");
						return;
					}
					else if (Ad.length()>253) {
						JOptionPane.showMessageDialog(null,"Ad Uzunluğu Çok Fazla. "
								+ "Lütfen Sistem Yöneticisi İle İletişime Geçin !");
						return;
					}
					else if (Soyad.isBlank()) {
						JOptionPane.showMessageDialog(null,"Soyad Girmediniz !");
						return;
					}
					else if (Soyad.length()>253) {
						JOptionPane.showMessageDialog(null,"Soyad Uzunluğu Çok Fazla. "
								+ "Lütfen Sistem Yöneticisi İle İletişime Geçin !");
						return;
					}
					else if (Tc.isBlank()) {
						JOptionPane.showMessageDialog(null,"T.C. No Girmediniz !");
						return;
					}
					else if (Tc.length()!=11) {
						JOptionPane.showMessageDialog(null,"T.C. No Hatalı Girilmiştir!");
						return;
					}
					else if (Tarih.isBlank()) {
						JOptionPane.showMessageDialog(null,"Doğum Tarihi Girmediniz !");
						return;
					}
					else if (Tarih.length()>253) {
						JOptionPane.showMessageDialog(null,"Tarih Uzunluğu Çok Fazla. Hatalı Giriş Yaptınız ");
						return;
					}
					else if (Sifre.isBlank()) {
						JOptionPane.showMessageDialog(null,"Şifre Girmediniz !");
						return;
					}
					else if (Sifre.length()>253) {
						JOptionPane.showMessageDialog(null,"Şifre Uzunluğu Çok Fazla. Hatalı Giriş Yaptınız ");
						return;
					}
					else if (Sifre.length()<6) {
						JOptionPane.showMessageDialog(null,"Şifre Uzunluğu Çok Kısa En Az 6 Karakter Olmalı ! ");
						return;
					}
					else if (!checkbox_kosullar.isSelected()) {
						JOptionPane.showMessageDialog(null,"Üyelik Koşullarını Onaylamadınız !");
					}
					else if (Guvenlik.isBlank()) {
						JOptionPane.showMessageDialog(null,"Güvenlik Kodu Girmediniz !");
						return;
					}
					else if (!Guvenlik.equals(Kodd)) {
						JOptionPane.showMessageDialog(null,"Güvenlik Kodunu Yanlış Girdiniz !");
						return;
					}
					else if (Maas.isBlank()) {
						JOptionPane.showMessageDialog(null,"Maaş Bilgisi Girilmedi !");
						return;
					}
					else if (Maas.length()>10) {
						JOptionPane.showMessageDialog(null,"Maaş Miktarı Çok Fazla !");
						return;
					}
					try {
						TCNo=Long.valueOf(Tc);
						for (Kullanici Kullanici:Main.kullanicilar) {
							if (TCNo == Kullanici.getTcNo()) {
								JOptionPane.showMessageDialog(null,"Bu T.C Kimlik Numarası İle Mevcut Bir Hesap Vardır !");
								return;
							}
						}
					}
					catch(Exception ee) {
						JOptionPane.showMessageDialog(null,"T.C Kimlik Numarasını Hatalı Girdiniz !");
						return;
					}
					try {
						maas=Long.valueOf(Maas);
					}
					catch(Exception ee) {
						JOptionPane.showMessageDialog(null,"Maaş Bilgisini Hatalı Girdiniz !");
						return;
					}

					Main.mudurler.add(new Mudur(TCNo,Ad,Soyad,Tarih,maas,Sifre));
					JOptionPane.showMessageDialog(null,"Müdür Hesabı Oluşturuldu !");
					SQLBaglantisi.mudurKayit();
					URL dizin = AnaEkran.class.getResource("/ilkKurulum.txt");
					File f = new File(dizin.toURI());
					f.delete();
					dispose();
					AnaEkran.main(null);
					return;
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"Hatalı Giriş Yaptınız !");
					return;
				}
			}
		});
		buton_uyeOl.setIcon(new ImageIcon(IlkKurulum.class.getResource("/resimler/UyeOl.png")));
		buton_uyeOl.setToolTipText("Üye Ol");
		buton_uyeOl.setBorderPainted(false);
		buton_uyeOl.setBounds(95, 510, 200, 50);
		contentPane.add(buton_uyeOl);

		JLabel arkaplan_1 = new JLabel("");
		arkaplan_1.setOpaque(true);
		arkaplan_1.setBackground(new Color(95, 158, 160));
		arkaplan_1.setBounds(0, 0, 443, 509);
		contentPane.add(arkaplan_1);

		JLabel arkaplan = new JLabel("");
		arkaplan.setIcon(new ImageIcon(IlkKurulum.class.getResource("/resimler/ErenSağ.png")));
		arkaplan.setBounds(0, 0, 800, 600);
		contentPane.add(arkaplan);
	}
}
