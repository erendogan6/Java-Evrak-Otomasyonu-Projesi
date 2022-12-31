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
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class GorevlilerArayuz extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_imzalananEvraklar;
	private JTable table_imzaBekleyenler;
	public GorevlilerArayuz(int index) {
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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 18));
		tabbedPane.setBounds(0, 35, 800, 550);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("İmza Bekleyen Evrağı İmzala", null, panel, null);
		panel.setLayout(null);

		JComboBox<Integer> comboBox_evraklar = new JComboBox<Integer>();
		comboBox_evraklar.setBackground(Color.ORANGE);
		comboBox_evraklar.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_evraklar.setMaximumRowCount(1000);
		comboBox_evraklar.setBounds(305, 54, 112, 32);
		panel.add(comboBox_evraklar);
		for (int i=0;i<Main.evraklar.size();i++) {
			if (Main.evraklar.get(i).getImzalayan()==null)
				comboBox_evraklar.addItem(Main.evraklar.get(i).getDogrulamaKod());
		}



		JLabel label_imza2 = new JLabel("Doğrulama Numarasını Seçiniz");
		label_imza2.setFont(new Font("Arial", Font.BOLD, 20));
		label_imza2.setBounds(11, 50, 297, 38);
		panel.add(label_imza2);

		JButton buton_evrakImzala = new JButton("");
		buton_evrakImzala.setBounds(11, 125, 228, 50);
		buton_evrakImzala.setBorderPainted(false);
		buton_evrakImzala.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/evrakImzala.png")));
		buton_evrakImzala.setToolTipText("Evrak İmzala");
		panel.add(buton_evrakImzala);



		JLabel label_imza1 = new JLabel("İmzalayacağınız Evrağın");
		label_imza1.setFont(new Font("Arial", Font.BOLD, 20));
		label_imza1.setBounds(11, 23, 238, 32);
		panel.add(label_imza1);


		JLabel arkaplan = new JLabel("");
		arkaplan.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/ErenSağ.png")));
		arkaplan.setBounds(0, 0, 801, 500);
		panel.add(arkaplan);


		buton_evrakImzala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int secim = Integer.valueOf(comboBox_evraklar.getSelectedItem().toString());
					for (int i=0;i<Main.evraklar.size();i++) {
						if (secim==Main.evraklar.get(i).getDogrulamaKod()) {
							Main.evraklar.get(i).setImzalayan(Main.gorevliler.get(index));
							SQLBaglantisi.evrakKayit();
							JOptionPane.showMessageDialog(null, "Evrak İmzalandı");
							comboBox_evraklar.removeAllItems();
							for (int j=0;j<Main.evraklar.size();j++) {
								if (Main.evraklar.get(j).getImzalayan()==null) {
									comboBox_evraklar.addItem(Main.evraklar.get(j).getDogrulamaKod());
								}}
							return;
						}}
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null,"Hata Meydana Geldi !");
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(126, 217, 87));
		tabbedPane.addTab("İmza Bekleyen Evrakları Görüntüle", null, panel_2, null);
		panel_2.setLayout(null);

		JButton buton_imzaBekleyenEvraklariGoruntule = new JButton();
		buton_imzaBekleyenEvraklariGoruntule.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/imzaBekleyenEvraklariGoruntulee.png")));
		buton_imzaBekleyenEvraklariGoruntule.setBorderPainted(false);
		buton_imzaBekleyenEvraklariGoruntule.setBounds(93, 409, 650, 50);
		panel_2.add(buton_imzaBekleyenEvraklariGoruntule);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(0, 0, 800, 409);
		panel_2.add(scrollPane_1);

		table_imzaBekleyenler = new JTable();
		table_imzaBekleyenler.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_imzaBekleyenler.setFillsViewportHeight(true);
		table_imzaBekleyenler.setAutoCreateRowSorter(true);
		table_imzaBekleyenler.setIntercellSpacing(new Dimension(5, 5));
		table_imzaBekleyenler.setRowMargin(5);
		table_imzaBekleyenler.setFont(new Font("Arial", Font.PLAIN, 18));
		table_imzaBekleyenler.setBorder(null);
		table_imzaBekleyenler.setDefaultEditor(Object.class, null);
		table_imzaBekleyenler.setBackground(new Color(126, 217, 87));
		scrollPane_1.setViewportView(table_imzaBekleyenler);
		DefaultTableModel tblModell = (DefaultTableModel)table_imzaBekleyenler.getModel();
		String[] cols = {"Seri No", "Doğrulama Kod", "Tür", "Tarih", "İmzalayan", "Oluşturan","Geçerlilik"};
		tblModell.setColumnIdentifiers(cols);

		buton_imzaBekleyenEvraklariGoruntule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblModell.getDataVector().removeAllElements();
				String gecerli;
				try {
					for (Evrak Evrak : Main.evraklar) {
						if (Evrak.getImzalayan() == null) {
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
							tblModell.addRow(tmp);
						}
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "İmza Bekleyen Evrak Yoktur !");
				}
			}
		});
		table_imzaBekleyenler.setRowHeight(30);


		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Hesap Ayarları", null, panel_3, null);
		panel_3.setLayout(null);


		JTextPane output_kisiselBilgi = new JTextPane();
		output_kisiselBilgi.setOpaque(false);
		output_kisiselBilgi.setFont(new Font("Arial", Font.BOLD, 22));
		output_kisiselBilgi.setEditable(false);
		output_kisiselBilgi.setBounds(0, 85, 342, 379);
		panel_3.add(output_kisiselBilgi);

		JButton buton_kisiselBilgiGoster = new JButton("");
		buton_kisiselBilgiGoster.setBorderPainted(false);
		buton_kisiselBilgiGoster.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/kisiselBilgileriGoruntule.png")));
		buton_kisiselBilgiGoster.setBounds(0, 25, 360, 50);
		buton_kisiselBilgiGoster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output_kisiselBilgi.setText(Main.gorevliler.get(index).toString());
			}
		});
		panel_3.add(buton_kisiselBilgiGoster);



		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(126, 217, 87));
		panel_3.setBackground(new Color(126, 217, 87));
		tabbedPane.addTab("İmzalanan Evrakları Görüntüle", null, panel_1, null);
		panel_1.setLayout(null);

		JButton buton_imzalananEvraklariGoruntule = new JButton("");
		buton_imzalananEvraklariGoruntule.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/imzalananEvraklariGoruntulee.png")));
		buton_imzalananEvraklariGoruntule.setBorderPainted(false);
		buton_imzalananEvraklariGoruntule.setBounds(160, 410, 450, 50);
		panel_1.add(buton_imzalananEvraklariGoruntule);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 800, 409);
		panel_1.add(scrollPane);

		table_imzalananEvraklar = new JTable();
		table_imzalananEvraklar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_imzalananEvraklar.setFillsViewportHeight(true);
		table_imzalananEvraklar.setRowMargin(5);
		table_imzalananEvraklar.setRowHeight(30);
		table_imzalananEvraklar.setIntercellSpacing(new Dimension(5, 5));
		table_imzalananEvraklar.setDefaultEditor(Object.class, null);
		table_imzalananEvraklar.setBackground(new Color(126, 217, 87));
		table_imzalananEvraklar.setBorder(null);
		table_imzalananEvraklar.setFont(new Font("Arial", Font.PLAIN, 18));
		scrollPane.setViewportView(table_imzalananEvraklar);
		DefaultTableModel tblModel = (DefaultTableModel)table_imzalananEvraklar.getModel();
		tblModel.setColumnIdentifiers(cols);

		buton_imzalananEvraklariGoruntule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblModel.getDataVector().removeAllElements();
				String gecerli;
				try {
					for (Evrak Evrak : Main.evraklar) {
						if (Evrak.getImzalayan() == Main.gorevliler.get(index)) {
							if (Evrak.isGecerlilik()) {
								gecerli = "Geçerli";}
							else {
								gecerli = "Geçerli Değil";}
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
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "İmzalanan Evrak Yok !");
					return;
				}
				table_imzalananEvraklar.setAutoCreateRowSorter(true);
			}
		});


		JLabel label_eskiSifre1 = new JLabel("Eski Şifrenizi Giriniz: ");
		label_eskiSifre1.setFont(new Font("Arial", Font.BOLD, 20));
		label_eskiSifre1.setBounds(403, 25, 205, 52);
		panel_3.add(label_eskiSifre1);

		JLabel label_yeniSifre1 = new JLabel("Yeni Şifrenizi Giriniz: ");
		label_yeniSifre1.setFont(new Font("Arial", Font.BOLD, 20));
		label_yeniSifre1.setBounds(401, 85, 213, 52);
		panel_3.add(label_yeniSifre1);

		JLabel label_yeniSifre2 = new JLabel("Yeni Şifreyi Tekrar Giriniz: ");
		label_yeniSifre2.setFont(new Font("Arial", Font.BOLD, 20));
		label_yeniSifre2.setBounds(352, 145, 256, 52);
		panel_3.add(label_yeniSifre2);

		JPasswordField input_yeniSifre = new JPasswordField();
		input_yeniSifre.setFont(new Font("Arial", Font.PLAIN, 16));
		input_yeniSifre.setColumns(10);
		input_yeniSifre.setBackground(Color.ORANGE);
		input_yeniSifre.setBounds(609, 90, 162, 38);
		panel_3.add(input_yeniSifre);

		JPasswordField input_eskiSifre = new JPasswordField();
		input_eskiSifre.setFont(new Font("Arial", Font.PLAIN, 16));
		input_eskiSifre.setColumns(10);
		input_eskiSifre.setBackground(Color.ORANGE);
		input_eskiSifre.setBounds(609, 32, 162, 38);
		panel_3.add(input_eskiSifre);

		JPasswordField input_yeniSifre2 = new JPasswordField();
		input_yeniSifre2.setFont(new Font("Arial", Font.PLAIN, 16));
		input_yeniSifre2.setColumns(10);
		input_yeniSifre2.setBackground(Color.ORANGE);
		input_yeniSifre2.setBounds(609, 154, 162, 38);
		panel_3.add(input_yeniSifre2);

		JButton buton_sifreDegis = new JButton("");
		buton_sifreDegis.setBorderPainted(false);
		buton_sifreDegis.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/sifreDegistir.png")));
		buton_sifreDegis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String eskisifre =String.valueOf(input_eskiSifre.getPassword());
				String yenisifre1 =String.valueOf(input_yeniSifre.getPassword());
				String yenisifre2 =String.valueOf(input_yeniSifre2.getPassword());
				if (eskisifre.isBlank()) {
					JOptionPane.showMessageDialog(null,"Eski Şifre Girişi Yapılmamıştır!");
					return;}
				else if (yenisifre1.length()>253) {
					JOptionPane.showMessageDialog(null,"Yeni Şifre Maksimum Uzunluğu Aşmaktadır !");
					return;}
				else if (yenisifre1.length()<6) {
					JOptionPane.showMessageDialog(null,"Yeni Şifre Minimum 6 Karakter olmalıdır !");
					return;}
				else if(Objects.equals(eskisifre,Main.gorevliler.get(index).getSifre())){
					if (yenisifre1.isBlank() || yenisifre2.isBlank() ) {
						JOptionPane.showMessageDialog(null,"Yeni Şifre İçin Giriş Yapmadınız !");
						return;}
					else if (yenisifre1.equals(yenisifre2)){
						Main.gorevliler.get(index).setSifre(yenisifre2);
						SQLBaglantisi.gorevliKayit();
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
		buton_sifreDegis.setBounds(529, 210, 280, 50);
		panel_3.add(buton_sifreDegis);

		JButton buton_cikisYap = new JButton();
		buton_cikisYap.setIcon(new ImageIcon(GorevlilerArayuz.class.getResource("/resimler/hesapCikisYappp.png")));
		buton_cikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AnaEkran yeni = new AnaEkran();
				yeni.setVisible(true);
				return;
			}
		});
		buton_cikisYap.setBounds(529, 391, 220, 50);
		panel_3.add(buton_cikisYap);
		buton_cikisYap.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		JLabel lblNewLabel = new JLabel("Hoşgeldiniz "+Main.gorevliler.get(index).getAd()+" "+Main.gorevliler.get(index).getSoyAd() +" (Görevli)");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 786, 38);
		contentPane.add(lblNewLabel);
	}
}
