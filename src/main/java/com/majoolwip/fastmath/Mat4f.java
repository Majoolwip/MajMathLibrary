package com.majoolwip.fastmath;

public class Mat4f {
	public float[] m;

	public Mat4f() {
		m = new float[4 * 4];
	}

	public Mat4f(float[] m) {
		if(m.length != 16) {
			throw new RuntimeException("Matrix is not 4x4");
		} else {
			this.m = m;
		}
	}

	public Mat4f initIdentity() {
		int index = 0;
		m[index++] = 1; m[index++] = 0; m[index++] = 0; m[index++] = 0;
		m[index++] = 0; m[index++] = 1; m[index++] = 0; m[index++] = 0;
		m[index++] = 0; m[index++] = 0; m[index++] = 1; m[index++] = 0;
		m[index++] = 0; m[index++] = 0; m[index++] = 0; m[index] = 1;
		return this;
	}

	public Mat4f initTranslation(float x, float y, float z) {
		int index = 0;
		m[index++] = 1; m[index++] = 0; m[index++] = 0; m[index++] = x;
		m[index++] = 0; m[index++] = 1; m[index++] = 0; m[index++] = y;
		m[index++] = 0; m[index++] = 0; m[index++] = 1; m[index++] = z;
		m[index++] = 0; m[index++] = 0; m[index++] = 0; m[index] = 1;
		return this;
	}

	public Mat4f initRotation(float x, float y, float z) {
		float[] m1 = new float[4 * 4];
		float[] m2 = new float[4 * 4];
		float[] m3 = new float[4 * 4];

		float cosX = (float)Math.cos(x);
		float sinX = (float)Math.sin(x);
		float cosY = (float)Math.cos(y);
		float sinY = (float)Math.sin(y);
		float cosZ = (float)Math.cos(z);
		float sinZ = (float)Math.sin(z);

		int index = 0;
		m1[index++] = cosZ; m1[index++] = -sinZ; m1[index++] = 0; m1[index++] = 0;
		m1[index++] = sinZ; m1[index++] =  cosZ; m1[index++] = 0; m1[index++] = 0;
		m1[index++] = 0; m1[index++] = 0; m1[index++] = 1; m1[index++] = 0;
		m1[index++] = 0; m1[index++] = 0; m1[index++] = 0; m1[index] = 1;
		index = 0;
		m2[index++] = 1; m2[index++] = 0; m2[index++] = 0; m2[index++] = 0;
		m2[index++] = 0; m2[index++] = cosX; m2[index++] = -sinX; m2[index++] = 0;
		m2[index++] = 0; m2[index++] = sinX; m2[index++] = cosX; m2[index++] = 0;
		m2[index++] = 0; m2[index++] = 0; m2[index++] = 0; m2[index] = 1;
		index = 0;
		m3[index++] = cosY; m3[index++] = 0; m3[index++] = -sinY; m3[index++] = 0;
		m3[index++] = 0; m3[index++] = 1; m3[index++] = 0; m3[index++] = 0;
		m3[index++] = sinY; m3[index++] = 0; m3[index++] = cosY; m3[index++] = 0;
		m3[index++] = 0; m3[index++] = 0; m3[index++] = 0; m3[index] = 1;

		m = new Mat4f(m1).mul(new Mat4f(m3).mul(new Mat4f(m2))).m;
		return this;
	}

	public Mat4f initRotation(Vec3f f, Vec3f u, Vec3f r) {
		int index = 0;
		m[index++] = r.x(); m[index++] = r.y(); m[index++] = r.z(); m[index++] = 0;
		m[index++] = u.x(); m[index++] = u.y(); m[index++] = u.y(); m[index++] = 0;
		m[index++] = f.x(); m[index++] = f.y(); m[index++] = f.y(); m[index++] = 0;
		m[index++] = 0; m[index++] = 0; m[index++] = 0; m[index] = 1;
		return this;
	}

	public Vec4f transform(Vec4f r) {
		int index = 0;
		return new Vec4f(m[index++] * r.x() + m[index++] * r.y() + m[index++] * r.z() + m[index++] * r.w(),
				         m[index++] * r.x() + m[index++] * r.y() + m[index++] * r.z() + m[index++] * r.w(),
				         m[index++] * r.x() + m[index++] * r.y() + m[index++] * r.z() + m[index++] * r.w(),
				         m[index++] * r.x() + m[index++] * r.y() + m[index++] * r.z() + m[index] * r.w());
	}

	public Mat4f initScale(float x, float y, float z) {
		int index = 0;
		m[index++] = x; m[index++] = 0; m[index++] = 0; m[index++] = 0;
		m[index++] = 0; m[index++] = y; m[index++] = 0; m[index++] = 0;
		m[index++] = 0; m[index++] = 0; m[index++] = z; m[index++] = 0;
		m[index++] = 0; m[index++] = 0; m[index++] = 0; m[index] = 1;
		return this;
	}

	public Mat4f initPerspective(float fov, int width, int height, float zNear, float zFar) {
		float halfFOV = (float)Math.tan(fov / 2.0f);
		float zRange = zNear - zFar;
		float aspectRatio = (float)width / (float)height;

		int index = 0;
		m[index++] = 1.0f / (halfFOV * aspectRatio); m[index++] = 0;              m[index++] = 0;                       m[index++] = 0;
		m[index++] = 0;                              m[index++] = 1.0f / halfFOV; m[index++] = 0;                       m[index++] = 0;
		m[index++] = 0;                              m[index++] = 0;              m[index++] = (-zNear + zFar) / zRange;m[index++] = -2.0f * zFar * zNear / zRange;
		m[index++] = 0;                              m[index++] = 0;              m[index++] = -1;                       m[index] = 0;
		return this;
	}

	public Mat4f mul(Mat4f r) {
		Mat4f res = new Mat4f();
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				res.m[x + y * 4] =  m[x] * res.m[y * 4] +
									m[x * 4] * res.m[1 + y * 4] +
									m[x + 2 * 4] * res.m[2 + y * 4] +
									m[x + 3 * 4] * res.m[3 + y * 4];
			}
		}
		return res;
	}
}
