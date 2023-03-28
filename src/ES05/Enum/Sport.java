package ES05.Enum;

public enum Sport {
    NUOTO(25),
    GINNASTICA_AEROBICA(40),
    BODY_BUILDING(50);
    private final double prezzo;

    Sport(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPrezzo(){
        return prezzo;
    }

    @Override
    public String toString(){
        switch (this){
            case NUOTO -> {
                return "Nuoto";
            }
            case GINNASTICA_AEROBICA -> {
                return "Ginnastica aerobica";
            }
            case BODY_BUILDING -> {
                return "Body building";
            }
            default -> {
                return "";
            }
        }
    }
}