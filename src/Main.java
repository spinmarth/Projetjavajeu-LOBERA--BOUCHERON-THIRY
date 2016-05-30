
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Main {
  public static void main(String[] args) {
    Jeu jeu = new Jeu();
    
    
    
    try 
    {
      UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
    Affichage affichage = new Affichage();
    
  }
}