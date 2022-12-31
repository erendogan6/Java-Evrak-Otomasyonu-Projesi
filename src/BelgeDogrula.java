import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class BelgeDogrula extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton button_belgeDogrula = new JButton();
	private final JButton button_cikisYap = new JButton();
	private JTextField input_dogrulamaKod;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Çarpı tuşuna basıldığında kapanması için
					URL resim = BelgeDogrula.class.getResource("/resimler/ikon.png");
					Image icon = Toolkit.getDefaultToolkit().getImage(resim);
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BelgeDogrula() {
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

		button_belgeDogrula.setBorderPainted(false);
		button_belgeDogrula.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/belgeDogrula.png")));
		button_belgeDogrula.setBounds(6, 128, 250, 50);
		button_belgeDogrula.setToolTipText("Belge Doğrula");
		button_cikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AnaEkran frm = new AnaEkran();
				frm.setVisible(true);
			}
		});
		button_cikisYap.setBorderPainted(false);
		button_cikisYap.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/cikisYap.png")));
		button_cikisYap.setBounds(553, 503, 200, 50);
		button_cikisYap.setToolTipText("Çıkış Yap");
		contentPane.setLayout(null);

		JTextPane label_evrakBilgiler = new JTextPane();
		label_evrakBilgiler.setOpaque(false);
		label_evrakBilgiler.setFont(new Font("Arial", Font.BOLD, 18));
		label_evrakBilgiler.setEditable(false);
		label_evrakBilgiler.setBounds(10, 196, 400, 326);
		contentPane.add(label_evrakBilgiler);

		input_dogrulamaKod = new JTextField();
		input_dogrulamaKod.setFont(new Font("Arial", Font.BOLD, 18));
		input_dogrulamaKod.setColumns(10);
		input_dogrulamaKod.setBackground(Color.ORANGE);
		input_dogrulamaKod.setBounds(282, 65, 130, 38);
		contentPane.add(input_dogrulamaKod);

		button_belgeDogrula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (input_dogrulamaKod.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"Doğrulama Kodu Girmediniz !");
					return;
				}
				try {
					int tmp = Integer.valueOf(input_dogrulamaKod.getText());
					for (int i =0;i<Main.evraklar.size();i++) {
						if (tmp==Main.evraklar.get(i).getDogrulamaKod()) {
							label_evrakBilgiler.setText(Main.evraklar.get(i).toString());
							return;
						}
						if (i==Main.evraklar.size()-1) {
							JOptionPane.showMessageDialog(null,"Doğrulama Kodu İle Uyuşan Evrak Bulunamamıştır !");
							return;
						}
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"Doğrulama Kodunu Hatalı Girdiniz !");
					return;
				}

			}
		});

		JLabel label_dogrula2 = new JLabel("Doğrulama Kodunu Giriniz: ");
		label_dogrula2.setOpaque(false);
		label_dogrula2.setFont(new Font("Arial", Font.BOLD, 20));
		label_dogrula2.setBounds(10, 64, 262, 39);
		contentPane.add(label_dogrula2);

		JLabel label_dogrula1 = new JLabel("Görüntülemek İstediğiniz Evrakın ");
		label_dogrula1.setOpaque(false);
		label_dogrula1.setFont(new Font("Arial", Font.BOLD, 20));
		label_dogrula1.setBounds(10, 32, 322, 39);
		contentPane.add(label_dogrula1);
		contentPane.add(button_belgeDogrula);
		contentPane.add(button_cikisYap);

		JLabel arkaplan = new JLabel("");
		arkaplan.setIcon(new ImageIcon(BelgeDogrula.class.getResource("/resimler/ErenSağ.png")));
		arkaplan.setBounds(0, -21, 800, 600);
		contentPane.add(arkaplan);
	}
}
