package lesson4;

import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Tämän esimerkin tarkoituksena on havainnollistaa olioiden monimuotoisuutta ja
 * rajapintojen käyttämistä.
 */
public class ListExamples {

    public static void main(final String[] args) {
        List<Integer> numeroLista = new LinkedList<>();
        numeroLista.add(1);
        numeroLista.add(2);
        numeroLista.add(3);
        numeroLista.add(1);
        System.out.println(laskeEsiintymat(numeroLista));

        List<String> tekstiLista = new LinkedList<>();
        tekstiLista.add("Pekka");
        tekstiLista.add("Maija");
        tekstiLista.add("Elina");
        tekstiLista.add("Pekka");
        System.out.println(laskeEsiintymat(tekstiLista));

        List<MyObject> omaLista = new LinkedList<>();
        omaLista.add(new MyObject(1, "Volvo"));
        omaLista.add(new MyObject(2, "Mersu"));
        omaLista.add(new MyObject(3, "BMW"));
        omaLista.add(new MyObject(4, "Volvo"));
        System.out.println(laskeEsiintymat(omaLista));
        
        // Bonuksena vielä sorttaus Comparable rajapinnalla
        Collections.sort(omaLista);
        System.out.println("Aakkosjärjestetty autolista:  "+omaLista);

    }

    /**
     * 
     * 
     * @param list
     * @return Metodi palauttaa Mapin, jossa on avaimena parametrina saadun Listan
     *         objekti ja keynä lukumäärä kuinka monta samaa objektia listassa oli.
     */
    private static <T> Map<T, Integer> laskeEsiintymat(List<T> list) {
        Map<T, Integer> tulos = new HashMap<>();
        for (T object : list) {
            if (tulos.containsKey(object)) {
                tulos.put(object, tulos.get(object) + 1);
            } else {
                tulos.put(object, 1);
            }
        }
        return tulos;
    }
}

/**
 * Lisätään esimerkkiin vielä oma objekti, jolla on id ja tekstikenttä ja
 * overridataan luokan hashcode ja equals-metodit siten, että pelkkä
 * tekstisisällön samankaltaisuus tarkoittaa samankaltaisuutta, sitten se
 * voidaan myös antaa mielekkääseen vertailuun laskeEsiintymat metodille.
 * 
 * Luokka toteuttaa myös Comparable rajapinnan, jolloin OmaObjekteja voidaan myös järjestää suhteessa toisiinsa.
 * Tässä tapauksessa järjestys tapahtuu text perusteella String-luokan omaa compare-toteutusta hyödyntäen.
 * Tämä käytännössä aiheuttaa MyObject järjestämisen aakkosjärjestykseen.
 */
class MyObject implements Comparable<MyObject> {
    private int id;
    private String text;

    public MyObject(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyObject)) {
            return false;
        }
        MyObject toinenObjekti = (MyObject) o;
        return this.text.equals(toinenObjekti.gettext());
    }

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    @Override
    public String toString() {
        return this.gettext();
    }

    public String gettext() {
        return this.text;
    }

    @Override
    public int compareTo(MyObject other) {
        return this.text.compareTo(other.text);
    }
}
