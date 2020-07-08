package spells;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidacaoXml {

    public static void main(String[] args) throws Exception {

        while (true) {
            File schemaFile = new File("/c/Users/....xsd");

            Source xmlFile = new StreamSource(new File("/c/Users/....xml"));
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            try {
                Schema schema = schemaFactory.newSchema(schemaFile);
                Validator validator = schema.newValidator();
                validator.validate(xmlFile);
                System.out.println("XML is valid");
            } catch (SAXException e) {
                System.out.println("XML is NOT valid reason:" + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
