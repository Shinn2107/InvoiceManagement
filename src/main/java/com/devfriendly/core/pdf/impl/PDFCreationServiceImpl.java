package com.devfriendly.core.pdf.impl;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.xmlgraphics.util.MimeConstants;

import com.devfriendly.core.pdf.PDFContext;
import com.devfriendly.core.pdf.PDFCreationService;
import com.devfriendly.core.pdf.data.PDFOutputData;
import com.devfriendly.core.pdf.exception.PDFCreationException;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class PDFCreationServiceImpl implements PDFCreationService {


    private FopFactory fopFactory;

    private TransformerFactory transformerFactory;

    private static PDFCreationService pdfCreationService;

    public static PDFCreationService getInstance(){
        if(pdfCreationService==null){
            pdfCreationService = new PDFCreationServiceImpl();
        }
        return pdfCreationService;
    }

    private PDFCreationServiceImpl() {

        this.fopFactory = FopFactory.newInstance(new File(".").toURI());
        this.transformerFactory = TransformerFactory.newInstance();
    }


    public PDFOutputData createPDF(PDFContext pdfInput) throws PDFCreationException, IOException {
        if(pdfInput==null) throw new PDFCreationException("PDFInput object can't be null");
        if(pdfInput.getSourceDataForPDF()==null) throw new PDFCreationException("The source for the pdfInput is null, which can't be");
        if(pdfInput.getStylesheetForPDF()==null) throw new PDFCreationException("The stylesheet for the pdfInput is null, which can't be");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            File styleSheet = new File(pdfInput.getStylesheetForPDF());
            if(!styleSheet.exists()){
                throw new PDFCreationException("The stylesheet under path: "+pdfInput.getStylesheetForPDF()+" couldn't be found.");
            }
            final InputStream inputStream = new FileInputStream(styleSheet);
            final Transformer transformer = transformerFactory.newTransformer(new StreamSource(inputStream));
            //Make sure the XSL transformation's result is piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());
            //Setup input
            Source src = pdfInput.getSourceDataForPDF();

            //Start the transformation and rendering process
            transformer.transform(src, res);
        } catch (FOPException fopException){
            throw new PDFCreationException("Please check FOPException thrown below");
        } catch (TransformerConfigurationException e) {
            throw new PDFCreationException("Exception occured while trying to transform the xsltSource");
        } catch (TransformerException e) {
            throw new PDFCreationException("Exception occured while trying to transform the source to the result");
        } finally{
            out.flush();
            out.close();
        }

        return new PDFOutputData(out);
    }
}
