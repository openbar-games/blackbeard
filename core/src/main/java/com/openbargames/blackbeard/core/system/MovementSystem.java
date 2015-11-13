package com.openbargames.blackbeard.core.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.openbargames.blackbeard.core.component.Position;
import com.openbargames.blackbeard.core.component.Velocity;

public class MovementSystem extends EntityProcessingSystem {

	ComponentMapper<Position> mPosition;
	ComponentMapper<Velocity> mVelocity;

	public MovementSystem() {
		super(Aspect.all(Position.class, Velocity.class));
	}

	@Override
	protected void process(Entity e) {
		Position position = mPosition.create(e);
		Velocity velocity = mVelocity.create(e);

		if (position.getX() > 500 || position.getX() < 0) velocity.invertX();
		if (position.getY() > 500 || position.getY() < 0) velocity.invertY();

		position.setX(position.getX() + velocity.getX());
		position.setY(position.getY() + velocity.getY());

		System.out.println("Moving entity " + e + " to position " + position);
	}
}
