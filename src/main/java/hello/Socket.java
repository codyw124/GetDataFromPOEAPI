
package hello;

import java.util.HashMap;
import java.util.Map;

public class Socket {

    private Integer group;
    private String attr;
    private String sColour;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getSColour() {
        return sColour;
    }

    public void setSColour(String sColour) {
        this.sColour = sColour;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
