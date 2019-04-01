package com.marcellomessori.teamassessmentassignment;

import java.util.ArrayList;

class DecoratedTableWithHeader {

	private ArrayList<String> csvLines;
	private static final String CSV_SEPARATOR = ";";
	private static final String VERTICAL_DECORATOR = "|";
	private static final String VERTEX_DECORATOR = "+";
	private static final String HORIZONTAL_DECORATOR = "-";
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private int columnNumber;
	private int[] maxColWidths;

	public DecoratedTableWithHeader() {
		init();
	}

	public void addCsvLine(String get) {
		csvLines.add(get);
		updateColMaxWidths(get);
	}

	public String display() {
		StringBuilder formattedCsv = new StringBuilder();
		formattedCsv.append(getFormattedHeader());
		formattedCsv.append(LINE_SEPARATOR);
		formattedCsv.append(getFormattedLineBreak());
		for (int lineNumber = 1; lineNumber < csvLines.size(); lineNumber++) {
			formattedCsv.append(LINE_SEPARATOR);
			formattedCsv.append(getFormattedLine(lineNumber));
		}
		return formattedCsv.toString();
	}

	public String getFormattedHeader() {
		return getFormattedLine(0);
	}

	public String getFormattedRecord(int csvLineNumber) {
		return getFormattedLine(csvLineNumber);
	}

	public String getFormattedLineBreak() {
		StringBuilder decorateLine = new StringBuilder();
		for (int colWidth : maxColWidths) {
			decorateLine.append(String.format("%" + colWidth + "s", "").replace(" ", HORIZONTAL_DECORATOR));
			decorateLine.append(VERTEX_DECORATOR);
		}
		return decorateLine.toString();
	}

	private String getFormattedLine(int csvArrayIndex) {
		String[] items = csvLines.get(csvArrayIndex).split(CSV_SEPARATOR);

		StringBuilder decorateLine = new StringBuilder();
		for (int i = 0; i < maxColWidths.length; i++) {
			int maxWidth = Math.max(maxColWidths[i], items[i].length());
			decorateLine.append(String.format("%-" + maxWidth + "s", items[i]));
			decorateLine.append(VERTICAL_DECORATOR);
		}

		return decorateLine.toString();
	}

	private void init() {
		csvLines = new ArrayList<String>();
	}

	private void updateColMaxWidths(String csvLine) {
		checkAlreadyCreatedMaxColWidths();
		
		String[] cvsLineCols = csvLine.split(CSV_SEPARATOR);
		for (int column = 0; column < cvsLineCols.length; column++) {
			if (cvsLineCols[column].length() > maxColWidths[column]) {
				maxColWidths[column] = cvsLineCols[column].length();
			}
		}
	}

	private void checkAlreadyCreatedMaxColWidths() {
		if (maxColWidths == null) {
			columnNumber = csvLines.get(0).split(CSV_SEPARATOR).length;
			maxColWidths = new int[columnNumber];
			for (int i = 0; i < maxColWidths.length; i++) {
				maxColWidths[i] = 0;
			}
		}
	}
}
