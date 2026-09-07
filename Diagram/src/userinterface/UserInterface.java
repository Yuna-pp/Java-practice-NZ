package userinterface;

import java.awt.Color;

import ecs100.UI;
import ecs100.UIFileChooser;

public class UserInterface {
	
	private static final double MAP_LEFT=10;
	private static final double MAP_TOP =10;
	private static final double TILE_SIZE = 20;
    private MazeMap map;
    private MapGrid mapGrid;
    private Player player = new Player("lib/picture.png");
    private boolean isGameMode = false;
    private boolean isSettingPlayer = false;
    private int score = 0;
	
    private void createMap() {
        int rows = UI.askInt("Rows (5-30)");
        int columns = UI.askInt("Columns (5-30)");
        
        if (rows < 5 || rows > 30 || columns < 5 || columns > 30) {
            UI.println("Invalid map size.");
            return;
        }
        
        map = new MazeMap(rows, columns);       
        draw();
        if (map != null) {
            this.mapGrid = new MapGrid(map.getGrid());
        }
    }

    private void draw() {
        UI.clearGraphics();
        
        if (map != null) {
            map.draw(MAP_LEFT, MAP_TOP, TILE_SIZE);
        }
    }
    private void saveMap() {
        if (map == null) {
            UI.println("No map.");
            return;
        }
        String fileName = UIFileChooser.save();  
        if (fileName != null) {
            map.save(fileName);
        }
    }
    private void mapLoader() {
        MapType[][] grid = MapLoader.loadMapFromPGM();
        if (grid != null && grid.length > 0) {
            map = new MazeMap(grid); 
            this.mapGrid = new MapGrid(map.getGrid()); 
            mapGrid.drawTool(player);
        }
    }
	
    private void doMouse(String action, double x, double y) {
        if (action.equalsIgnoreCase("pressed") && mapGrid != null) {
        	if(isSettingPlayer) {
        		int col= (int) ((x-10)/20); // 换算列号
                int row= (int) ((y-10)/20); // 换算行号
                setPlayerStartPosition(row, col);
                isSettingPlayer = false; 
                return;
        	}
            mapGrid.handleMouseClick(x, y); 
            redrawMap();         
        }
    }
    private void redrawMap() {
        if (mapGrid != null) {
            mapGrid.drawTool(player); // 传入player绘制
        }
    }
    
    public void setPlayerStartPosition(int row, int col) {
        MapType[][] grid = mapGrid.getGrid();
        this.score = 0;
        if (grid == null) return;
        //检查越界
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            UI.println("fail！Must in the Map");
            return;
        }
        // 检查是不是墙
        if (grid[row][col] == MapType.WALL) {
            UI.println("Fail! The start position can't set in the wall");
            return;
        }
        //更新 Player 对象的坐标
        player.setPosition(row, col);        
        //UI.println(col + ", " + row );
        // 重绘地图（把 player 画出来）
        mapGrid.drawTool(player);
       
    }
    
    public void doKey(String key) {
    	if (player == null || !player.isSet() ) return;
    	int nextRow = player.getRow();
        int nextCol = player.getCol();
        
        if (key.equalsIgnoreCase("w")) {
            nextRow--; //up
        } else if (key.equalsIgnoreCase("s")) {
            nextRow++; //down
        } else if (key.equalsIgnoreCase("a")) {
            nextCol--; //left
        } else if (key.equalsIgnoreCase("d")) {
            nextCol++; //right
        } else {
            return; 
        }
        MapType[][] grid = mapGrid.getGrid();
        if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
            return; // 出界，不移动
        }
        if (grid[nextRow][nextCol] == MapType.WALL) {
            return; // 撞墙，不移动
        }
        if (grid[nextRow][nextCol] == MapType.COIN) {//吃金币
        	this.score++;
        	grid[nextRow][nextCol] = MapType.FLOOR;
        	UI.println("Collected a coin! Total coins: " + score);
        }
        player.setPosition(nextRow, nextCol);
        if (grid[nextRow][nextCol] == MapType.DOOR) {//完成游戏
            this.isGameMode = true;
            mapGrid.drawTool(player); 
            UI.setFontSize(24);
            UI.setColor(Color.red);
            UI.drawString("Congratulations! Total coins: " + score, 90, 60);
            return;
        }
        mapGrid.drawTool(player);
    }
    
    public void enablePlayerSetting() {
        this.isSettingPlayer = true;
        UI.println("Click on the map to set player position.");
    }
    
    private void setWallTool() {
        mapGrid.setCurrentTool(MapType.WALL);
    }
     
    private void setDoorTool() {
        mapGrid.setCurrentTool(MapType.DOOR);
    }
    
    private void setEraserTool() {
        mapGrid.setCurrentTool(MapType.ERASER);
    }
    
    private void setCoinTool() {
    	mapGrid.setCurrentTool(MapType.COIN);
    }
	public UserInterface() {
		UI.initialise();
        UI.addButton("New Map", this::createMap);
        UI.addButton("Save map", this::saveMap);      
        UI.addButton("Load Map", this::mapLoader);
        UI.addButton("Tool: Wall", this::setWallTool);
        UI.addButton("Tool: Door",this::setDoorTool);
        UI.addButton("Tool: Eraser",this::setEraserTool);
        UI.addButton("Tool: Coin", this::setCoinTool);
        UI.addButton("Set Player", this::enablePlayerSetting);
        UI.setMouseListener(this::doMouse); 
        UI.setKeyListener(this::doKey); 
        UI.addButton("Quit", UI::quit);	
        }
	
	public static void main(String[] args) {
		new UserInterface();
	}
}
