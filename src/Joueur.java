
public class Joueur {

    String couleur;
    String nom;
    int iA;
    int ligneTerritoire;
    int colonneTerritoire;
 
    public Joueur(String nomm){
        couleur = null;
        nom = nomm;
        iA = 0;
        
    }
    
    public Joueur(int num){
        couleur = null;
        nom = "IA";
        iA = num;
        
    }
}
