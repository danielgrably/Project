package restaurant;
import java.util.LinkedList;
import java.util.Scanner;
import logger.Logger;
import logger.LoggerFactory;

public class Products {

    private final LinkedList<Aliment> productList = new LinkedList<Aliment>();
    Logger logger = LoggerFactory.getLogger("product");
    private Scanner scan = new Scanner(System.in);


    public String toString() {
        return productList.toString();
    }

    public LinkedList<Aliment> getProductList() { return productList; }

    //Afficher la liste des aliments
    public void afficherListe(){
        for (Aliment aliment : this.productList) {
            logger.info("", "\t"+aliment+"\n");
        }
    }

    //Ajouter un aliment à la vente
    private void add (Aliment aliment){
        productList.add(aliment);
    }


    //Créer puis ajouter un aliment à la vente
    public void create_add(String nom, int quantite, double prix){
        Aliment aliment = new Aliment(nom, quantite, prix);
        this.add(aliment);
    }


    //Initialiser les produits mis en vente
    public void init () {
        double inf = Double.POSITIVE_INFINITY;
        create_add("bagel", 20, 8);
        create_add("burger", 10, 10);
        create_add("smoothie", 5, 5);
        create_add("café", (int)inf, 2);
    }


    public boolean verification_aliment_existant(String nom){
        boolean verif = false; /*l'aliment n'existe pas par défault*/
        for (Aliment aliment_courant : productList) {
            if(aliment_courant.getNom().toLowerCase().compareTo(nom.toLowerCase())==0){
                verif = true;} //si les chaînes sont identiques, l'aliment existe
        }
        return verif;
    }


    public void ajouter_produit(){
        logger.info("","\nAjoutez un produit à la vente\nEntrez le nom du produit:\n");
        String nom = scan.next();
        boolean test_aliment_existant = verification_aliment_existant(nom); //aliment.verification(products); /*vrai par défault */

        if(test_aliment_existant==false) { //si l'aliment n'existe pas
            logger.info("","\nEntrez la quantité du produit:\n");
            int quantite = (int)askNextGuess();
            logger.info("","\nEntrez le prix du produit:\n");
            double prix = askNextGuess();
            create_add(nom, quantite, prix);
        }
        else{logger.info("", "\nCe produit existe déjà\n");}
    }


 /*   public boolean verif_chiffre(double prix){
        long choix = 0;
        boolean bool = false;
        do {
            try {
                choix = scan.nextLong();
                bool = true;
            } catch (Exception e) {
                logger.info("","Veuillez entrer un nombre");
                break;
            }

        } while (!bool);

        return bool;
    }*/

    public double askNextGuess() {
        Scanner scan = new Scanner(System.in);
        double choix = 0;
        boolean bool = false;
        do {
            try {
                choix = scan.nextDouble();
                bool = true;
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre!");
                break;
            }

        } while (!bool);

        return choix;
    }

}


