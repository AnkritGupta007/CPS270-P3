package edu.cmich.cps270;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Func {
	double apply(double x);
}

public class LagrangePolynomial {

	public static void main(String[] args) {
		double[] xpoints = {0,0.6,0.9};
		double[] fnAtxpoints = {1,0.8253,0.6216} ;
		LagrangePolynomial pol = new LagrangePolynomial( xpoints, fnAtxpoints  ); 

		System.out.println(pol.evaluateAt(0.45));


		// Estimating the U.S. Population in 1975 and in 2020
		double[] censusYear = {1950, 1960, 1970, 1980, 1990, 2000, 2010};
		double[] censusPopulation = {151.3, 179.3, 203.3, 226.5, 249.6, 282.5, 309.3};

		LagrangePolynomial censusPolynomial = new LagrangePolynomial(censusYear, censusPopulation);
		System.out.println("Census Estimate 1975: " + censusPolynomial.evaluateAt(1975));
		System.out.println("Census Estimate 2020: " + censusPolynomial.evaluateAt(2020));

		// Estimating the Snipe population in 2017
		double[] snipeYear = {2012, 2014, 2016, 2018, 2020};
		double[] snipePopulation = {51, 1005, 20453, 405232, 1815700, 8137723};

		LagrangePolynomial snipePolynomial = new LagrangePolynomial(snipeYear, snipePopulation);
		System.out.println("Snipe Pop. Estimate 2017: " + snipePolynomial.evaluateAt(2017));
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

		Pair<Double, Double> currPair = null;
		for (int n = 0; n < fnEvals.size(); n++) {
			double kValue = fnEvals.get(n).getL();	

			double Ln_k = 1.0;
			for (int k = 0; k < fnEvals.size(); k++) {
				if(k != n) {
					currPair = fnEvals.get(k);
					Ln_k = Ln_k * (x - currPair.getL()) / (kValue - currPair.getL());
				}
			}

			sum = sum + fnEvals.get(n).getR() * Ln_k;
		}

		return sum;
	}

}

