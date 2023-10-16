package Field;

import LiveObjects.AliveFactory;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private int height;
    private int width;

    private Cell [][] cells;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        cells=new Cell[width][height];
    }

    public void initialize(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = new Cell();
                cells[i][j]=cell;
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i>0) {cells[i][j].addNeighbors(cells[i-1][j]);}
                if (i<=cells.length-2) {cells[i][j].addNeighbors(cells[i+1][j]);}
                if (j>0) {cells[i][j].addNeighbors(cells[i][j-1]);}
                if (j<=cells[i].length-2) {cells[i][j].addNeighbors(cells[i][j+1]);}
            }
        }
        AliveFactory factory = new AliveFactory();
        for (Cell[] rows:cells) {
            for (Cell cell:rows) {
                factory.randomPlant(cell);
                factory.randomPredator(cell);
                factory.randomHerbivore(cell);
                factory.randomHerbivore(cell);
                System.out.println("Created cell with alives:");
                System.out.println(cell);
            }
        }
    }

    public String getFieldStatus(){
        Map[][] maps=new Map[width][height];

        for (int row=0;row<height;row++){
            for (int column=0;column<width;column++){
                if (cells[row][column] != null){
                    maps[row][column]=cells[row][column].getPivot();
                }
                else maps[row][column]=null;
            }
        }
        return maps.toString();
    }

    public String getCellStatus(int x, int y){
        if ((x < width) && (y < height)) return "Cell (" + x + ";" + y + ") has next representatives:\n" + cells[x][y].toString();
        else return "incorrect cell address\n";
    }
}
