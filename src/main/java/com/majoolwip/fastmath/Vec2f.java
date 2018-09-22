package com.majoolwip.fastmath;

public class Vec2f {
	private float x, y;

	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public float invLength() {
		return 1f / length();
	}

	public Vec2f normalized() {
		float invLength = invLength();
		return new Vec2f(x / invLength, y / invLength);
	}

	public float dot(Vec2f r) {
		return x * r.x + y * r.y;
	}

	public Vec2f add(Vec2f r) {
		return new Vec2f(x + r.x, y + r.y);
	}

	public Vec2f add(float r) {
		return new Vec2f(x + r, y + r);
	}

	public Vec2f sub(Vec2f r) {
		return new Vec2f(x - r.x, y - r.y);
	}

	public Vec2f sub(float r) {
		return new Vec2f(x - r, y - r);
	}

	public Vec2f mul(Vec2f r) {
		return new Vec2f(x * r.x, y * r.y);
	}

	public Vec2f mul(float r) {
		return new Vec2f(x * r, y * r);
	}

	public Vec2f div(Vec2f r) {
		return new Vec2f(x / r.x, y / r.y);
	}

	public Vec2f div(float r) {
		return new Vec2f(x / r, y / r);
	}

	public void set(Vec2f r) {
		this.x = r.x;
		this.y = r.y;
	}

	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float x() {
		return x;
	}

	public float y() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Vec2f) {
			Vec2f v = (Vec2f) o;
			return (Math.abs(v.x - x) < Defs.EPSILON) && (Math.abs(v.y - y) < Defs.EPSILON);
		}
		return false;
	}

	@Override
	public String toString() {
		return "{ " + x + " " + y + " }";
	}
}
