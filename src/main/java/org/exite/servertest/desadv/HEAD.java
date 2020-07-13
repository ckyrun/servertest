package org.exite.servertest.desadv;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("HEAD")
public class HEAD {

    @XStreamAlias("SUPPLIER")
    public String SUPPLIER;

    @XStreamAlias("BUYER")
    public String BUYER;

    @XStreamAlias("INVOICEPARTNER")
    public String INVOICEPARTNER;

    @XStreamAlias("DELIVERYPLACE")
    public String DELIVERYPLACE;

    @XStreamAlias("SENDER")
    public String SENDER;

    @XStreamAlias("RECIPIENT")
    public String RECIPIENT;

    @XStreamAlias("EDIINTERCHANGEID")
    public String EDIINTERCHANGEID;

    @XStreamAlias("EDIMESSAGE")
    public String EDIMESSAGE;

    @XStreamImplicit
    @XStreamAlias("PACKINGSEQUENCE")
    public List<PACKINGSEQUENCE> PACKINGSEQUENCE;

    @XStreamAlias("INFO")
    public String INFO;
}
