package com.pux0r3.zombiemaster.renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Vector;

import com.pux0r3.zombiemaster.math.Vector3;
import com.pux0r3.zombiemaster.renderer.shader.Mat4ShaderPart;

/**
 * Represents an object that can be drawn by our rendering system
 * 
 * @author Patrick
 *
 */
public class Renderable {
	private Vector3[] mVertices;
	private int[] mIndices;
	
	private boolean mVertexBufferDirty = true;
	private FloatBuffer mVertexBuffer;
	
	private boolean mIndexBufferDirty = true;
	private IntBuffer mIndexBuffer;
	
	private Vector<Pass> mRenderPasses = new Vector<Pass>();
	
	/**
	 * Public accessor for the vertex buffer (ready for OpenGL ES rendering)
	 * 
	 * @return The vertices, ready to render
	 */
	public FloatBuffer getVertexBuffer() {
		if (mVertexBufferDirty) {
			regenerateVertexBuffer();
		}
		return mVertexBuffer;
	}
	
	/**
	 * Regenerates the vertex buffer (if dirty)
	 */
	private void regenerateVertexBuffer() {
		ByteBuffer bb = ByteBuffer.allocateDirect(mVertices.length * 3 * 4);
		bb.order(ByteOrder.nativeOrder());
		mVertexBuffer = bb.asFloatBuffer();
		
		for(Vector3 v : mVertices) {
			mVertexBuffer.put(v.X);
			mVertexBuffer.put(v.Y);
			mVertexBuffer.put(v.Z);
		}
		mVertexBuffer.position(0);
		
		mVertexBufferDirty = false;
	}

	/**
	 * Retrieves the index buffer for rendering
	 * 
	 * @return The index buffer, prepared for GLES 2.0
	 */
	public IntBuffer getIndexBuffer() {
		if (mIndexBufferDirty) {
			regenerateIndexBuffer();
		}
		return mIndexBuffer;
	}

	/**
	 * Regenerates the index buffer for GLES 2.0 rendering
	 */
	private void regenerateIndexBuffer() {
		ByteBuffer bb = ByteBuffer.allocateDirect(mIndices.length * 4);
		bb.order(ByteOrder.nativeOrder());
		mIndexBuffer = bb.asIntBuffer();

		mIndexBuffer.put(mIndices);
		mIndexBuffer.position(0);
		
		mIndexBufferDirty = false;
	}
	
	public void addRenderPass(Pass pass) {
		mRenderPasses.add(pass);
	}
}
