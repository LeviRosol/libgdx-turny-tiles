# libgdx-turny-tiles
libGDX Turny Tiles game - PoC

I slapped this game together over a couple evenings where I had a little time to kill. The basic idea is a simple time killer game where you rotate sprites to make connecting shapes.

Game structure wise, all levels are contained within a single TMX file. The file gets loaded upon game load, and displays level 0. As tiles are turned, a check is done to see if all tiles now match the original layout. If they do not, the player keeps going. If they do all match, then the level is over and the next level is loaded.

# Useful information

* The TMX map is 10x10
* Tiles are 32x32
* Currently compiles for Android and Desktop
