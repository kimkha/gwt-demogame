package firstgame.client.base;

import com.google.gwt.user.client.ui.Image;

import firstgame.shared.Constant;

public class Commons {
	public static Image getBlockImage(int type) {
		switch (type) {
		case Constant.FLOOR.BROWN:
			return new Image("images/block_brown.png");
		case Constant.FLOOR.DIRT:
			return new Image("images/block_dirt.png");
		case Constant.FLOOR.GRASS:
			return new Image("images/block_grass.png");
		case Constant.FLOOR.PLAIN:
			return new Image("images/block_plain.png");
		case Constant.FLOOR.STONE:
			return new Image("images/block_stone.png");
		case Constant.FLOOR.STONE_TALL:
			return new Image("images/block_stone_tall.png");
		case Constant.FLOOR.WALL:
			return new Image("images/block_wall.png");
		case Constant.FLOOR.WALL_TALL:
			return new Image("images/block_wall_tall.png");
		case Constant.FLOOR.WATER:
			return new Image("images/block_water.png");
		case Constant.FLOOR.WOOD:
			return new Image("images/block_wood.png");
		}
		
		return new Image("images/block_brown.png");
	}

	public static Image getCharacterImage(int type) {
		switch (type) {
		case Constant.CHARACTER.BOY:
			return new Image("images/character_boy.png");
		case Constant.CHARACTER.CAT_GIRL:
			return new Image("images/character_cat_girl.png");
		case Constant.CHARACTER.HORN_GIRL:
			return new Image("images/character_horn_girl.png");
		case Constant.CHARACTER.PINK_GIRL:
			return new Image("images/character_pink_girl.png");
		case Constant.CHARACTER.PRINCESS:
			return new Image("images/character_princess_girl.png");
		}
		
		return new Image("images/character_boy.png");
	}
	
}
