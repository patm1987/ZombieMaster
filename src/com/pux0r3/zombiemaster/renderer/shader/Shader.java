package com.pux0r3.zombiemaster.renderer.shader;

import android.opengl.GLES20;

public class Shader {
	private static final int kInvalidShader = -1;
	
	private boolean mInitialized = false;
	
	private int mVertex = kInvalidShader;
	private int mFragment = kInvalidShader;
	private int mProgram = kInvalidShader;
	
	public void Init(String vertexShader, String fragmentShader)
			throws AlreadyInitializedException {
		if (mInitialized) {
			throw new AlreadyInitializedException();
		}
		
		mVertex = loadShader(ShaderType.Vertex, vertexShader);
		mFragment = loadShader(ShaderType.Fragment, fragmentShader);
		mProgram = generateProgram(mVertex, mFragment);
		
		mInitialized = true;
	}
	
	public boolean isIntitialized() {
		return mInitialized;
	}
	
	public int getVertexShader() {
		return mVertex;
	}
	
	public int getFragmentShader() {
		return mFragment;
	}
	
	public int getShader(ShaderType type)
	{
		switch(type)
		{
		case Vertex:
			return mVertex;
			
		case Fragment:
			return mFragment;
		}
		return kInvalidShader;
	}
	
	public int getProgram() {
		return mProgram;
	}
	
	private int generateProgram(int vertexShader, int fragmentShader) {
		int program = GLES20.glCreateProgram();
		
		GLES20.glAttachShader(program, vertexShader);
		GLES20.glAttachShader(program, fragmentShader);
		GLES20.glLinkProgram(program);
		
		return program;
	}
	
	private int createShader(ShaderType type) {
		return GLES20.glCreateShader(shaderTypeToInt(type));
	}
	
	private int loadShader(ShaderType type, String code) {
		int shader = createShader(type);
		
		GLES20.glShaderSource(shader, code);
		GLES20.glCompileShader(shader);
		
		return shader;
	}
	
	private int shaderTypeToInt(ShaderType type) {
		switch(type) {
		case Vertex:
			return GLES20.GL_VERTEX_SHADER;

		case Fragment:
			return GLES20.GL_FRAGMENT_SHADER;

		default:
			return GLES20.GL_NONE;
		}
	}

	public enum ShaderType {
		Vertex,
		Fragment
	}
	
	public class AlreadyInitializedException extends Exception {
		private static final String kExceptionText = "Shader Already Initialized!";
		
		public AlreadyInitializedException() {
			super(kExceptionText);
		}
	}
}
