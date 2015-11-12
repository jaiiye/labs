package xml.parser.dom;

//
//Example from:
//	https://docs.oracle.com/javase/tutorial/jaxp/dom/readingXML.html 
//

// These are the JAXP APIs used by DOMEcho:
import javax.xml.parsers.DocumentBuilder; // https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilder.html
import javax.xml.parsers.DocumentBuilderFactory; //https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilderFactory.html
// These classes are for the exceptions that can be thrown when the XML document is parsed:
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.*;
// These classes read the sample XML file and manage output:
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
// Finally, import the W3C definitions for a DOM, DOM exceptions, entities and nodes:
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DOMEcho {

    static final String outputEncoding = "UTF-8";
    
    // 	The basicIndent constant to define the basic unit of indentation used when DOMEcho displays the node tree hierarchy, 
    //	is defined by adding the following highlighted lines to the DOMEcho constructor class.
    private PrintWriter out;
    private int indent = 0;
    private final String basicIndent = " ";    

    DOMEcho(PrintWriter out) {
        this.out = out;
    }

    private static void usage() {
        // ...
    }

    public static void main(String[] args) throws Exception {
    	// Configuring the Factory
    	// By default, the factory returns a non-validating parser that knows nothing about name spaces. 
    	// To get a validating parser, or one that understands name spaces (or both), you can configure 
    	// the factory to set either or both of those options using the following code.
    	String filename = null;
    	boolean dtdValidate = false;
    	boolean xsdValidate = false;
    	String schemaSource = null;
    	
    	args[1] = "/home/users/xblepa/git/labs/java/parser/src/test/data/personal-schema.xml";
        
        boolean ignoreWhitespace = false;
        boolean ignoreComments = false;
        boolean putCDATAIntoText = false;
        boolean createEntityRefs = false;

		        
		for (int i = 0; i < args.length; i++) {
		    if (args[i].equals("-dtd"))  { 
		    		dtdValidate = true;
		    } 
		    else if (args[i].equals("-xsd")) {
		    	xsdValidate = true;
		    } 
		    else if (args[i].equals("-xsdss")) {
		        if (i == args.length - 1) {
		            usage();
		        }
		        xsdValidate = true;
		        schemaSource = args[++i];
		    }
		    else if (args[i].equals("-ws")) {
	            ignoreWhitespace = true;
	        } 
	        else if (args[i].startsWith("-co")) {
	            ignoreComments = true;
	        }
	        else if (args[i].startsWith("-cd")) {
	            putCDATAIntoText = true;
	        } 
	        else if (args[i].startsWith("-e")) {
	            createEntityRefs = true;
	            // ...
	        } 
		    else {
		        filename = args[i];
		        if (i != args.length - 1) {
		            usage();
		        }
		    }
		}
		
		if (filename == null) {
		    usage();
		}
	    	
        // Next, add the following code to the main() method, to obtain an instance of a factory that can give us a document builder.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        dbf.setNamespaceAware(true);
        dbf.setValidating(dtdValidate || xsdValidate);
       
        // Now, add the following code to main() to get an instance of a builder, and use it to parse the specified file.
        DocumentBuilder db = dbf.newDocumentBuilder(); 
        
        // The following code configures the document builder to use the error handler defined in Handle Errors. 
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err,outputEncoding);
        db.setErrorHandler(new MyErrorHandler (new PrintWriter(errorWriter, true)));

        
        Document doc = db.parse(new File(filename));    
  
    }

    //Handle Errors
    //  Next, add the error-handling logic. The most important point is that a JAXP-conformant document builder is required to report 
    //	SAX exceptions when it has trouble parsing an XML document. The DOM parser does not have to actually use a SAX parser internally, 
    //	but because the SAX standard is already there, it makes sense to use it for reporting errors. As a result, the error-handling 
    //	code for DOM applications is very similar to that for SAX applications:
	private static class MyErrorHandler implements ErrorHandler {
	    
	    private PrintWriter out;
	
	    MyErrorHandler(PrintWriter out) {
	        this.out = out;
	    }
	
	    private String getParseExceptionInfo(SAXParseException spe) {
	        String systemId = spe.getSystemId();
	        if (systemId == null) {
	            systemId = "null";
	        }
	
	        String info = "URI=" + systemId + " Line=" + spe.getLineNumber() +
	                      ": " + spe.getMessage();
	        return info;
	    }
	
	    public void warning(SAXParseException spe) throws SAXException {
	        out.println("Warning: " + getParseExceptionInfo(spe));
	    }
	        
	    public void error(SAXParseException spe) throws SAXException {
	        String message = "Error: " + getParseExceptionInfo(spe);
	        throw new SAXException(message);
	    }
	
	    public void fatalError(SAXParseException spe) throws SAXException {
	        String message = "Fatal Error: " + getParseExceptionInfo(spe);
	        throw new SAXException(message);
	    }
	}
	
	//obtaining Node Type Information
	//	The DOM node element type information is obtained by calling the various methods of the org.w3c.dom.Node class. 
	//	The node attributes by exposed by DOMEcho are echoed by the following code.	

	private void printlnCommon(Node n) {
	    System.out.print(" nodeName=\"" + n.getNodeName() + "\"");

	    String val = n.getNamespaceURI();
	    if (val != null) {
	        out.print(" uri=\"" + val + "\"");
	    }

	    val = n.getPrefix();

	    if (val != null) {
	        out.print(" pre=\"" + val + "\"");
	    }

	    val = n.getLocalName();
	    if (val != null) {
	        out.print(" local=\"" + val + "\"");
	    }

	    val = n.getNodeValue();
	    if (val != null) {
	        out.print(" nodeValue=");
	        if (val.trim().equals("")) {
	            // Whitespace
	            out.print("[WS]");
	        }
	        else {
	            out.print("\"" + n.getNodeValue() + "\"");
	        }
	    }
	    out.println();
	}
	
	// Next, a method is defined to set the indentation for the nodes when they are printed, so that the node hierarchy will be easily visible.
	private void outputIndentation() {
	    for (int i = 0; i < indent; i++) {
	        out.print(basicIndent);
	    }
	}
	
	// The code to print out the DOM tree nodes with the appropriate indentation is shown below.
	private void echo(Node n) {
	    outputIndentation();
	    int type = n.getNodeType();

	    switch (type) {
	        case Node.ATTRIBUTE_NODE:
	            out.print("ATTR:");
	            printlnCommon(n);
	            break;

	        case Node.CDATA_SECTION_NODE:
	            out.print("CDATA:");
	            printlnCommon(n);
	            break;

	        case Node.COMMENT_NODE:
	            out.print("COMM:");
	            printlnCommon(n);
	            break;

	        case Node.DOCUMENT_FRAGMENT_NODE:
	            out.print("DOC_FRAG:");
	            printlnCommon(n);
	            break;

	        case Node.DOCUMENT_NODE:
	            out.print("DOC:");
	            printlnCommon(n);
	            break;

	        case Node.DOCUMENT_TYPE_NODE:
	            out.print("DOC_TYPE:");
	            printlnCommon(n);
	            NamedNodeMap nodeMap = ((DocumentType)n).getEntities();
	            indent += 2;
	            for (int i = 0; i < nodeMap.getLength(); i++) {
	                Entity entity = (Entity)nodeMap.item(i);
	                echo(entity);
	            }
	            indent -= 2;
	            break;

	        case Node.ELEMENT_NODE:
	            out.print("ELEM:");
	            printlnCommon(n);

	            NamedNodeMap atts = n.getAttributes();
	            indent += 2;
	            for (int i = 0; i < atts.getLength(); i++) {
	                Node att = atts.item(i);
	                echo(att);
	            }
	            indent -= 2;
	            break;

	        case Node.ENTITY_NODE:
	            out.print("ENT:");
	            printlnCommon(n);
	            break;

	        case Node.ENTITY_REFERENCE_NODE:
	            out.print("ENT_REF:");
	            printlnCommon(n);
	            break;

	        case Node.NOTATION_NODE:
	            out.print("NOTATION:");
	            printlnCommon(n);
	            break;

	        case Node.PROCESSING_INSTRUCTION_NODE:
	            out.print("PROC_INST:");
	            printlnCommon(n);
	            break;

	        case Node.TEXT_NODE:
	            out.print("TEXT:");
	            printlnCommon(n);
	            break;

	        default:
	            out.print("UNSUPPORTED NODE: " + type);
	            printlnCommon(n);
	            break;
	    }

	    indent++;
	    for (Node child = n.getFirstChild(); child != null;
	         child = child.getNextSibling()) {
	        echo(child);
	    }
	    indent--;
	}
	
	/**
	 * Find the named subnode in a node's sublist.
	 * <ul>
	 * <li>Ignores comments and processing instructions.
	 * <li>Ignores TEXT nodes (likely to exist and contain
	 *         ignorable whitespace, if not validating.
	 * <li>Ignores CDATA nodes and EntityRef nodes.
	 * <li>Examines element nodes to find one with
	 *        the specified name.
	 * </ul>
	 * @param name  the tag name for the element to find
	 * @param node  the element node to start searching from
	 * @return the Node found
	 */
	public Node findSubNode(String name, Node node) {
	    if (node.getNodeType() != Node.ELEMENT_NODE) {
	        System.err.println("Error: Search node not of element type");
	        System.exit(22);
	    }

	    if (! node.hasChildNodes()) return null;

	    NodeList list = node.getChildNodes();
	    for (int i=0; i < list.getLength(); i++) {
	        Node subnode = list.item(i);
	        if (subnode.getNodeType() == Node.ELEMENT_NODE) {
	           if (subnode.getNodeName().equals(name)) 
	               return subnode;
	        }
	    }
	    return null;
	}
	
	/**
	  * Return the text that a node contains. This routine:
	  * <ul>
	  * <li>Ignores comments and processing instructions.
	  * <li>Concatenates TEXT nodes, CDATA nodes, and the results of
	  *     recursively processing EntityRef nodes.
	  * <li>Ignores any element nodes in the sublist.
	  *     (Other possible options are to recurse into element 
	  *      sublists or throw an exception.)
	  * </ul>
	  * @param    node  a  DOM node
	  * @return   a String representing its contents
	  */
	public String getText(Node node) {
	    StringBuffer result = new StringBuffer();
	    if (! node.hasChildNodes()) return "";

	    NodeList list = node.getChildNodes();
	    for (int i=0; i < list.getLength(); i++) {
	        Node subnode = list.item(i);
	        if (subnode.getNodeType() == Node.TEXT_NODE) {
	            result.append(subnode.getNodeValue());
	        }
	        else if (subnode.getNodeType() == Node.CDATA_SECTION_NODE) {
	            result.append(subnode.getNodeValue());
	        }
	        else if (subnode.getNodeType() == Node.ENTITY_REFERENCE_NODE) {
	            // Recurse into the subtree for text
	            // (and ignore comments)
	            result.append(getText(subnode));
	        }
	    }

	    return result.toString();
	}


	
}