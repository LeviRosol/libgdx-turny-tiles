package com.wewritecode.turnytiles;

import java.util.ArrayList;

/**
 * Created by levirosol on 12/26/15.
 */
public class GridCell {
    // The actual Stage XY
    private int _x;
    private int _y;

    // The size of the _cell
    private int _height;
    private int _width;

    private Tile _tile;
    private Grid _grid;


    public void set_tile(Tile tile){
        _tile = tile;
        _tile.setPosition(getGridX(), getGridY());
        _grid.getLevel().getLayer().addActor(get_tile());
    }

    public Tile get_tile(){
        return _tile;
    }

    public GridCell(int x, int y, int height, int width, Grid grid, Tile tile){
        _x = x;
        _y = y;
        _height = height;
        _width = width;
        _grid = grid;
//        set_tile(tile);
    }

    public int getGridX(){
        return _x * _width;
    }

    public int getGridY(){
        return _y * _height;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public Grid getGrid(){
        return _grid;
    }

    public boolean matchTileType(String type){
        return this._tile.getClass().getSimpleName().equals(type);
    }

    public boolean isLeftOfCell(GridCell cell){
        return (cell.getX() == getX() + 1) && cell.getY() == getY();
    }

    public boolean isRightOfCell(GridCell cell){
        return (cell.getX() == getX() - 1) && cell.getY() == getY();
    }

    public boolean isBelowCell(GridCell cell){
        return (cell.getX() == getX()) && (cell.getY() == getY() + 1);
    }

    public boolean isAboveCell(GridCell cell){
        return (cell.getX() == getX()) && (cell.getY() == getY() - 1);
    }

    // This checks the 4 cells adjacent to the cell
    public boolean nextToCell(GridCell cell) {
        // left
        if(isLeftOfCell(cell)){
            return true;
        }

        // right
        if(isRightOfCell(cell)){
            return true;
        }

        // up
        if(isBelowCell(cell)){
            return true;
        }

        // down
        if(isAboveCell(cell)){
            return true;
        }

        return false;
    }

    public ArrayList<GridCell> getNeighbors(){
        ArrayList<GridCell> cells = new ArrayList<GridCell>();

        cells.add(_grid.getCell(_x,_y));
        cells.add(_grid.getCell(_x+1,_y));
        cells.add(_grid.getCell(_x-1,_y));
        cells.add(_grid.getCell(_x,_y+1));
        cells.add(_grid.getCell(_x,_y-1));

        return cells;
    }

}
