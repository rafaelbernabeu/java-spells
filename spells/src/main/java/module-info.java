module spells.module {
     requires jdk.unsupported;
     requires com.fasterxml.jackson.databind;
     requires java.xml;
     requires org.jsoup;
     requires org.apache.poi.ooxml;
     requires lombok;
     exports spells;
    exports spells.jdk14;
}