
import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.Animal.Herbivore.Horse;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.Plant.Plant;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Cell cell = new Cell();
        for (int i = 0; i < 10; i++) {
            Alive plant = new Plant(cell);
            Thread thread3 = new Thread(plant);
            thread3.start();

            Alive horse = new Horse(cell);
            Thread thread2 = new Thread(horse);
            thread2.start();

            Alive wolf = new Wolf(cell);
            Thread thread1 = new Thread(wolf);
            thread1.start();

        }

        while (!cell.getRepresentatives().isEmpty()) {
            System.out.println(cell);
            Thread.sleep(1000);
        }
        System.out.println("all died");
    }
}