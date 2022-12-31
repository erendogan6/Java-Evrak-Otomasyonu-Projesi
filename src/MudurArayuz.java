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
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MudurArayuz extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tumEvraklarTable;
	private JTable tumGorevlilerTable;
	private JTextField input_ad;
	private JTextField input_Soyad;
	private JTextField input_TC;
	private JTextField input_tarih;
	private JTextField input_guvenlik;
	private JTextField input_Maas;
	public MudurArayuz(int index) {
		setBackground(new Color(126, 217, 87));
		setResizable(false);
		setPreferredSize(new Dimension(800, 650));
		setMinimumSize(new Dimension(800, 650));
		setMaximumSize(new Dimension(800, 650));
		setTitle("Evrak Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(126, 217, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 18));
		tabbedPane.setBounds(0, 30, 800, 600);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Evrak İşlemleri", null, panel, null);
		panel.setLayout(null);

		JButton buton_evrakSil = new JButton();
		buton_evrakSil.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/evrakSil.png")));
		buton_evrakSil.setToolTipText("Evrak Pasifleştir");
		buton_evrakSil.setBorderPainted(false);
		buton_evrakSil.setBounds(67, 407, 260, 50);
		panel.add(buton_evrakSil);

		JComboBox<Integer> KomboBox_evraklar = new JComboBox<Integer>();
		KomboBox_evraklar.setBackground(Color.ORANGE);
		KomboBox_evraklar.setFont(new Font("Arial", Font.BOLD, 16));
		KomboBox_evraklar.setMaximumRowCount(1000);
		KomboBox_evraklar.setBounds(305, 54, 112, 32);
		panel.add(KomboBox_evraklar);


		buton_evrakSil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int secim = Integer.valueOf(KomboBox_evraklar.getSelectedItem().toString());
					for (int i=0; i<Main.evraklar.size();i++) {
						if (secim==Main.evraklar.get(i).getDogrulamaKod()) {
							Main.evraklar.remove(i);
							SQLBaglantisi.evrakKayit();
							JOptionPane.showMessageDialog(null, "Evrak Sistemden Silindi !");
							KomboBox_evraklar.removeAllItems();
							for (int j=0;j<Main.evraklar.size();j++) {
								KomboBox_evraklar.addItem(Main.evraklar.get(j).getDogrulamaKod());
							}
						}
					}
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Hata Meydana Geldi !");
					return;
				}
			}
		});

		JButton buton_evrakPasiflestir = new JButton();
		buton_evrakPasiflestir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int secim = Integer.valueOf(KomboBox_evraklar.getSelectedItem().toString());
					for (int i=0;i<Main.evraklar.size();i++) {
						if (secim==Main.evraklar.get(i).getDogrulamaKod() && Main.evraklar.get(i).isGecerlilik() ){
							Main.mudurler.get(index).evrakIptalEt(Main.evraklar.get(i));
							SQLBaglantisi.evrakKayit();
							JOptionPane.showMessageDialog(null, "Evrak Geçerliliği Pasif Hale Getirildi !");
							return;
						}
						else if (secim==Main.evraklar.get(i).getDogrulamaKod() && !Main.evraklar.get(i).isGecerlilik() ){
							JOptionPane.showMessageDialog(null, "Evrak Geçerliliği Zaten Pasif Haldedir !!!");
							return;
						}
					}
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Hata Meydana Geldi !");
					return;
				}
			}
		});
		buton_evrakPasiflestir.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/evrakiPasifHaleGetir.png")));
		buton_evrakPasiflestir.setToolTipText("Evrak Pasifleştir");
		buton_evrakPasiflestir.setBorderPainted(false);
		buton_evrakPasiflestir.setBounds(39, 192, 350, 50);
		panel.add(buton_evrakPasiflestir);

		JLabel label_gecerlilik2 = new JLabel("Doğrulama Numarasını Seçiniz");
		label_gecerlilik2.setFont(new Font("Arial", Font.BOLD, 20));
		label_gecerlilik2.setBounds(11, 50, 297, 38);
		panel.add(label_gecerlilik2);

		JButton buton_evrakAktiflestir = new JButton();
		buton_evrakAktiflestir.setBounds(39, 132, 350, 50);
		buton_evrakAktiflestir.setBorderPainted(false);
		buton_evrakAktiflestir.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/evrakıAktifHaleGetir.png")));
		buton_evrakAktiflestir.setToolTipText("Evrak Aktifleştir");
		panel.add(buton_evrakAktiflestir);

		JLabel label_gecerlilik1 = new JLabel("İşlem Yapacağınız Evrağın");
		label_gecerlilik1.setFont(new Font("Arial", Font.BOLD, 20));
		label_gecerlilik1.setBounds(11, 23, 270, 32);
		panel.add(label_gecerlilik1);


		JLabel arkaplan = new JLabel();
		arkaplan.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/ErenSağ.png")));
		arkaplan.setBounds(0, 0, 801, 530);
		panel.add(arkaplan);
		for (int i=0;i<Main.evraklar.size();i++) {
			KomboBox_evraklar.addItem(Main.evraklar.get(i).getDogrulamaKod());
		}

		buton_evrakAktiflestir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int secim = Integer.valueOf(KomboBox_evraklar.getSelectedItem().toString());
					for (int i=0;i<Main.evraklar.size();i++) {
						if (secim==Main.evraklar.get(i).getDogrulamaKod() && !Main.evraklar.get(i).isGecerlilik() ){
							Main.mudurler.get(index).evrakAktifEt(Main.evraklar.get(i));
							SQLBaglantisi.evrakKayit();
							JOptionPane.showMessageDialog(null, "Evrak Geçerliliği Aktif Hale Getirildi !");
							return;
						}
						else if (secim==Main.evraklar.get(i).getDogrulamaKod() && Main.evraklar.get(i).isGecerlilik() ){
							JOptionPane.showMessageDialog(null, "Evrak Geçerliliği Zaten Aktif Haldedir !!!");
							return;
						}
					}
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Hata Meydana Geldi !");
					return;
				}
			}
		});

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Görevli İşlemleri", null, panel_6, null);
		panel_6.setBackground(new Color(126, 217, 87));
		panel_6.setLayout(null);


		JCheckBox checkbox_isKosullar = new JCheckBox("İşe Alma, Çıkarma Koşullarını Kabul Ediyor, Onaylıyorum.");
		checkbox_isKosullar.setOpaque(false);
		checkbox_isKosullar.setFont(new Font("Arial", Font.BOLD, 20));
		checkbox_isKosullar.setBounds(6, 415, 569, 28);
		panel_6.add(checkbox_isKosullar);

		JTextField input_yeniMaasMiktar = new JTextField();
		input_yeniMaasMiktar.setOpaque(true);
		input_yeniMaasMiktar.setFont(new Font("Arial", Font.PLAIN, 16));
		input_yeniMaasMiktar.setBackground(Color.ORANGE);
		input_yeniMaasMiktar.setBounds(275, 77, 136, 38);
		panel_6.add(input_yeniMaasMiktar);

		JLabel label_zam3 = new JLabel("Yeni Maaş Miktarını Giriniz");
		label_zam3.setFont(new Font("Arial", Font.BOLD, 20));
		label_zam3.setBounds(8, 78, 269, 32);
		panel_6.add(label_zam3);

		JTextPane output_kisiselBilgi = new JTextPane();
		output_kisiselBilgi.setOpaque(false);
		output_kisiselBilgi.setFont(new Font("Arial", Font.BOLD, 22));
		output_kisiselBilgi.setEditable(false);
		output_kisiselBilgi.setBounds(443, 77, 342, 332);
		panel_6.add(output_kisiselBilgi);

		JComboBox<Long> KomboBox_gorevliler = new JComboBox<Long>();
		KomboBox_gorevliler.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					long secim = (long) KomboBox_gorevliler.getSelectedItem();
					for (int i=0;i<Main.gorevliler.size();i++) {
						if (secim==Main.gorevliler.get(i).getTcNo()){
							output_kisiselBilgi.setText(Main.gorevliler.get(i).toString());
						}
					}
				}catch(Exception ee) {
				}

			}
		});
		KomboBox_gorevliler.setBackground(Color.ORANGE);
		KomboBox_gorevliler.setFont(new Font("Arial", Font.BOLD, 16));
		KomboBox_gorevliler.setMaximumRowCount(1000);
		KomboBox_gorevliler.setBounds(592, 24, 173, 36);
		panel_6.add(KomboBox_gorevliler);

		JButton buton_yeniMaasAyarla = new JButton("");
		buton_yeniMaasAyarla.setBounds(6, 133, 400, 50);
		buton_yeniMaasAyarla.setBorderPainted(false);
		buton_yeniMaasAyarla.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/yeniMaas.png")));
		buton_yeniMaasAyarla.setToolTipText("Yeni Maaşı Ayarla");
		panel_6.add(buton_yeniMaasAyarla);

		JLabel label_zam2 = new JLabel("İşlem Yapacağınız Görevlinin T.C. Kimlik Numarasını Seçiniz");
		label_zam2.setFont(new Font("Arial", Font.BOLD, 20));
		label_zam2.setBounds(11, 23, 585, 32);
		panel_6.add(label_zam2);


		buton_yeniMaasAyarla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					long secim = (long) KomboBox_gorevliler.getSelectedItem();
					if (input_yeniMaasMiktar.getText().length()>15) {
						JOptionPane.showMessageDialog(null,"Maaş Miktarını Çok Fazla Girdiniz !");
						return;
					}
					else if (input_yeniMaasMiktar.getText().isBlank() || input_yeniMaasMiktar.getText().equals("0")) {
						JOptionPane.showMessageDialog(null,"Maaş Miktarını Girmediniz !");
						return;
					}
					for (int i=0;i<Main.gorevliler.size();i++) {
						if (secim==Main.gorevliler.get(i).getTcNo()){
							Double yeniMaas = Double.parseDouble(input_yeniMaasMiktar.getText());
							Main.gorevliler.get(i).setMaas(yeniMaas);
							SQLBaglantisi.gorevliKayit();
							JOptionPane.showMessageDialog(null, "Eski Maaş:"+Main.gorevliler.get(i).getMaas()+" Yeni Maaş:"+input_yeniMaasMiktar.getText());
							return;
						}
					}
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Hatalı Giriş Yaptınız !");
					return;
				}
			}
		});
		tabbedPane.addTab("Görevli İşlemleri", null, panel_6, null);

		JButton buton_istenCikar = new JButton();
		buton_istenCikar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					long secim = (long) KomboBox_gorevliler.getSelectedItem();
					if (!checkbox_isKosullar.isSelected()){
						JOptionPane.showMessageDialog(null,"Koşulları Onaylamadınız Kardeş !");
						return;
					}
					for (int i=0;i<Main.gorevliler.size();i++) {
						if (secim==Main.gorevliler.get(i).getTcNo() ){
							if (!Main.gorevliler.get(i).isCalismaDurumu()) {
								JOptionPane.showMessageDialog(null,"Görevli Zaten İşten Çıkarılmıştır !");
								return;
							}
							Main.gorevliler.get(i).setCalismaDurumu(false);
							Main.gorevliler.get(i).setIsCikisTarihi(LocalDate.now().toString());
							SQLBaglantisi.gorevliKayit();
							JOptionPane.showMessageDialog(null,"Görevli İşten Çıkarıldı !");
							return;
						}
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"Hata Meydana Geldi !");
					return;
				}
			}
		});
		buton_istenCikar.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/istenCikarr.png")));
		buton_istenCikar.setToolTipText("İşten Çıkar");
		buton_istenCikar.setBorderPainted(false);
		buton_istenCikar.setBounds(418, 449, 236, 50);
		panel_6.add(buton_istenCikar);

		JButton buton_iseTekrarAl = new JButton("");
		buton_iseTekrarAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buton_iseTekrarAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					long secim = (long) KomboBox_gorevliler.getSelectedItem();
					if (!checkbox_isKosullar.isSelected()){
						JOptionPane.showMessageDialog(null,"Koşulları Onaylamadınız Kardeş !");
						return;
					}
					for (int i=0;i<Main.gorevliler.size();i++) {
						if (secim==Main.gorevliler.get(i).getTcNo()){
							if (Main.gorevliler.get(i).isCalismaDurumu()) {
								JOptionPane.showMessageDialog(null,"Görevli Zaten Çalışmaktadır!");
								return;
							}
							Main.gorevliler.get(i).setCalismaDurumu(true);
							Main.gorevliler.get(i).setIsCikisTarihi(null);
							Main.gorevliler.get(i).setIsGirisTarihi(LocalDate.now().toString());
							SQLBaglantisi.gorevliKayit();
							JOptionPane.showMessageDialog(null,"Görevli Tekrar İşe Alındı!");
							return;
						}
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"Hatalı Giriş Yaptınız !");
				}
			}
		});
		buton_iseTekrarAl.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/iseTekrarAl.png")));
		buton_iseTekrarAl.setToolTipText("İşten Çıkar");
		buton_iseTekrarAl.setBorderPainted(false);
		buton_iseTekrarAl.setBounds(43, 449, 260, 50);
		panel_6.add(buton_iseTekrarAl);



		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tüm Görevlileri Görüntüle", null, panel_2, null);
		panel_2.setLayout(null);

		JButton buton_tumGorevlileriGoruntule = new JButton();
		buton_tumGorevlileriGoruntule.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/tumGorevlileriGoruntule.png")));
		buton_tumGorevlileriGoruntule.setBorderPainted(false);
		buton_tumGorevlileriGoruntule.setBounds(206, 462, 400, 50);
		panel_2.add(buton_tumGorevlileriGoruntule);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(0, 0, 800, 450);
		panel_2.add(scrollPane_1);

		tumGorevlilerTable = new JTable();
		tumGorevlilerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tumGorevlilerTable.setFillsViewportHeight(true);
		tumGorevlilerTable.setAutoCreateRowSorter(true);
		tumGorevlilerTable.setIntercellSpacing(new Dimension(5, 5));
		tumGorevlilerTable.setRowMargin(5);
		tumGorevlilerTable.setFont(new Font("Arial", Font.PLAIN, 16));
		tumGorevlilerTable.setBorder(null);
		tumGorevlilerTable.setDefaultEditor(Object.class, null);
		tumGorevlilerTable.setBackground(new Color(126, 217, 87));
		panel_2.setBackground(new Color(126, 217, 87));
		scrollPane_1.setViewportView(tumGorevlilerTable);
		DefaultTableModel tblModell = (DefaultTableModel)tumGorevlilerTable.getModel();
		String[] cols = {"T.C Kimlik No", "Ad","Soyad", "Doğum Tarihi", "Maaş",
				"Giriş Tarihi", "Çıkış Tarihi","Durumu"};
		tblModell.setColumnIdentifiers(cols);

		buton_tumGorevlileriGoruntule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblModell.getDataVector().removeAllElements();
				String gecerli;
				try {
					for (Gorevli Gorevli: Main.gorevliler) {
						if (Gorevli.isCalismaDurumu()) {
							gecerli = "Çalışıyor";}
						else {
							gecerli = "Çalışmıyor";}
						String[] tmp = {String.valueOf(Gorevli.getTcNo()),
								Gorevli.getAd(),
								Gorevli.getSoyAd(),
								Gorevli.getDogumTarihi(),
								String.valueOf(Gorevli.getMaas()),
								Gorevli.getIsGirisTarihi(),
								Gorevli.getIsCikisTarihi(),
								gecerli};
						tblModell.addRow(tmp);
					}
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Görevli Yoktur !");
					return;
				}
			}
		});
		tumGorevlilerTable.setRowHeight(30);




		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(126, 217, 87));
		tabbedPane.addTab("Tüm Evrakları Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);

		JButton buton_tumEvraklariGoruntule = new JButton("");
		buton_tumEvraklariGoruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buton_tumEvraklariGoruntule.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/tumEvraklariGoruntule.png")));
		buton_tumEvraklariGoruntule.setBorderPainted(false);
		buton_tumEvraklariGoruntule.setBounds(211, 464, 400, 50);
		panel_1.add(buton_tumEvraklariGoruntule);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(126, 217, 87));
		scrollPane.setBounds(0, 0, 800, 450);
		panel_1.add(scrollPane);

		tumEvraklarTable = new JTable();
		tumEvraklarTable.setFillsViewportHeight(true);
		tumEvraklarTable.setEditingColumn(0);
		tumEvraklarTable.setEditingRow(0);
		tumEvraklarTable.setRowMargin(5);
		tumEvraklarTable.setRowHeight(30);
		tumEvraklarTable.setIntercellSpacing(new Dimension(5, 5));
		tumEvraklarTable.setDefaultEditor(Object.class, null);
		tumEvraklarTable.setBackground(new Color(126, 217, 87));


		scrollPane.setViewportView(tumEvraklarTable);
		tumEvraklarTable.setBorder(null);
		tumEvraklarTable.setFont(new Font("Arial", Font.PLAIN, 18));

		DefaultTableModel tblModel = (DefaultTableModel)tumEvraklarTable.getModel();
		String[] colss = {"Seri No", "Doğrulama Kod", "Tür", "Tarih", "İmzalayan", "Oluşturan","Geçerlilik"};
		tblModel.setColumnIdentifiers(colss);

		buton_tumEvraklariGoruntule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblModel.getDataVector().removeAllElements();
				String gecerli;
				try {
					for (Evrak Evrak : Main.evraklar) {
						if (Evrak.isGecerlilik()) {
							gecerli = "Geçerli";}
						else {
							gecerli = "Geçerli Değil";}
						String[] tmp = {String.valueOf(Evrak.getSeriNo()),
								String.valueOf(Evrak.getDogrulamaKod()),
								String.valueOf(Evrak.getTur()),
								Evrak.getTarih(),
								Evrak.ImzalayanKim(),
								String.valueOf(Evrak.getOlusturan().getAd()+" "+Evrak.getOlusturan().getSoyAd()),
								gecerli};
						tblModel.addRow(tmp);
						tumEvraklarTable.setAutoCreateRowSorter(true);
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Kayıtlı Evrak Yoktur !");
					return;
				}
			}
		});

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Hesap Ayarları", null, panel_4, null);
		panel_4.setBackground(new Color(126, 217, 87));
		panel_4.setLayout(null);

		JLabel label_sifre1 = new JLabel("Eski Şifrenizi Giriniz: ");
		label_sifre1.setFont(new Font("Arial", Font.BOLD, 20));
		label_sifre1.setBounds(403, 27, 205, 52);
		panel_4.add(label_sifre1);

		JLabel label_sifre2 = new JLabel("Yeni Şifrenizi Giriniz: ");
		label_sifre2.setFont(new Font("Arial", Font.BOLD, 20));
		label_sifre2.setBounds(401, 89, 213, 52);
		panel_4.add(label_sifre2);

		JLabel label_sifre3 = new JLabel("Yeni Şifreyi Tekrar Giriniz: ");
		label_sifre3.setFont(new Font("Arial", Font.BOLD, 20));
		label_sifre3.setBounds(348, 155, 262, 52);
		panel_4.add(label_sifre3);

		JPasswordField input_sifreYeni1 = new JPasswordField();
		input_sifreYeni1.setFont(new Font("Arial", Font.PLAIN, 16));
		input_sifreYeni1.setColumns(10);
		input_sifreYeni1.setBackground(Color.ORANGE);
		input_sifreYeni1.setBounds(609, 94, 162, 38);
		panel_4.add(input_sifreYeni1);

		JPasswordField input_eskiSifre = new JPasswordField();
		input_eskiSifre.setFont(new Font("Arial", Font.PLAIN, 16));
		input_eskiSifre.setColumns(10);
		input_eskiSifre.setBackground(Color.ORANGE);
		input_eskiSifre.setBounds(609, 34, 162, 38);
		panel_4.add(input_eskiSifre);

		JPasswordField input_sifreYeni2 = new JPasswordField();
		input_sifreYeni2.setFont(new Font("Arial", Font.PLAIN, 16));
		input_sifreYeni2.setColumns(10);
		input_sifreYeni2.setBackground(Color.ORANGE);
		input_sifreYeni2.setBounds(609, 166, 162, 38);
		panel_4.add(input_sifreYeni2);

		JButton buton_sifreDegistir = new JButton("");
		buton_sifreDegistir.setBorderPainted(false);
		buton_sifreDegistir.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/sifreDegistir.png")));
		buton_sifreDegistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String eskisifre =String.valueOf(input_eskiSifre.getPassword());
				String yenisifre1 =String.valueOf(input_sifreYeni1.getPassword());
				String yenisifre2 =String.valueOf(input_sifreYeni2.getPassword());
				if (eskisifre.isBlank()) {
					JOptionPane.showMessageDialog(null,"Eski Şifre Girişi Yapılmamıştır!");
					return;}
				else if (yenisifre1.length()>253) {
					JOptionPane.showMessageDialog(null,"Yeni Şifre Maksimum Uzunluğu Aşmaktadır !");
					return;}
				else if (yenisifre1.length()<6) {
					JOptionPane.showMessageDialog(null,"Yeni Şifre Minimum 6 Karakter olmalıdır !");
					return;}
				else if(Objects.equals(eskisifre,Main.mudurler.get(index).getSifre())){
					if (yenisifre1.isBlank() || yenisifre2.isBlank()) {
						JOptionPane.showMessageDialog(null,"Yeni Şifre İçin Giriş Yapmadınız !");
						return;}
					else if (yenisifre1.equals(yenisifre2)){
						Main.mudurler.get(index).setSifre(yenisifre2);
						SQLBaglantisi.mudurKayit();
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
		buton_sifreDegistir.setBounds(527, 221, 280, 50);
		panel_4.add(buton_sifreDegistir);

		JTextPane label_kisiselBilgiler = new JTextPane();
		label_kisiselBilgiler.setOpaque(false);
		label_kisiselBilgiler.setFont(new Font("Arial", Font.BOLD, 22));
		label_kisiselBilgiler.setEditable(false);
		label_kisiselBilgiler.setBounds(0, 89, 342, 391);
		panel_4.add(label_kisiselBilgiler);

		JButton buton_kisiselBilgileriGoster = new JButton("");
		buton_kisiselBilgileriGoster.setBorderPainted(false);
		buton_kisiselBilgileriGoster.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/kisiselBilgileriGoruntule.png")));
		buton_kisiselBilgileriGoster.setBounds(10, 27, 360, 50);
		buton_kisiselBilgileriGoster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label_kisiselBilgiler.setText(Main.mudurler.get(index).toString());
			}
		});
		panel_4.add(buton_kisiselBilgileriGoster);

		JButton buton_cikisYap = new JButton();
		buton_cikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AnaEkran yeni = new AnaEkran();
				yeni.setVisible(true);
				return;
			}
		});
		panel_4.add(buton_cikisYap);
		buton_cikisYap.setFont(new Font("Arial", Font.BOLD, 26));
		buton_cikisYap.setBounds(551, 456, 220, 50);
		buton_cikisYap.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/hesapCikisYappp.png")));
		buton_cikisYap.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		for (int i=0;i<Main.gorevliler.size();i++) {
			KomboBox_gorevliler.addItem(Main.gorevliler.get(i).getTcNo());
		}

		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Görevli İşe Alım", null, panel_7, null);
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(126, 217, 87));

		input_ad = new JTextField();
		input_ad.setFont(new Font("Arial", Font.BOLD, 18));
		input_ad.setColumns(10);
		input_ad.setBackground(Color.ORANGE);
		input_ad.setBounds(98, 49, 130, 38);
		panel_7.add(input_ad);

		input_Soyad = new JTextField();
		input_Soyad.setFont(new Font("Arial", Font.BOLD, 18));
		input_Soyad.setColumns(10);
		input_Soyad.setBackground(Color.ORANGE);
		input_Soyad.setBounds(98, 110, 130, 38);
		panel_7.add(input_Soyad);

		input_TC = new JTextField();
		input_TC.setFont(new Font("Arial", Font.BOLD, 18));
		input_TC.setColumns(10);
		input_TC.setBackground(Color.ORANGE);
		input_TC.setBounds(98, 171, 130, 38);
		panel_7.add(input_TC);

		input_Maas = new JTextField();
		input_Maas.setFont(new Font("Arial", Font.BOLD, 18));
		input_Maas.setColumns(10);
		input_Maas.setBackground(Color.ORANGE);
		input_Maas.setBounds(101, 239, 130, 38);
		panel_7.add(input_Maas);

		input_tarih = new JTextField();
		input_tarih.setFont(new Font("Arial", Font.BOLD, 18));
		input_tarih.setColumns(10);
		input_tarih.setBackground(Color.ORANGE);
		input_tarih.setBounds(157, 286, 130, 38);
		panel_7.add(input_tarih);

		input_guvenlik = new JTextField();
		input_guvenlik.setFont(new Font("Arial", Font.BOLD, 18));
		input_guvenlik.setColumns(10);
		input_guvenlik.setBackground(Color.RED);
		input_guvenlik.setBounds(157, 337, 130, 38);
		panel_7.add(input_guvenlik);

		JLabel label_alim = new JLabel("Görevli Kayıt Ekranına Hoş Geldiniz.");
		label_alim.setOpaque(false);
		label_alim.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim.setBounds(224, 10, 369, 39);
		panel_7.add(label_alim);

		JLabel label_alim1 = new JLabel("Ad:");
		label_alim1.setOpaque(false);
		label_alim1.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim1.setBounds(10, 48, 70, 39);
		panel_7.add(label_alim1);

		JLabel label_alim2 = new JLabel("Soyad:");
		label_alim2.setOpaque(false);
		label_alim2.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim2.setBounds(10, 109, 70, 39);
		panel_7.add(label_alim2);

		JLabel label_alim3 = new JLabel("T.C. No:");
		label_alim3.setOpaque(false);
		label_alim3.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim3.setBounds(10, 170, 83, 39);
		panel_7.add(label_alim3);

		JLabel label_alim5 = new JLabel("Doğum Tarihi:");
		label_alim5.setOpaque(false);
		label_alim5.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim5.setBounds(10, 288, 148, 39);
		panel_7.add(label_alim5);

		JLabel label_alim6 = new JLabel("Güvenlik Kodu:");
		label_alim6.setOpaque(false);
		label_alim6.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim6.setBounds(10, 337, 148, 39);
		panel_7.add(label_alim6);

		JLabel output_guvenlikKod = new JLabel("");
		output_guvenlikKod.setOpaque(false);
		output_guvenlikKod.setHorizontalTextPosition(SwingConstants.CENTER);
		output_guvenlikKod.setHorizontalAlignment(SwingConstants.CENTER);
		output_guvenlikKod.setFont(new Font("Arial", Font.BOLD, 20));
		output_guvenlikKod.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		output_guvenlikKod.setBounds(294, 337, 108, 39);
		panel_7.add(output_guvenlikKod);

		JLabel label_alim4 = new JLabel("Maaş:");
		label_alim4.setOpaque(false);
		label_alim4.setFont(new Font("Arial", Font.BOLD, 20));
		label_alim4.setBounds(10, 237, 86, 39);
		panel_7.add(label_alim4);

		JCheckBox checkbox_kosullar = new JCheckBox("Çalışan İşe Alım Koşullarını Kabul Ediyor, Onaylıyorum.");
		checkbox_kosullar.setActionCommand("");
		checkbox_kosullar.setOpaque(false);
		checkbox_kosullar.setFont(new Font("Arial", Font.BOLD, 20));
		checkbox_kosullar.setBounds(11, 421, 568, 28);
		panel_7.add(checkbox_kosullar);

		JCheckBox checkbox_calismaDurum = new JCheckBox("Çalışma Durumu Aktif Olarak Ayarlansın.");
		checkbox_calismaDurum.setOpaque(false);
		checkbox_calismaDurum.setFont(new Font("Arial", Font.BOLD, 20));
		checkbox_calismaDurum.setActionCommand("");
		checkbox_calismaDurum.setBounds(10, 382, 568, 28);
		panel_7.add(checkbox_calismaDurum);

		JButton buton_iseAl = new JButton("");

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
		output_guvenlikKod.setText(Kodd);

		JTextArea label_yeniCalisan = new JTextArea("Görevli Bilgileri:");
		label_yeniCalisan.setBorder(null);
		label_yeniCalisan.setEditable(false);
		label_yeniCalisan.setWrapStyleWord(true);
		label_yeniCalisan.setOpaque(false);
		label_yeniCalisan.setFont(new Font("Arial", Font.BOLD, 20));
		label_yeniCalisan.setBounds(449, 66, 292, 338);
		panel_7.add(label_yeniCalisan);

		buton_iseAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long TCNo;
				try {
					String Ad = input_ad.getText();
					String Soyad = input_Soyad.getText();
					String Tc = input_TC.getText();
					String Tarih = input_tarih.getText();
					String Guvenlik = input_guvenlik.getText();
					if (input_Maas.getText().isBlank()) {
						JOptionPane.showMessageDialog(null,"Maaş Girmediniz !");
						return;
					}
					double Maas = Double.valueOf( input_Maas.getText());
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
					else if (Tc.length()>12||Tc.length()<9) {
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
					else if (Maas == 0) {
						JOptionPane.showMessageDialog(null,"Maaş Girmediniz !");
						return;
					}
					else if (String.valueOf(Maas).length()>10) {
						JOptionPane.showMessageDialog(null,"Maaş Uzunluğu Çok Fazla. Hatalı Giriş Yaptınız");
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
						JOptionPane.showMessageDialog(null,"Doğrulama Kodunu Yanlış Girdiniz !");
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
					}catch(Exception ee) {
						JOptionPane.showMessageDialog(null,"T.C Kimlik Numarasını Hatalı Girdiniz !");
						return;
					}
					String sifre = String.valueOf( rand.nextInt(900000)+100000);

					Main.gorevliler.add(new Gorevli(TCNo,Ad,Soyad,Tarih,Maas,sifre));
					SQLBaglantisi.gorevliKayit();
					JOptionPane.showMessageDialog(null,"İşe Alım Tamamlandı !");
					JOptionPane.showMessageDialog(null,"Varsayılan Şifre "+sifre+" Olarak Atanmıştır. Lütfen Not Alınız.");
					for (int i=0;i<Main.gorevliler.size();i++){
						if (Main.gorevliler.get(i).getTcNo()==TCNo) {
							if (!checkbox_calismaDurum.isSelected()) {
								Main.gorevliler.get(i).setCalismaDurumu(false);
								Main.gorevliler.get(i).setIsGirisTarihi("");
							}
							label_yeniCalisan.setText(Main.gorevliler.get(i).toString()+ "\nŞifre: "+sifre);
							KomboBox_gorevliler.removeAllItems();
							for (Gorevli Gorevli:Main.gorevliler){
								KomboBox_gorevliler.addItem(Gorevli.getTcNo());
							}
							return;
						}

					}

				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"Hatalı Giriş Yaptınız !");
					return;
				}
			}});
		buton_iseAl.setIcon(new ImageIcon(MudurArayuz.class.getResource("/resimler/iseAl.png")));
		buton_iseAl.setBorderPainted(false);
		buton_iseAl.setBounds(26, 469, 100, 50);
		panel_7.add(buton_iseAl);



		JLabel label_hosgeldiniz = new JLabel("Hoşgeldiniz "+Main.mudurler.get(index).getAd()+" "+Main.mudurler.get(index).getSoyAd() +" (Müdür)");
		label_hosgeldiniz.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_hosgeldiniz.setHorizontalTextPosition(SwingConstants.CENTER);
		label_hosgeldiniz.setHorizontalAlignment(SwingConstants.CENTER);
		label_hosgeldiniz.setOpaque(true);
		label_hosgeldiniz.setBackground(Color.ORANGE);
		label_hosgeldiniz.setFont(new Font("Arial", Font.BOLD, 20));
		label_hosgeldiniz.setBounds(0, 0, 786, 38);
		contentPane.add(label_hosgeldiniz);
	}
}
