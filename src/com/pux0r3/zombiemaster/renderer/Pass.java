package com.pux0r3.zombiemaster.renderer;

import com.pux0r3.zombiemaster.renderer.shader.Shader;

/**
 * Represents a render pass
 * 
 * @author Patrick
 *
 */
public class Pass {
	
	private Shader mShader;

	public Shader getShader() {
		return mShader;
	}

	public void setShader(Shader shader) {
		mShader = shader;
	}

}
