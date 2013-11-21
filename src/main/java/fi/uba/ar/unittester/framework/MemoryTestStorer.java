package fi.uba.ar.unittester.framework;

import java.util.ArrayList;
import java.util.List;

public class MemoryTestStorer implements TestStorer {
	
	private static List<Test> tests;

	public MemoryTestStorer() {
		if (tests == null) {
			reset();
		}
	}

	public void store(Test test) {
		tests.add(test);
	}

	public List<String> getStored() {
		List<String> testsNames = new ArrayList<String>();
		for (Test test : tests) {
			testsNames.add(test.getTestName());
		}
		return testsNames;
	}

	public void reset() {
		tests = new ArrayList<Test>();
	}

}
