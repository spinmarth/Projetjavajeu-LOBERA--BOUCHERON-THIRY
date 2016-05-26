import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Grille extends JPanel {
    
    Jeu jeu = new Jeu(1);
    
    public void paintComponent(Graphics g){
        
        
        if(jeu.formeCase == 1 ){
                for(int i=0; i<jeu.tailleGrille; i++){

                    for (int j=0; j<jeu.tailleGrille; j++){
 
                        if(jeu.grilleCellule[i][j].couleur.equals("r")){
                            g.setColor(Color.red);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("b")){
                            g.setColor(Color.blue);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("j")){
                            g.setColor(Color.yellow);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("n")){
                            g.setColor(Color.magenta);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("v")){
                            g.setColor(Color.green);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("o")){
                            g.setColor(Color.orange);
                        }

                        g.fillRect(25+30*j,25+30*i,30,30);
                        g.setColor(Color.white);
                        g.drawRect(25+30*j,25+30*i,30,30);
                    }
                }
                
                for(int i=0; i<jeu.tailleGrille; i++){

                    for (int j=0; j<jeu.tailleGrille; j++){
 
                        if(jeu.grilleCellule[i][j].territoire != 0){
                            g.setColor(Color.black);
                            g.drawRect(25+30*j,25+30*i,30,30);
                        }
                    }
                }
        }
        
        if(jeu.formeCase == 2 ){
                
                for(int i=0; i<jeu.tailleGrille; i++){

                    for (int j=0; j<jeu.tailleGrille; j++){

                        if(jeu.grilleCellule[i][j].couleur.equals("r")){
                            g.setColor(Color.red);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("b")){
                            g.setColor(Color.blue);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("j")){
                            g.setColor(Color.yellow);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("n")){
                            g.setColor(Color.magenta);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("v")){
                            g.setColor(Color.green);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("o")){
                            g.setColor(Color.orange);
                        }
                        
                        if(i%2==0){
                            int ii=i/2;
                            int yCoordinate[]={25+50*ii, 50+50*ii, 75+50*ii, 50+50*ii};
                            int xCoordinate[]={25+30*j, 40+30*j, 25+30*j, 10+30*j};
                            g.fillPolygon(xCoordinate,yCoordinate,4);
                            g.setColor(Color.white);
                            g.drawPolygon(xCoordinate,yCoordinate,4);
                        }
                        else{
                            int ii = i/2;
                            int yCoordinate[]={50+50*ii, 75+50*ii, 100+50*ii, 75+50*ii};
                            int xCoordinate[]={40+30*j, 55+30*j, 40+30*j, 25+30*j};
                            g.fillPolygon(xCoordinate,yCoordinate,4);
                            g.setColor(Color.white);
                            g.drawPolygon(xCoordinate,yCoordinate,4);
                        }
                    }
                }
                
                for(int i=0; i<jeu.tailleGrille; i++){

                    for (int j=0; j<jeu.tailleGrille; j++){
 
                        if(jeu.grilleCellule[i][j].territoire != 0){
                            if(i%2==0){
                                int ii=i/2;
                                int yCoordinate[]={25+50*ii, 50+50*ii, 75+50*ii, 50+50*ii};
                                int xCoordinate[]={25+30*j, 40+30*j, 25+30*j, 10+30*j};
                                g.setColor(Color.black);
                                g.drawPolygon(xCoordinate,yCoordinate,4);
                            }
                            else{
                                int ii = i/2;
                                int yCoordinate[]={50+50*ii, 75+50*ii, 100+50*ii, 75+50*ii};
                                int xCoordinate[]={40+30*j, 55+30*j, 40+30*j, 25+30*j};
                                g.setColor(Color.black);
                                g.drawPolygon(xCoordinate,yCoordinate,4);
                            }   
                        }
                    }
                }
        }
        
        if(jeu.formeCase == 3 ){
                for(int i=0; i<jeu.tailleGrille; i++){

                    for (int j=0; j<jeu.tailleGrille; j++){

                        if(jeu.grilleCellule[i][j].couleur.equals("r")){
                            g.setColor(Color.red);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("b")){
                            g.setColor(Color.blue);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("j")){
                            g.setColor(Color.yellow);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("n")){
                            g.setColor(Color.magenta);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("v")){
                            g.setColor(Color.green);
                        }
                        
                        if(jeu.grilleCellule[i][j].couleur.equals("o")){
                            g.setColor(Color.orange);
                        }

                        if(i%2==0){
                            int ii=i/2;
                            int yCoordinate[]={10+42*ii, 17+42*ii, 31+42*ii, 38+42*ii, 31+42*ii, 17+42*ii};
                            int xCoordinate[]={24+28*j, 38+28*j, 38+28*j, 24+28*j, 10+28*j, 10+28*j};
                            g.fillPolygon(xCoordinate,yCoordinate,6);
                            g.setColor(Color.white);
                            g.drawPolygon(xCoordinate,yCoordinate,6);
                        }
                        else{
                            int ii = i/2;
                            int yCoordinate[]={31+42*ii, 38+42*ii, 52+42*ii, 59+42*ii, 52+42*ii, 38+42*ii};
                            int xCoordinate[]={38+28*j, 52+28*j, 52+28*j, 38+28*j, 24+28*j, 24+28*j};
                            g.fillPolygon(xCoordinate,yCoordinate,6);
                            g.setColor(Color.white);
                            g.drawPolygon(xCoordinate,yCoordinate,6);
                        }
                    }
                }
                
                for(int i=0; i<jeu.tailleGrille; i++){

                    for (int j=0; j<jeu.tailleGrille; j++){
 
                        if(jeu.grilleCellule[i][j].territoire != 0){
                            
                            if(i%2==0){
                                int ii=i/2;
                                int yCoordinate[]={10+42*ii, 17+42*ii, 31+42*ii, 38+42*ii, 31+42*ii, 17+42*ii};
                                int xCoordinate[]={24+28*j, 38+28*j, 38+28*j, 24+28*j, 10+28*j, 10+28*j};
                                g.setColor(Color.black);
                                g.drawPolygon(xCoordinate,yCoordinate,6);
                            }
                            
                            else{
                                int ii = i/2;
                                int yCoordinate[]={31+42*ii, 38+42*ii, 52+42*ii, 59+42*ii, 52+42*ii, 38+42*ii};
                                int xCoordinate[]={38+28*j, 52+28*j, 52+28*j, 38+28*j, 24+28*j, 24+28*j};
                                g.setColor(Color.black);
                                g.drawPolygon(xCoordinate,yCoordinate,6);
                            }   
                        }
                    }
                }  
            
        }
        
    }
    
    public void setJeu(Jeu jeuu){
        this.jeu=jeuu;
    }
}
