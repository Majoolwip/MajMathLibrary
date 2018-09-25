package com.majoolwip.fastmath;

public class MajMath {

	public static boolean closeToZero(double d) {
		return Math.abs(d) < Defs.EPSILON;
	}

	/**
	 * Computes the determinate of the quadratic
	 * formula.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double determinate(double a, double b, double c) {
		return b * b - 4 * a * c;
	}

	/**
	 * Computes the quadratic formula and returns
	 * and array of the roots.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double[] quadratic(double a, double b, double c) {
		final double d = determinate(a,b,c);
		if(d > 0) {
			final double[] res = new double[2];
			double sd = Math.sqrt(d);
			res[0] = (-b - sd) / (2d * a);
			res[1] = (-b + sd) / (2d * a);
			return res;
		} else if(d == 0) {
			final double[] res = new double[1];
			res[0] = (-b) / (2d * a);
			return res;
		} else {
			return new double[0];
		}
	}
}
