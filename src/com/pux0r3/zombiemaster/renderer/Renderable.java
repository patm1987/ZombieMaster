package com.pux0r3.zombiemaster.renderer;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.pux0r3.zombiemaster.math.Vector3;

public class Renderable {
	private Vector3[] mVertices;
	private int mIndices;
	
	private boolean mVertexBufferDirty = true;
	private FloatBuffer mVertexBuffer;
	
	private boolean mIndexBufferDirty = true;
	private IntBuffer mIndexBuffer;
	
	public FloatBuffer getVertexBuffer() {
		if (mVertexBufferDirty) {
			regenerateVertexBuffer();
		}
		return mVertexBuffer;
	}
	
	private void regenerateVertexBuffer() {
		// TODO Auto-generated method stub
		
	}

	public IntBuffer getIndexBuffer() {
		if (mIndexBufferDirty) {
			regenerateIndexBuffer();
		}
		return mIndexBuffer;
	}

	private void regenerateIndexBuffer() {
		// TODO Auto-generated method stub
		
	}
}
