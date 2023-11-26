package kezdooldal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Asteroid_destroyer extends JFrame implements ActionListener, KeyListener {
    private  int SZELESSEG = 1000;
    private  int MAGASSAG = 600;
    private  int JATEKOS_MERET = 55;
    private  int ELLEN_MERET = 30;
    private  int LOSTOR_MERET = 5;

  
    private ImageIcon jatekosIcon = new ImageIcon("urhajo.jpg");
    private JLabel jatekosLabel = new JLabel(jatekosIcon);
    private ImageIcon hatterkep = new ImageIcon("hatter_csillag.jpg");
    
    ImageIcon ellensegIcon = new ImageIcon("ellenseg.jpg");
    
    
    private int jatekosX = SZELESSEG / 2 - JATEKOS_MERET / 2;
    private int jatekosY = MAGASSAG - 2 * JATEKOS_MERET;
    private int jatekosSebesseg = 7;

    private List<EllensegZH> ellensegek = new ArrayList<>();
    private List<Bullet> lostorok = new ArrayList<>();
    private List<Bullet> torlendoLostorok = new ArrayList<>();

    private int megsemmisitettEllensegek = 0;
    private JLabel pontszamCimke;

    private JLabel leiras;
    private Timer idozito;
    
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new Asteroid_destroyer();
    });
}
    public Asteroid_destroyer() {
        setTitle("Asteroid Destroyer");
        setSize(SZELESSEG, MAGASSAG);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel panel = new JatekPanel();
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);
        panel.addKeyListener(this);
        add(panel);

        pontszamCimke = new JLabel("Elpusztított aszteroidák: 0", SwingConstants.CENTER);
        leiras = new JLabel("MOZGÁS:  balra  <-- nyíllal,   jobbra --> nyillal,  LÖVÉS: space lenyomása ", SwingConstants.CENTER);
        pontszamCimke.setForeground(Color.WHITE); // Fehér szöveg fekete háttérrel
        pontszamCimke.setBackground(Color.BLACK);
        pontszamCimke.setOpaque(true);
        pontszamCimke.setFont(new Font("Arial", Font.BOLD, 20)); 
        leiras.setForeground(Color.WHITE);  
        leiras.setBackground(Color.BLACK);  
        leiras.setOpaque(true);
        
        
        add(pontszamCimke, BorderLayout.NORTH);
        add(leiras, BorderLayout.SOUTH);
        
       
         panel.setLayout(null);
        jatekosLabel.setBounds(jatekosX, jatekosY, jatekosIcon.getIconWidth(), jatekosIcon.getIconHeight());
        panel.add(jatekosLabel);
        
          

        idozito = new Timer(10, this);
        idozito.start();

        elhelyezEllensegek();

        setVisible(true);
    }

    private void elhelyezEllensegek() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(SZELESSEG - ELLEN_MERET);
            int y = random.nextInt(MAGASSAG / 2);
            ellensegek.add(new EllensegZH(x, y));
            
            JLabel ellensegLabel = new JLabel(ellensegIcon);
            ellensegLabel.setBounds(x, y, ellensegIcon.getIconWidth(), ellensegIcon.getIconHeight());
            
            
        }
    }

    private void mozgatJatekost(int irany) {
        jatekosX += irany * jatekosSebesseg;
        if (jatekosX < 0) {
            jatekosX = 0;
        } else if (jatekosX > SZELESSEG - JATEKOS_MERET) {
            jatekosX = SZELESSEG - JATEKOS_MERET;
        }
    }

    private void mozgatEllensegeket() {
        for (EllensegZH ellenseg : ellensegek) {
            ellenseg.mozgat();
        }
    }

    private void mozgatTorusokat() {
        for (Bullet tor : lostorok) {
            tor.mozgat();
            if (tor.getY() < 0) {
                torlendoLostorok.add(tor);
            }
        }

        lostorok.removeAll(torlendoLostorok);
        torlendoLostorok.clear();
    }

    private void utkozeseketEllenoriz() {
        for (Bullet tor : new ArrayList<>(lostorok)) {
            for (EllensegZH ellenseg : new ArrayList<>(ellensegek)) {
                if (tor.getHatarok().intersects(ellenseg.getHatarok())) {
                    torlendoLostorok.add(tor);
                    ellensegek.remove(ellenseg);
                    megsemmisitettEllensegek++;
                    frissitPontszamCimke();
                }
            }
        }
   if (ellensegek.isEmpty()) {    
        idozito.stop();
        JOptionPane.showMessageDialog(this, "Gratulálok! Az összes aszteroidát megsemmisítetted!", "Játék Vége", JOptionPane.INFORMATION_MESSAGE);
        jatekVege();
    }
   
        for (EllensegZH ellenseg : new ArrayList<>(ellensegek)) {
            if (ellenseg.getHatarok().intersects(new Rectangle(jatekosX, jatekosY, JATEKOS_MERET, JATEKOS_MERET))) {
                idozito.stop();
                 int valasztas = JOptionPane.showOptionDialog(this,
                    "Az aszteroidákat nem sikerült elpusztítanod!\nElpusztított aszteroidák: " + megsemmisitettEllensegek,
                    "Játék Vége", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new Object[]{"Újraindítás", "Kilépés"}, "Újraindítás");

                     if (valasztas == JOptionPane.YES_OPTION) {
                     dispose();
                     Asteroid_destroyer sp = new Asteroid_destroyer();
                     } else if(valasztas == JOptionPane.NO_OPTION){
                        dispose();
                       // fokez s = new fokez();
                       // s.setVisible(true);
            }
        }
      }
    }
    private void jatekVege() {
    int valasztas = JOptionPane.showOptionDialog(this,
            "Győztél! Az összes aszteroida elpusztítva!\nElpusztított aszteroidák: " + megsemmisitettEllensegek,
            "Játék Vége", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, new Object[]{"Újraindítás", "Kilépés"}, "Újraindítás");

    if (valasztas == JOptionPane.YES_OPTION) {
        dispose();
        Asteroid_destroyer sp = new Asteroid_destroyer();
    } else if(valasztas == JOptionPane.NO_OPTION){
      // Kilépés esetén
        dispose();
      Kezdooldal s = new Kezdooldal();
      s.setVisible(true);
       
      
    }
}

    private void frissitPontszamCimke() {
        pontszamCimke.setText("Elpusztított aszteroidák: " + megsemmisitettEllensegek);
    }

    private class JatekPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
             g.drawImage(hatterkep.getImage(), 0, 0, getWidth(), getHeight(), this);
            rajzolJatekot(g);
        }
    }

    private void rajzolJatekot(Graphics g) {
        
        g.fillRect(jatekosX, jatekosY, JATEKOS_MERET, JATEKOS_MERET);
        jatekosLabel.setBounds(jatekosX, jatekosY, jatekosIcon.getIconWidth(), jatekosIcon.getIconHeight());
        jatekosLabel.setBounds(jatekosX, jatekosY, 50 , 40);
       
       
   
      
        for (EllensegZH ellenseg : ellensegek) {
          g.setColor(Color.BLUE);
          ellenseg.rajzol(g);
           
          g.setColor(Color.GRAY);
         int feliratX = ellenseg.getX() + ELLEN_MERET / 2 - 8; 
        int feliratY = ellenseg.getY() + ELLEN_MERET / 2 + 6; 
        g.drawString("O.o", feliratX, feliratY);
        }

        g.setColor(Color.RED);
        for (Bullet tor : lostorok) {
            g.fillRect(tor.getX(), tor.getY(), LOSTOR_MERET, LOSTOR_MERET);
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mozgatEllensegeket();
        mozgatTorusokat();
        utkozeseketEllenoriz();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int billKod = e.getKeyCode();

        if (billKod == KeyEvent.VK_LEFT) {
            mozgatJatekost(-1);
        } else if (billKod == KeyEvent.VK_RIGHT) {
            mozgatJatekost(1);
        } else if (billKod == KeyEvent.VK_SPACE) {
            lostorok.add(new Bullet(jatekosX + JATEKOS_MERET / 2, jatekosY));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private class EllensegZH {
        private int x;
        private int y;
        private int sebesseg = 1;
        
         public void rajzol(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);

        Ellipse2D.Double kor = new Ellipse2D.Double(x, y, ELLEN_MERET, ELLEN_MERET);
        g2d.fill(kor);
    }
        

        public EllensegZH(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void mozgat() {
            y += sebesseg;
            if (y > MAGASSAG) {
                y = 0;
                x = new Random().nextInt(SZELESSEG - ELLEN_MERET);
            }
        }

        public Rectangle getHatarok() {
            return new Rectangle(x, y, ELLEN_MERET, ELLEN_MERET);
        }
    }

    private class Bullet {
        private int x;
        private int y;
        private int sebesseg = 5;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void mozgat() {
            y -= sebesseg;
        }

        public Rectangle getHatarok() {
            return new Rectangle(x, y, LOSTOR_MERET, LOSTOR_MERET);
        }
        
    }
}
