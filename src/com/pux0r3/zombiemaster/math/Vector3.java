package com.pux0r3.zombiemaster.math;

public class Vector3 implements Cloneable {
	public float X, Y, Z;
	
	public Vector3(float x, float y, float z) {
		X = x;
		Y = y;
		Z = z;
	}
	
	public Vector3 (Vector3 original) {
		this(original.X, original.Y, original.Z);
	}
	
	protected Object Clone() throws CloneNotSupportedException {
		return new Vector3(this);
	}
}
