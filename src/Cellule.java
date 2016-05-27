import java.util.ArrayList;
public class Cellule {

    String couleur;
    int territoire;
    int verifie;
    ArrayList<Cellule> listeVoisin;
	
    public Cellule(){
    	territoire = 0;
	verifie = 0;
	listeVoisin = new ArrayList<Cellule>();
	
	int x =(int) (Math.random() * 90);
	int compare = 15;
	
	if (x<=compare){
            this.couleur = "r";
	}
	else if(x>compare && x<=2*compare){
            this.couleur = "b";
	}
	else if(x>2*compare && x<=3*compare){
            this.couleur = "j";
	}
	else if(x>3*compare && x<=4*compare){
            this.couleur = "v";
	}
	else if(x>4*compare && x<=5*compare){
            this.couleur = "o";
	}
	else{
            this.couleur = "n";
	}
    }
    
    public Cellule(Cellule cellule){
        
        territoire=cellule.territoire;
        verifie = 0;
        listeVoisin = new ArrayList<Cellule>();
        couleur = cellule.couleur;
    }
 
    public void ChangementCouleurRandom(){
        
        int x =(int) (Math.random() * 90);
	int compare = 15;
	
	if (x<=compare){
            this.couleur = "r";
	}
	else if(x>compare && x<=2*compare){
            this.couleur = "b";
	}
	else if(x>2*compare && x<=3*compare){
            this.couleur = "j";
	}
	else if(x>3*compare && x<=4*compare){
            this.couleur = "v";
	}
	else if(x>4*compare && x<=5*compare){
            this.couleur = "o";
	}
	else{
            this.couleur = "n";
	}
    }
    
    public void ChangementCouleur(String couleur){
            
        this.couleur=couleur;
        this.verifie=1;
            
    }
        
    public void ChangementTerritoire(int joueur){
            
        this.territoire=joueur+1;
        this.verifie=1;
            
    }    
    
    public String getCouleur(){
        return this.couleur;
    }
}
