import java.util.*;
import java.io.*;

public class HelloWorld {

    public static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        //Biblio.lireFichier("src/biblio.txt"); 
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/biblio.txt"));
            String line = br.readLine();
            while (line != null) {
                //System.out.println(line);                    
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Problème d'ouverture du fichier" + "biblio.txt");
        }

        int nombre1, nombre2, choixOperation;
        int resultat;

        menu(); // Affiche le menu
        System.out.println();
        boolean finDuProgramme = false;

        while (!finDuProgramme) {            
            choixOperation = validationChoixmenu();
            if (choixOperation == 0) {
                finDuProgramme = true;
            } else {
                System.out.println("Entrer le premier nombre :");
                nombre1 = clavier.nextInt();
                clavier.nextLine();
                System.out.println();
                System.out.println("Entrer le deuxième nombre :");
                nombre2 = clavier.nextInt();
                clavier.nextLine();

                switch (choixOperation) {
                    case 1:
                        resultat = addition(nombre1, nombre2);
                        System.out.println("Voici la somme :");
                        System.out.println(resultat);
                        break;
                    case 2:
                        resultat = soustraction(nombre1, nombre2);
                        System.out.println("Voici la soustraction :");
                        System.out.println(resultat);
                        break;
                    case 3:
                        resultat = multiplication(nombre1, nombre2);
                        System.out.println("Voici la multiplication :");
                        System.out.println(resultat);
                        break;
                    case 4:
                        resultat = division(nombre1, nombre2);
                        System.out.println("Voici la division :");
                        System.out.println(resultat);
                        break;
                }
                // On redemande un type opération ou de sortir du programme...                
            }
        }
        System.out.println("Le programme de la calculatrice est maintenant terminé !");        
    }    

    public static void menu() {
        System.out.println("Bienvenue aux opérations arithmétique");
        System.out.println("1 : addition");
        System.out.println("2 : soustraction");
        System.out.println("3 : multiplication");
        System.out.println("4 : division");
        System.out.println("0 : Quitter");
    }   
    
    public static int validationChoixmenu() {
        boolean valeurAnormale = false;
        int choixValidee = 0;

        while (!valeurAnormale) {//tant que valeurAnormale n'est pas différent de false
            try {
                System.out.println("Veuillez saisir votre type opération...");
                choixValidee = choixMenu();
                valeurAnormale = true;
            } catch (InputMismatchException e) {
                System.out.println("SVP! Veuillez entrer une valeur numérique !");
                clavier.nextLine();     
            } catch (ChoixMenuInvalide e) {
                System.out.println(e.getMessage());
            }
        }
        return choixValidee;
    }
    
    public static int choixMenu() throws ChoixMenuInvalide {
        int choixEnValidation = 0;
        choixEnValidation = clavier.nextInt();
        clavier.nextLine();

        if (choixEnValidation < 0) {
            throw new ChoixMenuInvalide("Vous ne pouvez pas prendre une valeur négative !");
        }
        
        if (choixEnValidation > 4) {
            throw new ChoixMenuInvalide("Vous ne pouvez pas prendre une valeur plus grande que 4 !");
        }
        
        return choixEnValidation;
    }
    
    public static int addition(int nombre1, int nombre2) {
        return nombre1 + nombre2;
    }
    
    public static int soustraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }
}
