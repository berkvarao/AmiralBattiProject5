import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JPanel {
    private static final long serialVersionUID = 1L;

    // ANA MENÜDE YER ALAN BUTONLAR
    private JButton yeniOyun;
    private JButton ayarlar;
    private JButton oynanis;
    private JButton hakkimda;
    private JButton devamEt;
    private ImageIcon image_icon;


    // PANEL BOYUTUNA GÖRE RESMİN BOYUTUNU AYARLAR
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image_icon.getImage(), 0, 0, this);
    }
    public Menu(){

        this.setLayout(null);
        this.setSize(1366,768);
        this.setOpaque(false);//Öge opaklığını belirlemek için kullanılır.
        image_icon = new ImageIcon(".idea/images/ship_screen2.png");



        //Butonların oluşturulması
        yeniOyun=new JButton();
        oynanis = new JButton();
        ayarlar =new JButton();
        hakkimda = new JButton();
        devamEt = new JButton();

        yeniOyun.setSize(150, 50);
        oynanis.setSize(150, 50);
        ayarlar.setSize(150,50);
        hakkimda.setSize(150, 50);
        devamEt.setSize(150, 50);

        yeniOyun.setIcon(new ImageIcon(".idea/images/yeni_oyun.png"));
        oynanis.setIcon(new ImageIcon(".idea/images/oynanis.png"));
        ayarlar.setIcon(new ImageIcon(".idea/images/ayarlar.png"));
        hakkimda.setIcon(new ImageIcon(".idea/images/hakkimda.png"));
        devamEt.setIcon(new ImageIcon(".idea/images/devam_et.png"));

        yeniOyun.setLocation(200, 500);
        devamEt.setLocation(400, 500);
        ayarlar.setLocation(600, 500);
        oynanis.setLocation(800, 500);
        hakkimda.setLocation(1000, 500);

        //Handler sınıfı
        Handler h = new Handler();//Hangi olayın gerçekleştiğini belirleyen kod parçası(actionperformed)
        yeniOyun.addActionListener(h);
        yeniOyun.addMouseListener(h);
        yeniOyun.addMouseMotionListener(h);

        ayarlar.addActionListener(h);
        ayarlar.addMouseListener(h);
        ayarlar.addMouseMotionListener(h);

        oynanis.addActionListener(h);
        oynanis.addMouseListener(h);
        oynanis.addMouseMotionListener(h);

        hakkimda.addActionListener(h);
        hakkimda.addMouseListener(h);
        hakkimda.addMouseMotionListener(h);

        devamEt.addActionListener(h);
        devamEt.addMouseListener(h);
        devamEt.addMouseMotionListener(h);

        //ÖGELERİN PANELE YERLEŞTİRİLMESİ
        this.add(yeniOyun);
        this.add(oynanis);
        this.add(hakkimda);
        this.add(devamEt);
        this.add(ayarlar);
    }

    public JButton getAyarlar() {
        return ayarlar;
    }

    public void setAyarlar(JButton ayarlar) {
        this.ayarlar = ayarlar;
    }

    public JButton getYeniOyun() {
        return yeniOyun;
    }

    public void setYeniOyun(JButton yeniOyun) {
        this.yeniOyun = yeniOyun;
    }

    public JButton getOynanis() {
        return oynanis;
    }

    public void setOynanis(JButton oynanis) {
        this.oynanis = oynanis;
    }

    public JButton getHakkimda() {
        return hakkimda;
    }

    public void setHakkimda(JButton hakkimda) {
        this.hakkimda = hakkimda;
    }

    public JButton getDevamEt() {
        return devamEt;
    }

    public void setDevamEt(JButton devamEt) {
        this.devamEt = devamEt;
    }
    private class Handler implements ActionListener,MouseListener,MouseMotionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object pressed = e.getSource();//Tıklamanın hangi nesne üstünde gerçekleştiğini gösterir.

            if (pressed == yeniOyun) {
                AnaPanel anaPanel = new AnaPanel();
                Cerceve.setAnaPanel(anaPanel);

            }
            else if (pressed == devamEt) {

                // PANELLER ARASI GEÇİŞ İÇİN CARDLAYOUT TANIMLAMASI
                CardLayout c1 = (CardLayout) (Cerceve.getPaneller().getLayout());

                if (Cerceve.getAnaPanel() != null) {
                    c1.show(Cerceve.getPaneller(), "ana panel");

                    Cerceve.getAnaPanel().setFocusable(true);
                    Cerceve.getAnaPanel().requestFocusInWindow();
                } else {
                    String mesaj = "Devam eden oyun yok.";
                    JOptionPane.showMessageDialog(null, mesaj);
                }

            }
            else if (pressed==ayarlar) {
                CardLayout c1=(CardLayout) (Cerceve.getPaneller().getLayout());
                c1.show(Cerceve.getPaneller(),"ayarlar");
                Cerceve.getAnaPanel().setFocusable(true);
                Cerceve.getAnaPanel().requestFocusInWindow();

            }
            else if (pressed == oynanis) {
                String mesaj = "Amiral battı oyunu bilgisayara karşı oynanmaktadır.\n"
                        + "Sağdaki tahtada oyuncunun gemileri soldaki tahta içerisinde ise bilgisayarın gemileri mevcuttur.\n"
                        + "Gemileri fare ile sürekleyebilir, R tuşu ile gemilerin yönünü değiştirebilirsiniz.\n"
                        + "Gemileri yerleştirdikten sonra 'HAZIRIM' tuşuna basttığınızda kural dışı bir gemi yerleştirmesi yapmadıysanız oyun başlayacaktır.\n"
                        + "Bundan sonra rakibinizin gemilerini fare ile tıklayarak soldaki tahtada  aramaya başlayabilirsiniz.\n"
                        + "Rakibinizin gemilerinden bir parçasını bulduğunuzda ilgili kutunun arkaplanı yeşil, bulamadığınızda ise kırmızı olacaktır.\n"
                        + "Siz hamlenizi yaptıktan sonra sıra bilgisayara geçecek, bilgisayar sizin geminizin bir parçasını bulduğunda ilgili kutunun arkaplanı kırmızı, bulamadığında yeşil olacaktır.\n"
                        + "Oyun herhangi bir tarafın gemilerinin tamamı bulununcaya kadar devam edecektir.\n";

                JOptionPane.showMessageDialog(null, mesaj,"Oynanış",JOptionPane.INFORMATION_MESSAGE);
            } else if (pressed == hakkimda) {
                String mesaj = "Berk VARA O. 12211602054\n" + "Bilal ÇETİN 1221602061\n"
                        + "Zülfikar Can USTA 1221602095\n"+"Bayram Çağlar KAPTAN 1221602052\n"+"Çağatay ÖZEL 1221602636\n"+"Tarık GÜNGÖR 1221602080";

                JOptionPane.showMessageDialog(null, mesaj,"Hakkımızda",JOptionPane.INFORMATION_MESSAGE);
            }







        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            if (e.getSource() == yeniOyun) {
                yeniOyun.setIcon(new ImageIcon(".idea/images/yeni_oyun.png"));
            } else if (e.getSource() == devamEt) {
                devamEt.setIcon(new ImageIcon(".idea/images/devam_et.png"));
            } else if (e.getSource()==ayarlar) {
                ayarlar.setIcon(new ImageIcon(".idea/images/ayarlar.png"));
            } else if (e.getSource() == oynanis) {
                oynanis.setIcon(new ImageIcon(".idea/images/oynanis.png"));
            } else if (e.getSource() == hakkimda) {
                hakkimda.setIcon(new ImageIcon(".idea/images/hakkimda.png"));
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
          /* Mouse la basıldıktan sonra tıklama efekti verebilmek için kullanılır*/
            if (e.getSource() == yeniOyun) {
                yeniOyun.setIcon(new ImageIcon(".idea/images/yeni_oyun2.png"));
            } else if (e.getSource() == devamEt) {
                devamEt.setIcon(new ImageIcon(".idea/images/devam_et2.png"));
            } else if (e.getSource()==ayarlar) {
                ayarlar.setIcon(new ImageIcon(".idea/images/ayarlar2.png"));
            } else if (e.getSource() == oynanis) {
                oynanis.setIcon(new ImageIcon(".idea/images/oynanis2.png"));
            } else if (e.getSource() == hakkimda) {
                hakkimda.setIcon(new ImageIcon(".idea/images/hakkimda2.png"));
            }
        }
    }
}
