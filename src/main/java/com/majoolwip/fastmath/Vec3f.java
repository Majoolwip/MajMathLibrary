package com.majoolwip.fastmath;

public class Vec3f {
	private float x, y, z;
	private float cachedLength = -1;

	public Vec3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public float invLength() {
		return 1f / length();
	}

	public Vec3f normalized() {
		float length = length();
		return new Vec3f(x / length, y / length, z / length);
	}

	public float dot(Vec3f r) {
		return x * r.x + y * r.y + z * r.z;
	}

	public Vec3f cross(Vec3f r) {
		return new Vec3f(
				y * r.z - z * r.y,
				z * r.x - x * r.z,
				x * r.y - y * r.x);
	}

	public Vec3f add(Vec3f r) {
		return new Vec3f(x + r.x, y + r.y, z + r.z);
	}

	public Vec3f add(float r) {
		return new Vec3f(x + r, y + r, z + r);
	}

	public Vec3f sub(Vec3f r) {
		return new Vec3f(x - r.x, y - r.y, z - r.z);
	}

	public Vec3f sub(float r) {
		return new Vec3f(x - r, y - r, z - r);
	}

	public Vec3f mul(Vec3f r) {
		return new Vec3f(x * r.x, y * r.y, z * r.z);
	}

	public Vec3f mul(float r) {
		return new Vec3f(x * r, y * r, z * r);
	}

	public Vec3f div(Vec3f r) {
		return new Vec3f(x / r.x, y / r.y, z / r.z);
	}

	public Vec3f div(float r) {
		return new Vec3f(x / r, y / r, z / r);
	}

	public void set(Vec3f r) {
		this.x = r.x;
		this.y = r.y;
		this.z = r.z;
	}

	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Vec3f) {
			Vec3f v = (Vec3f) o;
			return (Math.abs(v.x - x) < Defs.EPSILON) &&
					(Math.abs(v.y - y) < Defs.EPSILON) &&
					(Math.abs(v.z - z) < Defs.EPSILON);
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
		return "{ " + x + " " + y + " " + z + " }";
	}
}
