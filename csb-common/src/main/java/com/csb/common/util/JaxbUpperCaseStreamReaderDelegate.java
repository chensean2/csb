package com.csb.common.util;

/*
 * this class is to convert the xml node with uppercase, so that the jaxb mapping can support case-insensitive.
 */
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class JaxbUpperCaseStreamReaderDelegate extends StreamReaderDelegate {


    public JaxbUpperCaseStreamReaderDelegate(XMLStreamReader reader) {
        super(reader);
    }
    
    @Override
    public String getAttributeLocalName(int index) {
        return super.getAttributeLocalName(index).toUpperCase().intern();
    }

    @Override
    public String getLocalName() {
        return super.getLocalName().toUpperCase().intern();
    }

}
