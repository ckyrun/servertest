package org.exite.servertest.desadv;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.exite.servertest.EdiDocument;

import java.util.List;

@XStreamAlias("DESADV")
public class DESADV implements EdiDocument {

    @XStreamAlias("NUMBER")
    public String NUMBER;

    @XStreamAlias("DATE")
    public String DATE;

    @XStreamAlias("INVOICENUMBER")
    public String INVOICENUMBER;

    @XStreamAlias("INVOICEDATE")
    public String INVOICEDATE;

    @XStreamAlias("DELIVERYDATE")
    public String DELIVERYDATE;

    @XStreamAlias("DELIVERYTIME")
    public String DELIVERYTIME;

    @XStreamAlias("ORDERNUMBER")
    public String ORDERNUMBER;

    @XStreamAlias("ORDERDATE")
    public String ORDERDATE;

    @XStreamAlias("DELIVERYNOTENUMBER")
    public String DELIVERYNOTENUMBER;

    @XStreamAlias("DELIVERYNOTEDATE")
    public String DELIVERYNOTEDATE;

    @XStreamAlias("DOCTYPE")
    public String DOCTYPE;

    @XStreamAlias("INFO")
    public String INFO;

    @XStreamAlias("CAMPAIGNNUMBER")
    public String CAMPAIGNNUMBER;

    @XStreamImplicit
    @XStreamAlias("HEAD")
    public List<HEAD> HEAD;

    @Override
    public String getSender() {
        if (checkHead()) {
            return this.HEAD.get(0).SENDER;
        } else {
            return null;
        }
    }

    @Override
    public String getRecipient() {
        if (checkHead()) {
            return this.HEAD.get(0).RECIPIENT;
        } else {
            return null;
        }
    }

    @Override
    public String getNumber() {
        return this.NUMBER;
    }


    private boolean checkHead() {
        if (this.HEAD != null && this.HEAD.size() > 0) {
            return true;
        }
        return false;
    }
}
