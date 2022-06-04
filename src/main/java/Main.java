import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        intro();
    }

    private static void intro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉽표(,)를 기준으로 구분)");
        String carName = scanner.nextLine();
        String[] carNames = carNameSplit(carName);
        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        startGame(number, carNames);

    }

    private static String[] carNameSplit(String names){
        return names.split(",");
    }

    private static void startGame(int number, String[] carNames){
        System.out.println("실행 결과");
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(createCarList(carName));
        }
        for(int i = 0; i < number + 1; i++){
            carGoing(carList, number, i);
        }
        winner(carList);
    }

    private static Car createCarList(String name){
        return new Car(name, 1);
    }

    private static void carGoing(List<Car> carList, int number, int index){
        for(int i = 0; i < carList.size(); i++){
            System.out.print(carList.get(i).getName()+ " : ");
            pathLength(carList.get(i).getLength());
            carList.set(i, modifyCarByLength(carList.get(i), number, index));
        }
        System.out.println();
    }

    private static void pathLength(int length){
        for(int i = 0; i < length; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private static Car modifyCarByLength(Car car, int number, int index){
        if(number == index){
            return car;
        }
        return car.going(car, randomNumber());
    }

    private static int randomNumber(){
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if(randomInt <= 4){
            return 1;
        }
        return 0;
    }

    private static void winner(List<Car> carList){
        Car winnerCar = new Car("test", 0);
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : carList) {
            winnerCars = checkLength(winnerCar, car, winnerCars);
            winnerCar = winnerRenew(winnerCar, car);
        }
        awardCeremony(winnerCars);
    }

    private static List<Car> checkLength(Car winnerCar, Car car, List<Car> winnerCars){
        if(car.getLength() > winnerCar.getLength()){
            List<Car> newWinner = new ArrayList<>();
            newWinner.add(car);
            return  newWinner;
        }else if(car.getLength().equals(winnerCar.getLength())){
            winnerCars.add(car);
        }
        return winnerCars;
    }

    private static Car winnerRenew(Car winnerCar, Car car){
        if(car.getLength() > winnerCar.getLength()){
            return car;
        }
        return winnerCar;
    }

    private static void awardCeremony(List<Car> winnercars){
        for(int i = 0; i < winnercars.size(); i++){
            comma(i);
            System.out.print(winnercars.get(i).getName());
        }
        System.out.print("가 최종 우승했습니다.");
    }

    private static void comma(int count){
        if(count >= 1){
            System.out.print(", ");
        }
    }
}
