package com.unk.PoC.level.block;

import com.unk.PoC.*;
import com.unk.PoC.entities.*;
import com.unk.PoC.gui.Sprite;

public class LadderBlock extends Block {
	private static final int LADDER_COLOR = 0xDB8E53;
	public boolean wait;

	public LadderBlock(boolean down) {
		if (down) {
			floorTex = 1;
			addSprite(new Sprite(0, 0, 0, 8 + 3, Art.getCol(LADDER_COLOR)));
		} else {
			ceilTex = 1;
			addSprite(new Sprite(0, 0, 0, 8 + 4, Art.getCol(LADDER_COLOR)));
		}
	}

	public void removeEntity(Entity entity) {
		super.removeEntity(entity);
		if (entity instanceof Player) {
			wait = false;
		}
	}

	public void addEntity(Entity entity) {
		super.addEntity(entity);

		if (!wait && entity instanceof Player) {
			level.switchLevel(id);
			Sound.ladder.play();
		}
	}
}
