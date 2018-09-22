package com.majoolwip.fastmath;

public class Quaternion {
	public float x, y, z, w;

	public Quaternion(float x, float y, float z, float w) {
		set(x,y,z,w);
	}

	public Quaternion(Vec3f axis, float radians) {
		float halfSin = (float)Math.sin(radians * 0.5f);
		float halfCos = (float)Math.cos(radians * 0.5f);
	}

	public float length() {
		return (float)Math.sqrt(x * x + y * y + z * z + w * w);
	}

	public float invLength() {
		return 1f / length();
	}

	public Quaternion normalized() {
		float invLength = invLength();
		return new Quaternion(x * invLength, y / invLength, z / invLength, w / invLength);
	}

	public Quaternion conjugate() {
		return new Quaternion(-x, -y, -z, w);
	}

	public Quaternion add(Quaternion r) {
		return new Quaternion(x + r.x, y + r.y, z + r.z, w + r.w);
	}

	public Quaternion add(float r) {
		return new Quaternion(x + r, y + r, z + r, w + r);
	}

	public Quaternion sub(Quaternion r) {
		return new Quaternion(x - r.x, y - r.y, z - r.z, w - r.w);

	}

	public Quaternion sub(float r) {
		return new Quaternion(x - r, y - r, z - r, w - r);
	}

	public Quaternion mul(Quaternion r) {
		return new Quaternion(x * r.w + w * r.x + y * r.z - z * r.y,
							  y * r.w + w * r.y + z * r.x - x * r.z,
							  z * r.w + w * r.z + x * r.y - y * r.x,
							  w * r.w - x * r.x - y * r.y - z * r.z);
	}

	public Quaternion mul(Vec3f r) {
		return new Quaternion(w * r.x() + y * r.z() - z * r.y(),
				              w * r.y() + z * r.x() - x * r.z(),
							  w * r.z() + x * r.y() - y * r.x(),
							  -x * r.x() - y * r.y() - z * r.z());
	}

	public Quaternion mul(float r) {
		return new Quaternion(x * r, y * r, z * r, w * r);
	}

	public void set(Quaternion r) {
		set(r.x, r.y, r.z, r.w);
	}

	public void set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	@Override
	public String toString() {
		return "[ " + x + " " + y + " " + z + " " + w + " ]";
	}
}
