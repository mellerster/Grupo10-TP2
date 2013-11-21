package fi.uba.ar.unittester.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * A Test Storer that stores the tests in a ArrayList
 * 
 */

public class MemoryTestStorer implements TestStorer {

	private static List<Test> tests;

	public MemoryTestStorer() {
		if (tests == null) {
			reset();
		}
	}

	/**
	 * Adds the test to the ArrayList, it doesn't matter if it is already
	 */
	public void store(Test test) {
		tests.add(test);
	}

	/**
	 * Converts the ArrayList of Test to a ArrayList of String with the
	 * names of the tests
	 */
	public List<String> getStored() {
		List<String> testsNames = new ArrayList<String>();
		for (Test test : tests) {
			testsNames.add(test.getTestName());
		}
		return testsNames;
	}

	/**
	 * recreate the ArrayList of Test
	 */
	public void reset() {
		tests = new ArrayList<Test>();
	}

}
