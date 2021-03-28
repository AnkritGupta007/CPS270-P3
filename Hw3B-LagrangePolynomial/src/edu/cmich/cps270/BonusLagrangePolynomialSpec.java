package edu.cmich.cps270;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BonusLagrangePolynomialSpec {
	
	@Test
	void lagrangePolynomialFaultyArrayLength() {

		double[] xi = {1};
		double[] fnxi = {1};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(1);
		
		assertFalse((Math.abs(result - 1) < 1e-5) && (Math.abs(result - 1) > 1e-5), () -> "Lagrange Polynomial Not Evaluated with Single-Value Array Length");	
	}
	
	@Test
	void lagrangePolynomialBadInputData() {

		double[] xi = {0, 0, 0, 0};
		double[] fnxi = {0, 0, 0, 0};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(1);
		
		assertFalse((Math.abs(result - 1) < 1e-5) && (Math.abs(result - 1) > 1e-5), () -> "Lagrange Polynomial Not Evaluated when Arrays Populated with Bad Data");	
	}
	
	@Test 
	void lagrangePolynomialSwappedInput() {
		double[] xi = {0, 16, 36};
		double[] fnxi = {0, 4, 6};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(2);
		assertFalse(Math.abs(result - 4) < 1e-5, () -> "Lagrange Polynomial Fails to Evaluate when xi and f(xi) Arrays are Swapped on Input");	
		
	}
	
	@Test
	void firstOrderLagrangePolynomialForXIs8At8() {
		double[] xi = {0, 16 };
		double[] fnxi = {0, 16};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(8);
		
		assertTrue(Math.abs(result - 8) < 1e-5, () -> "Lagrange polynomial of X evaluated at 8 should be 8.");	
		
	}
	
	@Test 
	void secondOrderLagrangePolynomialForX2Is8At64() {
		double[] xi = {0, 5, 7 };
		double[] fnxi = {0, 25, 49};
		LagrangePolynomial lp = new LagrangePolynomial(xi, fnxi);
		
		double result = lp.evaluateAt(8);
		assertTrue(Math.abs(result - 64) < 1e-5, () -> "Second order Lagrange polynomial of X^2 evaluated at 2 should be 4.");	
		
	}
	
	

}
