
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

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