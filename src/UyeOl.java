import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UyeOl extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton buton_uyeOl = new JButton();
	private final JButton buton_cikisYap = new JButton();
	private JTextField input_ad;
	private JTextField input_soyad;
	private JTextField input_TC;
	private JTextField input_tarih;
	private JTextField input_guvenlik;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Çarpı tuşuna basıldığında kapanması için
					URL resim = AnaEkran.class.getResource("/resimler/ikon.png");
					Image icon = Toolkit.getDefaultToolkit().getImage(resim);
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UyeOl() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				JOptionPane.showMessageDialog(null,"Lütfen Tüm Bilgileri Eksiksiz Ve Doğru Bir Şekilde Doldurunuz.\nŞifreniz En Az 6 Karakter olmaladır.");


			}
		});
		setResizable(false);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setTitle("Evrak Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		buton_uyeOl.setBorderPainted(false);
		buton_uyeOl.setIcon(new ImageIcon(UyeOl.class.getResource("/resimler/UyeOl.png")));
		buton_uyeOl.setBounds(41, 503, 200, 50);
		buton_uyeOl.setToolTipText("Üye Ol");
		buton_cikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AnaEkran frm = new AnaEkran();
				frm.setVisible(true);
			}
		});
		buton_cikisYap.setBorderPainted(false);
		buton_cikisYap.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/cikisYap.png")));
		buton_cikisYap.setBounds(553, 503, 200, 50);
		buton_cikisYap.setToolTipText("Çıkış Yap");
		contentPane.setLayout(null);

		JCheckBox checkbox_kosullar = new JCheckBox("Üyelik Koşullarını Kabul Ediyor, Onaylıyorum.");
		checkbox_kosullar.setOpaque(false);
		checkbox_kosullar.setFont(new Font("Arial", Font.BOLD, 17));
		checkbox_kosullar.setBounds(0, 452, 399, 28);
		contentPane.add(checkbox_kosullar);

		JLabel output_guvenlik = new JLabel("17T5G6");
		output_guvenlik.setHorizontalTextPosition(SwingConstants.CENTER);
		output_guvenlik.setHorizontalAlignment(SwingConstants.CENTER);
		output_guvenlik.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		output_guvenlik.setOpaque(false);
		output_guvenlik.setFont(new Font("Arial", Font.BOLD, 20));
		output_guvenlik.setBounds(170, 407, 108, 39);
		contentPane.add(output_guvenlik);

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
		input_guvenlik = new JTextField();
		input_guvenlik.setFont(new Font("Arial", Font.BOLD, 18));
		input_guvenlik.setColumns(10);
		input_guvenlik.setBackground(Color.RED);
		input_guvenlik.setBounds(160, 359, 130, 38);
		contentPane.add(input_guvenlik);

		JLabel label_uye6 = new JLabel("Güvenlik Kodu:");
		label_uye6.setOpaque(false);
		label_uye6.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye6.setBounds(10, 358, 154, 39);
		contentPane.add(label_uye6);

		JLabel label_uye2 = new JLabel("Soyad:");
		label_uye2.setOpaque(false);
		label_uye2.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye2.setBounds(10, 125, 70, 39);
		contentPane.add(label_uye2);

		input_TC = new JTextField();
		input_TC.setFont(new Font("Arial", Font.BOLD, 18));
		input_TC.setColumns(10);
		input_TC.setBackground(Color.ORANGE);
		input_TC.setBounds(98, 187, 130, 38);
		contentPane.add(input_TC);

		JLabel label_uye4 = new JLabel("Şifre:");
		label_uye4.setOpaque(false);
		label_uye4.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye4.setBounds(10, 251, 70, 39);
		contentPane.add(label_uye4);

		input_soyad = new JTextField();
		input_soyad.setFont(new Font("Arial", Font.BOLD, 18));
		input_soyad.setColumns(10);
		input_soyad.setBackground(Color.ORANGE);
		input_soyad.setBounds(98, 126, 130, 38);
		contentPane.add(input_soyad);

		JLabel label_uye5 = new JLabel("Doğum Tarihi:");
		label_uye5.setOpaque(false);
		label_uye5.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye5.setBounds(10, 307, 154, 39);
		contentPane.add(label_uye5);

		JPasswordField input_sifre = new JPasswordField();
		input_sifre.setFont(new Font("Arial", Font.BOLD, 18));
		input_sifre.setColumns(10);
		input_sifre.setBackground(Color.ORANGE);
		input_sifre.setBounds(98, 252, 130, 38);
		contentPane.add(input_sifre);

		JLabel label_uye3 = new JLabel("T.C. No:");
		label_uye3.setOpaque(false);
		label_uye3.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye3.setBounds(10, 186, 83, 39);
		contentPane.add(label_uye3);


		input_tarih = new JTextField();
		input_tarih.setFont(new Font("Arial", Font.BOLD, 18));
		input_tarih.setColumns(10);
		input_tarih.setBackground(Color.ORANGE);
		input_tarih.setBounds(160, 308, 130, 38);
		contentPane.add(input_tarih);

		input_ad = new JTextField();
		input_ad.setFont(new Font("Arial", Font.BOLD, 18));
		input_ad.setColumns(10);
		input_ad.setBackground(Color.ORANGE);
		input_ad.setBounds(98, 65, 130, 38);
		contentPane.add(input_ad);

		JLabel label_uye1 = new JLabel("Ad:");
		label_uye1.setOpaque(false);
		label_uye1.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye1.setBounds(10, 64, 70, 39);
		contentPane.add(label_uye1);

		JLabel label_uye = new JLabel("Kullanıcı Üye Ekranına Hoş Geldiniz");
		label_uye.setOpaque(false);
		label_uye.setFont(new Font("Arial", Font.BOLD, 20));
		label_uye.setBounds(41, 21, 369, 39);
		contentPane.add(label_uye);
		contentPane.add(buton_uyeOl);
		contentPane.add(buton_cikisYap);

		JLabel arkaplan_1 = new JLabel("");
		arkaplan_1.setOpaque(true);
		arkaplan_1.setBackground(new Color(95, 158, 160));
		arkaplan_1.setBounds(0, 0, 399, 500);
		contentPane.add(arkaplan_1);

		JLabel arkaplan = new JLabel();
		arkaplan.setIcon(new ImageIcon(UyeOl.class.getResource("/resimler/ErenSağ.png")));
		arkaplan.setBounds(0, -21, 800, 600);
		contentPane.add(arkaplan);

		JLabel label = new JLabel();
		label.setBounds(365, 374, 45, 13);
		contentPane.add(label);


		buton_uyeOl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long TCNo;
				try {
					String Ad = input_ad.getText();
					String Soyad = input_soyad.getText();
					String Tc = input_TC.getText();
					String Tarih = input_tarih.getText();
					String Sifre = String.valueOf( input_sifre.getPassword());
					String Guvenlik = input_guvenlik.getText();
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
						JOptionPane.showMessageDialog(null,"Tarih Uzunluğu Çok Fazla. "
								+ "Hatalı Giriş Yaptınız ");
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
						JOptionPane.showMessageDialog(null,"Şifre 6 Haneden Küçük Olamaz !");
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
					Main.kullanicilar.add(new Kullanici(TCNo,Ad,Soyad,Tarih,Sifre));
					SQLBaglantisi.kullaniciKayit();
					JOptionPane.showMessageDialog(null,"Hesabınız Oluşturuldu !");
					return;
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"Hatalı Giriş Yaptınız !");
					return;
				}
			}});
	}
}
