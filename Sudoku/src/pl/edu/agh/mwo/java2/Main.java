package pl.edu.agh.mwo.java2;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Main {

		
	public static void main(String[] args) {
		try {
			Workbook wb = WorkbookFactory.create(new File("sudoku.xlsx"));
			SudokuBoardChecker sbc = new SudokuBoardChecker(wb);

		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
