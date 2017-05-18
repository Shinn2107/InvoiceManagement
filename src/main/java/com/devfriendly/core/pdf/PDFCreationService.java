package com.devfriendly.core.pdf;

import java.io.IOException;

import com.devfriendly.core.pdf.data.PDFOutputData;
import com.devfriendly.core.pdf.exception.PDFCreationException;


/**
 * Created by Patrick Fey on 18.05.2017.
 */
public interface PDFCreationService {

    PDFOutputData createPDF(PDFContext pdfInput) throws PDFCreationException, IOException;
}
