//class for position object
public class Position{

    private int row;
    private int col;



    /**
     * constructor
     * @param r
     * @param c
     */
    public Position(int r, int c){
        col = c;
        row = r;
    }

    /**
     * gets row
     * @return
     */
    public int getRow(){
        return row;
    }

    /**
     * gets column
     * @return
     */
    public int getCol(){
        return col;
    }

    /**
     * changes row
     * @param r
     */
    public void setRow(int r) {
        row = r;
    }

    /**
     * changes column
     * @param c
     */
    public void setCol(int c){
        col = c;
    }
}
