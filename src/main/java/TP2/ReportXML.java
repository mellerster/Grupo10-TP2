package TP2;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReportXML extends Reporter {
	private Document doc;
	private Element root;
	private Element actualTestSuite;

	public ReportXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			doc = docBuilder.newDocument();
			doc.setXmlStandalone(true);
			root = doc.createElement("testsuites");

			doc.appendChild(root);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addResult(Result result) {

		if (!packageName.equals(result.getPackageName())) {
			actualTestSuite = doc.createElement("testsuite");
			root.appendChild(actualTestSuite);
			packageName = result.getPackageName();
			actualTestSuite.setAttribute("package", packageName);
			setTestSuiteName(result);
			setCounters();
		}
		Element testCase = doc.createElement("testcase");
		actualTestSuite.appendChild(testCase);
		testCase.setAttribute("name", result.getTestName());
		testCase.setAttribute("time", Double.toString(result.getTime()));
		results.add(result);
		setDescription(testCase, result);
		setStatus(testCase, "Passed");
		setTestCount();
		if (result.getState() == ResultType.Fail) {
			setFailureStatus(testCase);
			failures.add((ResultFail) result);
		}
		if (result.getState() == ResultType.Error) {
			setErrorStatus(testCase);
			errors.add((ResultError) result);
		}

	}

	private void setCounters() {
		actualTestSuite.setAttribute("failures", "0");
		actualTestSuite.setAttribute("errors", "0");
		actualTestSuite.setAttribute("skipped", "0");
		actualTestSuite.setAttribute("tests", "0");
	}

	private void setFailureStatus(Element testCase) {
		setStatus(testCase, "Failed");
		int count = Integer.parseInt(actualTestSuite.getAttribute("failures"));
		count++;
		actualTestSuite.setAttribute("failures", Integer.toString(count));
	}

	private void setErrorStatus(Element testCase) {
		setStatus(testCase, "With Error");
		int count = Integer.parseInt(actualTestSuite.getAttribute("errors"));
		count++;
		actualTestSuite.setAttribute("errors", Integer.toString(count));
	}

	private void setDescription(Element testCase, Result result) {
		if (!result.getDescription().equals("")) {
			testCase.setAttribute("description", result.getDescription());
		}
	}

	private void setTestCount() {
		String tests = actualTestSuite.getAttribute("tests");
		int testCount = Integer.parseInt(tests);
		testCount++;
		actualTestSuite.setAttribute("tests", Integer.toString(testCount));
	}

	private void setTestSuiteName(Result result) {
		String name = result.getPackageName();
		int pointPosition = name.lastIndexOf('.');
		if (pointPosition != -1) {
			name = name.substring(pointPosition + 1);
		}
		actualTestSuite.setAttribute("name", name);
	}

	@Override
	protected void saveResult(String result) {
	}

	@Override
	public void saveResults() {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult resultFile = new StreamResult(new File("Report.xml"));

			/*
			 * TODO: Take out the resultConsole is just for seeing the xml file
			 * while programming
			 */
			StreamResult resultConsole = new StreamResult(System.out);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, resultConsole);
			transformer.transform(source, resultFile);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setStatus(Element testCase, String status) {
		testCase.setAttribute("status", status);
	}
}