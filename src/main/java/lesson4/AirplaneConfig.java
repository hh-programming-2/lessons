package lesson4;

/**
 * The purpose of this example is to demonstrate interfaces and the usage of
 * Dependency Injection pattern.
 */
public class AirplaneConfig {

    private final Airplane superAirplane;
    private final Airplane cheapAirplane;

    public AirplaneConfig() {
    	
    	// Initialize a super plane which has a super engine
        superAirplane = new Airplane();
        Engine superEngine = new SuperEngine();
        superAirplane.setEngine(superEngine);

    	// Initialize a cheap plane which has a cheap engine 
        cheapAirplane = new Airplane();
        Engine cheapEngine = new CheapEngine();
        cheapAirplane.setEngine(cheapEngine);

        // "Composition over inheritance"
    }

}

class Airplane {
    // Airplane just needs an Engine interface object, it is not supposed to know the implementation details
	private Engine engine;

    // We can set any engine which implements the Engine interface using the setter method
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // Airplane's responsibility is to know how to a fly by starting and using the engine, the engine handles its own details
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
        // Do some super stuff
    }

    public boolean start() {
        // Do the required actions to start the super engine
        return false;
    }

}

class CheapEngine implements Engine {

    public void useEngine() {
        // Dome some cheap stuff
    }

    public boolean start() {
        // Do the required actions to start the cheap engine
        return false;
    }

}
