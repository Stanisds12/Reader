
package com.mycompany.reader;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;


public class ReaderPdf {
    public static void main(String[] args){
        try{
            String filename = "C:/Users/Usuario/Downloads/mj.pdf";
            PdfReader pdf=new PdfReader(filename);
            int pages=pdf.getNumberOfPages();
            for(int i=1;i<=pages;i++){
                String content=PdfTextExtractor.getTextFromPage(pdf, i);
                System.out.println(content); 
            }
            
        }catch(IOException x){
        }
    }
    
}
