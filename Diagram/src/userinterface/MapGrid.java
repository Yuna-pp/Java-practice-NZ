package userinterface;

import java.awt.Color;

import ecs100.UI;

//编辑和修改地图，专门处理编辑逻辑
/**
 * @param Edit and modify maps, specifically handling editing logic
 */
public class MapGrid {
	private MapType[][] grid;//存储地图二维网格数据的阵列 Store 2D grid data for maps
	//默认工具是WALL The drawing tool currently selected by the user is initialized as a wall by default
	private MapType currentTool = MapType.WALL;
    //The player objects associated with the current map
    private Player player;
    //The left and upper boundary offset of the map drawn on the canvas (in pixels)
    private static final double mapLeft =10;
	private static final double mapTop =10;
	//每个格子在屏幕上渲染的边长大小（像素）
	private static final double tileSize =20;
  
    public void handleMouseClick(double mouseX, double mouseY) {
    	//mouseX鼠标点击位置的X坐标
    	//mouseY鼠标点击位置的Y坐标
    	// 把鼠标的像素坐标 (X, Y) 换算成二维数组的下标 (col, row)
    	int col = (int) ((mouseX-mapLeft)/tileSize);//
        int row = (int) ((mouseY-mapTop)/tileSize);
        //check鼠标点的在不在地图内部
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        switch (currentTool) {
        case WALL:
            grid[row][col] = MapType.WALL;
            break;
        case DOOR:
            grid[row][col] = MapType.DOOR;
            break;
        case ERASER:
        	grid[row][col] = MapType.FLOOR;
            break;
        case FLOOR: // 橡皮擦 Eraser
            grid[row][col] = MapType.FLOOR;
            break;
        case COIN:
        	grid[row][col] = MapType.COIN;
            break;
        	
		default:
			break;
        }
    }
    /**
     * 
     * Traverse the entire map grid based on the types stored in each grid (such as walls, floors, etc.)
	 * Draw corresponding graphics on the canvas
     * @param object 当前触发重绘或关联的游戏对象 The current game object that triggers redrawing or associationS
     * 
     */
    public void drawTool(GameObject object) {
    	if (grid == null) return;
    	UI.clearGraphics();//清空旧画布，避免画面重叠
    	for (int row = 0; row < grid.length; row++) {
    		for (int col = 0; col < grid[0].length; col++) {
    			// 计算当前格子在屏幕上的像素坐标
    			// Calculate the pixel coordinates of the current grid on the screen
    			double x = mapLeft + col*tileSize;
                double y = mapTop+row*tileSize;
                switch (grid[row][col]) {
                // 根据网格类型绘制对应的颜色块 Draw corresponding color blocks based on the grid type
                case WALL:
                    UI.setColor(Color.DARK_GRAY);
                    UI.fillRect(x, y, tileSize, tileSize);
                    break;
                case FLOOR:
                    UI.setColor(Color.LIGHT_GRAY);
                    UI.fillRect(x, y, tileSize, tileSize);
                    break;
                case DOOR:
                    UI.setColor(Color.GREEN);
                    UI.fillRect(x, y, tileSize, tileSize);
                    UI.setColor(Color.BLACK);
                    UI.fillOval(x+2, y+8, 3, 3);
                    break;
                case COIN:
                	UI.setColor(Color.LIGHT_GRAY);
                    UI.fillRect(x, y, tileSize, tileSize);
                	UI.setColor(Color.orange);
                	UI.fillOval(x + tileSize/4, y + tileSize/4, tileSize/2, tileSize/2);
                	break;
               //其他未处理类型默认画成地板 Other unprocessed types are drawn as flooring by default
                default:
                	UI.setColor(Color.LIGHT_GRAY); 
                    UI.fillRect(x, y, tileSize, tileSize);   
                    break;
            }
                UI.setColor(Color.BLACK);
                UI.drawRect(x, y, tileSize, tileSize);
    		}
    	}
    	if (object != null) {
            object.draw(mapLeft, mapTop, tileSize);
        }
    	
    }
    public MapGrid(MapType[][] grid) {
        this.grid = grid;
    }
    public MapType[][] getGrid() {
		return grid;
	}

	public void setGrid(MapType[][] grid) {
		this.grid = grid;
	}

	public MapType getCurrentTool() {
		return currentTool;
	}

	public void setCurrentTool(MapType currentTool) {
		this.currentTool = currentTool;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
