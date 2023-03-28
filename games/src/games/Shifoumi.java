package games;

import java.util.Random;
import java.util.Scanner;

public class Shifoumi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"pierre", "feuille", "ciseaux"};

        System.out.println("Jouons à Pierre-Papier-Ciseaux !\n");

        int playerScore = 0;
        int computerScore = 0;

        while (playerScore < 3 && computerScore < 3) {
            System.out.print("Choisissez votre coup (pierre, feuille, ciseaux) ou 'q' pour quitter : ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("q")) {
                break;
            }

            if (!playerChoice.equals("pierre") && !playerChoice.equals("feuille") && !playerChoice.equals("ciseaux")) {
                System.out.println("Choix invalide, veuillez réessayer.");
                continue;
            }

            int computerIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerIndex];

            System.out.println("L'ordinateur choisit " + computerChoice + ".");

            if (playerChoice.equals(computerChoice)) {
                System.out.println("Match nul !");
            } else if ((playerChoice.equals("pierre") && computerChoice.equals("ciseaux")) ||
                    (playerChoice.equals("feuille") && computerChoice.equals("pierre")) ||
                    (playerChoice.equals("ciseaux") && computerChoice.equals("feuille"))) {
                System.out.println("Vous gagnez !");
                playerScore++;
            } else {
                System.out.println("L'ordinateur gagne !");
                computerScore++;
            }

            System.out.println("Score : Vous " + playerScore + " - " + computerScore + " Ordinateur");
            System.out.println();
        }

        if (playerScore > computerScore) {
            System.out.println("Vous avez gagné !");
        } else if (playerScore < computerScore) {
            System.out.println("L'ordinateur a gagné !");
        } else {
            System.out.println("Match nul !");
        }

        System.out.println("Merci d'avoir joué !");
    }
}
