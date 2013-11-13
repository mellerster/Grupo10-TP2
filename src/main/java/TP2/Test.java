package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Test Esta clase representa los test individuales que se desean probar.
 **/

public abstract class Test implements Testeable {

	private String name;
	private Fixture fixture;
	private List<String> tags;

	public Test(String name) {
		this.name = name;
		tags = new LinkedList<String>();
	}

	public abstract void run();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return getName();
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public void setTag(String tag) {
		tags.add(tag);
	}

	public boolean hasTag(String tag) {
		return tags.contains(tag);
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Test))
			return false;
		Test test = (Test) obj;
		return test.getName().equals(name);
	}
}
