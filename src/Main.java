import Field.Field;
import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.Animal.Herbivore.Horse;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.AnimalConstants;
import LiveObjects.Plant.Plant;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    //public static volatile RandomGenerator randomGenerator;
    public static void main(String[] args) {


        Field island = new Field(10, 10);
        Cell cell = new Cell();
        for (int i=0;i<10;i++){
            Alive wolf= new Wolf(cell);
            Thread thread1 = new Thread(wolf);
            thread1.start();
            Alive horse = new Horse(cell);
            Thread thread2 = new Thread(horse);
            thread2.start();
            Alive plant = new Plant(cell);
            Thread thread3 = new Thread(plant);
            thread3.start();
        }

        while (cell.getRepresentatives()!=null){
            System.out.println(cell);
        }
    }
}