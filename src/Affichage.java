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
    private Dimension dim = new Dimension(250, 70);
    
    
    public Affichage(){
        this.setSize(800,600);
        this.setTitle("Jeu des couleurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        
        composantMenu();
        
        this.setContentPane(menu);
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
        
        menu.add(Box.createVerticalStrut(30));
        menu.add(bouton2Menu1);
        
        menu.add(Box.createVerticalStrut(30));
        menu.add(bouton3Menu1);
    }
}
