import java.util.ArrayList;
import java.io.Serializable;


public class Joueur implements Serializable {

    String couleur;
    String nom;
    int iA;
    int score;
 
    public Joueur(String nomm){
        couleur = null;
        nom = nomm;
        iA = 0;
        score = 1;
        
    }
    
    public Joueur(Joueur jjoueur){

        couleur = jjoueur.couleur;
        nom = jjoueur.nom;
        iA = jjoueur.iA;
        score = jjoueur.score;
        
    }
    
    public Joueur(int num){
        couleur = null;
        nom = "IA";
        iA = num;
        score = 1;
        
    }
    
    public void AddCouleur(String couleurr){
        
        this.couleur = couleurr;
        
    }
    
    public void JeuIA1(Jeu jeu, int tour){
        
        String choixCouleur;
        
        String couleur1 = "";
        String couleur4 = "";
        String couleur3 = "";
        String couleur2 = "";  
        
        for(int i=0; i<jeu.listeJoueur.size(); i++){
            
            if(i==0){
                couleur1 = jeu.listeJoueur.get(i).couleur;
            }
            
            if(i==1){
                couleur2 = jeu.listeJoueur.get(i).couleur;
            }
            
            if(i==2){
                couleur3 = jeu.listeJoueur.get(i).couleur;
            }
            
            if(i==3){
                couleur4 = jeu.listeJoueur.get(i).couleur;
            }
        }
        
        do{
        
            int x =(int) (Math.random() * 90);
            int compare = 15;

            if (x<=compare){
                choixCouleur = "r";
            }
            else if(x>compare && x<=2*compare){
                choixCouleur = "b";
            }
            else if(x>2*compare && x<=3*compare){
                choixCouleur = "j";
            }
            else if(x>3*compare && x<=4*compare){
                choixCouleur = "v";
            }
            else if(x>4*compare && x<=5*compare){
                choixCouleur = "o";
            }
            else{
                choixCouleur = "n";
            }
        }while(choixCouleur.equals(couleur1) || choixCouleur.equals(couleur2) || choixCouleur.equals(couleur3) || choixCouleur.equals(couleur4));
        
        jeu.GainTerritoire(tour, choixCouleur);
        
    }
    
    public void JeuIA3(Jeu jjeeuu, int tour){
        
        int compteScore = 0;
        int scoreMax = 0;
        int idScoreMax = 0;
        
        String couleur1 = "";
        String couleur4 = "";
        String couleur3 = "";
        String couleur2 = "";        
        
        ArrayList<String> listeCouleur = new ArrayList<String>();
        listeCouleur.add("r");
        listeCouleur.add("o");
        listeCouleur.add("v");
        listeCouleur.add("j");
        listeCouleur.add("b");
        listeCouleur.add("n");
        
        for(int i=0; i<jjeeuu.listeJoueur.size(); i++){
            
            if(i==0){
                couleur1 = jjeeuu.listeJoueur.get(i).couleur;
            }
            
            if(i==1){
                couleur2 = jjeeuu.listeJoueur.get(i).couleur;
            }
            
            if(i==2){
                couleur3 = jjeeuu.listeJoueur.get(i).couleur;
            }
            
            if(i==3){
                couleur4 = jjeeuu.listeJoueur.get(i).couleur;
            }
        }
        
        for(int w=0; w<listeCouleur.size(); w++){
            
            if(!listeCouleur.get(w).equals(couleur1) && !listeCouleur.get(w).equals(couleur2) && !listeCouleur.get(w).equals(couleur3) && !listeCouleur.get(w).equals(couleur4)){
            
                compteScore = 0;
                
                Jeu jeu = new Jeu(jjeeuu);
                
                if(jeu.formeCase == 1){
                    jeu.CelluleVoisineCarre();
                }
                
                if(jeu.formeCase == 2){
                    jeu.CelluleVoisineLosange();
                }
                
                if(jeu.formeCase == 3){
                    jeu.CelluleVoisineHexagone();
                }
                
                ArrayList<Cellule> liste = new ArrayList();
                int ligne = jeu.Gainterritoireauxi(tour);
                int colonne = jeu.Gainterritoireauxj(tour);

                Cellule celluleMere = jeu.grilleCellule[ligne][colonne];
                jeu.grilleCellule[ligne][colonne].verifie = 1;
                int taille = celluleMere.listeVoisin.size();
                for (int i=0; i<taille; i++){
                    liste.add(celluleMere.listeVoisin.get(i));
                    celluleMere.listeVoisin.get(i).verifie=1;
                }
                celluleMere.ChangementCouleur(listeCouleur.get(w));
                jeu.listeJoueur.get(tour % jeu.listeJoueur.size()).couleur = listeCouleur.get(w);
        
                while(!liste.isEmpty()){
                    Cellule cellule = liste.get(0);
                    taille = cellule.listeVoisin.size();
            
                    if(cellule.territoire == 0){
                
                        if(cellule.couleur.equals(celluleMere.couleur)){
                            cellule.ChangementTerritoire(tour % jeu.listeJoueur.size());
                            compteScore = compteScore + 1;
                        
                            for (int i=0; i<taille; i++){
                          
                                if(cellule.listeVoisin.get(i).verifie == 0){
                    
                                liste.add(cellule.listeVoisin.get(i));
                                cellule.listeVoisin.get(i).verifie = 1;
                        
                                }
                            }       
                        }   
                
                        else{
                            cellule.verifie = 1; 
                        }
                    }

                    else if(cellule.territoire == celluleMere.territoire){
                
                        cellule.ChangementCouleur(couleur);
                
                        for (int i=0; i<taille; i++){

                            if(cellule.listeVoisin.get(i).verifie == 0){

                                liste.add(cellule.listeVoisin.get(i));
                                cellule.listeVoisin.get(i).verifie = 1;
                            }
                        }
                    }

                    else{

                        cellule.verifie = 1;
                    }  

                    liste.remove(0);
                }

                for (int i=0; i<jeu.tailleGrille; i++){
                    for (int j=0; j<jeu.tailleGrille; j++){
                        jeu.grilleCellule[i][j].verifie = 0;
                    }
                }
                
                if(compteScore > scoreMax){
                   scoreMax = compteScore;
                   idScoreMax = w;
                }
                    
            }
                
        }
        
        while(!(!listeCouleur.get(idScoreMax).equals(couleur1) && !listeCouleur.get(idScoreMax).equals(couleur2) && !listeCouleur.get(idScoreMax).equals(couleur3) && !listeCouleur.get(idScoreMax).equals(couleur4))){
            
            idScoreMax = idScoreMax + 1;
            
        }
        
        jjeeuu.GainTerritoire(tour, listeCouleur.get(idScoreMax)); 
            
    }
    
