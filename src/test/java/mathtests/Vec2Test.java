package mathtests;

import com.majoolwip.fastmath.Defs;
import com.majoolwip.fastmath.Vec2f;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Vec2Test {

	@Test
	public void addTest() {
		Vec2f a = new Vec2f(1,2);
		Vec2f b = new Vec2f(3, 4);
		Vec2f res = a.add(b);
		assertEquals(4, res.x(), Defs.EPSILON);
		assertEquals(6, res.y(), Defs.EPSILON);

		res = res.add(10);
		assertEquals(14, res.x(), Defs.EPSILON);
		assertEquals(16, res.y(), Defs.EPSILON);
	}

	@Test
	public void subTest() {
		Vec2f a = new Vec2f(1,2);
		Vec2f b = new Vec2f(3, 4);
		Vec2f res = a.sub(b);
		assertEquals(-2, res.x(), Defs.EPSILON);
		assertEquals(-2, res.y(), Defs.EPSILON);

		res = res.sub(10);
		assertEquals(-12, res.x(), Defs.EPSILON);
		assertEquals(-12, res.y(), Defs.EPSILON);
	}

	@Test
	public void mulTest() {
		Vec2f a = new Vec2f(1,2);
		Vec2f b = new Vec2f(3, 4);
		Vec2f res = a.mul(b);
		assertEquals(3, res.x(), Defs.EPSILON);
		assertEquals(8, res.y(), Defs.EPSILON);

		res = res.mul(10);
		assertEquals(30, res.x(), Defs.EPSILON);
		assertEquals(80, res.y(), Defs.EPSILON);
	}

	@Test
	public void divTest() {
		Vec2f a = new Vec2f(1,2);
		Vec2f b = new Vec2f(3, 4);
		Vec2f res = a.div(b);
		assertEquals(1/3d, res.x(), Defs.EPSILON);
		assertEquals(2/4d, res.y(), Defs.EPSILON);

		res = res.div(10);
		assertEquals(1/30d, res.x(), Defs.EPSILON);
		assertEquals(2/40d, res.y(), Defs.EPSILON);
	}

	@Test
	public void lengthTest() {
		Vec2f a = new Vec2f(3,4);
		assertEquals(5, a.length(), Defs.EPSILON);
		a.set(0,1);
		assertEquals(1, a.length(), Defs.EPSILON);
		a.set(1,0);
		assertEquals(1, a.length(), Defs.EPSILON);
		a.set(0,0);
		assertEquals(0, a.length(), Defs.EPSILON);
	}

	@Test
	public void invLengthTest() {
		Vec2f a = new Vec2f(3,4);
		assertEquals(1/5d, a.invLength(), Defs.EPSILON);
		a.set(0,1);
		assertEquals(1/1d, a.invLength(), Defs.EPSILON);
		a.set(1,0);
		assertEquals(1/1d, a.invLength(), Defs.EPSILON);
	}

	@Test
	public void dotTest() {
		Vec2f a = new Vec2f(1, 0);
		Vec2f b = new Vec2f(0, 1);
		assertEquals(0, a.dot(b), Defs.EPSILON);
		assertEquals(0, b.dot(a), Defs.EPSILON);
		b.set(1, 0);
		assertEquals(1, a.dot(b), Defs.EPSILON);
		assertEquals(1, b.dot(a), Defs.EPSILON);
	}

	@Test
	public void equalsTest() {
		Vec2f a = new Vec2f(1, 1);
		Vec2f b = new Vec2f(1, 1);
		assertTrue(a.equals(b));
		b.set(0,0);
		assertFalse(a.equals(b));
	}

	@Test
	public void toStringTest() {
		Vec2f a = new Vec2f(1,1);
		assertEquals("{ " + 1d + " " + 1d + " }", a.toString());
	}

	@Test
	public void setTest() {
		Vec2f a = new Vec2f(5,9);
		assertEquals(5, a.x(), Defs.EPSILON);
		assertEquals(9, a.y(), Defs.EPSILON);
		a.set(10, 18);
		assertEquals(10, a.x(), Defs.EPSILON);
		assertEquals(18, a.y(), Defs.EPSILON);
		Vec2f b = new Vec2f(-1, -5);
		a.set(b);
		assertEquals(-1, a.x(), Defs.EPSILON);
		assertEquals(-5, a.y(), Defs.EPSILON);
	}
}
