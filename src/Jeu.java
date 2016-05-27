import java.util.ArrayList;
public class Jeu {
	
    public Cellule [][] grilleCellule;
    public ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
    public int tailleGrille;
    public int formeCase;

    public Jeu(){
        tailleGrille = 13;
    }
    
    public Jeu(Jeu jeuuu){
        tailleGrille = jeuuu.tailleGrille;
        formeCase = jeuuu.formeCase;
        grilleCellule = new Cellule[tailleGrille][tailleGrille];
        
        for(int i=0; i<tailleGrille; i++){
            for(int j=0; j<tailleGrille; j++){
                
                grilleCellule[i][j] = new Cellule(jeuuu.grilleCellule[i][j]);
                
            }
        }
        listeJoueur = new ArrayList<Joueur>();
        
        for (int i=0; i<jeuuu.listeJoueur.size(); i++){
            listeJoueur.add(new Joueur(jeuuu.listeJoueur.get(i)));
        }
                
    }
    
    public Jeu(int x){
        tailleGrille = 10;
        grilleCellule = new Cellule[tailleGrille][tailleGrille];
        
        for(int i=0; i<tailleGrille; i++){
            for(int j=0; j<this.tailleGrille; j++){
                
                this.grilleCellule[i][j]= new Cellule();
                
            }
        }
        
        formeCase = 1;
        
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
        
        while(couleur3.equals(couleur1) || couleur3.equals(couleur2)){
            grilleCellule[0][this.tailleGrille - 1].ChangementCouleurRandom();
            couleur3 = grilleCellule[0][this.tailleGrille - 1].getCouleur();
        }
        
        while(couleur4.equals(couleur1) || couleur4.equals(couleur2) || couleur4.equals(couleur3)){
            grilleCellule[this.tailleGrille - 1][this.tailleGrille - 1].ChangementCouleurRandom();
            couleur4 = grilleCellule[this.tailleGrille - 1][this.tailleGrille - 1].getCouleur();
        }
    }
    public int Gainterritoireauxi(int tour){
        int i=0;
        int compare = tour % this.listeJoueur.size();
        
        if(compare == 0){
            i=0;
        }
        
        if(compare == 1){
            i=this.tailleGrille - 1;
        }
        
        if(compare == 2){
            i=this.tailleGrille - 1;
        }
        
        if(compare == 3){
            i=0;
        }
        
        return i;
    }
    public int Gainterritoireauxj(int tour){
        int j=0;
        int compare = tour % this.listeJoueur.size();
        
        if(compare == 0){
            j=0;
        }
        
        if(compare == 1){
            j=this.tailleGrille - 1;
        }
        
        if(compare == 2){
            j=0;
        }
        
        if(compare == 3){
            j=this.tailleGrille - 1;
        }
        
        return j;
    }
    
     public void GainTerritoire(int tour, String couleur){
        
        ArrayList<Cellule> liste = new ArrayList();
        int ligne = Gainterritoireauxi(tour);
        int colonne = Gainterritoireauxj(tour);

        Cellule celluleMere = this.grilleCellule[ligne][colonne];
        this.grilleCellule[ligne][colonne].verifie = 1;
        int taille = celluleMere.listeVoisin.size();
        for (int i=0; i<taille; i++){
            liste.add(celluleMere.listeVoisin.get(i));
            celluleMere.listeVoisin.get(i).verifie=1;
        }
        celluleMere.ChangementCouleur(couleur);
        this.listeJoueur.get(tour % listeJoueur.size()).couleur = couleur;
        
        while(!liste.isEmpty()){
            Cellule cellule = liste.get(0);
            taille = cellule.listeVoisin.size();
            
            if(cellule.territoire == 0){
                
                if(cellule.couleur.equals(celluleMere.couleur)){
                    cellule.ChangementTerritoire(tour % listeJoueur.size());
                    this.listeJoueur.get(tour % listeJoueur.size()).score = this.listeJoueur.get(tour % listeJoueur.size()).score +1;
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
        
        for (int i=0; i<tailleGrille; i++){
            for (int j=0; j<tailleGrille; j++){
                this.grilleCellule[i][j].verifie = 0;
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
    
    public void CheckCouleurVoisin(){
        
        String couleur1 = grilleCellule[0][0].getCouleur();
        String couleur2 = grilleCellule[this.tailleGrille - 1][0].getCouleur();
        String couleur3 = grilleCellule[0][this.tailleGrille - 1].getCouleur();
        String couleur4 = grilleCellule[this.tailleGrille - 1][this.tailleGrille - 1].getCouleur();
        
        for (int i=0; i<grilleCellule[0][0].listeVoisin.size(); i++){
            
            while(grilleCellule[0][0].listeVoisin.get(i).couleur.equals(couleur1)){
                
               grilleCellule[0][0].listeVoisin.get(i).ChangementCouleurRandom();
                
            }
            
        }
        
        for (int i=0; i<grilleCellule[tailleGrille-1][tailleGrille-1].listeVoisin.size(); i++){
            
            while(grilleCellule[tailleGrille-1][tailleGrille-1].listeVoisin.get(i).couleur.equals(couleur4)){
                
               grilleCellule[tailleGrille-1][tailleGrille-1].listeVoisin.get(i).ChangementCouleurRandom();
                
            }
            
        }
        
        for (int i=0; i<grilleCellule[tailleGrille-1][0].listeVoisin.size(); i++){
            
            while(grilleCellule[tailleGrille-1][0].listeVoisin.get(i).couleur.equals(couleur2)){
                
               grilleCellule[tailleGrille-1][0].listeVoisin.get(i).ChangementCouleurRandom();
                
            }
            
        }
        
        for (int i=0; i<grilleCellule[0][tailleGrille-1].listeVoisin.size(); i++){
            
            while(grilleCellule[0][tailleGrille-1].listeVoisin.get(i).couleur.equals(couleur3)){
                
               grilleCellule[0][tailleGrille-1].listeVoisin.get(i).ChangementCouleurRandom();
                
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
            if(i==0){ 
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[0][0].couleur);
                    this.grilleCellule[0][0].territoire=1;
            }
            if(i==1){
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[tailleGrille-1][tailleGrille-1].couleur);
                    this.grilleCellule[tailleGrille-1][tailleGrille-1].territoire=2;
            }        
                    
            if(i == 2){
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[tailleGrille-1][0].couleur);
                    this.grilleCellule[tailleGrille-1][0].territoire=3;
            }
            
            if(i == 3){
                    this.listeJoueur.get(i).AddCouleur(this.grilleCellule[0][tailleGrille-1].couleur);
                    this.grilleCellule[0][tailleGrille-1].territoire=4;
            }
        }
    }
}
