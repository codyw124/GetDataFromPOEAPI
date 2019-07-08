
package hello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Property {

    
    private String name;
    
    private List<List<String>> values = null;
    
    private Integer displayMode;
    
    private Integer type;
    
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<String>> getValues() {
        return values;
    }

    public void setValues(List<List<String>> values) {
        this.values = values;
    }
    
    public Integer getDisplayMode() {
        return displayMode;
    }
    
    public void setDisplayMode(Integer displayMode) {
        this.displayMode = displayMode;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
