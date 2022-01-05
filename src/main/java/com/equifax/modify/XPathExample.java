package com.equifax.modify;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class XPathExample {
	
    public void checkXmlEelements() throws Exception {
        // Get DOM Node for XML
        String fileName = "C:\\Users\\User\\Desktop\\records.xml";
        Document document = getDocument(fileName);
     
 
        String xpathExpressionName = "";
        String xpathExpressionId="";
        String xpathExpressionTitle="";
 
        // Get all employee names
        xpathExpressionName = "/employees/employee/name";
        boolean name =checkIfNodeExists(document, xpathExpressionName);   //true
         
        // Get all employee ids
        xpathExpressionId = "/employees/employee/id";
        boolean id =checkIfNodeExists(document, xpathExpressionId);   //true
         
        // Get all employee age
        xpathExpressionTitle = "/employees/employee/title";
        boolean title =checkIfNodeExists(document, xpathExpressionTitle);
        
        //false
        
        if(!name)
        {
        	
        	ModifyXml modifyXml=new ModifyXml();
        	modifyXml.modify("name","default-name");

        }
        
        if(!id)
        {
        	
        	ModifyXml modifyXml=new ModifyXml();
        	modifyXml.modify("id","default-id");

        }
        if(!title)
        {
        	
        	ModifyXml modifyXml=new ModifyXml();
        	modifyXml.modify("title","default-title");

        }
 
		/*
		 * // Get all department names xpathExpression =
		 * "/employees/employee/department/name";
		 * System.out.println(checkIfNodeExists(document, xpathExpression)); //true
		 * 
		 * // Get department locations xpathExpression =
		 * "/employees/employee/department/location";
		 * System.out.println(checkIfNodeExists(document, xpathExpression));
		 */  //false
    }
 
    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception 
    {
        boolean matches = false;
         
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();
 
        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
 
        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);
 
            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
             
            if(nodes != null  && nodes.getLength() > 0) {
                matches = true;
            }
 
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }
     
    private static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
    }   
}
