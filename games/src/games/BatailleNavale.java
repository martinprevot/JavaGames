package games;

import java.util.Scanner;

public class BatailleNavale {
    private static final int TAILLE_GRILLE = 10;
    private static final char SYMBOLE_BATEAU = 'B';
    private static final char SYMBOLE_TIR_RATE = 'X';
    private static final char SYMBOLE_TIR_TOUCHE = 'O';

    private char[][] grille;
    private int nbBateaux;

    public BatailleNavale(int nbBateaux) {
        this.nbBateaux = nbBateaux;
        this.grille = new char[TAILLE_GRILLE][TAILLE_GRILLE];
        initialiserGrille();
        placerBateaux();
    }

    private void initialiserGrille() {
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                grille[i][j] = '.';
            }
        }
    }

    private void placerBateaux() {
        for (int i = 0; i < nbBateaux; i++) {
            int ligne, colonne;
            do {
                ligne = (int) (Math.random() * TAILLE_GRILLE);
                colonne = (int) (Math.random() * TAILLE_GRILLE);
            } while (grille[ligne][colonne] != '.');
            grille[ligne][colonne] = SYMBOLE_BATEAU;
        }
    }

    public void afficherGrille(boolean afficherBateaux) {
        System.out.print("  ");
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if (!afficherBateaux && grille[i][j] == SYMBOLE_BATEAU) {
                    System.out.print(". ");
                } else {
                    System.out.print(grille[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean tirer(int ligne, int colonne) {
        if (grille[ligne][colonne] == SYMBOLE_BATEAU) {
            grille[ligne][colonne] = SYMBOLE_TIR_TOUCHE;
            return true;
        } else {
            grille[ligne][colonne] = SYMBOLE_TIR_RATE;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BatailleNavale jeu = new BatailleNavale(5);
        boolean fini = false;
        int nbTirs = 0;

        System.out.println("Bienvenue dans le jeu de bataille navale !");
        System.out.println("Vous devez couler " + jeu.nbBateaux + " bateaux.");
        System.out.println("Entrez les coordonnées pour tirer.");

        while (!fini) {
            jeu.afficherGrille(false);
            System.out.print("Ligne : ");
            int ligne = scanner.nextInt();
            System.out.print("Colonne : ");
            int colonne = scanner.nextInt();

            nbTirs++;
            if (jeu.tirer(ligne,colonne)) {
                System.out.println("Touché !");
                if (jeu.gagne()) {
                    System.out.println("Bravo, vous avez coulé tous les bateaux en " + nbTirs + " tirs !");
                    fini = true;
                }
            } else {
                System.out.println("Raté !");
            }
        }
        jeu.afficherGrille(true);
        scanner.close();
    }

    public boolean gagne() {
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if (grille[i][j] == SYMBOLE_BATEAU) {
                    return false;
                }
            }
        }
        return true;
    }
}