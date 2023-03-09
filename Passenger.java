public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
