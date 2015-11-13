package com.openbargames.blackbeard.core;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.utils.EntityBuilder;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.openbargames.blackbeard.core.component.Graphic;
import com.openbargames.blackbeard.core.component.Position;
import com.openbargames.blackbeard.core.component.Velocity;
import com.openbargames.blackbeard.core.system.MovementSystem;

public class Game implements ApplicationListener {

	private World world;
	private EntityBuilder entityBuilder;

	@Override
	public void create () {
		createWorld();
		createEntityBuilder();
		Entity entity = entityBuilder.build();

		System.out.println("Entity created: " + entity);
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {
		world.setDelta(Gdx.graphics.getDeltaTime());
		world.process();
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}

	private void createWorld() {
		WorldConfiguration config = new WorldConfigurationBuilder()
				.with(new MovementSystem())
				.build();

		world = new World(config);
	}

	private void createEntityBuilder() {
		entityBuilder = new EntityBuilder(world)
				.with(new Position(), new Velocity(1, 1), new Graphic(new Texture(Gdx.files.internal("libgdx-logo.png"))));
	}
}
