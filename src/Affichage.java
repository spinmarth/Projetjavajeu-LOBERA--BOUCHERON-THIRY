import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Affichage extends JFrame {
    private JPanel container = new JPanel();
    private JPanel menu = new JPanel();
    private JPanel menuTaille = new JPanel();
    private JPanel barreTaille = new JPanel();
    private Dimension dim = new Dimension(250, 70);
    private Dimension dim2 = new Dimension(100, 40);
    
    
    public Affichage(){
        this.setSize(800,600);
        this.setTitle("Jeu des couleurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        
        composantMenu();
        
        this.add(menu);
        this.setVisible(true);
    }

    public void composantMenu(){
        
        Font police = new Font("Arial", Font.BOLD, 48);
        JLabel titreMenu = new JLabel ("Jeu Des Couleurs");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton bouton1Menu1 = new JButton("Partie rapide");
        bouton1Menu1.setMaximumSize(dim);
        bouton1Menu1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton bouton2Menu1 = new JButton("Partie personalisée");
        bouton2Menu1.setMaximumSize(dim);
        bouton2Menu1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton bouton3Menu1 = new JButton("Charger une partie");
        bouton3Menu1.setMaximumSize(dim);
        bouton3Menu1.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        menu.add(Box.createVerticalStrut(70));
        menu.add(titreMenu);
        
        menu.add(Box.createVerticalStrut(70));
        menu.add(bouton1Menu1);
        bouton1Menu1.addActionListener(new Bouton1Listener());
        
        menu.add(Box.createVerticalStrut(30));
        menu.add(bouton2Menu1);
        bouton2Menu1.addActionListener(new Bouton2Listener());
        
        menu.add(Box.createVerticalStrut(30));
        menu.add(bouton3Menu1);
        bouton3Menu1.addActionListener(new Bouton3Listener());
        
    }
    
    public void removeMenu(){
        this.remove(menu);
        this.repaint();
    }
    
    public void affichageMenuTaille(){
        
        menuTaille.setLayout(new BoxLayout(menuTaille, BoxLayout.Y_AXIS));
        
        Font police = new Font("Arial", Font.BOLD, 36);
        JLabel titreMenu = new JLabel ("Veuillez choisir la taille de la grille");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        barreTaille.setLayout(new BoxLayout(barreTaille, BoxLayout.X_AXIS));
        barreTaille.setSize(new Dimension(200,500));
        
            JButton tailleMoins = new JButton("Diminuer");
            tailleMoins.setMaximumSize(dim2);
            tailleMoins.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            int tailleGrille = jeu.getTailleGrille();
            JLabel taille = new JLabel ("13");
            taille.setFont(police);
            
            JButton taillePlus = new JButton("Augmenter");
            taillePlus.setMaximumSize(dim2);
            taillePlus.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            barreTaille.add(tailleMoins);
            barreTaille.add(Box.createRigidArea(new Dimension(150,1)));
            barreTaille.add(taille);
            barreTaille.add(Box.createRigidArea(new Dimension(150,1)));
            barreTaille.add(taillePlus);
        
        JButton boutonValider = new JButton("Valider");
        boutonValider.setMaximumSize(dim);
        boutonValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        menuTaille.add(Box.createVerticalStrut(70));
        menuTaille.add(titreMenu);
        menuTaille.add(Box.createVerticalStrut(150));
        menuTaille.add(barreTaille);
        menuTaille.add(Box.createVerticalStrut(80));
        menuTaille.add(boutonValider);
        
        this.add(menuTaille);
        this.validate();


    }

    class Bouton1Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            removeMenu();
        }
    }
    
    class Bouton2Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
            removeMenu();
            affichageMenuTaille();
            
        }
    }
    
    class Bouton3Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    
}
