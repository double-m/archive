package com.marcellomessori.teamassessmentassignment;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class MyCsvTest {

	private MyCsv myCsv;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private StringBuilder expectedDisplayPage1Length2;
	private StringBuilder expectedDisplayPage2Length2;
	private StringBuilder expectedDisplayLastPageLength3;

	@Before
	public void setUp() throws FileNotFoundException, IOException {
		myCsv = new MyCsv("persons.csv");

		expectedDisplayPage1Length2 = new StringBuilder();
		expectedDisplayPage1Length2.append("Name |Age|City    |");
		expectedDisplayPage1Length2.append(LINE_SEPARATOR);
		expectedDisplayPage1Length2.append("-----+---+--------+");
		expectedDisplayPage1Length2.append(LINE_SEPARATOR);
		expectedDisplayPage1Length2.append("Peter|42 |New York|");
		expectedDisplayPage1Length2.append(LINE_SEPARATOR);
		expectedDisplayPage1Length2.append("Paul |57 |London  |");

		expectedDisplayPage2Length2 = new StringBuilder();
		expectedDisplayPage2Length2.append("Name  |Age|City  |");
		expectedDisplayPage2Length2.append(LINE_SEPARATOR);
		expectedDisplayPage2Length2.append("------+---+------+");
		expectedDisplayPage2Length2.append(LINE_SEPARATOR);
		expectedDisplayPage2Length2.append("Mary  |35 |Munich|");
		expectedDisplayPage2Length2.append(LINE_SEPARATOR);
		expectedDisplayPage2Length2.append("Jaques|66 |Paris |");
	}

	@Test
	public void shoudReturnFileNotFoundExceptionWhenItCannotFindTheSourceFile() throws IOException {
		try {
			new MyCsv("nonExistingFile.csv");
			fail("Should have thrown a FileNotFoundException.");
		} catch (FileNotFoundException e) {
			assertEquals(true, true);
		}
	}

	@Test
	public void shoudReturnTheFirstPageWithALengthOf2() {
		assertEquals(expectedDisplayPage1Length2.toString(), myCsv.display(2));
		assertEquals(expectedDisplayPage1Length2.toString(), myCsv.display(2, 1));
	}

	@Test
	public void shoudReturnTheSecondPageWithALengthOf2() {
		assertEquals(expectedDisplayPage2Length2.toString(), myCsv.display(2, 2));
	}
	
}
