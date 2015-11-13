package com.openbargames.blackbeard.core.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;

public class Graphic extends Component {

	private Texture texture;

	public Graphic() { }

	public Graphic(Texture texture) {
		this.texture = texture;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
}
