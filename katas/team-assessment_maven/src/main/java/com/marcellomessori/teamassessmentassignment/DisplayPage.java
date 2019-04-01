package com.marcellomessori.teamassessmentassignment;

public class DisplayPage {

	private final int recordTotal;
	private final int linesPerPage;
	private final int pageNumber;
	private int startingLineToDisplay;
	private int endingLineToDisplay;

	DisplayPage(int recordTotal, int linesPerPage, int pageNumber) {
		this.recordTotal = recordTotal;
		this.linesPerPage = linesPerPage;
		this.pageNumber = pageNumber;
		init();
	}

	public int getStartingLineToDisplay() {
		return startingLineToDisplay;
	}

	public int getEndingLineToDisplay() {
		return endingLineToDisplay;
	}

	private void init() {
		int numberOfRecordToDisplay = Math.min(linesPerPage, recordTotal);
		if (numberOfRecordToDisplay < 1) {
			numberOfRecordToDisplay = recordTotal;
		}
		int lastPageNumber = recordTotal / numberOfRecordToDisplay;
		if (recordTotal % numberOfRecordToDisplay > 0) {
			lastPageNumber += 1;
		}
		int numberOfThePageToDisplay = Math.min(pageNumber, lastPageNumber);
		if (numberOfThePageToDisplay < 1) {
			numberOfThePageToDisplay = 1;
		}
		startingLineToDisplay = (numberOfThePageToDisplay - 1) * numberOfRecordToDisplay + 1;
		endingLineToDisplay = Math.min(numberOfThePageToDisplay * numberOfRecordToDisplay, recordTotal);
	}
}
