package fi.uba.ar.unittester.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTestStorer implements TestStorer {

	public void store(Test test) {
		if (testNotInFile(test)) {
			BufferedWriter file;
			try {
				file = new BufferedWriter(new FileWriter("testsStores.txt",
						true));
				file.write(test.getTestName());
				file.newLine();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean testNotInFile(Test test) {
		BufferedReader file = getBufferedFileReader();
		if (file == null) {
			return true;
		}

		String testName;
		try {
			while ((testName = file.readLine()) != null) {
				if (testName.equals(test.getTestName())) {
					return false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}
		return true;
	}

	private BufferedReader getBufferedFileReader() {
		BufferedReader file = null;
		try {
			file = new BufferedReader(new FileReader("testsStores.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		;
		return file;
	}

	public List<String> getStored() {
		BufferedReader file;
		List<String> testsNames = new ArrayList<String>();
		try {
			file = getBufferedFileReader();
			String testName;

			while ((testName = file.readLine()) != null) {
				testsNames.add(testName);
			}
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testsNames;
	}

	public void reset() {
		BufferedWriter file;
		try {
			file = new BufferedWriter(new FileWriter("testsStores.txt"));
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
