package edu.cmich.cps270;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LagrangePolynomialSpec {

	
	@Test
	void lagrangePolynomialEvaluatedAtXiIsFnXi() {

		double[] xi = {0, 1, 3, 4 };
		double[] fnxi = {0, 1, 3, 4};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(1);
		
		assertTrue(Math.abs(result - 1) < 1e-5, () -> "Lagrange polynomial evaluated at xi should be f(xi).");	
	}
	
	@Test
	void firstOrderLagrangePolynomialForXIs2At2() {
		double[] xi = {0, 4 };
		double[] fnxi = {0, 4};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(2);
		
		assertTrue(Math.abs(result - 2) < 1e-5, () -> "Lagrange polynomial of X evaluated at 2 should be 2.");	
		
	}
	
	@Test 
	void secondOrderLagrangePolynomialForX2Is4At2() {
		double[] xi = {0, 4, 6 };
		double[] fnxi = {0, 16, 36};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(2);
		assertTrue(Math.abs(result - 4) < 1e-5, () -> "Second order Lagrange polynomial of X^2 evaluated at 2 should be 4.");	
		
	}
	


}
