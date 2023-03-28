package ES05;

import ES05.Enum.Sport;

public class Iscrizione {
    private Iscritto iscritto;
    private Sport sportScelto;

    public Iscrizione(Iscritto iscritto, Sport sportScelto) {
        this.iscritto = iscritto;
        this.sportScelto = sportScelto;
    }

    public Iscritto getIscritto() {
        return iscritto;
    }

    public Sport getSportScelto() {
        return sportScelto;
    }

    public boolean compare(Iscrizione i){
        return this.getIscritto().compare(i.getIscritto()) && getSportScelto().equals(i.getSportScelto());
    }

    @Override public String toString(){
        return "Iscrizione:\n Iscritto: " + iscritto.toString()
                + "\n Sport scelto: " + sportScelto;
    }
}