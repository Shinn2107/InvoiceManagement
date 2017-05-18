<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:f="Functions"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <!-- Attribut-Sets fuer Tabellenzellen -->
    <!-- Seitenaufteilung -->

    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="DIN-A4" page-height="29.5cm" page-width="21cm" margin-top="0cm" margin-bottom="0cm" margin-left="0cm" margin-right="0cm">
                    <fo:region-body region-name="body" margin-top="1.0cm" margin-bottom="0.5cm" margin-left="2cm" margin-right="0.5cm" />
                    <fo:region-before region-name="header" extent="0cm" />
                    <fo:region-after region-name="footer"  extent="1.0cm"/>
                    <fo:region-start region-name="left" extent="0cm" />
                    <fo:region-end region-name="right" extent="0cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="DIN-A4">

                <!-- Static Footer Content -->
                <fo:static-content flow-name="footer">
                    <fo:block font-size="8pt"  margin-left="2cm">

                    </fo:block>
                </fo:static-content>


                <!-- BODY -->
                <fo:flow flow-name="body">
                    <xsl:apply-templates />
                    <fo:table id="Letter-header">
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block id="image">
                                        <fo:external-graphic src="file:appData/logo/logoThiel_smaller.png"/>
                                    </fo:block>
                                </fo:table-cell>

                                

                            </fo:table-row>
							<fo:table-row>
								<fo:table-cell>
									<fo:block end-indent="0.2in"  font-size="8pt" text-align="left">
										<xsl:value-of select="ORDER/ISSUER/companyName" />  <xsl:value-of select="ORDER/ISSUER/address" /> <xsl:value-of select="ORDER/ISSUER/city" />
									</fo:block>
								</fo:table-cell>
							</fo:table-row>

                        </fo:table-body>

                    </fo:table>

                    <fo:block space-before="20px"/>
                    <fo:table id="HEAD">
                        <fo:table-body>
                            <fo:table-row>
                                <!-- Left Cell -->
                                <fo:table-cell>
									
                                    <fo:block end-indent="0.2in"  font-size="10pt" text-align="left">


                                        <fo:inline font-weight="bold">
                                            <xsl:value-of select="ORDER/RECIPIENT-ADDRESS/companyName" />
                                        </fo:inline>
										<fo:block>
                                            <xsl:value-of select="ORDER/RECIPIENT-ADDRESS/name" />
                                        </fo:block>
                                        <fo:block>
                                            <xsl:value-of select="ORDER/RECIPIENT-ADDRESS/address" />
                                        </fo:block>

                                        <fo:block>
                                            <xsl:value-of select="ORDER/RECIPIENT-ADDRESS/city" />
                                        </fo:block>

                                        <fo:block space-before="10px"/>

                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block start-indent="0.2in" font-size="10pt" margin-left="100pt" text-align="left">
                                        <fo:block>
                                            <xsl:value-of select="ORDER/ISSUER/companyName" />
                                        </fo:block>
                                        <fo:block>
                                            <xsl:value-of select="ORDER/ISSUER/address" />
                                        </fo:block>
                                        <fo:block>
                                            <xsl:value-of select="ORDER/ISSUER/city" />
                                        </fo:block>


                                    </fo:block>
                                </fo:table-cell>

                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
					
					

                    <fo:block-container id="text_content" font-size="10pt" width="100%">
                        <fo:block id="text_header" space-before="50px" font-size="14pt">
                            <fo:inline font-weight="bold">
                                Rechnung
                            </fo:inline>
                        </fo:block>
                        <fo:block space-before="10px"/>
						<fo:table id="text_content_table">
							<fo:table-column column-width="33%"/>
                            <fo:table-column column-width="33%"/>
                            <fo:table-column column-width="32%"/>
							<fo:table-body>
								<fo:table-row>
									<!-- Left Cell -->
									<fo:table-cell>
										<fo:block>
											Bestellnummer:
											<fo:inline space-start="0.5cm" >
												<xsl:value-of select="ORDER/HEAD/orderNumber"/>
											</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block>
											Kundennummer:
											<fo:inline space-start="0.5cm" >
												<xsl:value-of select="ORDER/HEAD/customerNumber"/>
											</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block>
											Datum:
											<fo:inline space-start="0.5cm" >
												<xsl:value-of select="ORDER/HEAD/orderCreationDate" />
											</fo:inline>
										</fo:block>
									</fo:table-cell>
	  
								</fo:table-row>
							</fo:table-body>
						</fo:table>
                        
                        <fo:block space-before="10px"/>

                        <fo:table>

                            <fo:table-column column-width="10%"/>
                            <fo:table-column column-width="50%"/>
                            <fo:table-column column-width="15%"/>
                            <fo:table-column column-width="25%"/>

                            <fo:table-header border="solid black 1px">
                                <fo:table-cell border-right="solid black 1px" padding="2px">
                                    <fo:block font-weight="bold">Position</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right="solid black 1px" padding="2px">
                                    <fo:block font-weight="bold">Artikel</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right="solid black 1px" padding="2px">
                                    <fo:block font-weight="bold">Menge</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right="solid black 1px" padding="2px">
                                    <fo:block font-weight="bold">Gesamtpreis</fo:block>
                                    <fo:block font-weight="bold">(brutto) in EUR</fo:block>
                                </fo:table-cell>
                            </fo:table-header>

                            <fo:table-body>
                                <xsl:for-each select="ORDER/DATA/item">
                                    <fo:table-row>

                                        <fo:table-cell border-right="solid black 0.5px" padding="5px">
                                            <fo:block><xsl:value-of select="itemPosition"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-right="solid black 0.5px" padding="5px">
                                            <fo:block><xsl:value-of select="productName"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-right="solid black 0.5px" padding="5px">
                                            <fo:block><xsl:value-of select="quantity"/> <xsl:value-of select="unit"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-right="solid black 0.5px" padding="5px">
                                            <fo:block><xsl:value-of select="totalPrice"/></fo:block>
                                        </fo:table-cell>

                                    </fo:table-row>
                                </xsl:for-each>
                                <fo:table-row>
                                    <fo:table-cell border-right="solid black 0.5px" border-bottom="solid black 1px" padding="2px">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-right="solid black 0.5px" border-bottom="solid black 1px" padding="2px">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-right="solid black 0.5px" border-bottom="solid black 1px" padding="2px">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell  border-bottom="solid black 1px" padding="2px">
                                        <fo:block></fo:block>
                                    </fo:table-cell>

                                </fo:table-row>
                            </fo:table-body>

                        </fo:table>

                        <fo:block space-before="10px"/>
                        <fo:table>
                            <fo:table-column column-width="40%"/>
                            <fo:table-column column-width="60%"/>

                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-size="12pt" font-weight="bold">
                                            Zwischensumme :
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-size="12pt" font-weight="bold" text-align="right" margin-right="20pt">
                                            <xsl:value-of select="ORDER/TOTALS/totals"/>
                                        </fo:block>
                                    </fo:table-cell >
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-size="10pt">
                                            + <fo:inline space-start="29.5pt">
                                            MwSt (<xsl:value-of select="ORDER/TOTALS/tax"/>):
                                        </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>

                                    <fo:table-cell>
                                        <fo:block font-size="10pt" text-align="right" margin-right="20pt">
                                            <xsl:value-of select="ORDER/TOTALS/taxFromTotals"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding-top="10pt">
                                        <fo:block font-size="14pt" font-weight="bold">
                                            Gesamtsumme (inkl. MwSt.)
                                        </fo:block>
                                    </fo:table-cell>

                                    <fo:table-cell padding-top="10pt" border-top="solid black 1px">
                                        <fo:block font-size="12pt" font-weight="bold" text-align="right" margin-right="20pt">
                                            <xsl:value-of select="ORDER/TOTALS/totalIncludingTax"/>
                                        </fo:block>
                                    </fo:table-cell>

                                </fo:table-row>


                            </fo:table-body>

                        </fo:table>

                        <fo:block space-before="30pt">
                            Vielen Dank für Ihren Einkauf bei uns.
                        </fo:block>
                        <fo:block space-before="10pt">
                            Wünscht Ihnen Ihre
                        </fo:block>
                        <fo:block font-weight="bold">
                            <xsl:value-of select="ORDER/ISSUER/companyName" />
                        </fo:block>


                    </fo:block-container>

                </fo:flow>

            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>