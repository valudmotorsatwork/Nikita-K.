package com.valud;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.Iterator;

public class CreatePdfFile {

                public void createPdf() 
                {

                                try {

                                    FileInputStream fin = new FileInputStream(new File("./resources/Javatext.xlsx"));
                                    HSSFWorkbook wb = new HSSFWorkbook(fin);
                                    HSSFSheet sheet = wb.getSheetAt(0);

                                               
                                    Iterator<Row> rowIt = sheet.iterator();

                                    Document doc = new Document();

                                    PdfWriter.getInstance(doc, new FileOutputStream("Javatext"));
                                    doc.open();
                                    PdfPTable table = new PdfPTable(6);

                                     PdfPCell pcell;
                                   while (rowIt.hasNext()) 
                                   {
                                                     Row row = rowIt.next();
                                                     Iterator<Cell> cellIterator = row.cellIterator();
                                                    while (cellIterator.hasNext()) {
                                                      Cell cell = cellIterator.next();

                                                     switch (cell.getCellType())
                                                     {
                                                        case Cell.CELL_TYPE_STRING:
                                                   pcell = new PdfPCell(new Phrase(cell.getStringCellValue()));
                                                                                                
                                                    table.addCell(pcell);
                                                    pcell.setBackgroundColor(BaseColor.GREEN);
                                                    break;

                                                                                }
                                                  }

                                        }

                                                doc.add(table);

                                                doc.close();
                                                fin.close();

                                } catch (Exception e) 
                                {
                                                e.printStackTrace();
                                }

                                
                }

}
