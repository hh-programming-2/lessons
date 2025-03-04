package lesson4;

/**
 * Tämän esimerkin tarkoituksena on havainnollistaa olioiden monimuotoisuutta ja
 * Dependency Injection -patternia.
 */
public class AirplaneConfig {

    private final Airplane superAirplane;
    private final Airplane cheapAirplane;

    public AirplaneConfig() {
    	
    	// Konfiguroidaan superlentokone, laitetaan supermoottori tähän konfiguraatioon
        superAirplane = new Airplane();
        Engine superEngine = new SuperEngine();
        superAirplane.setEngine(superEngine);

    	// Konfiguroidaan halpa lentokone, laitetaan halpa moottori tähän konfiguraatioon
        cheapAirplane = new Airplane();
        Engine cheapEngine = new CheapEngine();
        cheapAirplane.setEngine(cheapEngine);
    }

}

class Airplane {

	private Engine engine; // Pelkkä rajapinta riittää Lentokoneelle, sen ei kuulu tietää toteutusyksityiskohtia.

    // Setter metodilla voidaan asettaa haluttu moottori lentokoneelle
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // Lentokoneen tehtävä on osata lentäminen kokonaisuutena, moottori huolehtii omista yksityiskohdistaan. 
    private void fly() {
        engine.start();
        engine.useEngine();
    }
}

interface Engine {
    public void useEngine();

    public boolean start();
}

class SuperEngine implements Engine {

    public void useEngine() {
        // tee jotain superjuttuja
    }

    public boolean start() {
        // Tee supermoottorin käynnistämiseen tarvittavat toimet
        return false;
    }

}

class CheapEngine implements Engine {

    public void useEngine() {
        // aja hitaasti
    }

    public boolean start() {
        // Tee halvan moottorin käynnistämiseen tarvittavat toimet
        return false;
    }

}
