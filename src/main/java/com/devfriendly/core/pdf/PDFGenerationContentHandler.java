package com.devfriendly.core.pdf;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Created by Patrick Fey on 30.10.2015.
 */
public class PDFGenerationContentHandler implements ContentHandler {

    public static final Attributes EMPTY_ATTS = new AttributesImpl();

    private ContentHandler target;


    public PDFGenerationContentHandler(ContentHandler forwardTo) {
        this.target = forwardTo;
    }

    public void startElement(String name) throws SAXException {
        startElement(name, EMPTY_ATTS);
    }


    public void startElement(String name, Attributes atts) throws SAXException {
        startElement(null, name, name, atts);
    }

    public void characters(String s) throws SAXException {
        target.characters(s.toCharArray(), 0, s.length());
    }

    public void endElement(String name) throws SAXException {
        endElement(null, name, name);
    }


    public void element(String name, String value) throws SAXException {
        element(name, value, EMPTY_ATTS);
    }


    public void element(String name, String value, Attributes atts) throws SAXException {
        startElement(name, atts);
        if (value != null) {
            characters(value.toCharArray(), 0, value.length());
        }
        endElement(name);
    }


    public void setDocumentLocator(Locator locator) {
        target.setDocumentLocator(locator);
    }


    public void startDocument() throws SAXException {
        target.startDocument();
    }


    public void endDocument() throws SAXException {
        target.endDocument();
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        target.startPrefixMapping(prefix, uri);
    }



    public void endPrefixMapping(String prefix) throws SAXException {
        target.endPrefixMapping(prefix);
    }


    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        target.startElement(namespaceURI, localName, qName, atts);
    }


    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        target.endElement(namespaceURI, localName, qName);
    }



    public void characters(char[] ch, int start, int length) throws SAXException {
        target.characters(ch, start, length);
    }



    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        target.ignorableWhitespace(ch, start, length);
    }



    public void processingInstruction(String target, String data) throws SAXException {
        this.target.processingInstruction(target, data);
    }


    public void skippedEntity(String name) throws SAXException {
        target.skippedEntity(name);
    }
}
