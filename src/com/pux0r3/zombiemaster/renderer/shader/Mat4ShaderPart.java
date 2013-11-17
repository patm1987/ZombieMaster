package com.pux0r3.zombiemaster.renderer.shader;

import com.pux0r3.zombiemaster.math.Matrix44;
import android.opengl.GLES20;

public class Mat4ShaderPart {
	private Matrix44 mMatrix;
	private int mMatrixId;
	
	public Mat4ShaderPart(Shader shader, String name){
		mMatrixId = GLES20.glGetUniformLocation(shader.getProgram(), name);
	}
	
	public void setMatrix(Matrix44 matrix) {
		mMatrix = matrix;
		GLES20.glUniformMatrix4fv(mMatrixId, 1, false, matrix.getValues(), 0);
	}
	
	public Matrix44 getMatrix() {
		return mMatrix;
	}
}
