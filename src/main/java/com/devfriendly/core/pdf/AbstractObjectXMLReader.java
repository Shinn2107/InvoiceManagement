package com.devfriendly.core.pdf;

import java.io.IOException;
import java.util.Map;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


/**
 * Created by Patrick Fey on 30.10.2015.
 */
public abstract class AbstractObjectXMLReader implements XMLReader {

    private static final String NAMESPACES =
            "http://xml.org/sax/features/namespaces";
    private static final String NS_PREFIXES =
            "http://xml.org/sax/features/namespace-prefixes";

    private Map features = new java.util.HashMap();
    private ContentHandler orgHandler;

    protected PDFGenerationContentHandler handler;
    /** Error handler */
    protected ErrorHandler errorHandler;


    /**
     * Constructor for the AbstractObjectReader object
     */
    public AbstractObjectXMLReader() {
        setFeature(NAMESPACES, false);
        setFeature(NS_PREFIXES, false);
    }


    /**
     * @see XMLReader#getContentHandler()
     */
    public ContentHandler getContentHandler() {
        return this.orgHandler;
    }

    /**
     * @see XMLReader#setContentHandler(ContentHandler)
     */
    public void setContentHandler(ContentHandler handler) {
        this.orgHandler = handler;
        this.handler = new PDFGenerationContentHandler(handler);

    }

    /**
     * @see XMLReader#getErrorHandler()
     */
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    /**
     * @see XMLReader#setErrorHandler(ErrorHandler)
     */
    public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
    }

    /**
     * @see XMLReader#getDTDHandler()
     */
    public DTDHandler getDTDHandler() {
        return null;
    }

    /**
     * @see XMLReader#setDTDHandler(DTDHandler)
     */
    public void setDTDHandler(DTDHandler handler) {
    }

    /**
     * @see XMLReader#getEntityResolver()
     */
    public EntityResolver getEntityResolver() {
        return null;
    }

    /**
     * @see XMLReader#setEntityResolver(EntityResolver)
     */
    public void setEntityResolver(EntityResolver resolver) {
    }

    /**
     * @see XMLReader#getProperty(String)
     */
    public Object getProperty(String name) {
        return null;
    }

    /**
     * @see XMLReader#setProperty(String, Object)
     */
    public void setProperty(String name, Object value) {
    }

    /**
     * @see XMLReader#getFeature(String)
     */
    public boolean getFeature(String name) {
        return ((Boolean) features.get(name)).booleanValue();
    }

    /**
     * Returns true if the NAMESPACES feature is enabled.
     * @return boolean true if enabled
     */
    protected boolean isNamespaces() {
        return getFeature(NAMESPACES);
    }

    /**
     * Returns true if the MS_PREFIXES feature is enabled.
     * @return boolean true if enabled
     */
    protected boolean isNamespacePrefixes() {
        return getFeature(NS_PREFIXES);
    }

    /**
     * @see XMLReader#setFeature(String, boolean)
     */
    public void setFeature(String name, boolean value) {
        this.features.put(name, new Boolean(value));
    }

    /**
     * @see XMLReader#parse(String)
     */
    public void parse(String systemId) throws IOException, SAXException {
        throw new SAXException(
                this.getClass().getName()
                        + " cannot be used with system identifiers (URIs)");
    }

    /**
     * @see XMLReader#parse(InputSource)
     */
    public abstract void parse(InputSource input)
            throws IOException, SAXException;
}
