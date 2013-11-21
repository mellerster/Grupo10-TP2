package fi.uba.ar.unittester.framework;

/**
 * Encapsulate the creation of a Storer {@link TestStorer}.
 * 
 */

public class TestStorerFactory {
	
	private static TestStorer testStorer;

	/**
	 * Enum to easy define the type of storer to create.
	 * 
	 */
	public enum StorerType {
		File, Memory
	}

	/**
	 * If there is no Storer creates an memory one and returns it. If there is a
	 * Storer returns the one that was created before.
	 * 
	 * @return the storer that was created.
	 */
	public TestStorer getStorer() {
		if (testStorer == null) {
			testStorer = new MemoryTestStorer();
		}
		return testStorer;
	}

	/**
	 * Defines the format of the Storer, it can be one of:
	 * {@link FileTestStorer} {@link MemoryTestStorer}
	 * 
	 * @param format
	 * @return the specific storer for that format
	 */
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
