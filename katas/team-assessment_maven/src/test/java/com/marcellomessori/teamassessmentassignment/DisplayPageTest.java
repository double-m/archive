package com.marcellomessori.teamassessmentassignment;

import static org.junit.Assert.*;
import org.junit.Test;

public class DisplayPageTest {

	private DisplayPage displayPage;

	@Test
	public void shoudReturnTheCorrectBoundaries() {
		displayPage = new DisplayPage(21, 10, 3);
		assertEquals(21, displayPage.getStartingLineToDisplay());
		assertEquals(21, displayPage.getEndingLineToDisplay());

		displayPage = new DisplayPage(21, 10, -1);
		assertEquals(1, displayPage.getStartingLineToDisplay());
		assertEquals(10, displayPage.getEndingLineToDisplay());

		displayPage = new DisplayPage(21, 10, 999);
		assertEquals(21, displayPage.getStartingLineToDisplay());
		assertEquals(21, displayPage.getEndingLineToDisplay());

		displayPage = new DisplayPage(10, 999, 1);
		assertEquals(1, displayPage.getStartingLineToDisplay());
		assertEquals(10, displayPage.getEndingLineToDisplay());

		displayPage = new DisplayPage(10, 999, 999);
		assertEquals(1, displayPage.getStartingLineToDisplay());
		assertEquals(10, displayPage.getEndingLineToDisplay());

		displayPage = new DisplayPage(10, -1, 999);
		assertEquals(1, displayPage.getStartingLineToDisplay());
		assertEquals(10, displayPage.getEndingLineToDisplay());
	}

}
