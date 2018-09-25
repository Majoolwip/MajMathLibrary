package mathtests;

import com.majoolwip.fastmath.Defs;
import com.majoolwip.fastmath.Vec2f;
import com.majoolwip.fastmath.Vec3f;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Vec3Test {
	@Test
	public void constructorTest() {
		Vec3f a = new Vec3f(1,2,3);
		assertEquals(1, a.x(), Defs.EPSILON);
		assertEquals(2, a.y(), Defs.EPSILON);
		assertEquals(3, a.z(), Defs.EPSILON);
	}

	@Test
	public void lengthTest() {
		Vec3f a = new Vec3f(5, 10, 15);
		assertEquals(Math.sqrt(350), a.length(), Defs.EPSILON);
		a.set(-5, -10, -15);
		assertEquals(Math.sqrt(350), a.length(), Defs.EPSILON);
		a.set(0,0,0);
		assertEquals(Math.sqrt(0), a.length(), Defs.EPSILON);
	}

	@Test
	public void inverseLengthTest() {
		Vec3f a = new Vec3f(5, 5, 5);
		assertEquals(1 / a.length(), a.invLength(), Defs.EPSILON);
	}

	@Test
	public void normalizedTest() {
		Vec3f a = new Vec3f(10, 12, -12);
		a = a.normalized();
		assertEquals(1d, a.length(), Defs.EPSILON);
	}
}
