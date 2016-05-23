import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Grille extends JPanel {
    public void paintComponent(Graphics g, Jeu jeu){
        
        switch(jeu.formeCase){
            case 1:
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
                
            case 2:
                
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
                
            case 3:
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

                        if(i%2==0){
                            int ii=i/2;
                            int yCoordinate[]={10+28*ii, 17+28*ii, 31+28*ii, 38+28*ii, 31+28*ii, 17+28*ii};
                            int xCoordinate[]={24+28*j, 38+28*j, 38+28*j, 24+28*j, 10+28*j, 10+28*j};
                            g.fillPolygon(xCoordinate,yCoordinate,6);
                            g.setColor(Color.white);
                            g.drawPolygon(xCoordinate,yCoordinate,6);
                        }
                        else{
                            int ii = i/2;
                            int yCoordinate[]={31+28*ii, 38+28*ii, 52+28*ii, 59+28*ii, 52+28*ii, 38+28*ii};
                            int xCoordinate[]={38+28*j, 52+28*j, 52+28*j, 38+28*j, 24+28*j, 24+28*j};
                            g.fillPolygon(xCoordinate,yCoordinate,6);
                            g.setColor(Color.white);
                            g.drawPolygon(xCoordinate,yCoordinate,6);
                        }
                    }
                }
            
        }
        
    }
}
