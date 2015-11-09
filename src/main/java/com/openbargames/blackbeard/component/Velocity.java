package com.openbargames.blackbeard.component;

import com.artemis.Component;

public class Velocity extends Component {

	private int x;
	private int y;

	public Velocity() { }

	public Velocity(int x, int y) {
		this.x = x;
		this.y = y;
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
