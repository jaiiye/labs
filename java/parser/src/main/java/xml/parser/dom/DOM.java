package xml.parser.dom;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class DOM {
	private InputStream inputStream;
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document doc;	
	
	public InputStream getInputString(){
		return this.inputStream;
	}
	
	public Document getDoc(){
		return this.doc;
	}
	
	public void setInputStream(FileInputStream fs){
		this.inputStream = fs;
	}
	
	public void setInputStream(File fp) throws FileNotFoundException{
		FileInputStream fs = new FileInputStream(fp);
		
		this.inputStream = fs;
	}
	
	public void setInputStream(String fp) throws FileNotFoundException{
		File f = new File(fp);		
		
		this.inputStream = new FileInputStream(f);
	}
	
	private void createDocumentBuilderFactory(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		this.dbf = dbf;
	}
	
	private void createDocumentBuilder() throws ParserConfigurationException{
		DocumentBuilder db = this.dbf.newDocumentBuilder();
		
		this.db = db;
	}
	
	public void parseXml() throws ParserConfigurationException, SAXException, IOException{
		this.doc = this.db.parse(inputStream);
	}
	
	public void parseXml(String fp) throws ParserConfigurationException, SAXException, IOException{
		setInputStream(fp);		
		parseXml();	
	}

}
