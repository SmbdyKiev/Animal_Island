package Field;

public class Field {
    private int height;
    private int width;

    private Cell [][] cells=new Cell[height][width];

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
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
                if (j<=cells[i].length-2) {cells[i][j].addNeighbors(cells[i-1][j+1]);}
            }
        }
    }

    public String getCellStatus(int x, int y){
        if ((x < width) && (y < height)) return "Cell (" + x + ";" + y + ") has next representatives:\n" + cells[x][y].toString();
        else return "incorrect cell address\n";
    }
}
