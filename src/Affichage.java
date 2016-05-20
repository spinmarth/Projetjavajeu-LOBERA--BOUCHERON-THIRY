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
import java.util.ArrayList;
import javax.swing.JTextField;


public class Affichage extends JFrame {
    private JPanel container = new JPanel();
    private JPanel menu = new JPanel();
    private JPanel menuTaille = new JPanel();
    private JPanel barreTaille = new JPanel();
    private JPanel menuForme = new JPanel();
    private JPanel barreForme = new JPanel();
    private JPanel menuJoueur = new JPanel();
    private JPanel barreJoueur1 = new JPanel();
    private JPanel barreJoueur2 = new JPanel();
    private JPanel barreJoueur3 = new JPanel();
    
    private JLabel taille = new JLabel();
    private JLabel[] listeLabel = new JLabel[4]; 
    
    private JTextField txtJoueur = new JTextField("Nom joueur");
    
    private Dimension dim = new Dimension(250, 70);
    private Dimension dim2 = new Dimension(100, 40);
    private Dimension dim3 = new Dimension(150, 55);
    
    private Jeu jeu = new Jeu();
    
    public Affichage(){
        this.setSize(800,600);
        this.setTitle("Jeu des couleurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        jeu.CreationListeJoueur();
        
        CreationMenu();
        CreationMenuTaille();
        CreationMenuForme();
        CreationMenuJoueur();
        
        this.add(menu);
        this.setVisible(true);
    }

    public void CreationMenu(){
        
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
    
    public void RemoveMenu(){
        this.remove(menu);

    }
    
    
    public void AddMenu(){
        this.add(menu);
        this.validate();
        this.repaint();
    }
    
    public void RemoveMenuTaille(){
        this.remove(menuTaille);

    }
    
    public void AddMenuTaille(){
        this.add(menuTaille);
        this.validate();
        this.repaint();
    }
    
    public void RemoveMenuForme(){
        this.remove(menuForme);

    }
    
    public void AddMenuForme(){
        this.add(menuForme);
        this.validate();
        this.repaint();
    }
    
    public void RemoveMenuJoueur(){
        this.remove(menuJoueur);

    }
    
    public void AddMenuJoueur(){
        this.add(menuJoueur);
        this.validate();
        this.repaint();
    }
    
    public void CreationMenuTaille(){
        
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
            tailleMoins.addActionListener(new DiminueTailleListener());
            
            int tailleGrille = jeu.getTailleGrille();
            String strTailleGrille = Integer.toString(tailleGrille);
            taille.setText(strTailleGrille);
            taille.setFont(police);
            
            JButton taillePlus = new JButton("Augmenter");
            taillePlus.setMaximumSize(dim2);
            taillePlus.setAlignmentX(Component.CENTER_ALIGNMENT);
            taillePlus.addActionListener(new AugmentTailleListener());
            
            barreTaille.add(tailleMoins);
            barreTaille.add(Box.createRigidArea(new Dimension(150,1)));
            barreTaille.add(taille);
            barreTaille.add(Box.createRigidArea(new Dimension(150,1)));
            barreTaille.add(taillePlus);
        
        JButton boutonValider = new JButton("Valider");
        boutonValider.setMaximumSize(dim);
        boutonValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        boutonValider.addActionListener(new ValideTailleListener());
        
        menuTaille.add(Box.createVerticalStrut(70));
        menuTaille.add(titreMenu);
        menuTaille.add(Box.createVerticalStrut(150));
        menuTaille.add(barreTaille);
        menuTaille.add(Box.createVerticalStrut(80));
        menuTaille.add(boutonValider);
    }
    
    public void CreationMenuForme(){
    
        menuForme.setLayout(new BoxLayout(menuForme, BoxLayout.Y_AXIS));
        
        Font police = new Font("Arial", Font.BOLD, 36);
        JLabel titreMenu = new JLabel ("Veuillez choisir la forme des cases");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        barreForme.setLayout(new BoxLayout(barreForme, BoxLayout.X_AXIS));
        barreForme.setSize(new Dimension(200,500));
            
            JButton formeCarre = new JButton("Carré");
            formeCarre.setMaximumSize(dim3);
            formeCarre.setAlignmentX(Component.CENTER_ALIGNMENT);
            formeCarre.addActionListener(new FormeCarreListener());
            
            JButton formeLosange = new JButton("Losange");
            formeLosange.setMaximumSize(dim3);
            formeLosange.setAlignmentX(Component.CENTER_ALIGNMENT);
            formeLosange.addActionListener(new FormeLosangeListener());
            
            JButton formeHexagonale = new JButton("Hexagonale");
            formeHexagonale.setMaximumSize(dim3);
            formeHexagonale.setAlignmentX(Component.CENTER_ALIGNMENT);
            formeHexagonale.addActionListener(new FormeHexagonaleListener());
            
            barreForme.add(formeCarre);
            barreForme.add(Box.createRigidArea(new Dimension(100,1)));
            barreForme.add(formeLosange);
            barreForme.add(Box.createRigidArea(new Dimension(100,1)));
            barreForme.add(formeHexagonale);
        
        menuForme.add(Box.createVerticalStrut(70));
        menuForme.add(titreMenu);
        menuForme.add(Box.createVerticalStrut(150));
        menuForme.add(barreForme);
        
    }
    
    public void CreationMenuJoueur(){
    
        menuJoueur.setLayout(new BoxLayout(menuJoueur, BoxLayout.Y_AXIS));
        
        Font police = new Font("Arial", Font.BOLD, 36);
        JLabel titreMenu = new JLabel ("Veuillez choisir le nombre de participants");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        barreJoueur1.setLayout(new BoxLayout(barreJoueur1, BoxLayout.X_AXIS));
        barreJoueur1.setMaximumSize(new Dimension(600,500));
        
            barreJoueur2.setLayout(new BoxLayout(barreJoueur2, BoxLayout.Y_AXIS));
            barreJoueur2.setMaximumSize(new Dimension(600,300));
                
                JLabel titreMenu2 = new JLabel ("Liste participants");
                titreMenu2.setFont(new Font("Arial",Font.BOLD, 24));
                titreMenu2.setAlignmentX(Component.CENTER_ALIGNMENT);
                barreJoueur2.add(titreMenu2);
                
                for (int i=0; i<4; i++){
                    
                    listeLabel[i] = new JLabel(jeu.listeJoueur[i].nom);
                    listeLabel[i].setFont(new Font("Arial", Font.BOLD, 16));
                    listeLabel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                    barreJoueur2.add(listeLabel[i]);
                } 
            
            barreJoueur3.setLayout(new BoxLayout(barreJoueur3, BoxLayout.Y_AXIS));
            barreJoueur3.setMaximumSize(new Dimension(600,300));
                
                txtJoueur.setMaximumSize(dim2);
                            
                JButton boutonJoueur = new JButton("Joueur");
                boutonJoueur.setMaximumSize(dim2);
                boutonJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
                boutonJoueur.addActionListener(new AjoutJoueur());
                
                JButton boutonIA1 = new JButton("IA niveau 1");
                boutonIA1.setMaximumSize(dim2);
                boutonIA1.setAlignmentX(Component.CENTER_ALIGNMENT);
                boutonIA1.addActionListener(new AjoutIA1());
                
                JButton boutonIA2 = new JButton("IA niveau 2");
                boutonIA2.setMaximumSize(dim2);
                boutonIA2.setAlignmentX(Component.CENTER_ALIGNMENT);
                boutonIA2.addActionListener(new AjoutIA2());
                
                JButton boutonIA3 = new JButton("IA niveau 3");
                boutonIA3.setMaximumSize(dim2);
                boutonIA3.setAlignmentX(Component.CENTER_ALIGNMENT);
                boutonIA3.addActionListener(new AjoutIA3());
                
                barreJoueur3.add(Box.createRigidArea(new Dimension(1,30)));
                barreJoueur3.add(txtJoueur);
                barreJoueur3.add(Box.createRigidArea(new Dimension(1,10)));
                barreJoueur3.add(boutonJoueur);
                barreJoueur3.add(Box.createRigidArea(new Dimension(1,50)));
                barreJoueur3.add(boutonIA1);
                barreJoueur3.add(Box.createRigidArea(new Dimension(1,30)));
                barreJoueur3.add(boutonIA2);
                barreJoueur3.add(Box.createRigidArea(new Dimension(1,30)));
                barreJoueur3.add(boutonIA3);
            
            barreJoueur1.add(barreJoueur2);
            barreJoueur1.add(barreJoueur3);
                
        menuJoueur.add(Box.createVerticalStrut(50));
        menuJoueur.add(titreMenu);
        
        menuJoueur.add(barreJoueur1);
    
    }

    public void modifMenuTaille(){
        int tailleGrille = jeu.getTailleGrille();
        String strTailleGrille = Integer.toString(tailleGrille);
        taille.setText(strTailleGrille);
    }
    
    class Bouton1Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            RemoveMenu();
        }
    }
    
    class Bouton2Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
            RemoveMenu();
            AddMenuTaille();
            
        }
    }
    
    class Bouton3Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class DiminueTailleListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.DiminueTaille();
            modifMenuTaille();
        }
    }
    
    class AugmentTailleListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.AugmentTaille();
            modifMenuTaille();
        }
    }
    
    class ValideTailleListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.CreationGrille();
            RemoveMenuTaille();
            AddMenuForme();
        }
    }
    
    class FormeCarreListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.CelluleVoisineCarre();
            RemoveMenuForme();
            AddMenuJoueur();
        }
    }
    
    class FormeLosangeListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.CelluleVoisineLosange();
            RemoveMenuForme();
            AddMenuJoueur();
        }
    }
    
    class FormeHexagonaleListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.CelluleVoisineHexagone();
            RemoveMenuForme();
            AddMenuJoueur();
        }
    }
    
    class AjoutJoueur implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class AjoutIA1 implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class AjoutIA2 implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    class AjoutIA3 implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    
}
