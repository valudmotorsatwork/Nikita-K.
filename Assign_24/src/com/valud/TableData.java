package com.valud;


import java.awt.Color;

import org.apache.poi.xssf.usermodel.XSSFFont;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class TableData
{
       private static final BaseColor GREEN = null;
		//special font sizes
          Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD,new BaseColor(0,0,0)); 
          Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
          public void insertCell(PdfPTable table,Paragraph P,int[] color)
          {
                
                //create a new cell with the specified Text and Font
                PdfPCell cell = new PdfPCell(new Phrase(P));
                cell.setBackgroundColor(new BaseColor(color[0],color[1],color[2]));
                table.addCell(cell);
               
          }
       
}

