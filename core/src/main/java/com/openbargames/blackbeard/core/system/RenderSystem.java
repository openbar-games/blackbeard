package com.openbargames.blackbeard.core.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.openbargames.blackbeard.core.component.Position;
import com.openbargames.blackbeard.core.component.Graphic;

public class RenderSystem extends EntityProcessingSystem {

	ComponentMapper<Position> mPosition;
	ComponentMapper<Graphic> mGraphic;

	private SpriteBatch batch;

	public RenderSystem() {
		super(Aspect.all(Position.class, Graphic.class));

		batch = new SpriteBatch();
	}

	@Override
	protected void begin() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	}

	@Override
	protected void process(Entity e) {
		Position position = mPosition.create(e);
		Graphic graphic = mGraphic.create(e);

		batch.begin();
		batch.draw(graphic.getTexture(), 100 + position.getX(), 100 + position.getY());
		batch.end();
	}
}
