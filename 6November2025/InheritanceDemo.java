
abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Common method
    public void start() {
        System.out.println(brand + " Vehicle is starting....");
    }

    // Abstract Method
    public abstract void displayInfo();

    // Final Method
    public final void stop() {
        System.out.println(brand + " vehicle is stopping...");
    }
}

class Car extends Vehicle {
    protected String fuelType;
    protected int doors;

    public Car(String brand, int year, String fuelType, int doors) {
        super(brand, year); // Call parent constructor
        this.fuelType = fuelType;
        this.doors = doors;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("car engine ie running smoothly");
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Doors: " + doors);
    }

    public void openTrunk() {
        System.out.println("Opening car trunk...");
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;
    private int range;

    public ElectricCar(String brand, int year, int batteryCapacity, int range) {
        super(brand, year, "Electric", 4);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    // Overriding the displayInfo() again
    @Override
    public void displayInfo() {
        System.out.println("Electric Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range: " + range + " km");
    }

    // Overriding start() to show different behavior
    @Override
    public void start() {
        super.start(); // Calls Car’s start()
        System.out.println("Electric system booting silently...");
    }

    public void chargeBattery() {
        System.out.println(brand + " is charging its battery (" + batteryCapacity + " kWh).");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Has Sidecar: " + hasSidecar);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Motorcycle engine revving...");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        // Using the parent reference to hold child object (Polymorphism)
        Vehicle car = new Car("Toyota", 2020, "Petrol", 4);
        Vehicle eCar = new ElectricCar("Tesla", 2023, 75, 450);
        Vehicle bike = new Motorcycle("Harley-Davidson", 2021, false);
        System.out.println("\n--- Car ---");
        car.start();
        car.displayInfo();
        car.stop();

        System.out.println("\n--- Electric Car ---");
        eCar.start();
        eCar.displayInfo();
        eCar.stop();

        System.out.println("\n--- Motorcycle ---");
        bike.start();
        bike.displayInfo();
        bike.stop();

        System.out.println("\n--- Specific ElectricCar Behavior ---");
        if (eCar instanceof ElectricCar) {
            ((ElectricCar) eCar).chargeBattery();
        }
    }
}
