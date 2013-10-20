package com.pux0r3.zombiemaster.renderer;

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
