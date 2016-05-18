import java.util.ArrayList;
public class Jeu {
	
    public Cellule [][] grilleCellule;
    public Joueur [] listeJoueur;
    public int tailleGrille;

    public Jeu(){
        tailleGrille = 13;
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
    
    public int getTailleGrille(){
        return tailleGrille;
    }
}
