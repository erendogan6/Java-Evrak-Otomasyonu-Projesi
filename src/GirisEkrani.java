import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class GirisEkrani extends JFrame {
	static URL resim = GirisEkrani.class.getResource("/resimler/ikon.png");
	static Image icon = Toolkit.getDefaultToolkit().getImage(resim);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GirisEkrani() {
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
		contentPane.setLayout(null);
		
		JButton geriDon = new JButton();
		geriDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnaEkran pnl = new AnaEkran();
				dispose();
				pnl.setVisible(true);
			}
		});
		
		
		
		JLabel input_Kod = new JLabel("1AT2Y5");
		input_Kod.setToolTipText("Soldaki Güvenlik Kodunu Giriniz");
		input_Kod.setOpaque(false);
		input_Kod.setFont(new Font("Arial", Font.BOLD, 22));
		input_Kod.setBounds(639, 310, 116, 39);
		input_Kod.setHorizontalTextPosition(SwingConstants.CENTER);
		input_Kod.setHorizontalAlignment(SwingConstants.CENTER);
		input_Kod.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		contentPane.add(input_Kod);
		
		geriDon.setIcon(new ImageIcon(GirisEkrani.class.getResource("/resimler/geriDon.png")));
		geriDon.setToolTipText("Geri Dön");
		geriDon.setBorderPainted(false);
		geriDon.setBounds(533, 474, 200, 50);
		contentPane.add(geriDon);
		
		JTextField input_TC = new JTextField();
		input_TC.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		input_TC.setForeground(Color.YELLOW);
		input_TC.setFont(new Font("Arial", Font.BOLD, 20));
		input_TC.setBackground(Color.GRAY);
		input_TC.setToolTipText("T.C. No Giriniz");
		input_TC.setBounds(492, 86, 220, 40);
		contentPane.add(input_TC);
		
		JPasswordField input_Sifre = new JPasswordField();
		input_Sifre.setEchoChar('*');
		input_Sifre.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		input_Sifre.setForeground(Color.YELLOW);
		input_Sifre.setFont(new Font("Arial", Font.BOLD, 20));
		input_Sifre.setBackground(Color.GRAY);
		input_Sifre.setToolTipText("Şifrenizi Giriniz");
		input_Sifre.setBounds(492, 200, 220, 40);
		contentPane.add(input_Sifre);
		
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
		input_Kod.setText(kod);
		JTextField output_Kod = new JTextField();
		output_Kod.setToolTipText("Güvenlik Kodu");
		output_Kod.setFont(new Font("Arial", Font.BOLD, 18));
		output_Kod.setColumns(10);
		output_Kod.setBackground(Color.RED);
		output_Kod.setBounds(492, 311, 130, 38);
		contentPane.add(output_Kod);
		output_Kod.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		
		JLabel label_Guvenlik = new JLabel("Güvenlik Kodu Giriniz");
		label_Guvenlik.setOpaque(false);
		label_Guvenlik.setFont(new Font("Arial", Font.BOLD, 22));
		label_Guvenlik.setBounds(492, 262, 241, 39);
		contentPane.add(label_Guvenlik);
		
		JButton girisYap = new JButton();
		girisYap.setIcon(new ImageIcon(GirisEkrani.class.getResource("/resimler/girisYap.png")));
		girisYap.setBorderPainted(false);
		girisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TC VE ŞİFRE GİRİŞİ
				/////////////////////////////////
				long tc;
				if (input_TC.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "TC Kimlik Numarasını Girmediniz !");
					return;
				}
				else if (input_Sifre.getPassword().length==0) {
					JOptionPane.showMessageDialog(null, "Şifre Girmediniz !");
					return;
				} 
				try {
				tc = Long.parseLong(input_TC.getText());
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "TC Kimlik Numarasını Hatalı Girdiniz !");
					input_TC.setText("");
					return;
				}
                if (tc <= 9999999999L || tc > 99999999999L) {
                	JOptionPane.showMessageDialog(null, "TC Kimlik Numarasını Hatalı Girdiniz !");
                	input_TC.setText("");
                	return;
                }
                String sifre = String.valueOf(input_Sifre.getPassword());
            	/////////////////////////////////
                
                //Güvenlik Kodu Kontrol
            	/////////////////////////////////
                if (output_Kod.getText().equals("")) {
                	JOptionPane.showMessageDialog(null, "Güvenlik Kodu Girmediniz !");
					return;
                }
                if (!output_Kod.getText().equals(Kodd)) {
                	JOptionPane.showMessageDialog(null, "Güvenlik Kodu Hatalı !");
					return;
                }
                
            	/////////////////////////////////
				
				//KULLANICI HESAP KONTROL
				///////////////////////////////////
                for (int i = 0; i < Main.kullanicilar.size(); i++) {
                    if (Objects.equals(sifre, Main.kullanicilar.get(i).getSifre()) && Main.kullanicilar.get(i).getTcNo() == tc) {
                    	
                    	JOptionPane.showMessageDialog(null, "Kullanıcı Bulundu. Giriş Yapılıyor !");
                    	
                        int index = i;
                        KullaniciArayuz kullanici = new KullaniciArayuz(index);
                        kullanici.setVisible(true);
						kullanici.setIconImage(icon);
                        dispose();
                        return;
                    } else if (Main.kullanicilar.get(i).getTcNo() == tc && !Objects.equals(sifre, Main.kullanicilar.get(i).getSifre())) {
                        JOptionPane.showMessageDialog(null, "Şifre Yanlış Girildi !");
                        input_Sifre.setText("");
                        return;
                    }
                }
                ///////////////////////////////////
                
                
                ////GÖREVLİ HESAP KONTROL
                /////////////////////////////////
                for (int i = 0; i < Main.gorevliler.size(); i++) {
                    if (Main.gorevliler.get(i).getTcNo() == tc &&!Main.gorevliler.get(i).isCalismaDurumu()){
                    	JOptionPane.showMessageDialog(null, "Aktif Çalışan Olarak Gözükmüyorsunuz. Sisteme Giremezsiniz");
                        return;
                    }
                    else if (Main.gorevliler.get(i).getTcNo() == tc && Objects.equals(Main.gorevliler.get(i).getSifre(), sifre)) {
                    	JOptionPane.showMessageDialog(null, "Görevli Bulundu. Giriş Yapılıyor");
                        int index = i;
                        GorevlilerArayuz gorevli = new GorevlilerArayuz(index);
                        gorevli.setVisible(true);
						gorevli.setIconImage(icon);
						dispose();
                        return;
                    } else if (Main.gorevliler.get(i).getTcNo() == tc && !Objects.equals(sifre, Main.gorevliler.get(i).getSifre())) {
                    	JOptionPane.showMessageDialog(null, "Şifre Yanlış Girildi");
                        return;
                    }
                }
                /////////////////////////////////
                
                // MÜDÜR HESAP KONTROL
            	/////////////////////////////////
                for (int i = 0; i < Main.mudurler.size(); i++) {
                    if (tc == Main.mudurler.get(i).getTcNo() && Objects.equals(sifre, Main.mudurler.get(i).getSifre())) {
                    	JOptionPane.showMessageDialog(null,"Müdür Bulundu. Giriş Yapılıyor");
                        int index = i;
                        MudurArayuz mudur = new MudurArayuz(index);
                        mudur.setVisible(true);
						mudur.setIconImage(icon);
						dispose();
                        return;
                    } else if (tc == Main.mudurler.get(i).getTcNo() && !Objects.equals(sifre, Main.mudurler.get(i).getSifre())) {
                    	JOptionPane.showMessageDialog(null,"Şifre Yanlış Girildi");
                        return;
                    }
                    if (i == Main.mudurler.size() - 1) {
                    	JOptionPane.showMessageDialog(null,"Belirtilen TC NO İle Kayıtlı Bir Hesap Bulunamadı");
                        return;
                    }
                }
                /////////////////////////////////
			}
		});
		girisYap.setToolTipText("Giriş Yap");
		girisYap.setBounds(533, 388, 200, 50);
		contentPane.add(girisYap);
		
		JLabel label_TC = new JLabel("TC No Giriniz");
		label_TC.setFont(new Font("Arial", Font.BOLD, 22));
		label_TC.setBounds(492, 42, 158, 40);
		contentPane.add(label_TC);
		
		JLabel label_Sifre = new JLabel("Şifre Giriniz");
		label_Sifre.setFont(new Font("Arial", Font.BOLD, 22));
		label_Sifre.setBounds(492, 159, 127, 40);
		contentPane.add(label_Sifre);
		
		JLabel arkaplan = new JLabel("");
		arkaplan.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/Eren Please.png")));
		arkaplan.setBounds(0, -24, 800, 600);
		contentPane.add(arkaplan);
	}
}
