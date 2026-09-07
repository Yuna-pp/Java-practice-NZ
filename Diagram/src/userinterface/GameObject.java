package userinterface;

/**
 * @author Yunian
 * @version 1.0
 */
public interface GameObject {
	/**
	 * get the row position in the game
	 * @return Row index (starting from 0)
	 */
	int getRow();
	/**
	 * get the column position in the game
	 * @return column index(starting from 0)
	 */
    int getCol();
    /**
     * check the game object whether in the map
     * @return If the object has been set to return true, otherwise return false
     */
    boolean isSet();
    /**
     * 
     * @param mapLeft The X-axis pixel offset of the left boundary of the map on the screen
     * @param mapTop The Y-axis pixel offset of the boundary on the map on the screen
     * @param tileSize Pixel size of each grid 每个网格的大小
     */
    void draw(double mapLeft, double mapTop, double tileSize);

}
