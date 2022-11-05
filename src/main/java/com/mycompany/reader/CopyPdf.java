
package com.mycompany.reader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CopyPdf {
    public static void main(String args[]) throws DocumentException{
        String filename = "C:/Users/Usuario/Downloads/mj.pdf";
         String destination = "C:/Users/Usuario/Downloads/mjCopy.pdf";
        try {
            PdfReader pdf=new PdfReader(filename);
            Document doc=new Document();
            FileOutputStream out=new FileOutputStream(destination);
            PdfWriter writer=PdfWriter.getInstance(doc, out);
            PdfImportedPage page;
            doc.open();
            int pages=pdf.getNumberOfPages();
            for(int i=1;i<=pages;i++){
                if(i%2==0){
                    PdfContentByte pdfByte=writer.getDirectContent();
                page=writer.getImportedPage(pdf, i);
                pdfByte.addTemplate(page,0,0);
                doc.newPage();
                }
            }
            out.flush();
            doc.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(CopyPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
