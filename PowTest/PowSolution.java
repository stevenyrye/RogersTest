package steven.test;

import java.util.ArrayList;
import java.util.List;
public class PowSolution { 

	public static void main(String[] args) throws Exception { 
		Double b = Math.pow(12, 38);
		Double a = myPow(12, 38);
		System.out.println("Math.pow(12, 38) = " + b);
		System.out.println("myPow(12, 38)    = " + a);
		System.out.println("Diff = " + (b - a));

		myPow(2, 115);
	}	    

	public static List<MultipFactor> workedOnLists = null;
	
	public static Double myPow(double x, double n) throws Exception {
		boolean reciprocal = false;
		System.out.println("Calculate " + x + "^" + n + ":");
		if (n == 0) return (double) 1;
		if (n == 1) return x;
		if (n == 2) return x * x;
		if (n < 0 && x == 0) return null;
		if (n < 0) {reciprocal = true; n=-n;}
		

		try {
			MultipFactor factorNode = new MultipFactor();
			factorNode.setnFactor((double) 1);
			factorNode.setValue(x);
			workedOnLists = new ArrayList<MultipFactor>();
			workedOnLists.add(factorNode);
			MultipFactor endNode;
			do {
				endNode = IterateFactor(n);
			} while (endNode == null);
			
			Double ret = endNode.getValue();	
			// these debug infor supposed to be put into log
			do {
				System.out.println("Node trace -> " + endNode.getnFactor());
				endNode = endNode.getPrev();
			} while (endNode != null);
			if (reciprocal) ret = 1/ret;
			System.out.println("Result => " + ret);
			return ret;
		} catch (Exception e) {
			throw e; // here we can create our own exceptions to handle different error
		}
	}
	
	public static MultipFactor IterateFactor(double n) throws Exception {
		try {
			List<MultipFactor> nextLevel = new ArrayList<MultipFactor>();
			for (MultipFactor factorNode : workedOnLists) {
				
			
				
				MultipFactor prev = factorNode;
				
				do {
					MultipFactor next = new MultipFactor();
					next.setPrev(factorNode);
					next.setaFactor(prev);
					next.setbFactor(factorNode);
					Double newNFactor = prev.getnFactor() + factorNode.getnFactor();
					if (newNFactor <= n) {
						next.setnFactor(newNFactor);

						nextLevel.add(next);
						if (newNFactor == n) {
							return next;
						}
					}
					prev = prev.getPrev();
				} while (prev != null);
				workedOnLists = nextLevel;
				
			}
			return null;
		} catch (Exception e) {
			throw e; // here we can create our own exceptions to handle different error
		}
	}
	
		
}