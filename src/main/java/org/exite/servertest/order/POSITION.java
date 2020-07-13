package org.exite.servertest.order;

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

    @XStreamAlias("ORDEREDQUANTITY")
    public String ORDEREDQUANTITY;

    @XStreamAlias("PRODUCTTYPE")
    public String PRODUCTTYPE;

    @XStreamAlias("QUANTITYOFCUINTU")
    public String QUANTITYOFCUINTU;

    @XStreamAlias("ORDERUNIT")
    public String ORDERUNIT;

    @XStreamAlias("ORDERPRICE")
    public String ORDERPRICE;

    @XStreamAlias("PRICEWITHVAT")
    public String PRICEWITHVAT;

    @XStreamAlias("AMOUNT")
    public String AMOUNT;

    @XStreamAlias("AMOUNTWITHVAT")
    public String AMOUNTWITHVAT;

    @XStreamAlias("ORDERPRICEBASIS")
    public String ORDERPRICEBASIS;

    @XStreamAlias("ORDERPRICEUNIT")
    public String ORDERPRICEUNIT;

    @XStreamAlias("VAT")
    public String VAT;

    @XStreamAlias("INFO")
    public String INFO;

    @XStreamAlias("CHARACTERISTIC")
    public CHARACTERISTIC CHARACTERISTIC;

    public int getIntVat(){
        try{
            return Integer.parseInt(getStringVat());
        } catch (Exception returnnull){
            return 0;
        }
    }

    public String getStringVat(){
        try{
            return VAT.split("\\.")[0];
        } catch (Exception returnnull){
            return null;
        }
    }

    public Float getPrice(){
        return ORDERPRICE == null ? 0 : Float.parseFloat(ORDERPRICE);
    }

    public Float getPriceWithVat(){
        return PRICEWITHVAT == null ? 0 : Float.parseFloat(PRICEWITHVAT);
    }

}
