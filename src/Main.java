
import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.Animal.Herbivore.Horse;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.Plant.Plant;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Cell cell1 = new Cell();
        Cell cell2 = new Cell();
        cell2.addNeighbors(cell1);
        cell1.addNeighbors(cell2);

        for (int i = 0; i < 10; i++) {
            Alive plant = new Plant(cell1);
            Thread thread3 = new Thread(plant);
            thread3.start();

            Alive plant2 = new Plant(cell2);
            Thread thread4 = new Thread(plant2);
            thread4.start();

            Alive horse = new Horse(cell1);
            Thread thread2 = new Thread(horse);
            thread2.start();

            Alive wolf = new Wolf(cell1);
            Thread thread1 = new Thread(wolf);
            thread1.start();

        }

        while ((!cell1.getRepresentatives().isEmpty()) ||(!cell2.getRepresentatives().isEmpty())) {
            System.out.println("Cell 1: "+cell1);
            System.out.println("Cell 2: "+cell2);
            Thread.sleep(1000);
        }
        System.out.println("all died");
    }
}