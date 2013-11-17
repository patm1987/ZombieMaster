package com.pux0r3.zombiemaster.renderer.shader;

public class BasicMVPShader extends Shader {
	private Mat4ShaderPart mMVPMatrixPart;
	private final String kDefaultMVPUniformName = "uMVPMatrix";
	
	public Mat4ShaderPart GetMVPMatrixPart() {
		return mMVPMatrixPart;
	}
	
	@Override
	public void Init(String vertexShader, String fragmentShader)
			throws AlreadyInitializedException {
		Init(vertexShader, fragmentShader, kDefaultMVPUniformName);
	}
	
	public void Init(String vertexShader, String fragmentShader, String mvpUniformName)
			throws AlreadyInitializedException {
		super.Init(vertexShader, fragmentShader);
		
		mMVPMatrixPart = new Mat4ShaderPart(this, mvpUniformName);
	}
}
