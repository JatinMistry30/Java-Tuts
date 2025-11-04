abstract class Vehicle {
    //Abstract methods
    abstract void accelerate();
    abstract void brake();


    //Concrete Method
    void startEngine() {
        System.out.println("Engine started!");
    }
}

class Car extends Vehicle{
    @Override
    void accelerate() {
        System.out.println("Car: Pressing gas pedal...");
    }
    @Override
    void brake() {
        System.out.println("Car: Applying brakes...");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.startEngine();
        myCar.accelerate();
        myCar.brake();
    }
}
