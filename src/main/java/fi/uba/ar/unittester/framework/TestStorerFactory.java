package fi.uba.ar.unittester.framework;

public class TestStorerFactory {
	private static TestStorer testStorer;

	public enum StorerType {
		File, Memory
	}

	public TestStorer getStorer() {
		if (testStorer == null) {
			testStorer = new MemoryTestStorer();
		}
		return testStorer;
	}

	public TestStorer getStorer(StorerType format) {
		switch (format) {
		case File:
			testStorer = new FileTestStorer();
			break;
		case Memory:
			testStorer = new MemoryTestStorer();
			break;
		default:
			break;
		}
		return testStorer;
	}
}
