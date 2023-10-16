package LiveObjects.Plant;
import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;
public class Plant extends Alive {
    public Plant(Cell position){
        super(position, AnimalConstants.AnimalParameters.PLANT.getIcon());
        setWeight(AnimalConstants.AnimalParameters.PLANT.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.PLANT.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.PLANT.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.PLANT.getMinFood());
        System.out.println("Created " + this.getIcon());
    }
    @Override
    public void reproduce() {
        if ((this.isAlive()) && (getCurrentPosition().getRepresentatives().get(this.getIcon()).size()<this.getMaxRepresentatives())){
            Alive plant = new Plant(getCurrentPosition());
            Thread thread = new Thread(plant);
            thread.start();
        }
    }
    @Override
    public void run() {
        while (isAlive()){
            reproduce();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Plant life was interupted");
            }
        }
    }
}
