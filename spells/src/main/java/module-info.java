module spells.module {

    requires jdk.unsupported;
    requires jdk.incubator.concurrent;
    requires java.xml;
    requires org.jsoup;
    requires org.apache.poi.ooxml;
    requires com.fasterxml.jackson.databind;
    requires lombok;

    exports spells;
    exports spells.jdk8;
    exports spells.jdk10;
    exports spells.jdk11;
    exports spells.jdk14;
    exports spells.jdk15;
    exports spells.jdk16;
    exports spells.jdk19;

}