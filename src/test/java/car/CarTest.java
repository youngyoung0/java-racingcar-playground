package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    public static class Car {
        private Integer length;

        public Car(){

        }

        public Car(String name, Integer length) {
            this.length = length;
        }

        public Car going(Car car, int value){
            this.length = value;
            car.setLength(car.getLength() + value);
            return car;
        }

        private Integer getLength(){
            return this.length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }
    }

    @Test
    @DisplayName("문자열 잘라서 해당값들 배열로 저장")
    void splitName(){
        String carStr = "car1,car2,car3";
        String[] cars = carStr.split(",");

        assertThat(cars).contains("car1","car2","car3");
    }

    @Test
    @DisplayName("랜덤 함수 만들기 0에서 10 생성하는 난수")
    void random(){
        Random random = new Random();
        int randomInt = random.nextInt(10);
        System.out.println(randomInt);
        for(int i = 0; i< 20; i++){
            assertThat(randomInt)
                    .isGreaterThan(-1)
                    .isLessThan(11);
        }
    }

    @Test
    @DisplayName("차의 거리 누적하는 테스트")
    void checkLength(){
        int number = 3;
        Car car = new Car("test", 1);
        for(int i = 0 ; i < 2; i++){
            car.setLength(car.getLength() + number);
        }
        assertThat(car.getLength()).isEqualTo(7);
    }
}
