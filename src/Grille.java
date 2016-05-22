import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Grille extends JPanel {
    public void paintComponent(Graphics g, Jeu jeu){
        
        for(int i=0; i<jeu.tailleGrille; i++){
            
            for (int j=0; j<jeu.tailleGrille; j++){
                
                switch(jeu.grilleCellule[i][j].couleur){
                    case "r" :
                        g.setColor(Color.red);
                    case "b" :
                        g.setColor(Color.blue);
                    case "j" :
                        g.setColor(Color.yellow);
                    case "v" :
                        g.setColor(Color.green);
                    case "o" :
                        g.setColor(Color.orange);
                    case "n" :
                        g.setColor(Color.magenta);
                    
                }
                
                g.fillRect(25+30*i,25+30*j,30,30);
                g.setColor(Color.white);
                g.drawRect(25+30*i,25+30*j,30,30);
            }
        }
        
    }
}
