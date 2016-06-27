package com.valud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.valud.SetGet;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class CreateSheet 
   { 
	
	public void logic()
	     {           
                   XSSFWorkbook workbook = new XSSFWorkbook();
                   XSSFSheet sheet = workbook.createSheet("Java Books");
                   
                   XSSFFont font = workbook.createFont();
                   font.setItalic(false);
                   font.setColor(HSSFColor.BRIGHT_GREEN.index); 
                   XSSFCellStyle style = workbook.createCellStyle();
                   style.setFont(font);
                   
                   XSSFFont font1 = workbook.createFont();
                   XSSFCellStyle style1= workbook.createCellStyle();
                   font1.setColor(HSSFColor.GREY_50_PERCENT.index);
                   style1.setFont(font1);
   
     // For Storing File Data Line By Line Into List(ArrayList).
     List<String> list = new ArrayList<>();

  try
    { 
	   SetGet inp=new SetGet();
		 inp.inputFile();
		 double RECON_DIFF = 0.0d;
	   BufferedReader bin= inp. inputFile();
     String line[]= new String[6];
     int count=0; 
  String s;
 
  
  while((s=bin.readLine())!=null)
  {
     if(s.contains("|"))
    {
  	  line=s.split("[|]");
    }
 else if(s.contains(" "))
    {
	 line =new String[6];
	 line[0]=s.substring(0, 8);
	 line[1]=s.substring(9,19);
	 line[2]=s.substring(19,22);
	 line[3]=s.substring(23,28);
	 line[4]=s.substring(29,36);
	 line[5]=s.substring(40,53);
	
    }

else if(s.contains(";"))
    {
	   line=s.split("[;]");
	 }

else if(s.contains(":"))
    {
	     line=s.split("[:]");
	  
	  }
     
else
     {
	 System.out.println("Sorry... Some Error Occured While Reading Some Deliemeters...");
     }
     for (int i = 0; i < line.length; i++) {
         list.add(line[i]);
}
  	  count++;
 }//End Of while loop
 
  //Following for loop Print Data Column wise.
  for(int i=0;i<list.size();i++)
  {
                  System.out.println(list.get(i));
  }

  //Here we write logic to convert this column data in row wise i.e. row=7 and column=5
  int r = 0;
  Cell cell = null ;
  for (int i = 0; i < 7; i++) {
                  
                  XSSFRow row = sheet.createRow(i);
                  for (int j = 0; j < 6; j++) {
                  cell = row.createCell(j);
                  // Create a cell with a value and set style to it.
                  cell.setCellValue(list.get(r));
                  if(i==0)
                  {                                                                 
                      cell.setCellStyle(style);
                  }
                  else
                  {                                                              
                  cell.setCellStyle(style1);
                  }
                  
                  r++;
                  }
                 
  }
  //For Writing Data To JavaBokks.xlsx File.
  
  FileOutputStream fos = new FileOutputStream("./resources/Javatext.xlsx");
  workbook.write(fos);
  fos.close();
    }
catch(Exception e)
{
	System.out.println(e);
}
}  //End Of logic Method
}


