import javax.swing.*;
import java.awt.CardLayout;

public class Cerceve extends JFrame {
    private static final long serialVersionUID = 1L;
    // Bu, sınıf yapısında herhangi bir değişiklik olmadıkça, serileştirilmiş nesnelerin uyumlu olacağı anlamına gelir

    private static AnaPanel anaPanel;
    private static Menu menu;
    private static JPanel paneller;
    private static CardLayout c1;//Paneller arası geçişi sağlar.

    public Cerceve() {
        this.setLayout(null);//Konulan objelerin yerini kendimizin belireyebilmesini sağlar.
        menu = new Menu();
        paneller = new JPanel(new CardLayout());
        paneller.setSize(1366, 768);
        paneller.setLocation(0, 0);
        paneller.add(menu, "Menü");

        getContentPane().add(paneller);//İçerik bileşenlerini doğrudan kontrol etmeye yarar.
        c1 = (CardLayout) (paneller.getLayout());
        c1.show(paneller, "Menü");
        menu.requestFocusInWindow();//Paneller arasında hangisine odaklanacağımızı belirtir.

        //ÇERÇEVE ÖZELLİKLERİ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame kapatıldığında uygulamanın tamamen sonlandırılmasını sağlar.
        this.setSize(1366, 700);
        this.setVisible(true);//JFrame i görünür hale getirir.
    }

    public static AnaPanel getAnaPanel() {
        return anaPanel;
    }

    public static void setAnaPanel(AnaPanel a) {
        anaPanel = a;
        paneller.add(anaPanel, "Ana Panel");
        c1.show(paneller, "Ana Panel");
        getAnaPanel().setFocusable(true);
        getAnaPanel().requestFocusInWindow();
    }

    public static Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu m) {
        menu = m;
    }

    public static JPanel getPaneller() {
        return paneller;
    }

    public void setPaneller(JPanel p) {
        paneller = p;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
