package com.openbargames.blackbeard.core.component;

import com.artemis.Component;

public class Velocity extends Component {

	private int x;
	private int y;

	public Velocity() { }

	public Velocity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void invertX() {
		x *= -1;
	}

	public void invertY() {
		y *= -1;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
