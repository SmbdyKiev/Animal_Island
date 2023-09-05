import Field.Field;
import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.AnimalConstants;

public class Main {
    public static void main(String[] args) {
        System.out.println(AnimalConstants.images);

        Field island = new Field(10, 10);
        Cell cell = new Cell();
        Alive wolf= new Wolf(cell);
        cell.addRepresentative(new Wolf(cell));
        System.out.println(cell.toString());
        for (String s:cell.getRepresentatives().keySet()) {
            System.out.println(s);
        }
        System.out.println();
    }
}