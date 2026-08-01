// Base class
class Vehicle {

    void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Subclass Car
class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with a key.");
    }
}

// Subclass Bike
class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts with a self-start or kick.");
    }
}

// Main class
public class VehicleDemo{

    public static void main(String[] args) {

        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        v1.start();
        v2.start();
    }
}