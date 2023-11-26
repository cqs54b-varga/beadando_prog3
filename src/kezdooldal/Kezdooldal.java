
package kezdooldal;
import javax.swing.*;


/**
 *
 * @author Varga László
 */
public class Kezdooldal extends JFrame{

    public Kezdooldal() {
        
       
        setTitle("GAME HUB");
         setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          setLocationRelativeTo(null);
          LoginPanel f = new LoginPanel();
          add(f.getContentPane());
          
    }   
          
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                LoginPanel f = new LoginPanel();
                f.show();
            }
        });
    }
    
}
