package com.openbargames.blackbeard;

import com.artemis.*;
import com.artemis.utils.EntityBuilder;
import com.openbargames.blackbeard.component.Position;
import com.openbargames.blackbeard.component.Velocity;
import com.openbargames.blackbeard.system.MovementSystem;

public class Game {

	private World world;

	private EntityBuilder entityBuilder;

	public Game() {
		createWorld();
		createEntityBuilder();
	}

	public void start() throws Exception {
		Entity entity = entityBuilder.build();

		System.out.println("Entity created: " + entity);

		while (true) {
			world.setDelta(1000);
			world.process();
			Thread.sleep(1000);
		}
	}

	private void createWorld() {
		WorldConfiguration config = new WorldConfigurationBuilder()
				.with(new MovementSystem())
				.build();

		world = new World(config);
	}

	private void createEntityBuilder() {
		entityBuilder = new EntityBuilder(world)
				.with(new Position(), new Velocity(1, 1));
	}
}
