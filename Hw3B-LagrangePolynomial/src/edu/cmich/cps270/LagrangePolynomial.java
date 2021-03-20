package edu.cmich.cps270;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Func {
	double apply(double x);
}

public class LagrangePolynomial {
	
	public static void main(String[] args) {

		
	}
	
	List<Pair<Double, Double>> fnEvals;
	
	/**
	 * 
	 * @param xi an array of values at which the function is evaluated
	 * @param fnAtxi the evaluation of the function at the points in xi
	 */
	public LagrangePolynomial(double[] xi, double[] fnAtxi) {
		this.fnEvals = new ArrayList<Pair<Double, Double>>();
		
		for(int i = 0; i < xi.length; i++) {
			fnEvals.add(new Pair<Double, Double>(xi[i], fnAtxi[i]));
		}
		
	}
	
	/**
	 * Evaluate a Lagrange interpolating polynomial at given x
	 * 
	 * @param x the location at which the Lagrange polynomial should be evaluated 
	 * @return the value of the Lagrange polynomial evaluated at x
	 */
	public double evaluateAt(double x) {
		
		double sum = 0;
		
		// YOUR CODE HERE
		
		
		return sum;
	}
	
}

