package com.majoolwip.fastmath;

public class Vec4f {
	private float x, y, z, w;

	public Vec4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}


	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}

	public float invLength() {
		return 1f / length();
	}

	public Vec3f normalized() {
		float length = invLength();
		return new Vec3f(x * length, y * length, z * length);
	}

	public float dot(Vec4f r) {
		return x * r.x() + y * r.y() + z * r.z() + w * r.w();
	}

	public Vec4f add(Vec4f r) {
		return new Vec4f(x + r.x(), y + r.y(), z + r.z(), w + r.w());
	}

	public Vec4f add(float r) {
		return new Vec4f(x + r, y + r, z + r, w + r);
	}

	public Vec4f sub(Vec4f r) {
		return new Vec4f(x - r.x(), y - r.y(), z - r.z(), w - r.w());
	}

	public Vec4f sub(float r) {
		return new Vec4f(x - r, y - r, z - r, w - r);
	}

	public Vec4f mul(Vec4f r) {
		return new Vec4f(x * r.x(), y * r.y(), z * r.z(), w * r.w());
	}

	public Vec4f mul(float r) {
		return new Vec4f(x * r, y * r, z * r, w * r);
	}

	public Vec4f div(Vec4f r) {
		return new Vec4f(x / r.x(), y / r.y(), z / r.z(), w / r.w());
	}

	public Vec4f div(float r) {
		return new Vec4f(x / r, y / r, z / r, w / r);
	}

	public void set(Vec4f r) {
		this.x = r.x();
		this.y = r.y();
		this.z = r.z();
		this.w = r.w();
	}

	public void set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Vec4f) {
			Vec4f v = (Vec4f) o;
			return (Math.abs(v.x - x) < Defs.EPSILON) &&
					(Math.abs(v.y - y) < Defs.EPSILON) &&
					(Math.abs(v.z - z) < Defs.EPSILON) &&
					(Math.abs(v.w - z) < Defs.EPSILON);
		}
		return false;
	}

	public float x() {
		return x;
	}

	public float y() {
		return y;
	}

	public float z() {
		return z;
	}

	public float w() {
		return w;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void setW(float w) {
		this.w = w;
	}

	public Vec3f xyz() {
		return new Vec3f(x,y,z);
	}

	public Vec2f xy() {
		return new Vec2f(x, y);
	}

	public Vec2f xz() {
		return new Vec2f(x, z);
	}

	public Vec2f yz() {
		return new Vec2f(y, z);
	}

	@Override
	public String toString() {
		return "{ " + x + " " + y + " " + z + " " + w + " }";
	}
}
