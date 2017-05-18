package com.devfriendly.core.pdf.data;


import org.apache.commons.io.output.ByteArrayOutputStream;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class PDFOutputData {

    private ByteArrayOutputStream byteArrayOutputStream;

    public PDFOutputData(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return byteArrayOutputStream;
    }
}
