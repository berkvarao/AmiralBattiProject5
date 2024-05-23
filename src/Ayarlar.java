import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Ayarlar extends JPanel {

    private static final long serialVersionUID = 1L;
    private static boolean yapayZekalar;
    private JToggleButton yapayZeka;
    private JLabel label2;
    private ImageIcon image_icon;
    private JButton menu;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image_icon.getImage(), 0, 0, this);
    }

    public Ayarlar() {

        // ARKAPLAN
        image_icon = new ImageIcon("images/ship_screen3.png");

        // BAŞLANGIÇTA YAPAYZEKA AÇIK.
        setYapayZekalar(true);


        this.setLayout(null);
        this.setSize(1366, 768);
        this.setOpaque(false);



        label2 = new JLabel("Yapay Zekalar");
        label2.setSize(200, 50);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 24));
        label2.setLocation(150, 400);

        yapayZeka = new JToggleButton();
        yapayZeka.setLocation(400, 400);
        yapayZeka.setSize(150, 50);
        yapayZeka.setIcon(new ImageIcon("images/acik.png"));
        yapayZeka.setToolTipText(
                "Kapalı olması durumunda, bilgisayar herhangi bir atışında geminin bir parçasını bulsa bile o geminin diğer parçalarını aramaz. Rastgele bir konuma atış yapar.");



        menu = new JButton();
        menu.setLocation(900, 400);
        menu.setSize(150, 50);
        menu.setIcon(new ImageIcon("images/ana_menu.png"));

        this.add(label2);
        this.add(yapayZeka);

        this.add(menu);

        //�� SINIF HANDLER
        Handler h = new Handler();
        yapayZeka.addItemListener(h);
        menu.addActionListener(h);
        menu.addMouseListener(h);
        menu.addMouseMotionListener(h);

    }



    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }


    public ImageIcon getImage_icon() {
        return image_icon;
    }

    public void setImage_icon(ImageIcon image_icon) {
        this.image_icon = image_icon;
    }

    public JButton getMenu() {
        return menu;
    }

    public void setMenu(JButton menu) {
        this.menu = menu;
    }

    private class Handler implements ItemListener, ActionListener, MouseListener, MouseMotionListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

           if (e.getItem() == yapayZeka) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    yapayZeka.setIcon(new ImageIcon("images/kapali.png"));
                    setYapayZekalar(false);
                } else {
                    yapayZeka.setIcon(new ImageIcon("images/acik.png"));
                    setYapayZekalar(true);
                }

            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menu) {
                CardLayout c1 = (CardLayout) (Cerceve.getPaneller().getLayout());
                c1.show(Cerceve.getPaneller(), "menü");
                Cerceve.getMenu().requestFocusInWindow();
            }

        }

        @Override
        public void mouseDragged(MouseEvent arg0) {
        }

        @Override
        public void mouseMoved(MouseEvent arg0) {
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == menu) {
                menu.setIcon(new ImageIcon("images/ana_menu2.png"));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() == menu) {
                menu.setIcon(new ImageIcon("images/ana_menu.png"));
            }

        }
    }

    public static boolean isYapayZekalar() {
        return yapayZekalar;
    }

    public static void setYapayZekalar(boolean yapayZekalar) {
        Ayarlar.yapayZekalar = yapayZekalar;
    }

    public JToggleButton getYapayZeka() {
        return yapayZeka;
    }

    public void setYapayZeka(JToggleButton yapayZeka) {
        this.yapayZeka = yapayZeka;
    }

}
