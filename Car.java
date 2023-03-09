import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengers;
    private int max_capacity;

    public Car(int max_capacity) {
        this.max_capacity = max_capacity;
        this.passengers = new ArrayList<Passenger>(this.max_capacity);
    }

    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }

    public int getCapacity(){
        return this.max_capacity;
    }

    public int seatsRemaining() {
        int passenger = passengers.size();
        int seatsRemaining = this.max_capacity - passenger;
        return seatsRemaining;
    }

    public void addPassenger(Passenger p) {
        if (seatsRemaining() != 0){
            this.passengers.add(p);
        }
        else {
            throw new RuntimeException ("Cannot add " + (p.getName()) + " because car is full.");
        }
    }

    public void removePassenger(Passenger p) {
        if (this.passengers.contains(p)){
            this.passengers.remove(p);
        }
        else {
            throw new RuntimeException((p.getName()) + " is not in car.");
        }
    }

    public void printManifest() {
        if (this.passengers.isEmpty() == false) {
            for (Passenger p : this.passengers){
                System.out.println(p.getName());
            }
        }
        else {
            System.out.println("This car is EMPTY.");
        }
    }

}