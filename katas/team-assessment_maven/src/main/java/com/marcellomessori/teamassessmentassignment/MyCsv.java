package com.marcellomessori.teamassessmentassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

class MyCsv {

	private final URL csvPersonsFile;
	private ArrayList<String> csvLines;

	public MyCsv(String csvPersonsFileName) throws FileNotFoundException, IOException {
		csvPersonsFile = getClass().getClassLoader().getResource(csvPersonsFileName);
		if (csvPersonsFile == null) {
			throw new FileNotFoundException("Error: could not find '" + csvPersonsFileName + "'.");
		}
		init(csvPersonsFile);
	}

	public String display() {
		return display(csvLines.size() - 1);
	}

	public String display(int linesPerPage) {
		return display(linesPerPage, 1);
	}

	public String display(int linesPerPage, int pageNumber) {
		int recordTotal = csvLines.size() - 1;
		DisplayPage displayPage = new DisplayPage(recordTotal, linesPerPage, pageNumber);

		DecoratedTableWithHeader decoratedTable = new DecoratedTableWithHeader();
		decoratedTable.addCsvLine(csvLines.get(0));
		for (int lineNumber = displayPage.getStartingLineToDisplay();
				lineNumber <= displayPage.getEndingLineToDisplay(); lineNumber++) {
			decoratedTable.addCsvLine(csvLines.get(lineNumber));
		}

		return decoratedTable.display();
	}

	private void init(URL csvPersonsFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPersonsFile.getPath()));

		storeLines(br);
	}

	private void storeLines(BufferedReader br) throws IOException {
		csvLines = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null) {
			csvLines.add(line);
		}
	}

}
