import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AnaEkran extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton uyeOl = new JButton();
	private final JButton belgeDogrula = new JButton();
	private final JButton cikisYap = new JButton();
	static URL resim = AnaEkran.class.getResource("/resimler/ikon.png");
	static Image icon = Toolkit.getDefaultToolkit().getImage(resim);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Çarpı tuşuna basıldığında kapanması için
					frame.setIconImage(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AnaEkran() {
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

		JButton girisYap = new JButton("");
		girisYap.setBorderPainted(false);
		girisYap.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/girisYap.png")));
		girisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				GirisEkrani frm2 = new GirisEkrani();
				frm2.setVisible(true);
				frm2.setIconImage(icon);
			}
		});
		girisYap.setBounds(509, 114, 200, 50);
		girisYap.setToolTipText("Giriş Yap");
		uyeOl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UyeOl uyelik = new UyeOl();
				dispose();
				uyelik.setVisible(true);
				uyelik.setIconImage(icon);
			}
		});
		uyeOl.setBorderPainted(false);
		uyeOl.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/UyeOl.png")));
		uyeOl.setBounds(509, 209, 200, 50);
		uyeOl.setToolTipText("Üye Ol");
		belgeDogrula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BelgeDogrula frm = new BelgeDogrula();
				dispose();
				frm.setVisible(true);
				frm.setIconImage(icon);
			}
		});
		belgeDogrula.setBorderPainted(false);
		belgeDogrula.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/belgeDogrula.png")));
		belgeDogrula.setBounds(486, 297, 250, 50);
		belgeDogrula.setToolTipText("Belge Doğrula");
		cikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				return;
			}
		});
		cikisYap.setBorderPainted(false);
		cikisYap.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/cikisYap.png")));
		cikisYap.setBounds(509, 474, 200, 50);
		cikisYap.setToolTipText("Çıkış Yap");
		contentPane.setLayout(null);
		contentPane.add(uyeOl);
		contentPane.add(belgeDogrula);
		contentPane.add(cikisYap);
		contentPane.add(girisYap);

		JLabel arkaPlan = new JLabel("");
		arkaPlan.setIcon(new ImageIcon(AnaEkran.class.getResource("/resimler/Eren Please.png")));
		arkaPlan.setBounds(0, 0, 800, 600);
		contentPane.add(arkaPlan);
	}
}
