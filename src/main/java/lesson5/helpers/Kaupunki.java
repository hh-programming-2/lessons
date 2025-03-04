package lesson5.helpers;

public class Kaupunki {
    private String nimi;
    private int asukasluku;

    public Kaupunki(String nimi, int asukasluku) {
        this.nimi = nimi;
        this.asukasluku = asukasluku;
    }

    public String getNimi() {
        return nimi;
    }

    public int getAsukasluku() {
        return asukasluku;
    }
}
