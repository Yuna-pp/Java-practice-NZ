package userinterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ecs100.UI;
import ecs100.UIFileChooser;
/**
 * @author Yunian
 * @version 1.0
 * 
 * 地图加载工具类，负责从文件中解析并加载地图布局。
 * Map loading tool class, responsible for parsing and loading map layouts from files.
 */
public class MapLoader {
	public static MapType[][] loadMapFromPGM() {
		/**
		 * 弹出文件选择器，读取用户指定的 PGM 格式文件，并将其解析转换为地图类型二维数组（MapType[][]）。
		 * Pop up the file selector, read the PGM format file specified by the user, 
		 * and parse it into a two-dimensional array of map types (MapType [] []).
		 * @return 解析成功返回转换后的 MapType[][] 二维数组；用户取消则为Null
		 * Successfully return the converted MapType [] [] two-dimensional array; 
		 * If the user cancels the selection while reading the file, return null.
		 */
        String fileName = UIFileChooser.open();
        if (fileName == null) return null; // 用户取消
        MapType[][] grid = null;
        try {
            Scanner scanner = new Scanner(new File(fileName));   
         // 1. 读取文件前两位的行列维度信息
           // Read the row and column dimension information of the first two digits of the file
            if (scanner.hasNextInt()) {
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                grid = new MapType[rows][cols];
                //Read grid pixel values row by row and column by column, and map them to the corresponding MapType enumeration
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        if (scanner.hasNextInt()) {
                            int val = scanner.nextInt();
                                if (val == 1) {
                                    grid[r][c] = MapType.WALL;
                                } else if (val == 2) {
                                    grid[r][c] = MapType.DOOR;
                                } else if (val == 3) {
                                    grid[r][c] = MapType.COIN; 
                                } else if(val==0) {
                                    grid[r][c] = MapType.FLOOR;
                                }  
                        }   
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            UI.println("File not found!");
        } catch (Exception e) {
            UI.println("Error loading map file.");
            e.printStackTrace();
        }
        return grid;
    }
   
}
