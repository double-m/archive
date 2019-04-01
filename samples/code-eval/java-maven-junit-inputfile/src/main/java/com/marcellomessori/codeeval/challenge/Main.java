package com.marcellomessori.codeeval.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String fileName = "src/main/resources/input-file.txt";

		if (args.length > 0) {
			fileName = args[0];
		}

		Challenge challenge = new Challenge(new File(fileName));
		challenge.play();		
	}
}

class Challenge {
	private File inputFile;
	private ChallengeHelper challengeHelper;
	
	public Challenge(File file) {
		this.inputFile = file;
		challengeHelper = new ChallengeHelper();
	}
	
	public void play() {
		processInputFile();
	}

	private void processInputFile() {

		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = in.readLine()) != null) {
				String[] lineArray = line.split("\\s");
				if (lineArray.length > 0) {
					// TODO change this
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}
}

class ChallengeHelper {
	
}