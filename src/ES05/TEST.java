package ES05;

import ES05.Enum.TextColor;
import ES05.Exception.CircoloSportivoException;

import java.util.Scanner;

public class TEST {
    private static final CircoloSportivo cs = new CircoloSportivo("Margioli","via della via","");
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws CircoloSportivoException {
        System.out.println(TextColor.ANSI_YELLOW + "Esercizio 05: Circolo Sportivo (Viligiardi Samuele, Scarpulla Lorenzo, Carelli Riccardo)");
        int scelta = 0;
        do {
            System.out.print(TextColor.ANSI_BLUE +  """
                 ————————————————————————————
                | > Menu'                    |
                | 1 - Aggiungi un'iscritto   |
                | 2 - Rimuovi un'iscritto    |
                | 3 - Lista degli iscritti   |
                | 4 - Retta mensile iscritto |
                | 5 - Aggiungi un'iscrizione |
                | 6 - Rimuovi un'iscrizione  |
                | 7 - Lista delle iscrizioni |
                | 8 - Iscritti a disciplina  |
                | 0 - Esci                   |
                """);
            do{
                System.out.print(TextColor.ANSI_BLUE + "Scelta: ");
                scelta = s.nextInt();
            } while (scelta < 0 || scelta > 8);
            switch (scelta) {
                case 1 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|——— Aggiungi un'iscritto ———|");
                    cs.addIscritto();
                }
                case 2 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|——— Rimuovi un'iscritto  ———|");
                    cs.deleteIscritto();
                }
                case 3 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|——— Lista degli iscritti ———|");
                    cs.listIscritti();
                }
                case 4 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|—— Retta mensile iscritto ——|");
                    cs.rettaMensileIscritto();
                }
                case 5 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|—— Aggiungi un'iscrizione ——|");
                    cs.addIscrizione();
                }
                case 6 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|—— Rimuovi un'iscrizione  ——|");
                    cs.deleteIscrizione();
                }
                case 7 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|—— Lista delle iscrizioni ——|");
                    cs.listIscrizioni();
                }
                case 8 -> {
                    System.out.println(TextColor.ANSI_BLUE + "|—— Iscritti a disciplina  ——|");
                    cs.iscrittiDisciplina();
                }
            }
        }while(scelta != 0);
    }
}