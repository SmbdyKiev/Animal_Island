import Field.Field;
import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.Animal.Herbivore.Horse;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.AnimalConstants;

public class Main {
    public static void main(String[] args) {
        System.out.println(AnimalConstants.images);

        Field island = new Field(10, 10);
        Cell cell = new Cell();
        Alive wolf= new Wolf(cell);
        Alive horse = new Horse(cell);
        System.out.println(cell.toString());
        System.out.println("kill the wolf");
        wolf.die();
        System.out.println(cell.toString());
    }
}