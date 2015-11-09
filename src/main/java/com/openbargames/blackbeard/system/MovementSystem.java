package com.openbargames.blackbeard.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.openbargames.blackbeard.component.Position;
import com.openbargames.blackbeard.component.Velocity;

public class MovementSystem extends EntityProcessingSystem {

	ComponentMapper<Position> mPosition;
	ComponentMapper<Velocity> mVelocity;

	public MovementSystem() {
		super(Aspect.all(Position.class, Velocity.class));
	}

	@Override protected void process(Entity e) {
		Position position = mPosition.create(e);
		Velocity velocity = mVelocity.create(e);

		position.setX(position.getX() + velocity.getX());
		position.setY(position.getY() + velocity.getY());

		System.out.println("Moving entity " + e + " to position " + position);
	}
}
