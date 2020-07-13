package org.exite.servertest.desadv;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("POSITION")
public class POSITION {

    @XStreamAlias("POSITIONNUMBER")
    public String POSITIONNUMBER;

    @XStreamAlias("PRODUCT")
    public String PRODUCT;

    @XStreamAlias("PRODUCTIDSUPPLIER")
    public String PRODUCTIDSUPPLIER;

    @XStreamAlias("PRODUCTIDBUYER")
    public String PRODUCTIDBUYER;

    @XStreamAlias("DELIVEREDQUANTITY")
    public String DELIVEREDQUANTITY;

    @XStreamAlias("DELIVEREDUNIT")
    public String DELIVEREDUNIT;

    @XStreamAlias("QUANTITYOFCUINTU")
    public String QUANTITYOFCUINTU;

    @XStreamAlias("ORDEREDQUANTITY")
    public String ORDEREDQUANTITY;

    @XStreamAlias("ORDERUNIT")
    public String ORDERUNIT;

    @XStreamAlias("AMOUNT")
    public String AMOUNT;

    @XStreamAlias("AMOUNTWITHVAT")
    public String AMOUNTWITHVAT;

    @XStreamAlias("TAXAMOUNT")
    public String TAXAMOUNT;

    @XStreamAlias("COUNTRYORIGIN")
    public String COUNTRYORIGIN;

    @XStreamAlias("PRICE")
    public String PRICE;

    @XStreamAlias("PRICEWITHVAT")
    public String PRICEWITHVAT;

    @XStreamAlias("TAXRATE")
    public String TAXRATE;

    @XStreamAlias("EXPIREDATE")
    public String EXPIREDATE;

    @XStreamAlias("VAT")
    public String VAT;

    @XStreamAlias("DESCRIPTION")
    public String DESCRIPTION;
}