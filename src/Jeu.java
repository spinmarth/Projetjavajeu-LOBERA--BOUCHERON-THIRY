import java.util.ArrayList;
public class Jeu {
	
    public Cellule [][] grilleCellule;
    public Joueur [] listeJoueur = new Joueur[4];
    public int tailleGrille;

    public Jeu(){
        tailleGrille = 13;
    }
    
    public void DiminueTaille(){
        
        if (tailleGrille>7){
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
    
    public void GainTerritoire(int numeroJoueur, String couleur){
        
        ArrayList<Cellule> liste = new ArrayList();
        Cellule celluleMere = this.grilleCellule[this.listeJoueur[numeroJoueur].ligneTerritoire][this.listeJoueur[numeroJoueur].colonneTerritoire];
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
                    cellule.ChangementTerritoire(numeroJoueur);
                    
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
    
    public void CreationListeJoueur(){
        
        for(int i=0; i<this.listeJoueur.length; i++){
            
            listeJoueur[i] = new Joueur();
        }
    }
    
    public int getTailleGrille(){
        return tailleGrille;
    }
}
