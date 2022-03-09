
package com.badlogic.gdx.math;

import static com.badlogic.gdx.math.MathUtils.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MathUtilsTest {

	@Test
	public void lerpAngleDeg () {
		assertEquals(10, MathUtils.lerpAngleDeg(10, 30, 0.0f), 0.01f);
		assertEquals(20, MathUtils.lerpAngleDeg(10, 30, 0.5f), 0.01f);
		assertEquals(30, MathUtils.lerpAngleDeg(10, 30, 1.0f), 0.01f);
	}

	@Test
	public void lerpAngleDegCrossingZero () {
		assertEquals(350, MathUtils.lerpAngleDeg(350, 10, 0.0f), 0.01f);
		assertEquals(0, MathUtils.lerpAngleDeg(350, 10, 0.5f), 0.01f);
		assertEquals(10, MathUtils.lerpAngleDeg(350, 10, 1.0f), 0.01f);
	}

	@Test
	public void lerpAngleDegCrossingZeroBackwards () {
		assertEquals(10, MathUtils.lerpAngleDeg(10, 350, 0.0f), 0.01f);
		assertEquals(0, MathUtils.lerpAngleDeg(10, 350, 0.5f), 0.01f);
		assertEquals(350, MathUtils.lerpAngleDeg(10, 350, 1.0f), 0.01f);
	}

	@Test
	public void testNorm () {
		assertEquals(-1.0f, MathUtils.norm(10f, 20f, 0f), 0.01f);
		assertEquals(0.0f, MathUtils.norm(10f, 20f, 10f), 0.01f);
		assertEquals(0.5f, MathUtils.norm(10f, 20f, 15f), 0.01f);
		assertEquals(1.0f, MathUtils.norm(10f, 20f, 20f), 0.01f);
		assertEquals(2.0f, MathUtils.norm(10f, 20f, 30f), 0.01f);
	}

	@Test
	public void testMap () {
		assertEquals(0f, MathUtils.map(10f, 20f, 100f, 200f, 0f), 0.01f);
		assertEquals(100f, MathUtils.map(10f, 20f, 100f, 200f, 10f), 0.01f);
		assertEquals(150f, MathUtils.map(10f, 20f, 100f, 200f, 15f), 0.01f);
		assertEquals(200f, MathUtils.map(10f, 20f, 100f, 200f, 20f), 0.01f);
		assertEquals(300f, MathUtils.map(10f, 20f, 100f, 200f, 30f), 0.01f);
	}

	@Test
	public void testRandomLong () {
		long r;
		for (int i = 0; i < 512; i++) {
			assertTrue((r = MathUtils.random(1L, 5L)) >= 1L && r <= 5L);
			assertTrue((r = MathUtils.random(6L, 1L)) >= 1L && r <= 6L);
			assertTrue((r = MathUtils.random(-1L, -7L)) <= -1L && r >= -7L);
			assertTrue((r = MathUtils.random(-8L, -1L)) <= -1L && r >= -8L);
		}
	}

	@Test
	public void testSinDeg () {
		assertEquals(0f, MathUtils.sinDeg(0f), 0f);
		assertEquals(1f, MathUtils.sinDeg(90f), 0f);
		assertEquals(0f, MathUtils.sinDeg(180f), 0f);
		assertEquals(-1f, MathUtils.sinDeg(270f), 0f);
	}

	@Test
	public void testCosDeg () {
		assertEquals(1f, MathUtils.cosDeg(0f), 0f);
		assertEquals(0f, MathUtils.cosDeg(90f), 0f);
		assertEquals(-1f, MathUtils.cosDeg(180f), 0f);
		assertEquals(0f, MathUtils.cosDeg(270f), 0f);
	}

	@Test
	public void testAtan2 () {
		float large = Float.MAX_VALUE, small = Float.MIN_VALUE;
		assertFalse(Float.isNaN(MathUtils.atan2(0f, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(large, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, large)));
		assertFalse(Float.isNaN(MathUtils.atan2(-large, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, -large)));
		assertFalse(Float.isNaN(MathUtils.atan2(small, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, small)));
		assertFalse(Float.isNaN(MathUtils.atan2(-small, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, -small)));
		assertFalse(Float.isNaN(MathUtils.atan2(large, large)));
		assertFalse(Float.isNaN(MathUtils.atan2(-large, large)));
		assertFalse(Float.isNaN(MathUtils.atan2(-large, -large)));
		assertFalse(Float.isNaN(MathUtils.atan2(large, -large)));
		assertFalse(Float.isNaN(MathUtils.atan2(small, small)));
		assertFalse(Float.isNaN(MathUtils.atan2(-small, small)));
		assertFalse(Float.isNaN(MathUtils.atan2(-small, -small)));
		assertFalse(Float.isNaN(MathUtils.atan2(small, -small)));
		large = Float.POSITIVE_INFINITY;
		assertFalse(Float.isNaN(MathUtils.atan2(large, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, large)));
		assertFalse(Float.isNaN(MathUtils.atan2(-large, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, -large)));
		assertFalse(Float.isNaN(MathUtils.atan2(small, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, small)));
		assertFalse(Float.isNaN(MathUtils.atan2(-small, 0f)));
		assertFalse(Float.isNaN(MathUtils.atan2(0f, -small)));
		assertFalse(Float.isNaN(MathUtils.atan2(large, large)));
		assertFalse(Float.isNaN(MathUtils.atan2(-large, large)));
		assertFalse(Float.isNaN(MathUtils.atan2(-large, -large)));
		assertFalse(Float.isNaN(MathUtils.atan2(large, -large)));
		assertFalse(Float.isNaN(MathUtils.atan2(small, small)));
		assertFalse(Float.isNaN(MathUtils.atan2(-small, small)));
		assertFalse(Float.isNaN(MathUtils.atan2(-small, -small)));
		assertFalse(Float.isNaN(MathUtils.atan2(small, -small)));
	}

	/** Returns atan2 in radians, less accurate than Math.atan2 but may be faster. Average error of 0.00231 radians (0.1323
	 * degrees), largest error of 0.00488 radians (0.2796 degrees). */
	static public float atan2 (float y, float x) {
		if (x == 0f) {
			if (y > 0f) return HALF_PI;
			if (y == 0f) return 0f;
			return -HALF_PI;
		}
		final float atan, z = y / x;
		if (Math.abs(z) < 1f) {
			atan = z / (1f + 0.28f * z * z);
			if (x < 0f) return atan + (y < 0f ? -PI : PI);
			return atan;
		}
		atan = HALF_PI - z / (z * z + 0.28f);
		return y < 0f ? atan - PI : atan;
	}

	@Test(expected = AssertionError.class)
	public void testOldAtan2 () {
		float large = Float.MAX_VALUE, small = Float.MIN_VALUE;
		assertFalse(Float.isNaN(atan2(0f, 0f)));
		assertFalse(Float.isNaN(atan2(large, 0f)));
		assertFalse(Float.isNaN(atan2(0f, large)));
		assertFalse(Float.isNaN(atan2(-large, 0f)));
		assertFalse(Float.isNaN(atan2(0f, -large)));
		assertFalse(Float.isNaN(atan2(small, 0f)));
		assertFalse(Float.isNaN(atan2(0f, small)));
		assertFalse(Float.isNaN(atan2(-small, 0f)));
		assertFalse(Float.isNaN(atan2(0f, -small)));
		assertFalse(Float.isNaN(atan2(large, large)));
		assertFalse(Float.isNaN(atan2(-large, large)));
		assertFalse(Float.isNaN(atan2(-large, -large)));
		assertFalse(Float.isNaN(atan2(large, -large)));
		assertFalse(Float.isNaN(atan2(small, small)));
		assertFalse(Float.isNaN(atan2(-small, small)));
		assertFalse(Float.isNaN(atan2(-small, -small)));
		assertFalse(Float.isNaN(atan2(small, -small)));
		large = Float.POSITIVE_INFINITY;
		assertFalse(Float.isNaN(atan2(large, 0f)));
		assertFalse(Float.isNaN(atan2(0f, large)));
		assertFalse(Float.isNaN(atan2(-large, 0f)));
		assertFalse(Float.isNaN(atan2(0f, -large)));
		assertFalse(Float.isNaN(atan2(small, 0f)));
		assertFalse(Float.isNaN(atan2(0f, small)));
		assertFalse(Float.isNaN(atan2(-small, 0f)));
		assertFalse(Float.isNaN(atan2(0f, -small)));
		assertFalse(Float.isNaN(atan2(large, large)));
		assertFalse(Float.isNaN(atan2(-large, large)));
		assertFalse(Float.isNaN(atan2(-large, -large)));
		assertFalse(Float.isNaN(atan2(large, -large)));
		assertFalse(Float.isNaN(atan2(small, small)));
		assertFalse(Float.isNaN(atan2(-small, small)));
		assertFalse(Float.isNaN(atan2(-small, -small)));
		assertFalse(Float.isNaN(atan2(small, -small)));
	}

}
