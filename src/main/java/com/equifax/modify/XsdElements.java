package com.equifax.modify;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XsdElements 
{
    public  void printXsd() { 
        try { 
            // parse the document
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("C:\\Users\\User\\Desktop\\records.xsd")); 
            NodeList list = doc.getElementsByTagName("xs:element");
            
            //Node employee = doc.getElementsByTagName("employee").item(0);
            //NodeList nodes = employee.getChildNodes();
           // System.out.println(nodes);

            //loop to print data
            for(int i = 0 ; i < list.getLength(); i++)
            {
                Element first = (Element)list.item(i);
                if(first.hasAttributes())
                {
                    String nm = first.getAttribute("name"); 
                    System.out.println(nm); 
                    String nm1 = first.getAttribute("type"); 
                    System.out.println(nm1); 
                }
            }
        } 
        catch (ParserConfigurationException e) 
        {
            e.printStackTrace();
        }
        catch (SAXException e) 
        { 
            e.printStackTrace();
        }
        catch (IOException ed) 
        {
            ed.printStackTrace();
        }
    }
}
