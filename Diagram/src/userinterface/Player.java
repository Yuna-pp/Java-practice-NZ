package userinterface;

import ecs100.UI;

public class Player implements GameObject {
    private int row = -1;
    private int col = -1;
    private boolean isSet = false;
    private String imagePath = "picture.png";

    public Player(String imagePath) {
        this.imagePath = imagePath;
    }
    
    @Override
	public void draw(double mapLeft, double mapTop, double tileSize) {
		// TODO Auto-generated method stub
		if (isSet && row >= 0 && col >= 0) {
            double px = mapLeft + col * tileSize;
            double py = mapTop + row * tileSize;
            UI.drawImage(imagePath, px+2, py+2, tileSize-2, tileSize-2);
        }
	}	
    
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
        this.isSet = true;
    }
    public void move(int dRow, int dCol) {
        this.row += dRow;
        this.col += dCol;
    }

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

    public boolean isSet() {
        return isSet;
    }

	public void setSet(boolean isSet) {
		this.isSet = isSet;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
