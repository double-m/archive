package com.marcellomessori.teamassessmentassignment;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DecoratedTableWithHeaderTest {

	private DecoratedTableWithHeader decoratedTable;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Before
	public void setUp() throws FileNotFoundException, IOException {
		decoratedTable = new DecoratedTableWithHeader();
		decoratedTable.addCsvLine("Name;Age;City");
		decoratedTable.addCsvLine("Peter;42;New York");
		decoratedTable.addCsvLine("Paul;57;London");
		decoratedTable.addCsvLine("Mary;35;Munich");
	}

	@Test
	public void shoudReturnTheFormattedHeader() {
		assertEquals("Name |Age|City    |", decoratedTable.getFormattedHeader());
	}

	@Test
	public void shoudReturnAFormattedDataLine() {
		assertEquals("Paul |57 |London  |", decoratedTable.getFormattedRecord(2));
	}

	@Test
	public void shoudReturnTheFormattedLineBreak() {
		assertEquals("-----+---+--------+", decoratedTable.getFormattedLineBreak());
	}

	@Test
	public void shoudReturnAFormattedSubsetOfRecords() {
		StringBuilder expectedDisplay = new StringBuilder();
		expectedDisplay.append("Name |Age|City    |");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("-----+---+--------+");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("Peter|42 |New York|");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("Paul |57 |London  |");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("Mary |35 |Munich  |");
		assertEquals(expectedDisplay.toString(), decoratedTable.display());
	}

	@Ignore
	public void nextTest() {

	}
}
