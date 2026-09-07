package userinterface;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import ecs100.UI;
/**
 * 迷宫地图类，用于管理迷宫的尺寸以及各个格子（Tile）的类型。
 * Maze map class, used to manage the size of the maze and the types of each tile.
 * 
 */
public class MazeMap {
	private MapType[][] tiles;
	private MapType[][] grid;
    private int rows;
    private int columns;
    
	public MazeMap(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;		
		this.tiles = new MapType[rows][columns];
		newMap();
	}
	
	private void newMap() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {         	
            	if (isBoundary(row, col)) {
                    tiles[row][col] = MapType.WALL;
                } else {
                    tiles[row][col] = MapType.FLOOR;
                }
            }
        }       	
	}
	//判断是不是边界
	public boolean isBoundary(int row, int col) {
		return row == 0 || row == rows - 1 || col == 0 || col == columns - 1;
	}
	//通过判断格子是什么类型选择格子的颜色
	public void draw(double left, double top, double tileSize) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                double x = left + col * tileSize;
                double y = top + row * tileSize;
                switch (tiles[row][col]) {
                case FLOOR -> UI.setColor(Color.LIGHT_GRAY);
                case WALL -> UI.setColor(Color.DARK_GRAY);          
                }
            	UI.fillRect(x, y, tileSize, tileSize);          	
                UI.setColor(Color.BLACK);
                UI.drawRect(x, y, tileSize, tileSize);//画边界线
            }
        }
	}
	
	public void save(String fileName) {
        try {
        	PrintStream out = new PrintStream(new File(fileName));
            out.println(rows + " " + columns);
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                	if (tiles[row][col] == MapType.WALL) {
                        out.print("1 ");
                    } else if (tiles[row][col] == MapType.DOOR) {
                        out.print("2 ");
                    } else if (tiles[row][col] == MapType.COIN) {
                        out.print("3 "); 
                    }
                    else {
                        out.print("0 ");                     
                        }
                }
                out.println(); 
            }
            out.close();
            UI.println("Map saved successfully.");
        } catch (IOException e) {
            UI.println("Unable to save map.");
        }
    }

	public MazeMap(MapType[][] tiles) {
	    this.rows = tiles.length;
	    this.columns = tiles[0].length;
	    this.tiles = tiles;
	}
	
	public MapType[][] getGrid() {
	    return this.tiles;
	}	
}
