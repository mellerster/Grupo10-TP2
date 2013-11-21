package fi.uba.ar.unittester.framework;

import java.util.List;

/**
 * Defines the interface for all the Storer's
 * 
 */
public interface TestStorer {

	/**
	 * Store the test that was successfully executed
	 * 
	 * @param A successful test
	 */
	public void store(Test test);

	/**
	 * Gets an List of Strings with the names of the tests stored
	 * 
	 * @return List of the Names of the tests stored
	 */
	public List<String> getStored();

	/**
	 * Delete all the previous results from the store
	 */
	public void reset();

}