    public void JeuIA2(Jeu jjeeuu, int toour){
        
        int compteScore = 0;
        int scoreMax = 0;
        int idScoreMax = 0;
        int tour = toour+1;
        
        String couleur1 = "";
        String couleur4 = "";
        String couleur3 = "";
        String couleur2 = "";        
        
        ArrayList<String> listeCouleur = new ArrayList<String>();
        listeCouleur.add("r");
        listeCouleur.add("o");
        listeCouleur.add("v");
        listeCouleur.add("j");
        listeCouleur.add("b");
        listeCouleur.add("n");
        
        for(int i=0; i<jjeeuu.listeJoueur.size(); i++){
            
            if(i==0){
                couleur1 = jjeeuu.listeJoueur.get(i).couleur;
            }
            
            if(i==1){
                couleur2 = jjeeuu.listeJoueur.get(i).couleur;
            }
            
            if(i==2){
                couleur3 = jjeeuu.listeJoueur.get(i).couleur;
            }
            
            if(i==3){
                couleur4 = jjeeuu.listeJoueur.get(i).couleur;
            }
        }
        
        for(int w=0; w<listeCouleur.size(); w++){
            
            if( !listeCouleur.get(w).equals(couleur1) && !listeCouleur.get(w).equals(couleur2) && !listeCouleur.get(w).equals(couleur3) && !listeCouleur.get(w).equals(couleur4)){
            
                compteScore = 0;
                
                Jeu jeu = new Jeu(jjeeuu);
                
                if(jeu.formeCase == 1){
                    jeu.CelluleVoisineCarre();
                }
                
                if(jeu.formeCase == 2){
                    jeu.CelluleVoisineLosange();
                }
                
                if(jeu.formeCase == 3){
                    jeu.CelluleVoisineHexagone();
                }
                
                ArrayList<Cellule> liste = new ArrayList();
                int ligne = jeu.Gainterritoireauxi(tour);
                int colonne = jeu.Gainterritoireauxj(tour);

                Cellule celluleMere = jeu.grilleCellule[ligne][colonne];
                jeu.grilleCellule[ligne][colonne].verifie = 1;
                int taille = celluleMere.listeVoisin.size();
                for (int i=0; i<taille; i++){
                    liste.add(celluleMere.listeVoisin.get(i));
                    celluleMere.listeVoisin.get(i).verifie=1;
                }
                celluleMere.ChangementCouleur(listeCouleur.get(w));
                jeu.listeJoueur.get(tour % jeu.listeJoueur.size()).couleur = listeCouleur.get(w);
        
                while(!liste.isEmpty()){
                    Cellule cellule = liste.get(0);
                    taille = cellule.listeVoisin.size();
            
                    if(cellule.territoire == 0){
                
                        if(cellule.couleur.equals(celluleMere.couleur)){
                            cellule.ChangementTerritoire(tour % jeu.listeJoueur.size());
                            compteScore = compteScore + 1;
                        
                            for (int i=0; i<taille; i++){
                          
                                if(cellule.listeVoisin.get(i).verifie == 0){
                    
                                liste.add(cellule.listeVoisin.get(i));
                                cellule.listeVoisin.get(i).verifie = 1;
                        
                                }
                            }       
                        }   
                
                        else{
                            cellule.verifie = 1; 
                        }
                    }

                    else if(cellule.territoire == celluleMere.territoire){
                
                        cellule.ChangementCouleur(couleur);
                
                        for (int i=0; i<taille; i++){

                            if(cellule.listeVoisin.get(i).verifie == 0){

                                liste.add(cellule.listeVoisin.get(i));
                                cellule.listeVoisin.get(i).verifie = 1;
                            }
                        }
                    }

                    else{

                        cellule.verifie = 1;
                    }  

                    liste.remove(0);
                }

                for (int i=0; i<jeu.tailleGrille; i++){
                    for (int j=0; j<jeu.tailleGrille; j++){
                        jeu.grilleCellule[i][j].verifie = 0;
                    }
                }
                
                if(compteScore > scoreMax){
                   scoreMax = compteScore;
                   idScoreMax = w;
                }
                    
            }
                
        }
        
        while(!(!listeCouleur.get(idScoreMax).equals(couleur1) && !listeCouleur.get(idScoreMax).equals(couleur2) && !listeCouleur.get(idScoreMax).equals(couleur3) && !listeCouleur.get(idScoreMax).equals(couleur4))){
            
            idScoreMax = idScoreMax + 1;
            
        }
        
        jjeeuu.GainTerritoire(toour, listeCouleur.get(idScoreMax)); 
            
    }
}

