package ES05;

import ES05.Enum.Sport;
import ES05.Enum.TextColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircoloSportivo {

    private String nome, via, datiAggiuntivi;
    private List<Iscritto> iscritti;
    private List<Iscrizione> iscrizioni;

    public CircoloSportivo(){}
    public CircoloSportivo(String nome, String via, String datiAggiuntivi, ArrayList<Iscritto> iscritti, ArrayList<Iscrizione> iscrizioni) {
        this.nome = nome;
        this.via = via;
        this.datiAggiuntivi = datiAggiuntivi;
        this.iscritti = iscritti;
        this.iscrizioni = iscrizioni;
    }
    public CircoloSportivo(String nome, String via, String datiAggiuntivi) {
        this.nome = nome;
        this.via = via;
        this.datiAggiuntivi = datiAggiuntivi;
        this.iscritti = new ArrayList<>();
        this.iscrizioni = new ArrayList<>();
    }
    public CircoloSportivo(CircoloSportivo cs) {
        this.nome = cs.nome;
        this.via = cs.via;
        this.datiAggiuntivi = cs.datiAggiuntivi;
        this.iscritti = cs.iscritti;
        this.iscrizioni = cs.iscrizioni;
    }

    public String getNome() {
        return nome;
    }

    public String getVia() {
        return via;
    }

    public String getDatiAggiuntivi() {
        return datiAggiuntivi;
    }

    public Iscritto getIscrittoByName(String name){
        for(Iscritto i : iscritti){
            if(i.getNome().equalsIgnoreCase(name))
                return i;
        }
        return new Iscritto();
    }

    public void addIscritto() {
        Iscritto iscritto = compilaIscritto();
        for(Iscritto i : this.iscritti)
            if(i.getCognome().equalsIgnoreCase(iscritto.getCognome()) && i.getNome().equalsIgnoreCase(iscritto.getNome())){
                System.out.println(TextColor.ANSI_RED + "ERRORE: Iscritto gia' presente!");
                return;
            }
        iscritti.add(iscritto);
        System.out.println((TextColor.ANSI_GREEN + "Iscritto aggiunto!"));
    }

    public void deleteIscritto() {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        if(!iscritti.isEmpty()){
            listIscritti();
            System.out.print(TextColor.ANSI_BLUE + "\nNumero dell'iscritto: ");
            scelta = scanner.nextInt();
            try {
                iscritti.remove(scelta-1);
                System.out.println(TextColor.ANSI_GREEN + "Iscritto eliminato");
            } catch (IndexOutOfBoundsException e){
                System.out.println(TextColor.ANSI_RED + "ERRORE: Iscritto non esistente");
            }
        } else System.out.println(TextColor.ANSI_RED + "ERRORE: Elenco vuoto");
    }
    public void listIscritti() {
        if(iscritti.isEmpty()){
            System.out.println(TextColor.ANSI_RED + "ERRORE: Elenco vuoto");
            return;
        }
        for(int i = 0; i < iscritti.size(); i++)
            System.out.println("N." + (i+1) + " > " + iscritti.get(i).toString());
    }

    public void addIscrizione() {
        if(!iscritti.isEmpty()){
            Iscrizione iscrizione = new Iscrizione(iscritti.get(scegliIscritto()),scegliSport());
            for(Iscrizione i : this.iscrizioni)
                if(i.compare(iscrizione)){
                    System.out.println(TextColor.ANSI_RED + "ERRORE: Iscrizione già effettuata!");
                    return;
                }
            iscrizioni.add(iscrizione);
            System.out.println(TextColor.ANSI_GREEN + "Iscrizione aggiunto!");
        } else {
            System.out.println(TextColor.ANSI_YELLOW + "Prima devi creare almeno un iscritto!");
        }
    }

    public void deleteIscrizione() {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        if(!iscrizioni.isEmpty()){
            listIscrizioni();
            System.out.print(TextColor.ANSI_BLUE +  "\nNumero dell'iscrizione: ");
            scelta = scanner.nextInt();
            try {
                iscrizioni.remove(scelta-1);
                System.out.println(TextColor.ANSI_GREEN + "Iscrizione eliminata");
            } catch (IndexOutOfBoundsException e){
                System.out.println(TextColor.ANSI_RED + "ERRORE: Iscrizione non esistente");
            }
        } else System.out.println(TextColor.ANSI_RED + "ERRORE: Elenco vuoto");
    }

    public void listIscrizioni() {
        if(iscrizioni.isEmpty()){
            System.out.println(TextColor.ANSI_RED + "ERRORE: Elenco vuoto");
            return;
        }
        for(int i = 0; i < iscrizioni.size(); i++)
            System.out.println("N." + (i+1) + " > " + iscrizioni.get(i).toString());
    }
    public void rettaMensileIscritto(){
        Scanner s = new Scanner(System.in);
        String nome;
        do{
            System.out.print("Nome iscritto: ");
            nome = s.nextLine();
        } while(!containsByName(nome));
        double tot = 0;
        for(Iscrizione i : iscrizioni)
            if(i.getIscritto().getNome().equalsIgnoreCase(nome))
                tot += i.getSportScelto().getPrezzo();
        if(tot == 0) {
            System.out.println(TextColor.ANSI_RED + "ERRORE: Non è iscritto al circolo");
        } else{
            System.out.println("Retta mensile per \"" + nome + "\": " + tot);
        }
    }

    public void iscrittiDisciplina(){
        if(iscrizioni.isEmpty()){
            System.out.println(TextColor.ANSI_YELLOW + "Non è stata registrata nessuna iscrizione");
            return;
        }
        int n = 0;
        Sport sport = scegliSport();
        for(Iscrizione i : iscrizioni){
            if(i.getSportScelto().equals(sport)){
                System.out.println("N." + (n+1) + " " + i);
                n++;
            }
        }
        if(n == 0) System.out.println(TextColor.ANSI_YELLOW + "Nessun iscrizione a questa disciplina");
    }

    public boolean containsByName(String name){
        for(Iscritto i : iscritti){
            if(i.getNome().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    //>>>> form <<<<
    public Iscritto compilaIscritto(){
        Scanner s = new Scanner(System.in);
        String nome, cognome;
        System.out.print(TextColor.ANSI_BLUE +  "Nome: ");
        nome = s.nextLine();
        System.out.print(TextColor.ANSI_BLUE +  "Cognome: ");
        cognome = s.nextLine();
        return new Iscritto(nome,cognome);
    }

    public Sport scegliSport(){
        Scanner s = new Scanner(System.in);
        int scelta;
        System.out.println(TextColor.ANSI_BLUE +  """
                Scegli lo sport:
                1 -- Nuoto
                2 -- Ginnastia Aerobica
                3 -- Body Building""");
        do{
            System.out.print(TextColor.ANSI_BLUE + "Scelta: ");
            //try {
                scelta = s.nextInt();
            //} catch (InputMismatchException e){
                //System.out.println(TextColor.ANSI_RED + "ERRORE: Input non valido");
                //scelta = -1;
                //}
        }while(scelta < 1 || scelta > 3);
        switch (scelta){
            case 1 -> { return Sport.NUOTO; }
            case 2 -> { return Sport.GINNASTICA_AEROBICA; }
            case 3 -> { return Sport.BODY_BUILDING; }
        }
        return null;
    }

    public int scegliIscritto(){
        Scanner s = new Scanner(System.in);
        int scelta;
        listIscritti();
        do{
            System.out.print(TextColor.ANSI_BLUE +  "Scegli l'iscritto: ");
            scelta = s.nextInt();
        } while(scelta-1 < 0 || scelta > iscritti.size());
        return scelta-1;
    }
}
