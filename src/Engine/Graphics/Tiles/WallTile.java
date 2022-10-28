package Engine.Graphics.Tiles;

import GameObject.Assets;

public class WallTile extends Tile {
    public WallTile(int id) {
        super(Assets.walls[id], id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
