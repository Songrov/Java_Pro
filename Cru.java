package lesson3.HW;

public enum Cru {
    GRAND(100),
    PREMIER(90),
    AUTRE(80);

    private int quality;

    Cru(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }
}