package Kap6.Kap6_3_STMJParser;

public class TemplateVariableSep extends StringTemplateElement {
    public String seperator;
    public TemplateVariableSep(String nameSep) {
        int i = nameSep.indexOf(':');
        name = nameSep.substring(1,i);
        seperator = nameSep.substring(i+1,nameSep.length()-1);
    }
}
