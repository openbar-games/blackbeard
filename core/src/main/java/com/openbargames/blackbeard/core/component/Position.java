package com.openbargames.blackbeard.core.component;

import com.artemis.Component;

public class Position extends Component {

	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override public String toString() {
		return "Position{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
