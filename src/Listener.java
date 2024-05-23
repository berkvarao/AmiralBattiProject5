
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Listener implements MouseListener, MouseMotionListener, KeyListener, ActionListener {

    // OYUNCUNUN TABLOSUNDAKİ GEMİLERİN DİZİYE İZDÜŞÜMÜ
    private int[][] oyuncu;
    // OYUNCUNUN TABLOSUNDAKi HüCRELER
    private JLabel[][] oyuncu_label;
    // BİLGİSAYARIN HAMLESİ İÇİN ÜRETİLEN RASTGELE SAYILAR
    private Random random;
    private int random_x;
    private int random_y;

    // DAHA ÖNCE TIKLANAN HÜCRELERİN BİR DAHA TIKLANMAMASI İÇİN GEREKEN DEĞİŞKEN
    private boolean basilmis = false;
    // SONRAKİ HAMLENİN HANGİ YÖNE OLACAĞINI KAYDEDEN DEĞİŞKEN
    private String sonraki_hamle = "";
    // GEMİNİN BULUNAN İLK PARÇASINI HAFIZAYA ALAN DEĞİŞKEN
    private int zeka_x, zeka_y;
    // GEMİNİN BULUNAN İLK PARÇASINDAN SONRAKİ HAMLELERDE GEMİNİN DİĞER PARÇALARI BULUNURSA İLGİLİ YÖN TRUE YAPILIR.
    private boolean sagdaVar, soldaVar, yukardaVar, asagidaVar;
    // EĞER İKİ TARAFTAN BİRİNİN TOPLAM BULUNAN PARÇA SAYISI 10 OLURSA OYUN BİTER.
    // ÇÜNKÜ GEMİ UZUNLUKLARI 1+2+3+4 = 10 PARÇADIR.
    private int oyuncu_parca;
    private int computer_parca;
    private int x, y;

    private boolean hazir = false;
    // OYUN BAŞLADIĞINDA VE BİTTİĞİNDE SETLENEN DEĞİŞKENLER
    private boolean oyunBasladi = false;
    private boolean oyunBitti = false;
    // oyuncu_yerlestirilen -> OYUNCU TABLOSUNDAKi GEMi OLAN VE OLMAYAN HÜCRELERİ DİZİYE İZ DÜŞÜRÜLME HALİ
    //
    // bilgisayar_yerlestilen-> OYUNCU_YERLESTİRİLEN İN BİLGİSAYAR VERSİYONU
    private int[][] oyuncu_yerlestirilen;
    private int[][] bilgisayar_yerlestilen;
    private JComponent component;
    private AnaPanel anaPanel;

    private int satir, sutun;
    // GEM�LER �ST �STE D�Z�L�P D�Z�LMEME DURUMUNU BEL�RT�R.
    private boolean yanlis_dizilim = false;
    // GEMİLERİN HEPSİNİN TABLOYA YERLEŞTİRİLİP YERLEŞTİRİLMEDİĞİNİ BELİRTİR.
    private boolean eksik_dizilim = false;

    public static int[][] transposeMatrix(int[][] m) {
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    public int[][] getOyuncu() {
        return oyuncu;
    }

    public void setOyuncu(int[][] oyuncu) {
        this.oyuncu = oyuncu;
    }

    public JLabel[][] getOyuncu_label() {
        return oyuncu_label;
    }

    public void setOyuncu_label(JLabel[][] oyuncu_label) {
        this.oyuncu_label = oyuncu_label;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRandom_x() {
        return random_x;
    }

    public void setRandom_x(int random_x) {
        this.random_x = random_x;
    }

    public int getRandom_y() {
        return random_y;
    }

    public void setRandom_y(int random_y) {
        this.random_y = random_y;
    }

    public boolean isBasilmis() {
        return basilmis;
    }

    public void setBasilmis(boolean basilmis) {
        this.basilmis = basilmis;
    }

    public String getSonraki_hamle() {
        return sonraki_hamle;
    }

    public void setSonraki_hamle(String sonraki_hamle) {
        this.sonraki_hamle = sonraki_hamle;
    }

    public int getZeka_x() {
        return zeka_x;
    }

    public void setZeka_x(int zeka_x) {
        this.zeka_x = zeka_x;
    }

    public int getZeka_y() {
        return zeka_y;
    }

    public void setZeka_y(int zeka_y) {
        this.zeka_y = zeka_y;
    }

    public boolean isSagdaVar() {
        return sagdaVar;
    }

    public void setSagdaVar(boolean sagdaVar) {
        this.sagdaVar = sagdaVar;
    }

    public boolean isSoldaVar() {
        return soldaVar;
    }

    public void setSoldaVar(boolean soldaVar) {
        this.soldaVar = soldaVar;
    }

    public boolean isYukardaVar() {
        return yukardaVar;
    }

    public void setYukardaVar(boolean yukardaVar) {
        this.yukardaVar = yukardaVar;
    }

    public boolean isAsagidaVar() {
        return asagidaVar;
    }

    public void setAsagidaVar(boolean asagidaVar) {
        this.asagidaVar = asagidaVar;
    }

    public int getOyuncu_parca() {
        return oyuncu_parca;
    }

    public void setOyuncu_parca(int oyuncu_parca) {
        this.oyuncu_parca = oyuncu_parca;
    }

    public int getComputer_parca() {
        return computer_parca;
    }

    public void setComputer_parca(int computer_parca) {
        this.computer_parca = computer_parca;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getOyuncu_yerlestirilen() {
        return oyuncu_yerlestirilen;
    }

    public void setOyuncu_yerlestirilen(int[][] oyuncu_yerlestirilen) {
        this.oyuncu_yerlestirilen = oyuncu_yerlestirilen;
    }

    public int[][] getBilgisayar_yerlestilen() {
        return bilgisayar_yerlestilen;
    }

    public void setBilgisayar_yerlestilen(int[][] bilgisayar_yerlestilen) {
        this.bilgisayar_yerlestilen = bilgisayar_yerlestilen;
    }

    public JComponent getComponent() {
        return component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }

    public AnaPanel getAnaPanel() {
        return anaPanel;
    }

    public void setAnaPanel(AnaPanel anaPanel) {
        this.anaPanel = anaPanel;
    }

    public int getSatir() {
        return satir;
    }

    public void setSatir(int satir) {
        this.satir = satir;
    }

    public int getSutun() {
        return sutun;
    }

    public void setSutun(int sutun) {
        this.sutun = sutun;
    }

    public boolean isYanlis_dizilim() {
        return yanlis_dizilim;
    }

    public void setYanlis_dizilim(boolean yanlis_dizilim) {
        this.yanlis_dizilim = yanlis_dizilim;
        if (yanlis_dizilim) {
            String mesaj = "\n    ----------\n    Gemiler üst üste dizilemez.";
            setHazir(false);
            anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
        }
    }

    public Listener() {
        random = new Random();
        sagdaVar = soldaVar = yukardaVar = asagidaVar = false;
        bilgisayar_yerlestilen = new int[10][10];
        oyuncu_parca = 0;
        computer_parca = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // OYUN BİTTİĞİNDE OYUNU SONLANDIRMAYA YARAR.
        if (!oyunBitti) {
            component = (JComponent) e.getComponent();
            basilmis = false;

            // HAZIRIMA BASILDIYSA BASILAN YERLERİN KOORDİNATLARINI ALMAYA GEREK YOK.
            if (!hazir && e.getX() <= 400 && e.getY() <= 420) {
                x = e.getX();
                y = e.getY();
            } else {

                // ARKAPLAN BOYANDIYSA DAHA ÖNCE BASILMIŞTIR.
                if (component.getBackground() == Color.RED | component.getBackground() == Color.GREEN) {
                    basilmis = true;
                } else {
                    basilmis = false;
                    if (getHazir()) {
                        int cx = e.getXOnScreen();

                        // SADECE SOL TABLODAKİ BASILIŞLARDA ARKAPLANI SARIYA BOYAR.
                        if (cx < 400) {
                            component.setBackground(Color.YELLOW);
                        }
                    }
                }

            }

            // BUTONLARA BASILMA EFEKT�
            if (e.getSource() == anaPanel.getMenu()) {
                anaPanel.getMenu().setIcon(new ImageIcon("images/ana_menu2.png"));
            } else if (e.getSource() == anaPanel.getYeniOyun()) {

                anaPanel.getYeniOyun().setIcon(new ImageIcon("images/yeni_oyun4.png"));

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!oyunBitti) {
            if (hazir & oyunBasladi & !basilmis) {
                component = (JComponent) e.getComponent();

                // BASILAN NOKTANIN TABLOYA İZDÜŞÜMÜNDE NEREYE GELECEĞİNİ HESAPLAR.
                int i = (component.getX() - 200) / 30;
                int j = (component.getY() - 100) / 30;

                if (i <= 9 && j <= 9 && (component.getBackground() != Color.RED | component.getBackground() != Color.GREEN)) {
                    if (getHazir() & !isEksik_dizilim() & !isYanlis_dizilim()) {
                        if (bilgisayar_yerlestilen[j][i] == 1) {
                            // BASILAN NOKTADA GEMİ VARSA ARKAPLAN YEŞİL OLUR.
                            component.setBackground(Color.GREEN);
                            ((JLabel) component).setText("   O");
                            String mesaj = "\n    ----------\n    vurdun !";
                            anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);

                            // GEMİNİN BİR PARÇASI BULUNDUĞU İÇİN computer_parca arttırılır.
                            computer_parca++;

                            // GEMİNİN TOPLAM BULUNAN PARÇASI 10'SA OYUN BİTER.
                            if (computer_parca == 10) {
                                String mesaj2 = "\n    ----------\n    KAZANDIN !";
                                anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                setOyunBitti(true);
                            }

                        } else {
                            // BASILAN NOKTADA GEMİ YOKSA ARKAPLAN KIRMIZI
                            component.setBackground(Color.RED);
                            ((JLabel) component).setText("   X");
                        }

                        if (!oyunBitti) {
                            if (Ayarlar.isYapayZekalar()) {
                                // İLK BASIŞ
                                if (sonraki_hamle.equals("")) {
                                    sagdaVar = false;
                                    soldaVar = false;
                                    yukardaVar = false;
                                    asagidaVar = false;
                                    random_x = random.nextInt(10);
                                    random_y = random.nextInt(10);

                                    // DAHA ÖNCE BASILMAYAN YENİ BİR KOORDİNAT BUL
                                    while (oyuncu_label[random_x][random_y].getBackground() == Color.RED
                                            | oyuncu_label[random_x][random_y].getBackground() == Color.GREEN) {
                                        random_x = random.nextInt(10);
                                        random_y = random.nextInt(10);
                                    }

                                    // OYUNCUNUN ORADA GEMİSİ VAR MI ?

                                    if (oyuncu[random_x][random_y] == 1) {

                                        // OYUNCUNUN ORDA GEMİSİ VARSA ARKAPLAN KIRMIZI
                                        oyuncu_label[random_x][random_y].setBackground(Color.RED);
                                        String mesaj = "\n    ----------\n    vuruldun !";
                                        anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);

                                        // GEMİNİN BİR PARÇASI BULUNDUĞU İÇİN oyuncu_parca arttırılır.
                                        oyuncu_parca++;

                                        // BULUNAN PARÇA SAYISI 10'SA OYUN BİTER.
                                        if (oyuncu_parca == 10) {
                                            String mesaj2 = "\n    ----------\n    KAYBETTİN !";
                                            anaPanel.getDurumAlani()
                                                    .setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                            setOyunBitti(true);
                                        }
                                        //YAPAY ZEKA AKTİF HALE GETİRİLİRSE
                                        // OYUNCU GEMİSİNİN İLK BULUNAN NOKTALARI HAFIZAYA ALINIR.
                                        zeka_x = random_x;
                                        zeka_y = random_y;
                                        //RASTGELE ATIŞ YAPTIKTAN SONRA BİR GEMİ PARÇASI BULUNURSA SIRASIYLA X VE Y DÜZLEMİNDEKİ ATIŞ YAPILMAMIŞ YERLERİ KONTROL EDER
                                        if (random_x + 1 <= 9
                                                && !(oyuncu_label[random_x + 1][random_y].getBackground() == Color.RED
                                                | oyuncu_label[random_x + 1][random_y]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "sag";
                                            random_x++;
                                        } else if (random_x - 1 >= 0
                                                && !(oyuncu_label[random_x - 1][random_y].getBackground() == Color.RED
                                                | oyuncu_label[random_x - 1][random_y]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "sol";
                                            random_x--;
                                        } else if (random_y - 1 >= 0
                                                && !(oyuncu_label[random_x][random_y - 1].getBackground() == Color.RED
                                                | oyuncu_label[random_x][random_y - 1]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "yukari";
                                            random_y--;
                                        } else if (random_y + 1 <= 9
                                                && !(oyuncu_label[random_x][random_y + 1].getBackground() == Color.RED
                                                | oyuncu_label[random_x][random_y + 1]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "asagi";
                                            random_y++;
                                        }

                                    } else {
                                        oyuncu_label[random_x][random_y].setBackground(Color.GREEN);
                                        sonraki_hamle = "";
                                    }
                                }
                                // YÖN KONTROLÜ YAPTIKTAN SONRA SONRAKİ HAMLENİN NEREYE YAPILACAĞINI BERLİRLER.
                                else if (sonraki_hamle.equals("sag")) {
                                    if (oyuncu[random_x][random_y] == 1) {
                                        sagdaVar = true;
                                        oyuncu_label[random_x][random_y].setBackground(Color.RED);
                                        String mesaj = "\n    ----------\n    vuruldun !";
                                        anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
                                        oyuncu_parca++;
                                        if (oyuncu_parca == 10) {
                                            String mesaj2 = "\n    ----------\n    KAYBETTİN !";
                                            anaPanel.getDurumAlani()
                                                    .setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                            setOyunBitti(true);
                                        }
                                        //GEMİNİN SAĞDA PARÇASI KALMAYANA KADAR ATIŞ YAPMAYA DEVAM EDER
                                        if (random_x + 1 <= 9
                                                && !(oyuncu_label[random_x + 1][random_y].getBackground() == Color.RED
                                                | oyuncu_label[random_x + 1][random_y]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "sag";
                                            random_x++;
                                        }  else {
                                            sonraki_hamle = "";
                                        }

                                    } else {
                                        oyuncu_label[random_x][random_y].setBackground(Color.GREEN);
                                        //EĞER GEMİNİN SAĞDA VURULACAK PARÇASI KALMAZSA SOL TARAFI DENER VE GEMİNİN BÜTÜN PARÇALARI BİTENE KADAR VURMAYA DEVAM EDER
                                        if (zeka_x - 1 >= 0 && !(oyuncu_label[zeka_x - 1][random_y]
                                                .getBackground() == Color.RED
                                                | oyuncu_label[zeka_x - 1][random_y].getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "sol";
                                            random_x = zeka_x - 1;
                                            //EĞER SAĞDA PARÇA YOKSA YUKARI VE AŞAĞI İÇİN AYNI İŞLEMLERİ UYGULAR,
                                        } else if (!sagdaVar) {
                                            random_x = zeka_x;
                                            if (random_y - 1 >= 0 && !(oyuncu_label[random_x][random_y - 1]
                                                    .getBackground() == Color.RED
                                                    | oyuncu_label[random_x][random_y - 1]
                                                    .getBackground() == Color.GREEN)) {
                                                random_y--;
                                                sonraki_hamle = "yukari";
                                            } else if (random_y + 1 <= 9 && !(oyuncu_label[random_x][random_y + 1]
                                                    .getBackground() == Color.RED
                                                    | oyuncu_label[random_x][random_y + 1]
                                                    .getBackground() == Color.GREEN)) {

                                                sonraki_hamle = "asagi";
                                                random_y++;
                                                sagdaVar = false;
                                                soldaVar = false;

                                            } else {
                                                sonraki_hamle = "";
                                            }
                                        } else {
                                            sonraki_hamle = "";
                                        }

                                    }

                                } else if (sonraki_hamle.equals("sol")) {
                                    if (oyuncu[random_x][random_y] == 1) {
                                        soldaVar = true;

                                        oyuncu_label[random_x][random_y].setBackground(Color.RED);
                                        String mesaj = "\n    ----------\n    vuruldun !";
                                        anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
                                        oyuncu_parca++;

                                        if (oyuncu_parca == 10) {
                                            String mesaj2 = "\n    ----------\n    KAYBETT�N !";
                                            anaPanel.getDurumAlani()
                                                    .setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                            setOyunBitti(true);
                                        }
                                        //GEMİNİN SOLDA PARÇASI KALMAYANA KADAR ATIŞ YAPMAYA DEVAM EDER
                                        if (random_x - 1 >= 0
                                                && !(oyuncu_label[random_x - 1][random_y].getBackground() == Color.RED
                                                | oyuncu_label[random_x - 1][random_y]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "sol";
                                            random_x--;
                                        } else {

                                            sonraki_hamle = "";
                                        }

                                    }
                                    // EĞER SOLDA YOKSA YUKARI VE AŞAĞIYI KONTROL EDER
                                    else {

                                        oyuncu_label[random_x][random_y].setBackground(Color.GREEN);

                                        if (!sagdaVar & !soldaVar) {
                                            if (random_y - 1 >= 0 && !(oyuncu_label[zeka_x][random_y - 1]
                                                    .getBackground() == Color.RED
                                                    | oyuncu_label[zeka_x][random_y - 1]
                                                    .getBackground() == Color.GREEN)) {
                                                sonraki_hamle = "yukari";

                                                random_y--;
                                                random_x = zeka_x;

                                            } else if (random_y + 1 <= 9 && !(oyuncu_label[zeka_x][random_y + 1]
                                                    .getBackground() == Color.RED
                                                    | oyuncu_label[zeka_x][random_y + 1]
                                                    .getBackground() == Color.GREEN)) {
                                                sonraki_hamle = "asagi";
                                                sagdaVar = false;
                                                soldaVar = false;
                                                random_y++;
                                                random_x = zeka_x;
                                            } else {
                                                sonraki_hamle = "";
                                            }
                                        } else {
                                            sonraki_hamle = "";
                                        }
                                    }
                                } else if (sonraki_hamle.equals("yukari")) {
                                    sagdaVar = soldaVar = false;
                                    if (oyuncu[random_x][random_y] == 1) {
                                        yukardaVar = true;
                                        oyuncu_label[random_x][random_y].setBackground(Color.RED);
                                        String mesaj = "\n    ----------\n    vuruldun !";
                                        anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
                                        oyuncu_parca++;

                                        if (oyuncu_parca == 10) {
                                            String mesaj2 = "\n    ----------\n    KAYBETT�N !";
                                            anaPanel.getDurumAlani()
                                                    .setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                            setOyunBitti(true);
                                        }
                                        if (random_y - 1 >= 0
                                                && !(oyuncu_label[random_x][random_y - 1].getBackground() == Color.RED
                                                | oyuncu_label[random_x][random_y - 1]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "yukari";
                                            random_y--;
                                        } else if (zeka_y + 1 <= 9 && !(oyuncu_label[random_x][zeka_y + 1]
                                                .getBackground() == Color.RED
                                                | oyuncu_label[random_x][zeka_y + 1].getBackground() == Color.GREEN)) {

                                            sonraki_hamle = "asagi";

                                            sagdaVar = false;
                                            soldaVar = false;
                                            random_y = zeka_y + 1;
                                        } else {

                                            sonraki_hamle = "";

                                        }

                                    } else {

                                        oyuncu_label[random_x][random_y].setBackground(Color.GREEN);

                                        if (!yukardaVar) {
                                            random_y = zeka_y;
                                            if (random_y + 1 <= 9 && !(oyuncu_label[random_x][random_y + 1]
                                                    .getBackground() == Color.RED
                                                    | oyuncu_label[random_x][random_y + 1]
                                                    .getBackground() == Color.GREEN)) {
                                                sonraki_hamle = "asagi";
                                                sagdaVar = false;
                                                soldaVar = false;
                                                random_y = zeka_y + 1;
                                            } else {
                                                sonraki_hamle = "";

                                            }
                                        } else {
                                            random_y = zeka_y;
                                            if (random_y + 1 < 9 && !(oyuncu_label[random_x][random_y + 1]
                                                    .getBackground() == Color.RED
                                                    | oyuncu_label[random_x][random_y + 1]
                                                    .getBackground() == Color.GREEN)) {
                                                sonraki_hamle = "asagi";
                                                sagdaVar = false;
                                                soldaVar = false;
                                                random_y++;
                                            } else {
                                                sonraki_hamle = "";

                                            }

                                        }
                                    }

                                } else if (sonraki_hamle.equals("asagi")) {
                                    sagdaVar = soldaVar = false;
                                    if (oyuncu[random_x][random_y] == 1) {
                                        asagidaVar = true;

                                        oyuncu_label[random_x][random_y].setBackground(Color.RED);
                                        String mesaj = "\n    ----------\n    vuruldun !";
                                        anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
                                        oyuncu_parca++;

                                        if (oyuncu_parca == 10) {
                                            String mesaj2 = "\n    ----------\n    KAYBETT�N !";
                                            anaPanel.getDurumAlani()
                                                    .setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                            setOyunBitti(true);
                                        }
                                        if (random_y + 1 <= 9
                                                && !(oyuncu_label[random_x][random_y + 1].getBackground() == Color.RED
                                                | oyuncu_label[random_x][random_y + 1]
                                                .getBackground() == Color.GREEN)) {
                                            sonraki_hamle = "asagi";
                                            sagdaVar = false;
                                            soldaVar = false;
                                            random_y++;
                                        } else {

                                            sonraki_hamle = "";

                                        }

                                    } else {
                                        oyuncu_label[random_x][random_y].setBackground(Color.GREEN);
                                        sonraki_hamle = "";

                                    }

                                }

                            } else {
                                //TABLODAN RASTGELE BİR NOKTANIN SEÇİLMESİNİ SAĞLAR.
                                random_x = random.nextInt(10);
                                random_y = random.nextInt(10);

                                while (oyuncu_label[random_x][random_y].getBackground() == Color.RED
                                        | oyuncu_label[random_x][random_y].getBackground() == Color.GREEN) {
                                    random_x = random.nextInt(10);
                                    random_y = random.nextInt(10);
                                }

                                if (oyuncu[random_x][random_y] == 1) {
                                    oyuncu_label[random_x][random_y].setBackground(Color.RED);
                                    String mesaj = "\n    ----------\n    vuruldun !";
                                    anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
                                    oyuncu_parca++;

                                    if (oyuncu_parca == 10) {
                                        String mesaj2 = "\n    ----------\n    KAYBETT�N !";
                                        anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj2);
                                        setOyunBitti(true);
                                    }
                                } else { // ISKA

                                    oyuncu_label[random_x][random_y].setBackground(Color.GREEN);

                                }

                            }

                        }

                    }
                }

            }
            if (e.getSource() == anaPanel.getMenu()) {
                anaPanel.getMenu().setIcon(new ImageIcon("images/ana_menu.png"));
            } else if (e.getSource() == anaPanel.getYeniOyun()) {
                anaPanel.getYeniOyun().setIcon(new ImageIcon("images/yeni_oyun4.png"));
            }
        }
    }

    public void setHazir(boolean hazir) {

        this.hazir = hazir;
        anaPanel.addKeyListener(this);
        anaPanel.setFocusable(true);
        anaPanel.requestFocusInWindow();


                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        oyuncu_yerlestirilen[i][j] = 0;
                    }
                }


                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (oyuncu_yerlestirilen[i][j] > 1) {
                            setYanlis_dizilim(true);
                            setHazir(false);
                            break;
                        }
                    }
                    if (yanlis_dizilim) {
                        break;
                    }
                }

                if (!yanlis_dizilim) {

                    // B�LG�SAYAR LABEL YERLE�T�RME

                    // LABEL ADED� veya LABEL BOYU
                    for (int i = 1; i <= 4; i++) {
                        // LABEL�N BA�LANGICINI BUL
                        satir = (int) (Math.random() * 9);
                        sutun = (int) (Math.random() * 9);
                        // System.out.println(1);

                        int yatayYerlestirme = (int) ((Math.random() * 9));

                        // P LABEL UZUNLUKLARI SIRAYLA 1,2,3,4
                        for (int p = 0; p < i; p++) {

                            // YATAY YERLE�T�RME

                            // P LABEL�N UZUNLU�U D�Z�Y� A�MAMALI
                            // while (!(sutun + i <= 9))
                            if (yatayYerlestirme % 2 == 0) {
                                if (p == 0) {

                                    // SUTUN BUYUK KAREY� A�MAMALI
                                    while (!(sutun + (i - 1) < 10)) {
                                        sutun = (int) (Math.random() * 9);
                                        // System.out.println(3);
                                    }
                                }
                                /*
                                 * boolean temiz_hucre = false; int a=0;
                                 */

                                // E�ER SATIR DOLUYSA B�R ALT SATIRA BAK
                                if (bilgisayar_yerlestilen[satir][sutun + p] == 1) {
                                    satir++;
                                    p = 0;

                                    // EN FAZLA 10 SATIR OLUR.
                                    if (satir > 9) {
                                        satir = satir % 10;
                                    }
                                    // System.out.println("dolu "+(p+1)+".par�a
                                    // i�in");
                                }

                                // LABEL�N SON PAR�ASI �SE ARTIK KONUMU
                                // YERLE�T�R.
                                if (p == i - 1) {
                                    for (int k = sutun; k <= sutun + p; k++) {
                                        bilgisayar_yerlestilen[satir][k] = 1;
                                    }
                                }
                                /*
                                 * System.out.
                                 * println("\n   0 1 2 3 4 5 6 7 8 9 \n");
                                 *
                                 * for (int z = 0; z < 10; z++) {
                                 * System.out.print(String.valueOf((char) (z +
                                 * 65)) + "  "); for (int x = 0; x < 10; x++) {
                                 * System.out.print(computer[z][x] + " "); }
                                 * System.out.println(); }
                                 */

                            } else {
                                // dikey yerle�tirme
                                if (p == 0) {

                                    // SUTUN BUYUK KAREY� A�MAMALI
                                    while (!(satir + (i - 1) < 10)) {
                                        satir = (int) (Math.random() * 9);
                                        // System.out.println(3);
                                    }
                                }
                                /*
                                 * boolean temiz_hucre = false; int a=0;
                                 */

                                // E�ER S�TUN DOLUYSA B�R YAN S�TUNA BAK
                                if (bilgisayar_yerlestilen[satir + p][sutun] == 1) {
                                    sutun--;
                                    p = 0;

                                    // EN FAZLA 10 SATIR OLUR.
                                    if (sutun < 0) {
                                        sutun = sutun + 10;
                                    }

                                }

                                // LABEL�N SON PAR�ASI �SE ARTIK LABEL�
                                // YERLE�T�R.
                                if (p == i - 1) {
                                    for (int k = satir; k <= satir + p; k++) {
                                        bilgisayar_yerlestilen[k][sutun] = 1;
                                    }
                                }

                                /*
                                 * System.out.
                                 * println("\n   0 1 2 3 4 5 6 7 8 9 \n");
                                 *
                                 * for (int z = 0; z < 10; z++) {
                                 * System.out.print(String.valueOf((char) (z +
                                 * 65)) + "  "); for (int x = 0; x < 10; x++) {
                                 * System.out.print(computer[z][x] + " "); }
                                 * System.out.println(); }
                                 *
                                 */
                            }
                        }
                    }
                    oyuncu = transposeMatrix(oyuncu_yerlestirilen);
                    String mesaj = "\n    ----------\n    Oyun basladi, hamle yap !";
                    anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
                    setOyunBasladi(true);
                }
            }
    public boolean getHazir() {
        return hazir;
    }





    @Override
    public void keyPressed(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == anaPanel.getHazirim() & !oyunBitti) {
            setHazir(true);
        } else if (e.getSource() == anaPanel.getMenu()) {

            CardLayout c1 = (CardLayout) (Cerceve.getPaneller().getLayout());
            c1.show(Cerceve.getPaneller(), "menü");
            Cerceve.getMenu().requestFocusInWindow();
        } else if (e.getSource() == anaPanel.getYeniOyun()) {
            AnaPanel anaPanel = new AnaPanel();
            Cerceve.setAnaPanel(anaPanel);
        }

    }

    public boolean isEksik_dizilim() {
        return eksik_dizilim;
    }

    public void setEksik_dizilim(boolean eksik_dizilim) {
        this.eksik_dizilim = eksik_dizilim;

        if (eksik_dizilim) {
            String mesaj = "\n    ----------\n    Gemilerin hepsi yerleştirilmeli.";
            anaPanel.getDurumAlani().setText(anaPanel.getDurumAlani().getText() + mesaj);
        }

    }

    public boolean isOyunBasladi() {
        return oyunBasladi;
    }

    public void setOyunBasladi(boolean oyunBasladi) {
        this.oyunBasladi = oyunBasladi;

        // B�LG�SAYARIN D�Z�L�M�
        System.out.println("\n----B�LG�SAYARIN D�Z�L�M�---- ");
        System.out.println("\n   0 1 2 3 4 5 6 7 8 9 \n");
        for (int z = 0; z < 10; z++) {
            System.out.print(String.valueOf((char) (z + 65)) + "  ");
            for (int x = 0; x < 10; x++) {
                System.out.print(oyuncu_yerlestirilen[z][x] + " ");
            }
            System.out.println();
        }
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        // OYUNCUNUN D�Z�L�M�
        System.out.println("\n----OYUNCUNUN D�Z�L�M�----");
        System.out.println("\n   0 1 2 3 4 5 6 7 8 9 \n");
        for (int z = 0; z < 10; z++) {
            System.out.print(String.valueOf((char) (z + 65)) + "  ");
            for (int x = 0; x < 10; x++) {
                System.out.print(oyuncu_yerlestirilen[z][x] + " ");
            }
            System.out.println();
        }
    }

    public boolean isOyunBitti() {
        return oyunBitti;
    }

    public void setOyunBitti(boolean oyunBitti) {
        this.oyunBitti = oyunBitti;
        if (oyunBitti) {
            /*
             * BUNLARIN YAPILMASINA GEREK YOK. YEN�OYUNA BASILDI�INDA ZATEN YEN�
             * B�R NESNE OLU�TURULUYOR.
             *
             * random_x=0; random_y=0; basilmis=false; sonraki_hamle="";
             * zeka_x=0; zeka_y=0;
             * sagdaVar=soldaVar=yukardaVar=asagidaVar=false; oyuncu_parca=0;
             * computer_parca=0; yanlik1 = yanlik2 = yanlik3 = yanlik4 = false;
             * computer = new int[10][10]; oyuncu= new int[10][10];
             * oyuncu_label=new JLabel[10][10]; setOyunBasladi(false);
             * anaPanel.getHazirim().setIcon(new
             * ImageIcon("images/hazirim.png"));
             *
             * JLabel[][] oy=anaPanel.getOyuncu_label(); JLabel[][]
             * co=anaPanel.getComputer_label();
             *
             * Color c=Color.decode("#0080FF"); Color
             * c2=Color.decode("#99CCFF");
             *
             * JLabel label1=anaPanel.getLabel1(); JLabel
             * label2=anaPanel.getLabel2(); JLabel label3=anaPanel.getLabel3();
             * JLabel label4=anaPanel.getLabel4();
             *
             * int x1 = 600, y1 = 450; int x2 = 660, y2 = 450; int x3 = 600, y3
             * = 500; int x4 = 720, y4 = 500;
             *
             * label1.setLocation(x1, y1); label2.setLocation(x2, y2);
             * label3.setLocation(x3, y3); label4.setLocation(x4, y4);
             *
             * for(int i=0;i<10;i++){ for(int j=0;j<10;j++){ if((i+j)%2==0){
             * oy[i][j].setBackground(c); co[i][j].setBackground(c);
             * oy[i][j].setText(" "); co[i][j].setText(" "); } else{
             * oy[i][j].setBackground(c2); co[i][j].setBackground(c2);
             * oy[i][j].setText(" "); co[i][j].setText(" "); } } } doluluk=new
             * int[10][10]; computer=new int[10][10];
             *
             * //setOyunBasladi(true);
             */
        }

    }
}
