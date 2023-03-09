import java.util.ArrayList;

public class Train {

    private final Engine engine;
    private ArrayList<Car> cars;

    public Train(FuelType f, double max_fuel, int nCars, int max_capacity) {
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(max_capacity));
        }
        this.engine = new Engine(f, max_fuel);
    }

    public Engine getEngine(){
        return this.engine;
    }

    public Car getCar(int i) {
        return this.cars.get(i-1);
    }

    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (Car c : cars) {
            maxCapacity += c.getCapacity();
        }
        return maxCapacity;
    }
    
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for (Car c : cars) {
            totalSeatsRemaining += c.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    public void printManifest() {
        for (Car c : cars) {
            c.printManifest();
        }
    }

    public static void main(String[] args) {
        Train my_train = new Train(FuelType.ELECTRIC, 100.0, 3, 4);
        Engine my_engine = my_train.getEngine();

        Car car1 = my_train.getCar(1);
        Car car2 = my_train.getCar(2);
        Car car3 = my_train.getCar(3);

        Passenger p1 = new Passenger("Taylor");
        Passenger p2 = new Passenger("Julie");
        Passenger p3 = new Passenger("Kim");
        Passenger p4 = new Passenger("Liz");
        Passenger p5 = new Passenger("Ella");
        p1.boardCar(car1);
        p2.boardCar(car1);
        p3.boardCar(car1);
        p4.boardCar(car2);
        p5.boardCar(car3);

        my_engine.go(); //trip 1 (100 miles to start, 25 miles used, 75 miles left)
        System.out.println("The current fuel: " + my_engine.getcurrent_fuel());

        System.out.println("Passengers in car 1: ");
        car1.printManifest();
        System.out.println("Seats remaining in car 1:  " + car1.seatsRemaining());
        System.out.println("Passengers in car 2: ");
        car2.printManifest();
        System.out.println("Seats remaining in car 2: " + car2.seatsRemaining());
        System.out.println("Passenger in car 3: ");
        car3.printManifest();
        System.out.println("Seats remaining in car 3: " + car3.seatsRemaining());

        my_engine.go(); //trip 2 (50 miles left)
        System.out.println("The current fuel: " + my_engine.getcurrent_fuel());

        System.out.println(p2.getName() + " has left the train.");
        car1.removePassenger(p2);
        System.out.println("Seats remaining in car 1:  " + car1.seatsRemaining());


        my_engine.refuel(); 

        }

    }
