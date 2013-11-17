package com.pux0r3.zombiemaster.math;

/**
 * Defines a 4x4 (16 element) row-major matrix
 * 
 * @author Patrick
 *
 */
public class Matrix44 {
	float mValues[] = new float[16];
	
	public Matrix44(float values[]) {
		int count = Math.min(mValues.length, values.length);
		for (int i = 0; i < count; i++) {
			mValues[i] = values[i];
		}
	}
	
	public Matrix44(
			float m00, float m10, float m20, float m30,
			float m01, float m11, float m21, float m31,
			float m02, float m12, float m22, float m32,
			float m03, float m13, float m23, float m33) {
		mValues[0] = m00;
		mValues[1] = m10;
		mValues[2] = m20;
		mValues[3] = m30;
		
		mValues[4] = m01;
		mValues[5] = m11;
		mValues[6] = m21;
		mValues[7] = m31;
		
		mValues[8] = m02;
		mValues[9] = m12;
		mValues[10] = m22;
		mValues[11] = m32;
		
		mValues[12] = m03;
		mValues[13] = m13;
		mValues[14] = m23;
		mValues[15] = m33;
	}
	
	public final float[] getValues() {
		return mValues;
	}
}
