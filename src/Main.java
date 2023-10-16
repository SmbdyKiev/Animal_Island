
import Field.Cell;
import Field.Field;
import LiveObjects.Alive;
import LiveObjects.AliveFactory;
import LiveObjects.Animal.Herbivore.Horse;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.Plant.Plant;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Field field = new Field(10,10);
        field.initialize();
        System.out.println(field.getFieldStatus());
        System.out.println("all died");
    }
}