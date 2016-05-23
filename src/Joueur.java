
public class Joueur {

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
    
    public Joueur(int num){
        couleur = null;
        nom = "IA";
        iA = num;
        score = 1;
        
    }
    
    public void AddCouleur(String couleurr){
        
        this.couleur = couleurr;
        
    }
}
