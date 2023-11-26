package kezdooldal;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class LoginPanel extends JFrame {
    private JTextField regFelhasznalonevMezo;
    private JPasswordField regJelszoMezo;
    private JTextField regEmailMezo;
    private JTextField loginFelhasznalonevMezo;
    private JPasswordField loginJelszoMezo;

    public LoginPanel() {
        // Ablak inicializálása
        setTitle("GAMING HUB");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Fülpanel létrehozása
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.BLACK);

        // Regisztrációs panel létrehozása és hozzáadása a fülpanelhez
        JPanel regisztracioPanel = createRegisztracioPanel();
        regisztracioPanel.setForeground(Color.BLACK);
        tabbedPane.addTab("Regisztráció", regisztracioPanel);

        // Bejelentkezési panel létrehozása és hozzáadása a fülpanelhez
        JPanel bejelentkezesPanel = createBejelentkezesPanel();
        tabbedPane.addTab("Bejelentkezés", bejelentkezesPanel);
       tabbedPane.setBackground(Color.BLACK);
       tabbedPane.setForeground(Color.GRAY);

        // Fülpanel hozzáadása az ablakhoz
        add(tabbedPane);
        

        // Háttérszín beállítása feketére
        getContentPane().setBackground(Color.BLACK);

        // GAMING HUB felirat létrehozása és beállítása
        JLabel cimLabel = new JLabel("GAMING HUB");
        cimLabel.setForeground(Color.WHITE); // Fehér szöveg
        cimLabel.setHorizontalAlignment(JLabel.CENTER); // Középre igazítás
        cimLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Betűméret és stílus beállítása
        add(cimLabel, BorderLayout.PAGE_START);

        // Ablak láthatóvá tétele
        setVisible(true);
    }

    private JPanel createRegisztracioPanel() {
        // Regisztrációs panel létrehozása
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(Color.RED);

        // Felhasználónév címke és mező hozzáadása a regisztrációs panelhez
        JLabel felhasznalonevLabel = new JLabel("Felhasználónév:");
        regFelhasznalonevMezo = new JTextField();
        regFelhasznalonevMezo.setPreferredSize(new Dimension(200, 25)); // Előnyben részesített méret beállítása
        panel.add(felhasznalonevLabel);
        panel.add(regFelhasznalonevMezo);
        felhasznalonevLabel.setForeground(Color.WHITE);

        // Jelszó címke és mező hozzáadása a regisztrációs panelhez
        JLabel jelszoLabel = new JLabel("Jelszó:");
        regJelszoMezo = new JPasswordField();
        regJelszoMezo.setPreferredSize(new Dimension(200, 25)); // Előnyben részesített méret beállítása
        panel.add(jelszoLabel);
        panel.add(regJelszoMezo);
        jelszoLabel.setForeground(Color.WHITE);

        // E-mail cím címke és mező hozzáadása a regisztrációs panelhez
        JLabel emailLabel = new JLabel("E-mail cím:");
        regEmailMezo = new JTextField();
        regEmailMezo.setPreferredSize(new Dimension(200, 25)); // Előnyben részesített méret beállítása
        panel.add(emailLabel);
        panel.add(regEmailMezo);
        emailLabel.setForeground(Color.WHITE);
        
 
        // Regisztráció gomb hozzáadása
        JButton regisztracioGomb = new JButton("Regisztráció");
        regisztracioGomb.addActionListener(e -> regisztracioVegrehajtas());
        panel.add(new JLabel()); // Üres címke a táblázat formázásához
        panel.add(regisztracioGomb);
        panel.setBackground(Color.BLACK);
        regisztracioGomb.setBackground(Color.WHITE);
       

        return panel;
    }

    private JPanel createBejelentkezesPanel() {
        // Bejelentkezési panel létrehozása
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(Color.BLACK);

        // Felhasználónév címke és mező hozzáadása a bejelentkezési panelhez
        JLabel felhasznalonevLabel = new JLabel("Felhasználónév:");
        loginFelhasznalonevMezo = new JTextField();
        loginFelhasznalonevMezo.setPreferredSize(new Dimension(200, 25)); // Előnyben részesített méret beállítása
        panel.add(felhasznalonevLabel);
        panel.add(loginFelhasznalonevMezo);
        felhasznalonevLabel.setForeground(Color.WHITE);

        // Jelszó címke és mező hozzáadása a bejelentkezési panelhez
        JLabel jelszoLabel = new JLabel("Jelszó:");
        loginJelszoMezo = new JPasswordField();
        loginJelszoMezo.setPreferredSize(new Dimension(200, 25)); // Előnyben részesített méret beállítása
        panel.add(jelszoLabel);
        panel.add(loginJelszoMezo);
        jelszoLabel.setForeground(Color.WHITE);

        // Bejelentkezés gomb hozzáadása
        JButton bejelentkezesGomb = new JButton("Bejelentkezés");
        bejelentkezesGomb.addActionListener(e -> bejelentkezesVegrehajtas());
        panel.add(new JLabel()); // Üres címke a táblázat formázásához
        panel.add(bejelentkezesGomb);
        bejelentkezesGomb.setBackground(Color.WHITE);

        return panel;
    }

    private void regisztracioVegrehajtas() {
    // Regisztrációs logika
    String felhasznalonev = regFelhasznalonevMezo.getText();
    char[] jelszoKarakterek = regJelszoMezo.getPassword();
    String jelszo = new String(jelszoKarakterek);
    String email = regEmailMezo.getText();

    // Ellenőrizzük, hogy a mezők ki vannak-e töltve
    if (felhasznalonev.isEmpty() || jelszo.isEmpty() || email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Minden mező kitöltése kötelező!", "Hiba", JOptionPane.ERROR_MESSAGE);
        return; // Ne folytassa a regisztrációt üres mezők esetén
    }

    // Adatbázisba mentés
    try {
        Connection kapcsolat = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyakorlas", "root", "1234");

        String felhasznaloHozzaadasQuery = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        PreparedStatement felhasznaloHozzaadasStatement = kapcsolat.prepareStatement(felhasznaloHozzaadasQuery);
        felhasznaloHozzaadasStatement.setString(1, felhasznalonev);
        felhasznaloHozzaadasStatement.setString(2, jelszo);
        felhasznaloHozzaadasStatement.setString(3, email);
        felhasznaloHozzaadasStatement.executeUpdate();
        saveUserDataToTxt(felhasznalonev, jelszo, email);
        kapcsolat.close();

        JOptionPane.showMessageDialog(this, "Sikeres regisztráció!");
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Hiba történt a regisztráció során.");
    }
}
private void saveUserDataToTxt(String felhasznalonev, String jelszo, String email) {
    try {
        // Elérési út beállítása a txt fájlnak
        String eleresiUt = "felhasznalok.txt";

        // FileWriter létrehozása a létező fájlhoz való hozzáfűzés módban
        FileWriter fileWriter = new FileWriter(eleresiUt, true);

        // PrintWriter létrehozása a könnyű kiíráshoz a fájlba
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Adatok kiírása a fájlba
        printWriter.println("Felhasználónév: " + felhasznalonev);
        printWriter.println("Jelszó: " + jelszo);
        printWriter.println("E-mail: " + email);
        printWriter.println();

        // Lezárjuk a PrintWriter-t
        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
  private void bejelentkezesVegrehajtas() {
    String felhasznalonev = loginFelhasznalonevMezo.getText();
    char[] jelszo = loginJelszoMezo.getPassword();
    if (felhasznalonev.isEmpty() || jelszo.length == 0) {
        JOptionPane.showMessageDialog(this, "Minden mező kitöltése kötelező!", "Hiba", JOptionPane.ERROR_MESSAGE);
        return; // Ne folytassa a bejelentkezést üres mezők esetén
    }
    
    System.out.println("Bejelentkezés - Felhasználónév: " + felhasznalonev + ", Jelszó: " + new String(jelszo));
    dispose();
    //fokez();
    fokez fokezAblak = new fokez();
    fokezAblak.setBejelentkezettFelhasznalo(felhasznalonev);
    fokezAblak.setVisible(true);
}

    private void fokez() {
        // Bezárjuk a bejelentkezési ablakot
        dispose();

        // Nyitunk egy új főablakot (MainForm)
         fokez kezdooldal = new fokez();
         kezdooldal.setVisible(true);
         

        
    }

    public static void main(String[] args) {
        // A Swing komponenseket a Swing EDT szálon kell létrehozni és módosítani
        SwingUtilities.invokeLater(() -> new LoginPanel());
        
    }
}
