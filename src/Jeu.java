import java.util.ArrayList;
public class Jeu {
	
    public Cellule [][] grilleCellule;
    public ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
    public int tailleGrille;
    public int formeCase;

    public Jeu(){
        tailleGrille = 13;
    }
    
    public void DiminueTaille(){
        
        if (tailleGrille>10){
            tailleGrille = tailleGrille - 1;
        }
        
    }
    
    public void AugmentTaille(){
        
        if(tailleGrille<15){
            tailleGrille = tailleGrille + 1;
        }
        
    }
    
    public void CreationGrille(){
        
        this.grilleCellule = new Cellule[tailleGrille][tailleGrille];
        
        for(int i=0; i<this.tailleGrille; i++){
            for(int j=0; j<this.tailleGrille; j++){
                
                this.grilleCellule[i][j]= new Cellule();
                
            }
        }
        
        String couleur1 = grilleCellule[0][0].getCouleur();
        String couleur2 = grilleCellule[this.tailleGrille - 1][0].getCouleur();
        String couleur3 = grilleCellule[0][this.tailleGrille - 1].getCouleur();
        String couleur4 = grilleCellule[this.tailleGrille - 1][this.tailleGrille - 1].getCouleur();
                
        while(couleur2.equals(couleur1)){
            grilleCellule[this.tailleGrille - 1][0].ChangementCouleurRandom();
            couleur2 = grilleCellule[this.tailleGrille - 1][0].getCouleur();
        }
        
        while(couleur3.equals(couleur1) && couleur3.equals(couleur2)){
            grilleCellule[0][this.tailleGrille - 1].ChangementCouleurRandom();
            couleur3 = grilleCellule[0][this.tailleGrille - 1].getCouleur();
        }
        
        while(couleur4.equals(couleur1) && couleur4.equals(couleur2) && couleur4.equals(couleur3)){
            grilleCellule[this.tailleGrille - 1][this.tailleGrille - 1].ChangementCouleurRandom();
            couleur4 = grilleCellule[this.tailleGrille - 1][this.tailleGrille - 1].getCouleur();
        }
    }
    public int Gainterritoireauxi(int tour){
        int i=0;
        int j=0;
        switch( tour % listeJoueur.size()){
            case 0 :
                i=0;
                j=0;
            case 1 :
                i=tailleGrille;
                j=tailleGrille;
            case 2 :
                i=tailleGrille;
                j=0;
            case 3 :
                i=0;
                j=tailleGrille;
        }
        return(i);
    }
    public int Gainterritoireauxj(int tour){
        int i=0;
        int j=0;
        switch( tour % listeJoueur.size()){
            case 0 :
                i=0;
                j=0;
            case 1 :
                i=tailleGrille;
                j=tailleGrille;
            case 2 :
                i=tailleGrille;
                j=0;
            case 3 :
                i=0;
                j=tailleGrille;
        }
        return(j);
    }
    
     public void GainTerritoire(int tour, String couleur){
        
        ArrayList<Cellule> liste = new ArrayList();
        Cellule celluleMere = this.grilleCellule[Gainterritoireauxi(tour)][Gainterritoireauxj(tour)];
        int taille = celluleMere.listeVoisin.size();
        for (int i=0; i<taille; i++){
            liste.add(celluleMere.listeVoisin.get(i));
        }
        celluleMere.ChangementCouleur(couleur);
        
        while(!liste.isEmpty()){
            Cellule cellule = liste.get(0);
            taille = cellule.listeVoisin.size();
            
            if(cellule.territoire == 0){
                if(cellule.couleur.equals(celluleMere.couleur)){
                    cellule.ChangementTerritoire(tour % listeJoueur.size());
                    
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
           
            
            
        }
        
    }
    
    
    public void CelluleVoisineCarre(){
        
        this.formeCase = 1;
		
        for(int i=0; i<this.tailleGrille; i++){
            for(int j=0; j<this.tailleGrille; j++){
	 
                if(i != 0){
                    this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j]);
                }
                
                if(i != this.tailleGrille - 1){
                    this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j]);
                }
                
                if(j != 0){
                    this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i][j-1]);
                }
                
                if(j != this.tailleGrille - 1){
                    this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i][j+1]);
                }
            }
        }
    }
    
    public void CelluleVoisineLosange(){
        
        this.formeCase = 2;
		 
	for(int i=0; i<this.tailleGrille; i++){
            for(int j=0; j<this.tailleGrille; j++){
	 
                if (i % 2 == 0){
                    
                    if(i != 0 && j != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j-1]);
                    }
                    
                    if(i != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j]);
                    }
                    
                    if(i != this.tailleGrille - 1 && j != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j-1]);
                    }   
                    
                    if(i != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j]);
                    }
                }
                
                else{
                    
                    if(i != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j]);
                    }
                    
                    if(i != 0 && j != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j+1]);
                    }
                    
                    if(i != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j]);
                    }   
                    
                    if(i != this.tailleGrille - 1 && j != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j+1]);
                    }
                }
            }
        }	
    }
    
    public void CelluleVoisineHexagone(){
        
        this.formeCase = 3;
		
	for(int i=0; i<this.tailleGrille; i++){
            for(int j=0; j<this.tailleGrille; j++){
	 
                if (i % 2 == 0){
                    
                    if(i != 0 && j != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j-1]);
                    }
                    
                    if(i != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j]);
                    }
                    
                    if(i != this.tailleGrille - 1 && j != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j-1]);
                    }   
                    
                    if(i != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j]);
                    }
                    
                    if(j != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i][j-1]);
                    }
                    
                    if(j != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i][j+1]);
                    }
                }
                
                else{
                    
                    if(i != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j]);
                    }
                    
                    if(i != 0 && j != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i-1][j+1]);
                    }
                    
                    if(i != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j]);
                    }   
                    
                    if(i != this.tailleGrille - 1 && j != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i+1][j+1]);
                    }
                    
                    if(j != 0){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i][j-1]);
                    }
                    
                    if(j != this.tailleGrille - 1){
                        this.grilleCellule[i][j].listeVoisin.add(this.grilleCellule[i][j+1]);
                    }
                }
            }
        }
    }
    
    public void AddNewJoueur(String nom){
        
        if(listeJoueur.size()<4){
            listeJoueur.add(new Joueur(nom));
        }
    }
    
    public void AddNewIa(int num){
        
        if(listeJoueur.size()<4){
            listeJoueur.add(new Joueur(num));
        }
    }
    
    public int getTailleGrille(){
        return tailleGrille;
    }
    
    public void AddCouleurJoueur(){
        
        for(int i=0; i<listeJoueur.size(); i++){
            switch(i){
                case 1 : 
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[0][0].couleur);
            
                case 2 :
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[tailleGrille-1][tailleGrille-1].couleur);
                
                case 3 :
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[tailleGrille-1][0].couleur);
                case 4 :
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[0][tailleGrille-1].couleur);
            }
        }
    }
}
