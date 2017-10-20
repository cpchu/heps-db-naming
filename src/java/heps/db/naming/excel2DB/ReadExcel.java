/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.excel2DB;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author huihui
 */
public class ReadExcel {

    public Workbook wb;
    
    public ReadExcel(Workbook wb) {
        this.wb = wb;
    }

    public Workbook getWb() {
        return wb;
    }

    public void setWb(Workbook wb) {
        this.wb = wb;
    }

    public ArrayList getSheetByName(String sheetName) {
        ArrayList dataList = new ArrayList();
        Sheet sheet = wb.getSheet(sheetName);
        for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
            Row row = (Row) rit.next();
            ArrayList oneRow = new ArrayList();
            for (Cell cell : row) {
                Object o = "";
                switch (cell.getCellType()) {

                    case Cell.CELL_TYPE_STRING:
                        o = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        o = cell.getNumericCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        o = cell.getBooleanCellValue();
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        o = cell.getCellFormula();
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        o = "";
                        break;
                    case Cell.CELL_TYPE_ERROR:
                        System.out.println("Error");
                        break;
                }
                oneRow.add(o);
            }
            dataList.add(oneRow);
        }
        return dataList;
    }

}
