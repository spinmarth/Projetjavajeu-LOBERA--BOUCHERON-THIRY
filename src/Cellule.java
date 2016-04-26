import java.util.ArrayList;
public class Cellule {

	String couleur;
	int territoire;
	int verifie;
	ArrayList listeVoisin;
	
	public Cellule(){
		territoire = 0;
		verifie = 0;
		listeVoisin = null;
		
		double x = Math.random();
		double compare = 1/6;
		
		if (x<=compare){
			couleur = "r";
		}
		else if(x>compare && x<=2*compare){
			couleur = "b";
		}
		else if(x>2*compare && x<=3*compare){
			couleur = "j";
		}
		else if(x>3*compare && x<=4*compare){
			couleur = "v";
		}
		else if(x>4*compare && x<=5*compare){
			couleur = "o";
		}
		else{
			couleur = "n";
		}
	}
	
	public void CelluleVoisineCarre(Cellule[][] grille, int colonne, int ligne){
		
		int longueur = grille.length;
		int hauteur = grille[0].length; 
		
		grille[ligne][colonne].listeVoisin = new ArrayList<Cellule>();
		 
		if(ligne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne-1][colonne]);
		}
		
		if(ligne != hauteur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne+1][colonne]);
		}
		
		if(colonne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne][colonne-1]);
		}
		
		if(colonne != longueur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne][colonne+1]);
		}
		
	}
	
	public void CelluleVoisineLosange(Cellule[][] grille, int colonne, int ligne){
		
		int longueur = grille.length;
		int hauteur = grille[0].length; 
		
		grille[ligne][colonne].listeVoisin = new ArrayList<Cellule>();
		 
		if(ligne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne-1][colonne]);
		}
		
		if(ligne != hauteur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne+1][colonne]);
		}
		
		if(colonne != longueur && ligne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne-1][colonne+1]);
		}
		
		if(colonne != longueur && ligne != hauteur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne+1][colonne+1]);
		}
		
	}
	
        
        public void CelluleVoisineHexagone(Cellule[][] grille, int colonne, int ligne){
		
		int longueur = grille.length;
		int hauteur = grille[0].length; 
		
		grille[ligne][colonne].listeVoisin = new ArrayList<Cellule>();
		 
		if(ligne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne-1][colonne]);
		}
		
		if(ligne != hauteur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne+1][colonne]);
		}
		
		if(colonne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne][colonne-1]);
		}
		
		if(colonne != longueur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne][colonne+1]);
		}
		
                if(colonne != longueur && ligne != 0){
			grille[ligne][colonne].listeVoisin.add(grille[ligne-1][colonne+1]);
		}
		
		if(colonne != longueur && ligne != hauteur){
			grille[ligne][colonne].listeVoisin.add(grille[ligne+1][colonne+1]);
		}
	}
        
        public void ChangementCouleur(String couleur){
            
            this.couleur=couleur;
            this.verifie=1;
            
        }
        
        public void ChangementTerritoire(){
            
            this.territoire=1;
            this.verifie=1;
            
        }
        
        
}
