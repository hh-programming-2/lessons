package lesson4;

/**
 * This example illustrates the object-oriented programming concepts of
 * inheritance, super class, and instanceof keywords.
 */
public class VehicleInheritance {
    public static void main(String[] args) {
        System.out.println("Car:");
        Car myCar = new Car("Tesla Model 3", 0);
        myCar.start();
        myCar.accelerate(80);
        myCar.honk();
        myCar.stop();

        System.out.println("Bicycle:");
        Bicycle myBike = new Bicycle(true, 0);
        myBike.start();
        myBike.accelerate(25);
        myBike.ringBell();
        myBike.stop();

        myCar.accelerate(50);
        myBike.accelerate(5);

        // Note that we can create an instance of the superclass as well
        Vechicle basicVehicle = new Vehicle(1);

        // The isFasterThan method accepts any class that inherits the Vehicle class
        System.out.println("Bike is faster?: " + isFasterThan(myBike, myCar));

        inspectVehicle(myCar);
        inspectVehicle(myBike);
    }

    public static boolean isFasterThan(Vehicle a, Vehicle b) {
        return a.getSpeed() > b.getSpeed();
    }

    public static void inspectVehicle(Vehicle vehicle) {
        // Is this specific vehicle object an instance of the Car class?
        if (vehicle instanceof Car) {
            // We checked that the vehicle is a Car object, safe to cast it
            Car car = (Car) vehicle;
            System.out.println("It has four wheels, this vehicle is car");
            car.honk();
        } else if (vehicle instanceof Bicycle) {
            Bicycle bike = (Bicycle) vehicle;
            System.out.println("It has two wheels, this vehicle is a bike");
            bike.ringBell();
        } else {
            System.out.println("No idea what kind of a vehicle this is");
        }
    }
}

// Super class, defines the basic attributes and methods of a vehicle
class Vehicle {
    private int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public void start() {
        if (!this.isMoving()) {
            this.speed = 1;
            System.out.println("Vehicle is starting...");
        } else {
            System.out.println("Vehicle is already moving!");
        }
    }

    public void stop() {
        this.speed = 0;
        System.out.println("Vehicle is stopping...");
    }

    public void accelerate(int increase) {
        speed += increase;
        System.out.println("Vehicle accelerated to " + speed + " km/h.");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    // Protected methods are only visible to the superclass and subclasses
    protected boolean isMoving() {
        return speed > 0;
    }
}

//Subclass. A car is a vehicle, but it also has a model and can honk
class Car extends Vehicle {
    //Subclasses can have their own attributes
    private String model;

    public Car(String model, int speed) {
        // Call the super class constructor and provide its parameters
        super(speed);
        // Set car-specific attributes
        this.model = model;
    }

    // Sub classes can have their own methods
    public void honk() {
        // We can call a protected method from a subclass
        if (this.isMoving()) {
            System.out.println(model + " is honking: Beep beep!");
        } else {
            System.out.println(model + " can't honk while not moving!");
        }
    }
}

/**
 * Subclass. A bicycle is a vehicle, but it also might have a bell, and it can
 * ring its bell. The bicycle can't accelerate above 20 km/h.
 */
class Bicycle extends Vehicle {
    private boolean hasBell;

    public Bicycle(boolean hasBell, int speed) {
        super(speed);
        this.hasBell = hasBell;
    }

    public void ringBell() {
        if (hasBell) {
            System.out.println("Bicycle bell rings: Ding ding!");
        } else {
            System.out.println("This bicycle has no bell.");
        }
    }

    /**
     * We can override methods of the superclass. The @Override annotation is an
     * explicit way to express the desire to provide an implementation for an
     * upper-level method. It helps, e.g., to spot typos at compilation time.
     */
    @Override
    public void accelerate(int increase) {
        if (exceedsMaxSpeed(increase)) {
            this.setSpeed(20);
            System.out.println("Bicycles can't go that fast! Limiting speed increase.");
        }

        this.setSpeed(this.getSpeed() + increase);
        System.out.println("Bicycle accelerated to " + this.getSpeed() + " km/h.");
    }

    // Private methods are only visible within the class
    private boolean exceedsMaxSpeed(int increase) {
        return this.getSpeed() + increase > 20;
    }
}
