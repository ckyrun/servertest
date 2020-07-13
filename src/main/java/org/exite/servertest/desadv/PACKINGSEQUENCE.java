package org.exite.servertest.desadv;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("PACKINGSEQUENCE")
public class PACKINGSEQUENCE {

    @XStreamAlias("HIERARCHICALID")
    public String HIERARCHICALID;

    @XStreamImplicit
    @XStreamAlias("POSITION")
    public List<POSITION> POSITION;

}