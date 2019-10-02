package readxml1;

import java.io.File;
import java.util.*;
import java.util.List;

//import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
import org.dom4j.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;


public class readxmlmain {
	public static void main(String[] args) throws DocumentException,FileNotFoundException, IOException{
		File file = new File("D:/胡清硯/navtex_code_data/data/xml_data");
		int counter = 0;
		int counter2 = 0; 
		int military = 0;
		int other = 0;
		int oelse = 0;
		int pipe = 0;
		int offshore = 0;
		int other_exercises = 0;
		int underwater = 0;
		int seismic_surveys = 0;
		int research = 0;
		int offshore_structures = 0;
		int drifting = 0;
		int dangerous = 0;	
		String [] typebox = new String[100];
		int [] counterbox = new int[100];
		ArrayList<String> typelist = new ArrayList<String> ();
		List<Integer> countlist = new ArrayList<Integer>();	
		 if (!file.isDirectory()) {
		         System.out.println("檔案");
		         System.out.println("path=" + file.getPath());
		         System.out.println("absolutepath=" + file.getAbsolutePath());
		         System.out.println("name=" + file.getName());
		 } else if (file.isDirectory()) {
		         String[] filelist = file.list();
		         for (int i = 0; i < filelist.length; i++) {
		                 File readfile = new File("D:/胡清硯/navtex_code_data/data/xml_data" + "//" + filelist[i]);
		                 if (!readfile.isDirectory()) {
		                         String path = readfile.getPath();
		                 		SAXReader reader = new SAXReader();
		                 		Document document = reader.read(new File(path));
		                 		Document document1 = reader.read(new File(path));
		                 		Element root = document.getRootElement();	                 		
		                 		//遍歷		                 		
		                 	    for (Iterator<Element> node = root.elementIterator(); node.hasNext();) {
		                 	        Element element = node.next();
		                 	        if(element.getName() == "imember") {
		                 	        	for(Iterator node2 = element.elementIterator();node2.hasNext();){
		                 	        		Element element1 = (Element) node2.next(); 
		                 	        		if(element1.getName() == "S124_NWPreamble") {
		                 	        			for(Iterator node3 = element1.elementIterator();node3.hasNext();) {
		                 	        				Element element2 = (Element) node3.next();	                 	        				    
		                 	        				if(element2.getName() == "warningHazardType" ){
//		                 	        					------------------------------------------
		                 	        					String A = element2.getText();
		                 	        				    int B = A.compareTo("military exercises");
		                 	        				    if (B == 0) {
		                 	        				    	counter++;
		                 	        				    }
		                 	        			}
		                 	        			}
		                 	        		}
		                 	        }
		                 	        }
		                 	    }
//		                 		======================================讀檔		                 	    
		                 	Element memberElm = root.element("imember");		//test
		                 	Element memberElm1 = memberElm.element("S124_NWPreamble");
		                 	Element memberElm2 = memberElm1.element("warningHazardType");
//	                 		======================================分類(自動)
		                 	String text1 = memberElm2.getText();
		                 	String text2 = new String(text1);
		                 	if (typelist.contains(text2) == false) {
		                 		typelist.add(text2);
		                 		countlist.add(0);
		                 	}
		                 	if(typelist.contains(text2)) {
		                 		int pos = typelist.indexOf(text2);
		                 		countlist.set(pos,countlist.get(pos) + 1);
		                 	}
//	                 		======================================分類(手動)
		                 		switch(memberElm2.getText()) {
		                 			case "military exercises":
		                 				military++;
		                 				break;
		                 			case "other":
		                 				other++;
		                 				break;
		                 			case "pipe or cable laying operations":
		                 				pipe++;
		                 				break;
		                 			case "seismic surveys":
		                 				seismic_surveys++;
		                 				break;
		                 			case "other exercises":
		                 				other_exercises++;
		                 				break;
		                 			case "underwater operations":
		                 				underwater++;
		                 				break;
		                 			case "dangerous wreck":
		                 				dangerous++;
		                 				break;
		                 			case "drifting hazard":
		                 				drifting++;
		                 				break;
		                 			case "research or scientific operations":
		                 				research++;
		                 				break;
		                 			case "offshore structures":				
		                 				offshore_structures++;
		                 				break;
		                 			default:
		                 				System.out.println(memberElm2.getText());
		                 				oelse++;
		                 		}
		                 } else if (readfile.isDirectory()) {
		                         readfile("D:/胡清硯/navtex_code_data/data/xml_data" + "//" + filelist[i]);		                 
		         }
		 }
		         System.out.println("warningHazardType:");
//		         System.out.println("military exercises:" + military);
//		         System.out.println("pipe or cable laying operations:" + pipe);
//		         System.out.println("seismic surveys:" + seismic_surveys);
//		         System.out.println("other exercises:" + other_exercises);
//		         System.out.println("underwater operations:" + underwater);
//		         System.out.println("dangerous wreck:" + dangerous);
//		         System.out.println("drifting hazard:" + drifting);
//		         System.out.println("research or scientific operations:" + research);
//		         System.out.println("offshore structures:" + offshore_structures);
//		         System.out.println("other:" + other);
//		         System.out.println("undefine:" + oelse);
//		         System.out.println("warningHazardType:");
		         for(int i = 0;i<typelist.size();i++) {
		        	 System.out.println(typelist.get(i)+":"+countlist.get(i));		        	 
		         }
	    }	   						
		}
private static void readfile(String string) {
		// TODO Auto-generated method stub
	System.out.println("something error~~~~~~~~~~~~~~~~~~~~~");
	}		
}