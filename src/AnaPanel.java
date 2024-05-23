
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class AnaPanel extends JPanel {

    private static final long serialVersionUID = 1L;


    //12345678910-ABCDEFGHIJ
    private JLabel[] sutun;
    private JLabel[] satir;
    private JLabel[] sutun2;
    private JLabel[] satir2;

    //BUTONLAR
    private JButton hazirim;
    private JButton menu;
    private JButton yeniOyun;

    //ANAPANELDEKİ 2 TABLO
    private JLabel[][] bilgisayar_label;
    private JLabel[][] oyuncu_label;

    //GEM�LER�N D�Z�LERE �Z D���M�
    private int[][] oyuncu_yerlestirilen;

    private Icon icon;
    private Listener m;

    private Image arkaplan;
    private ImageIcon image_icon;

    private JTextArea durumAlani;
    private JScrollPane kaydirac;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image_icon.getImage(), 0, 0, this);
    }

    public AnaPanel() {

        this.setLayout(null);
        this.setSize(1366, 768);
        this.setOpaque(false);

        //ANAPANEL ARKAPLAN
        image_icon = new ImageIcon("images/ship_screen.png");

        oyuncu_yerlestirilen = new int[10][10];
        bilgisayar_label = new JLabel[10][10];
        oyuncu_label = new JLabel[10][10];

        //ANAPANELDEKİ BİLGİ EKRANI
        durumAlani = new JTextArea(50, 50);
        durumAlani.setEditable(false);
        durumAlani.setLocation(950, 200);
        durumAlani.setSize(200, 100);

        //SATIR VE SÜTUNLARIN OLUŞTURULMASI VE YERLEŞTİRİLMESİ
        sutun = new JLabel[10];
        satir = new JLabel[10];
        sutun2 = new JLabel[10];
        satir2 = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            sutun[i] = new JLabel(String.valueOf(i + 1));
            satir[i] = new JLabel(String.valueOf((char) (i + 65)));
            sutun2[i] = new JLabel(String.valueOf(i + 1));
            satir2[i] = new JLabel(String.valueOf((char) (i + 65)));

            sutun[i].setLocation(200 + i * 30, 90);
            sutun[i].setSize(30, 30);
            sutun2[i].setLocation(600 + i * 30, 90);
            sutun2[i].setSize(30, 30);


            satir[i].setLocation(170, 120 + i * 30);
            satir[i].setSize(30, 30);
            satir2[i].setLocation(570, 120 + i * 30);
            satir2[i].setSize(30, 30);

            sutun[i].setOpaque(true);
            satir[i].setOpaque(true);
            sutun2[i].setOpaque(true);
            satir2[i].setOpaque(true);

            sutun[i].setHorizontalAlignment(SwingConstants.CENTER);
            sutun[i].setHorizontalTextPosition(SwingConstants.CENTER);
            sutun2[i].setHorizontalAlignment(SwingConstants.CENTER);
            sutun2[i].setHorizontalTextPosition(SwingConstants.CENTER);

            satir[i].setHorizontalAlignment(SwingConstants.CENTER);
            satir[i].setHorizontalTextPosition(SwingConstants.CENTER);
            satir2[i].setHorizontalAlignment(SwingConstants.CENTER);
            satir2[i].setHorizontalTextPosition(SwingConstants.CENTER);

            sutun[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            satir[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            sutun2[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            satir2[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            sutun[i].setBackground(Color.YELLOW);
            satir[i].setBackground(Color.YELLOW);
            sutun2[i].setBackground(Color.YELLOW);
            satir2[i].setBackground(Color.YELLOW);

            Font f = new Font("Times New Roman", Font.BOLD, 24);

            sutun[i].setFont(f);
            satir[i].setFont(f);
            sutun2[i].setFont(f);
            satir2[i].setFont(f);

            this.add(sutun[i]);
            this.add(satir[i]);
            this.add(sutun2[i]);
            this.add(satir2[i]);

        }


        durumAlani.setFont(new Font("Times New Roman", Font.BOLD, 18));
        kaydirac = new JScrollPane(durumAlani);
        kaydirac.setSize(300, 300);
        kaydirac.setLocation(950, 120);


        this.add(kaydirac);


        //HAZIRIM BUTONU
        hazirim = new JButton();
        hazirim.setLocation(950, 450);
        hazirim.setSize(150, 50);
        hazirim.setIcon(new ImageIcon("images/hazirim.png"));

        //YEN�OYUN BUTONU
        yeniOyun = new JButton();
        yeniOyun.setLocation(1100, 450);
        yeniOyun.setSize(150, 50);
        yeniOyun.setIcon(new ImageIcon("images/yeni_oyun3.png"));

        //ANAMENU BUTONU
        menu = new JButton();
        menu.setLocation(950, 500);
        menu.setSize(300, 50);
        menu.setIcon(new ImageIcon("images/ana_menu.png"));


        //LISTENER INITIALIZE
        m = new Listener();
       m.setOyuncu_yerlestirilen(oyuncu_yerlestirilen);

        this.addKeyListener(m);
        this.setFocusable(true);
        this.requestFocusInWindow();

        hazirim.addActionListener(m);
        hazirim.addMouseListener(m);
        hazirim.addMouseMotionListener(m);

        yeniOyun.addActionListener(m);
        yeniOyun.addMouseListener(m);
        yeniOyun.addMouseMotionListener(m);

        menu.addActionListener(m);
        menu.addMouseListener(m);
        menu.addMouseMotionListener(m);


        //ÇERÇEVEYE ÖGELERİ EKLEME

        this.add(hazirim);
        this.add(yeniOyun);
        this.add(menu);

        //OYUN TAHTASININ OLUŞTURULMASI

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                bilgisayar_label[i][j] = new JLabel();
                bilgisayar_label[i][j].setSize(30, 30);
                bilgisayar_label[i][j].setLocation(200 + i * 30, 120 + j * 30);
                bilgisayar_label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                this.add(bilgisayar_label[i][j]);
                bilgisayar_label[i][j].setOpaque(true);
                bilgisayar_label[i][j].addMouseListener(m);
                bilgisayar_label[i][j].addMouseMotionListener(m);
                if ((i + j) % 2 == 0) {
                    bilgisayar_label[i][j].setBackground(Color.BLUE);
                } else {
                    bilgisayar_label[i][j].setBackground(Color.WHITE);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                oyuncu_label[i][j] = new JLabel();
                oyuncu_label[i][j].setSize(30, 30);
                oyuncu_label[i][j].setLocation(600 + i * 30, 120 + j * 30);
                oyuncu_label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                this.add(oyuncu_label[i][j]);
                oyuncu_label[i][j].setOpaque(true);

                if ((i + j) % 2 == 0) {
                    oyuncu_label[i][j].setBackground(Color.BLUE);
                } else {
                    oyuncu_label[i][j].setBackground(Color.WHITE);
                }
            }
        }


        m.setOyuncu_label(oyuncu_label);
        m.setAnaPanel(this);

    }

    public JLabel[] getSutun() {
        return sutun;
    }

    public void setSutun(JLabel[] sutun) {
        this.sutun = sutun;
    }

    public JLabel[] getSatir() {
        return satir;
    }

    public void setSatir(JLabel[] satir) {
        this.satir = satir;
    }

    public JLabel[] getSutun2() {
        return sutun2;
    }

    public void setSutun2(JLabel[] sutun2) {
        this.sutun2 = sutun2;
    }

    public JLabel[] getSatir2() {
        return satir2;
    }

    public void setSatir2(JLabel[] satir2) {
        this.satir2 = satir2;
    }

    public JButton getHazirim() {
        return hazirim;
    }

    public void setHazirim(JButton hazirim) {
        this.hazirim = hazirim;
    }

    public JButton getMenu() {
        return menu;
    }

    public void setMenu(JButton menu) {
        this.menu = menu;
    }

    public JButton getYeniOyun() {
        return yeniOyun;
    }

    public void setYeniOyun(JButton yeniOyun) {
        this.yeniOyun = yeniOyun;
    }

    public JLabel[][] getBilgisayar_label() {
        return bilgisayar_label;
    }

    public void setBilgisayar_label(JLabel[][] bilgisayar_label) {
        this.bilgisayar_label = bilgisayar_label;
    }

    public JLabel[][] getOyuncu_label() {
        return oyuncu_label;
    }

    public void setOyuncu_label(JLabel[][] oyuncu_label) {
        this.oyuncu_label = oyuncu_label;
    }

    public int[][] getOyuncu_yerlestirilen() {
        return oyuncu_yerlestirilen;
    }

    public void setOyuncu_yerlestirilen(int[][] oyuncu_yerlestirilen) {
        this.oyuncu_yerlestirilen = oyuncu_yerlestirilen;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Listener getM() {
        return m;
    }

    public void setM(Listener m) {
        this.m = m;
    }

    public Image getArkaplan() {
        return arkaplan;
    }

    public void setArkaplan(Image arkaplan) {
        this.arkaplan = arkaplan;
    }

    public ImageIcon getImage_icon() {
        return image_icon;
    }

    public void setImage_icon(ImageIcon image_icon) {
        this.image_icon = image_icon;
    }

    public JTextArea getDurumAlani() {
        return durumAlani;
    }

    public void setDurumAlani(JTextArea durumAlani) {
        this.durumAlani = durumAlani;
    }

    public JScrollPane getKaydirac() {
        return kaydirac;
    }

    public void setKaydirac(JScrollPane kaydirac) {
        this.kaydirac = kaydirac;
    }


}

