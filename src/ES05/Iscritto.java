package ES05;

public class Iscritto {
    private String nome, cognome;

    public Iscritto(){}
    public Iscritto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Iscritto(Iscritto i) {
        this.nome = i.nome;
        this.cognome = i.cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean compare(Iscritto i){
        return getCognome().equalsIgnoreCase(i.getCognome()) && getNome().equalsIgnoreCase(i.getNome());
    }


    @Override public String toString(){
        return "Nome: " + this.getNome() + " - Cognome: " + this.getCognome();
    }
}
