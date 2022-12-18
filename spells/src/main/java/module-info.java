module spells.module {
     requires jdk.unsupported;
     requires jdk.incubator.concurrent;
     requires java.xml;
     requires org.jsoup;
     requires org.apache.poi.ooxml;
     requires com.fasterxml.jackson.databind;
     requires lombok;
     exports spells;
    exports spells.jdk14;
}