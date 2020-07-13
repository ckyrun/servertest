package org.exite.servertest.order;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("HEAD")
public class HEAD {

    @XStreamAlias("SUPPLIER")
    public String SUPPLIER;

    @XStreamAlias("BUYER")
    public String BUYER;

    @XStreamAlias("DELIVERYPLACE")
    public String DELIVERYPLACE;

    @XStreamAlias("INVOICEPARTNER")
    public String INVOICEPARTNER;

    @XStreamAlias("SENDER")
    public String SENDER;

    @XStreamAlias("RECIPIENT")
    public String RECIPIENT;

    @XStreamAlias("CONSIGNEE")
    public String CONSIGNEE;

    @XStreamAlias("INFO")
    public String INFO;

    @XStreamAlias("EDIINTERCHANGEID")
    public String EDIINTERCHANGEID;

    @XStreamImplicit
    @XStreamAlias("POSITION")
    public List<POSITION> POSITION;

}
