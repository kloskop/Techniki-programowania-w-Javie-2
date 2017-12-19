package pl.edu.agh.mwo.java2;

import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SudokuBoardChecker {
	private Workbook workbook;

	
	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public SudokuBoardChecker(Workbook workbook) {
		this.workbook = workbook;
		for (int k = 0; k < workbook.getNumberOfSheets(); k++) {
			System.out.println("ARKUSZ NR "+(k+1));
			System.out.println("Plansza jest poprawna synkaktycznie: "+verifyBoardStructure(k)); //zadanie 1
			
			boolean isSudokuBoardCoorect = verifyBoard(k); //zadanie 2
			if (isSudokuBoardCoorect) {
				System.out.println("Plansza Sudoku na arkuszu nr " + (k + 1) + " jest prawid³owa");
			}
			System.out.println("\n ....................");
		}

	}

	public boolean verifyBoard(int sheetIndex) {
		boolean result = false;
		boolean verifyRows = verifyRows(sheetIndex);
		boolean verifyColumn = verifyColumn(sheetIndex);
		boolean verifyArea = verifyAllAreas3x3(sheetIndex);
		if (verifyRows && verifyColumn && verifyArea) {
			result = true;
		}
		return result;
	}

	public boolean verifyRows(int sheetIndex) {
		boolean result = true;
		Set<Double> set = new HashSet<>();
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		for (int i = 0; i < 9; i++) {
			int howManyNumericInRow = 0;
			Row row = sheet.getRow(i);
			for (int j = 0; j < 9; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellTypeEnum();
				if (cellType == CellType.NUMERIC) {
					howManyNumericInRow++;
					set.add(cell.getNumericCellValue());
				}
			}
			if (set.size() != howManyNumericInRow) {
				result = false;
				System.out.println("Plansza Sudoku na arkuszu nr" + (sheetIndex + 1)
						+ " jest z³a poniewa¿ wyst¹pi³o " + "powtórzenie w wierszu: " + (i + 1));
			}
			set.clear();
		}
		return result;
	}
	
	private int checkCells(Sheet sheet,Set<Double> set, int FistColumnIndex, int LastColumnIndex,int rowIndex) {
		int howManyNumericInArea = 0;
		for (int cellIndex = FistColumnIndex; cellIndex <= LastColumnIndex; cellIndex++) {
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			CellType cellType = cell.getCellTypeEnum();
			if (cellType == CellType.NUMERIC) {
				howManyNumericInArea++;
				set.add(cell.getNumericCellValue());
			}

		}
		
		return howManyNumericInArea;
	}
	
	public boolean verifyAllAreas3x3(int sheetIndex) {
		Set<Double> set = new HashSet<>();
		boolean result = true;
		int howManyNumericInArea=0;
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		for (int rowIndex = 0; rowIndex <7; rowIndex=rowIndex+3) {
			for (int numberOfBoxesHorizonally = 0; numberOfBoxesHorizonally <3; numberOfBoxesHorizonally++) {
				for (int i = 0; i < 3; i++) {
					int rowToCheck =i+rowIndex;
					int FistColumnIndex= 0+3*numberOfBoxesHorizonally;
					int LastColumnIndex=2+3*numberOfBoxesHorizonally;
					howManyNumericInArea+=checkCells(sheet,set,FistColumnIndex,LastColumnIndex,rowToCheck);
				}
				if (set.size() != howManyNumericInArea) {
					result = false;
					System.out.println("B³¹d w arkuszu: "+"w jednych z kwadratów 3x3 wyst¹pi³o powtórzenie");
				}
				howManyNumericInArea=0;
				set.clear();
			}
			}
		return result;

	}
	private void addCelltoSet(Set<Double> set, Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		if (cellType == CellType.NUMERIC) {
			set.add(cell.getNumericCellValue());
		}
	}
	
	public boolean verifyColumn(int sheetIndex) {
		boolean result = true;
		Set<Double> set = new HashSet<>();
		Sheet sheet = workbook.getSheetAt(sheetIndex);

		for (int i = 0; i < 9; i++) {
			int howManyNumericInColumn = 0;
			for (int j = 0; j < 9; j++) {
				Row row = sheet.getRow(j);
				Cell cell = row.getCell(0 + i);
				addCelltoSet(set,cell);
				CellType cellType = cell.getCellTypeEnum();
				if (cellType == CellType.NUMERIC) {
					howManyNumericInColumn++; 
					set.add(cell.getNumericCellValue());
				}
			}
			if (set.size() != howManyNumericInColumn) {
				result = false;
				System.out.println("\n Plansza Sudoku na arkuszu nr " + (sheetIndex + 1)
						+ " jest z³a poniewa¿ wyst¹pi³o " + "powtórzenie w kolumnie: " + KolumnaEnum.getNameByCode(i));
			}
			set.clear();


		}
		return result;
	}

	public boolean verifyBoardStructure(int sheetIndex) {
		boolean result = true;
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellTypeEnum();
				if (cell == null || cellType.equals(CellType.STRING)|| cellType.equals(CellType.BOOLEAN)
								 || cellType.equals(CellType.FORMULA)|| cellType.equals(CellType.ERROR)) {
					System.out.println("B³¹d w komórce "+KolumnaEnum.getNameByCode(j)+(i+1)+" poniewa¿ wyst¹pi³: "+cellType);
					result = false;
				}

// je¿eli chcemy sprawdziæ cellType ka¿dej komórki z osobna
//				switch (cellType) {
//				case BLANK: // pusta wartoœæ
//					System.out.println("ij: " + i + j + " BLANK");
//					break;
//				case BOOLEAN: // wartoœæ
//					System.out.println("ij: " + i + j + " BOOLEAN");
//					break;
//
//				case STRING:// wartoœæ tekstowa
//					System.out.println("ij: " + i + j + " STRING");
//					break;
//				case NUMERIC: // wartoœæ numeryczna (zmienno przecinkowa)
//					System.out.println("ij: " + i + j + " NUMERIC");
//					break;
//				case FORMULA: // formu³a
//					System.out.println("ij: " + i + j + " FORMULA");
//					break;
//				case ERROR:
//					System.out.println("ij: " + i + j + " ERROR");
//					break;// b³¹d }
//				default:
//					System.out.println("default");
//
//				}

			}
		}
		return result;
	}
}
