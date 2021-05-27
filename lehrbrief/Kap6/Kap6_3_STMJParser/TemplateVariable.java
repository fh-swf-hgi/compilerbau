package Kap6.Kap6_3_STMJParser;

public class TemplateVariable extends StringTemplateElement {
    public TemplateVariable(String name) {
        this.name = name.substring(1,name.length()-1);
    }
 }
