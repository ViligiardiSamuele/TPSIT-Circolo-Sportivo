package ES05.Enum;

public enum BackColor {
    ANSI_BLACK_BG ("\u001B[40m"),
    ANSI_RED_BG ("\u001B[41m"),
    ANSI_GREEN_BG ("\u001B[42m"),
    ANSI_YELLOW_BG ("\u001B[43m"),
    ANSI_BLUE_BG ("\u001B[44m"),
    ANSI_PURPLE_BG ("\u001B[45m"),
    ANSI_CYAN_BG ("\u001B[46m"),
    ANSI_WHITE_BG ("\u001B[47m");

    private final String color;
    BackColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        return this.getColor();
    }
}
