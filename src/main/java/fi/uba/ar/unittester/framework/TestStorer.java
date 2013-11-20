package fi.uba.ar.unittester.framework;

import java.util.List;

public interface TestStorer {
	public void store(Test test);
	public List<String> getStored();
	public void reset();
}
