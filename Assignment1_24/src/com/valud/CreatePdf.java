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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class CreatePdf
{
    Document document = new Document();
    Paragraph paragraph = null;
   
    PdfPTable table = new PdfPTable(6);
public void pdflogic()
{
    try
   {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./resources/Javapdf.pdf"));
      document.open();
      SetGet inp=new SetGet();
		 inp.inputFile();
		 double RECON_DIFF = 0.0d;
	   BufferedReader bin= inp. inputFile();
  String line[]= new String[6];
  int count=0; 
String s;

List<String> list = new ArrayList<>();
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

     
      table.setWidthPercentage(100); //Width 100%
      table.setSpacingBefore(10f); //Space before table
      table.setSpacingAfter(10f); //Space after table
      
      table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
      TableData insert=new TableData();
        // For Storing File Data Line By Line Into List(ArrayList).
    
     int r=0;
        for (int i=0;i<7;i++)
        {
            for (int j = 0; j < 6; j++) 
                   {
                          paragraph = new Paragraph(list.get(r));
                          insert.insertCell(table,paragraph);
                          r++;
                    }
         }
             document.add(table);
            document.add(paragraph);
             document.close();
             writer.close();
           
   }//try block closed.
    catch (Exception e)
          {
             e.printStackTrace();
          }
    

}
}
