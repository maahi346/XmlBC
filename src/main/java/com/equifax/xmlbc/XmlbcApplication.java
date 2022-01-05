package com.equifax.xmlbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.equifax.modify.ModifyXml;
import com.equifax.modify.XPathExample;
import com.equifax.modify.XpathExample1;
import com.equifax.modify.XsdElements;
import com.equifax.validation.XMLValidator;



@SpringBootApplication
public class XmlbcApplication {
	
	
	
	 public static final String XML_FILE = "records.xml";
	    public static final String SCHEMA_FILE = "records.xsd";

	public static void main(String[] args) throws Exception {
		
		
		
		 SpringApplication.run(XmlbcApplication.class, args);
		  
		  XMLValidator xMLValidator = new XMLValidator(); boolean valid =
		 xMLValidator.validate(XML_FILE, SCHEMA_FILE);
		 
		  //ModifyXml modifyXml=new ModifyXml(); 
		  //modifyXml.modify();
		 
		 
		//XsdElements xsdElements =new XsdElements();
		 //xsdElements.printXsd();
		 
		// XPathExample xPathExample=new XPathExample();
		// xPathExample.checkXmlEelements();
		 
		  //System.out.printf("%s validation = %b.", XML_FILE, valid);
	}

}


