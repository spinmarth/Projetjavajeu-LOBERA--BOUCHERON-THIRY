import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.io.Serializable;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


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
    private JPanel menuJeu = new JPanel();
    private JPanel menuJeuNorth = new JPanel();
    private Grille menuJeuCenter;
    private JPanel menuJeuSouth = new JPanel();
    private JPanel menuJeuEast = new JPanel();
    private JPanel menuJeuWest = new JPanel();
    private JPanel panelFinJeu = new JPanel();
    
    private JLabel taille = new JLabel();
    private JLabel[] listeLabel = new JLabel[4]; 
    private JLabel[] listeLabelJeu = new JLabel[8]; 
    private JLabel titreMenuJeu = new JLabel();
    
    private JTextField txtJoueur = new JTextField("Nom joueur");
    
    private Dimension dim = new Dimension(250, 70);
    private Dimension dim2 = new Dimension(100, 40);
    private Dimension dim3 = new Dimension(150, 55);
    
    private JButton boutonJaune;
    private JButton boutonVert;
    private JButton boutonBleu;
    private JButton boutonOrange;
    private JButton boutonRouge;
    private JButton boutonViolet;
    
    private JMenu menuBar1 = new JMenu("Options");
    private JMenuItem retourHome = new JMenuItem("Accueil");
    private JMenuItem sauvegarde = new JMenuItem("Sauvegarder");
    private JMenuItem mute = new JMenuItem("Mute");
    private JMenuItem unmute = new JMenuItem("Unmute");
    private JMenuBar menuBar = new JMenuBar();
  
    private int finJeu=0;
    
    private Music music;
    
    private Jeu jeu = new Jeu();
    
    public Affichage(){
        this.setSize(800,600);
        this.setTitle("Jeu des couleurs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        
       
        
        retourHome.addActionListener(new RetourHome());
        sauvegarde.addActionListener(new Sauvegarde());
        mute.addActionListener(new Mute());
        unmute.addActionListener(new Unmute());
        
        menuBar1.add(retourHome);
        menuBar1.add(sauvegarde);
        menuBar1.add(mute);
        menuBar.add(menuBar1);
        this.setJMenuBar(menuBar);
        
        CreationMenu();
        CreationMenuTaille();
        CreationMenuForme();
        CreationMenuJoueur();
        
        this.add(menu);
        this.setVisible(true);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
		music=new Music();
		music.start();
            }
	});
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
        jeu = new Jeu();
        CreationMenuTaille();
        CreationMenuJoueur();
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
    
    public void RemoveMenuJeu(){
        this.remove(menuJeu);

    }
    
    public void AddMenuJeu(){
        
        this.validate();
        this.repaint();
        this.finJeu = 0;
        
    }
    
    public void CreationMenuTaille(){
        
        menuTaille = new JPanel();
        menuTaille.setLayout(new BoxLayout(menuTaille, BoxLayout.Y_AXIS));
        
        Font police = new Font("Arial", Font.BOLD, 36);
        JLabel titreMenu = new JLabel ("Veuillez choisir la taille de la grille");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        barreTaille = new JPanel();
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
    
        menuJoueur = new JPanel();
        menuJoueur.setLayout(new BoxLayout(menuJoueur, BoxLayout.Y_AXIS));
        
        Font police = new Font("Arial", Font.BOLD, 36);
        JLabel titreMenu = new JLabel ("Veuillez choisir le nombre de participants");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        barreJoueur1 = new JPanel();
        barreJoueur1.setLayout(new BoxLayout(barreJoueur1, BoxLayout.X_AXIS));
        barreJoueur1.setMaximumSize(new Dimension(500,500));
        
            barreJoueur2 = new JPanel();
            barreJoueur2.setLayout(new BoxLayout(barreJoueur2, BoxLayout.Y_AXIS));
            barreJoueur2.setMaximumSize(new Dimension(500,300));
                
                JLabel titreMenu2 = new JLabel ("Liste participants");
                titreMenu2.setFont(new Font("Arial",Font.BOLD, 24));
                titreMenu2.setAlignmentX(Component.CENTER_ALIGNMENT);
                barreJoueur2.add(titreMenu2);
                barreJoueur2.add(Box.createRigidArea(new Dimension(1,30)));
                
                for (int i=0; i<4; i++){
                    
                    listeLabel[i] = new JLabel();
                    listeLabel[i].setFont(new Font("Arial", Font.BOLD, 16));
                    listeLabel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                    barreJoueur2.add(listeLabel[i]);
                    barreJoueur2.add(Box.createRigidArea(new Dimension(1,30)));
                } 
            
            barreJoueur3 = new JPanel();
            barreJoueur3.setLayout(new BoxLayout(barreJoueur3, BoxLayout.Y_AXIS));
            barreJoueur3.setMaximumSize(new Dimension(500,300));
                
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
                
        menuJoueur.add(Box.createVerticalStrut(30));
        menuJoueur.add(titreMenu);
        
        menuJoueur.add(barreJoueur1);
        
        JButton valide = new JButton("Valider");
        valide.setMaximumSize(dim);
        valide.setAlignmentX(Component.CENTER_ALIGNMENT);
        valide.addActionListener(new ValideMenuJoueur());
        
        menuJoueur.add(valide);
        menuJoueur.add(Box.createVerticalStrut(30));

    }
    
    public void CreationMenuJeu(){
        
        menuJeu = new JPanel();
        menuJeu.setLayout(new BoxLayout(menuJeu, BoxLayout.Y_AXIS));
 
        menuJeuNorth = new JPanel();
        menuJeuNorth.setLayout(new BoxLayout(menuJeuNorth, BoxLayout.X_AXIS));
        menuJeuNorth.setMaximumSize(new Dimension(800,500));
        
        menuJeuCenter = new Grille();
        menuJeuCenter.setJeu(jeu);
        
        menuJeuWest = new JPanel();
        menuJeuWest.setMaximumSize(new Dimension(500,500));
       
        menuJeuEast = new JPanel();
        menuJeuEast.setMaximumSize(new Dimension(300,500));
        menuJeuEast.setLayout(new BoxLayout(menuJeuEast, BoxLayout.Y_AXIS));
        
            
            Font police = new Font("Arial", Font.BOLD, 30);
            titreMenuJeu.setText("Tour " + Integer.toString(jeu.compteurTour +1));
            titreMenuJeu.setFont(police);
            titreMenuJeu.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            menuJeuEast.add(Box.createRigidArea(new Dimension(100,50)));
            menuJeuEast.add(titreMenuJeu);
            menuJeuEast.add(Box.createRigidArea(new Dimension(100,50)));
        
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                listeLabelJeu[2*i] = new JLabel();
                listeLabelJeu[2*i+1] = new JLabel();
                listeLabelJeu[2*i].setText(jeu.listeJoueur.get(i).nom);
                listeLabelJeu[2*i].setAlignmentX(Component.CENTER_ALIGNMENT);
                listeLabelJeu[2*i+1].setText(Integer.toString(jeu.listeJoueur.get(i).score));
                listeLabelJeu[2*i+1].setAlignmentX(Component.CENTER_ALIGNMENT);
                
                if (jeu.compteurTour % jeu.listeJoueur.size() == i){
                    listeLabelJeu[2*i].setFont(new Font("Arial", Font.BOLD,20));
                }
                else{
                    listeLabelJeu[2*i].setFont(new Font("Arial", Font.PLAIN, 16));
                }
                menuJeuEast.add(listeLabelJeu[2*i]);
                menuJeuEast.add(Box.createRigidArea(new Dimension(100,10)));
                menuJeuEast.add(listeLabelJeu[2*i+1]);
                menuJeuEast.add(Box.createRigidArea(new Dimension(100,25)));
            }
        
        menuJeuSouth = new JPanel();
        menuJeuSouth.setSize(800,100);
        menuJeuSouth.setLayout(new BoxLayout(menuJeuSouth, BoxLayout.X_AXIS));
        
            boolean check = true;
        
            boutonJaune = new JButton("Jaune");
            boutonJaune.setMaximumSize(dim2);
            boutonJaune.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonJaune.addActionListener(new ChoixCouleurJaune());
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                if(jeu.listeJoueur.get(i).couleur.equals("j")){
                    check = false;
                }
            } 
            
            if(check){
                boutonJaune.setBackground(Color.YELLOW);
            }
            
            else{
                boutonJaune.setBackground(Color.BLACK);
            }
            
            
            boutonRouge = new JButton("Rouge");
            boutonRouge.setMaximumSize(dim2);
            boutonRouge.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonRouge.addActionListener(new ChoixCouleurRouge());
            
            check = true;
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                if(jeu.listeJoueur.get(i).couleur.equals("r")){
                    check = false;
                }
            } 
            
            if(check){
                boutonRouge.setBackground(Color.RED);
            }
            
            else{
                boutonRouge.setBackground(Color.BLACK);
            }
            
            boutonVert = new JButton("Vert");
            boutonVert.setMaximumSize(dim2);
            boutonVert.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonVert.addActionListener(new ChoixCouleurVert());
            
            check = true;
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                if(jeu.listeJoueur.get(i).couleur.equals("v")){
                    check = false;
                }
            } 
            
            if(check){
                boutonVert.setBackground(Color.GREEN);
            }
            
            else{
                boutonVert.setBackground(Color.BLACK);
            }
            
            boutonBleu = new JButton("Bleu");
            boutonBleu.setMaximumSize(dim2);
            boutonBleu.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonBleu.addActionListener(new ChoixCouleurBleu());
            
            check = true;
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                if(jeu.listeJoueur.get(i).couleur.equals("b")){
                    check = false;
                }
            } 
            
            if(check){
                boutonBleu.setBackground(Color.BLUE);
            }
            
            else{
                boutonBleu.setBackground(Color.BLACK);
            }
            
            boutonOrange = new JButton("Orange");
            boutonOrange.setMaximumSize(dim2);
            boutonOrange.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonOrange.addActionListener(new ChoixCouleurOrange());
            
            check = true;
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                if(jeu.listeJoueur.get(i).couleur.equals("o")){
                    check = false;
                }
            } 
            
            if(check){
                boutonOrange.setBackground(Color.ORANGE);
            }
            
            else{
                boutonOrange.setBackground(Color.BLACK);
            }
            
            boutonViolet = new JButton("Violet");
            boutonViolet.setMaximumSize(dim2);
            boutonViolet.setAlignmentX(Component.CENTER_ALIGNMENT);
            boutonViolet.addActionListener(new ChoixCouleurViolet());
            
            check = true;
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                if(jeu.listeJoueur.get(i).couleur.equals("n")){
                    check = false;
                }
            } 
            
            if(check){
                boutonViolet.setBackground(Color.MAGENTA);
            }
            
            else{
                boutonViolet.setBackground(Color.BLACK);
            }
            
            
            menuJeuSouth.add(boutonJaune);
            menuJeuSouth.add(Box.createRigidArea(new Dimension(15,25)));
            menuJeuSouth.add(boutonRouge);
            menuJeuSouth.add(Box.createRigidArea(new Dimension(15,25)));
            menuJeuSouth.add(boutonVert);
            menuJeuSouth.add(Box.createRigidArea(new Dimension(15,25)));
            menuJeuSouth.add(boutonBleu);
            menuJeuSouth.add(Box.createRigidArea(new Dimension(15,25)));
            menuJeuSouth.add(boutonOrange);
            menuJeuSouth.add(Box.createRigidArea(new Dimension(15,25)));
            menuJeuSouth.add(boutonViolet);
            
        
        menuJeuNorth.add(menuJeuCenter);
        
        menuJeuNorth.add(menuJeuEast);
        menuJeuNorth.add(Box.createRigidArea(new Dimension(100,1)));
        
           
        menuJeu.add(menuJeuNorth);
        menuJeu.add(menuJeuSouth);
        
        
        this.setContentPane(menuJeu);  
    }
    
    public void CreationPanelFinJeu(String nom){
        
        panelFinJeu.setLayout(new BoxLayout(panelFinJeu, BoxLayout.Y_AXIS));
        
        Font police = new Font("Arial", Font.BOLD, 36);
        JLabel titreMenu = new JLabel (nom + " a gagné la partie");
        titreMenu.setFont(police);
        titreMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelFinJeu.add(Box.createVerticalStrut(250));
        panelFinJeu.add(titreMenu);
    
    }
    
    public void ModifMenuJeu(){
        
        boolean check = true;
        
        titreMenuJeu.setText("Tour " + Integer.toString(jeu.compteurTour+1));
        
        for (int i=0; i<jeu.listeJoueur.size(); i++){
                
            listeLabelJeu[2*i+1].setText(Integer.toString(jeu.listeJoueur.get(i).score));
             
            if (jeu.compteurTour % jeu.listeJoueur.size() == i){
                listeLabelJeu[2*i].setFont(new Font("Arial", Font.BOLD,20));
            }
            else{
                listeLabelJeu[2*i].setFont(new Font("Arial", Font.PLAIN, 16));
            }
        }
            
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            if(jeu.listeJoueur.get(i).couleur.equals("j")){
                check = false;
            }
        } 
            
        if(check){
            boutonJaune.setBackground(Color.YELLOW);
        }
            
        else{
            boutonJaune.setBackground(Color.BLACK);
        }
        
        check = true;
            
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            if(jeu.listeJoueur.get(i).couleur.equals("r")){
                check = false;
            }
        } 
            
        if(check){
            boutonRouge.setBackground(Color.RED);
        }
            
        else{
            boutonRouge.setBackground(Color.BLACK);
        }
        
        check = true;
            
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            if(jeu.listeJoueur.get(i).couleur.equals("b")){
                check = false;
            }
        } 
            
        if(check){
            boutonBleu.setBackground(Color.BLUE);
        }
            
        else{
            boutonBleu.setBackground(Color.BLACK);
        }
        
        check = true;
            
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            if(jeu.listeJoueur.get(i).couleur.equals("o")){
                check = false;
            }
        } 
            
        if(check){
            boutonOrange.setBackground(Color.ORANGE);
        }
            
        else{
            boutonOrange.setBackground(Color.BLACK);
        }
        
        check = true;
            
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            if(jeu.listeJoueur.get(i).couleur.equals("v")){
                check = false;
            }
        } 
            
        if(check){
            boutonVert.setBackground(Color.GREEN);
        }
            
        else{
            boutonVert.setBackground(Color.BLACK);
        }
        
        check = true;
            
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            if(jeu.listeJoueur.get(i).couleur.equals("n")){
                check = false;
            }
        } 
            
        if(check){
            boutonViolet.setBackground(Color.MAGENTA);
        }
            
        else{
            boutonViolet.setBackground(Color.BLACK);
        }
        
        this.repaint();
    }

    public void modifMenuTaille(){
        int tailleGrille = jeu.getTailleGrille();
        String strTailleGrille = Integer.toString(tailleGrille);
        taille.setText(strTailleGrille);
    }
    
    public void modifMenuJoueur(){
        
        for (int i=0; i<jeu.listeJoueur.size(); i++){
                    
            listeLabel[i].setText(jeu.listeJoueur.get(i).nom);
            
        }
    }
    
    public void Sauvegarde() throws IOException{
        jeu.Sauvegarde();
    }
    
    public void CheckFinJeu(){
        
        int scoreMax = (jeu.tailleGrille * jeu.tailleGrille / 2) + 1;
        int compteScore=0;
        int maxScore=0;
        int idMaxScore=0;
        
        for (int i=0; i<jeu.listeJoueur.size(); i++){
            
            compteScore = compteScore + jeu.listeJoueur.get(i).score;
            
            if(jeu.listeJoueur.get(i).score > maxScore){
                maxScore = jeu.listeJoueur.get(i).score;
                idMaxScore = i;
            }
            
            if(jeu.listeJoueur.get(i).score > scoreMax){
                finJeu=1;
                this.getContentPane().removeAll();
                AddPanelFinJeu(jeu.listeJoueur.get(i).nom);
            } 
        } 
        
        if(compteScore == jeu.tailleGrille * jeu.tailleGrille){
            finJeu = 1;
            this.getContentPane().removeAll();
            AddPanelFinJeu(jeu.listeJoueur.get(idMaxScore).nom);
        }
    }
    
    public void AddPanelFinJeu(String nom){
        CreationPanelFinJeu(nom);
        this.add(panelFinJeu);
        this.validate();
        this.repaint();
        
    }
    
    public void RemoveAll(){
        this.getContentPane().removeAll();
        
    }
    
    public void ChargeSauvegarde() throws IOException, ClassNotFoundException, FileNotFoundException{
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("jeu.tmp"))) { 
        jeu = (Jeu) input.readObject();
        RemoveMenu();
        CreationMenuJeu();
        AddMenuJeu();
}
        
    }
    
    class Bouton1Listener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            RemoveMenu();
            jeu.CreationGrille();
            jeu.CelluleVoisineCarre();
            jeu.CheckCouleurVoisin();
            jeu.AddNewJoueur("Vous");
            jeu.AddNewIa(3);
            jeu.AddCouleurJoueur();
            CreationMenuJeu();
            RemoveMenuJoueur();
            AddMenuJeu();
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
            
            try {
                ChargeSauvegarde();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    class RetourHome implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            
            RemoveAll();
            AddMenu();
            
 
        }
    }
    
    class Sauvegarde implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            try {
                Sauvegarde();
            } catch (IOException ex) {
                Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class Mute implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            menuBar1.remove(mute);
            menuBar1.add(unmute);
            music.stop();
        }
    }
    
    class Unmute implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            menuBar1.remove(unmute);
            menuBar1.add(mute);
            music=new Music();
            music.start();
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
            jeu.CheckCouleurVoisin();
            RemoveMenuForme();
            AddMenuJoueur();
        }
    }
    
    class FormeLosangeListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.CelluleVoisineLosange();
            jeu.CheckCouleurVoisin();
            RemoveMenuForme();
            AddMenuJoueur();
        }
    }
    
    class FormeHexagonaleListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            jeu.CelluleVoisineHexagone();
            jeu.CheckCouleurVoisin();
            RemoveMenuForme();
            AddMenuJoueur();
        }
    }
    
    class AjoutJoueur implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String nomJoueur = txtJoueur.getText();
            jeu.AddNewJoueur(nomJoueur);
            modifMenuJoueur();
            
        }
    }
    
    class AjoutIA1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(!jeu.listeJoueur.isEmpty()){
                jeu.AddNewIa(1);
                modifMenuJoueur();
            }
        }
    }
    
    class AjoutIA2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(!jeu.listeJoueur.isEmpty()){
                jeu.AddNewIa(2);
                modifMenuJoueur();
            }
        }
    }
    
    class AjoutIA3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(!jeu.listeJoueur.isEmpty()){
                jeu.AddNewIa(3);
                modifMenuJoueur();
            }
        }
    }
    
    class ValideMenuJoueur implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if (jeu.listeJoueur.size()>1){
                 
                jeu.AddCouleurJoueur();
                CreationMenuJeu();
                RemoveMenuJoueur();
                AddMenuJeu();
                
            }   
        }
    }
    
    class ChoixCouleurJaune implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            boolean check = true;
            String str = "j";
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                if(str.equals(jeu.listeJoueur.get(i).couleur)){
                    check = false;
                }
            }
            
            if(check){
                
                jeu.GainTerritoire(jeu.compteurTour, str);
                CheckFinJeu();
                jeu.compteurTour=jeu.compteurTour+1;
                while(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA != 0 && finJeu==0){
                    
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 1 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA1(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 2 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA2(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 3 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA3(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                }
                ModifMenuJeu();
                
            }
            
            else{
                
            }
            
        }
    }
    
    class ChoixCouleurViolet implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            boolean check = true;
            String str = "n";
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                if(str.equals(jeu.listeJoueur.get(i).couleur)){
                    check = false;
                }
            }
            
            if(check){
                
                jeu.GainTerritoire(jeu.compteurTour, str);
                CheckFinJeu();
                jeu.compteurTour=jeu.compteurTour+1;
                while(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA != 0 && finJeu==0){
                    
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 1 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA1(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 2 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA2(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 3 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA3(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                }
                ModifMenuJeu();
                
            }
            
            else{
                
            }
            
        }
    }
    
    class ChoixCouleurRouge implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            boolean check = true;
            String str = "r";
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                if(str.equals(jeu.listeJoueur.get(i).couleur)){
                    check = false;
                }
            }
            
            if(check){
                
                jeu.GainTerritoire(jeu.compteurTour, str);
                CheckFinJeu();
                jeu.compteurTour=jeu.compteurTour+1;
                while(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA != 0 && finJeu==0){
                    
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 1 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA1(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 2 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA2(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 3 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA3(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                }
                ModifMenuJeu();
                
            }
            
            else{
                
            }
            
        }
    }
      
    class ChoixCouleurVert implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            boolean check = true;
            String str = "v";
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                if(str.equals(jeu.listeJoueur.get(i).couleur)){
                    check = false;
                }
            }
            
            if(check){
                
                jeu.GainTerritoire(jeu.compteurTour, str);
                CheckFinJeu();
                jeu.compteurTour=jeu.compteurTour+1;
                while(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA != 0 && finJeu==0){
                    
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 1 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA1(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 2 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA2(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 3 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA3(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                }
                ModifMenuJeu();
                
            }
            
            else{
                
            }
            
        }
    }
    
    class ChoixCouleurOrange implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            boolean check = true;
            String str = "o";
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                if(str.equals(jeu.listeJoueur.get(i).couleur)){
                    check = false;
                }
            }
            
            if(check){
                
                jeu.GainTerritoire(jeu.compteurTour, str);
                CheckFinJeu();
                if(finJeu==0){
                jeu.compteurTour=jeu.compteurTour+1;
                while(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA != 0 && finJeu==0){
                    
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 1 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA1(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 2 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA2(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 3 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA3(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                }
                ModifMenuJeu();
                }
            }
            
            else{
                
            }
            
        }
    }
    
    class ChoixCouleurBleu implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            boolean check = true;
            String str = "b";
            
            for (int i=0; i<jeu.listeJoueur.size(); i++){
                
                if(str.equals(jeu.listeJoueur.get(i).couleur)){
                    check = false;
                }
            }
            
            if(check){
                
                
                jeu.GainTerritoire(jeu.compteurTour, str);
                CheckFinJeu();
                jeu.compteurTour=jeu.compteurTour+1; 
                
                while(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA != 0 && finJeu==0){
                    
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 1 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA1(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 2 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA2(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                    if(jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).iA == 3 ){
                        jeu.listeJoueur.get(jeu.compteurTour % jeu.listeJoueur.size()).JeuIA3(jeu, jeu.compteurTour);
                        CheckFinJeu();
                        jeu.compteurTour = jeu.compteurTour+1;
                    }
                }
                ModifMenuJeu();
            }
            
            else{
                
            }
        }
    }
}
