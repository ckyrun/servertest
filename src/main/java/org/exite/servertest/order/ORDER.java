package org.exite.servertest.order;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.exite.servertest.EdiDocument;

import java.util.List;

@XStreamAlias("ORDER")
public class ORDER implements EdiDocument {

    @XStreamAlias("DOCUMENTNAME")
    public String DOCUMENTNAME;

    @XStreamAlias("NUMBER")
    public String NUMBER;

    @XStreamAlias("DATE")
    public String DATE;

    @XStreamAlias("DELIVERYDATE")
    public String DELIVERYDATE;

    @XStreamAlias("DELIVERYTIME")
    public String DELIVERYTIME;

    @XStreamAlias("CAMPAIGNNUMBER")
    public String CAMPAIGNNUMBER;

    @XStreamAlias("CURRENCY")
    public String CURRENCY;

    @XStreamAlias("DOCTYPE")
    public String DOCTYPE;

    @XStreamAlias("ORDRTYPE")
    public String ORDRTYPE;

    @XStreamAlias("INFO")
    public String INFO;

    @XStreamImplicit
    @XStreamAlias("HEAD")
    public List<HEAD> HEAD;

    @Override
    public String getSender() {
        return this.HEAD.get(0).SENDER;
    }

    @Override
    public String getRecipient() {
        return this.HEAD.get(0).RECIPIENT;
    }

    @Override
    public String getNumber() {
        return this.NUMBER;
    }

}