package Field;

public class Field {
    private int height;
    private int width;

    private Cell [][] cells=new Cell[height][width];

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void putCell(int x, int y, Cell cell){
        if(x < width && y < height){cells[x][y] = cell;}
    }

    public String getCellStatus(int x, int y){
        if (x<width && y<height) return "Cell ("+x+";"+y+") has next representatives:\n"+cells[x][y].toString();
        else return "incorrect cell address\n";
    }
}
