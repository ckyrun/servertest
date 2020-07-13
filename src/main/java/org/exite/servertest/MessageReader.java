package org.exite.servertest;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;

public class MessageReader {
    public static EdiDocument getMessage(InputStream streamXML, String typeDoc) throws ClassNotFoundException {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias(typeDoc, Class.forName("org.exite.servertest." + typeDoc.toLowerCase() + "." + typeDoc));
        xstream.autodetectAnnotations(true);
        return (EdiDocument) xstream.fromXML(streamXML);
    }
}
