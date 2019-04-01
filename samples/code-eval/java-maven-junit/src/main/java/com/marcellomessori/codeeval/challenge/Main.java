package com.marcellomessori.codeeval.challenge;

public class Main {

	public static void main(String[] args) {
		Challenge challenge = new Challenge("Hello World!");
		challenge.play();
	}
}

class Challenge {
	private final String input;

	public Challenge(String input) {
		this.input = input;
	}

	public void play() {
		System.out.println(processInput(input));
	}

	// TODO change this
	protected String processInput(String input) {
		return input;
	}
}
