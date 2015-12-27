package com.wewritecode.turnytiles;

/**
 * Created by levirosol on 12/26/15.
 */
public class Grid {
    private GridCell[][] _cells;
    private int _cellHeight;
    private int _cellWidth;
    private Level _level;

    public Grid(Level level, int height, int width) {
        this._level = level;
        _cells = new GridCell[width][height];
        _cellHeight = 32;
        _cellWidth = 32;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                GridCell cell;

                cell = new GridCell(x,y,_cellHeight, _cellWidth, this, level.getTile(x,y));

                _cells[cell.getX()][cell.getY()] = cell;
            }
        }
    }

    public GridCell getCell(int x, int y) {
        GridCell node = _cells[x][y];

        return node;
    }

    public GridCell getCellByAbs(int x, int y) {
        int cellX = x / _cellWidth;
        int cellY = y / _cellHeight;

        return _cells[cellX][cellY];
    }

    public Level getLevel(){
        return _level;
    }

}
