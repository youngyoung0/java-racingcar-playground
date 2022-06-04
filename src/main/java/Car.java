public class Car {
    private String name;
    private Integer length;

    public Car(){

    }

    public Car(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public Car going(Car car, int value){
        car.setLength(car.getLength() + value);
        return car;
    }

    public Integer getLength(){
        return this.length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }
}
