/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appman.maven.pdf2tiff;

import org.ghost4j.Ghostscript;
import org.ghost4j.GhostscriptException;

/**
 *
 * @author APPMAN_LABTOP_56
 */
public class Pdf2Tiff {
    
    private static String iPath = "FixFile/";
    private static String oPath = "Result/";
    
    public static void main(String[] args){
       
       String pdfName = "";
       String tiffName = "";
       String filenames[] = {
           "3033255500"
       };
       System.out.println("...");       
       for (int i = 0; i < filenames.length; i++){
           pdfName = iPath + "application-" + filenames[i] + ".pdf";
           tiffName = oPath + "application-" + filenames[i ]+ ".tiff";

            Ghostscript gs = Ghostscript.getInstance();
	    // -r mean resoltion 200x200
            String[] gsArgs = new String[] {
                    "-dQUIET", "-dNOPAUSE", "-dBATCH", "-dSAFER",
                    "-sDEVICE=tiffgray", "-sCompression=lzw", "-r200", "-sOutputFile=" + tiffName, pdfName
            };
            try {
                gs.initialize(gsArgs);
                System.out.print(filenames[i]);
                gs.exit();
                System.out.println(" Done");
            } catch (GhostscriptException e) {
                System.out.println(e.getMessage());
            }
       }
    }
}
