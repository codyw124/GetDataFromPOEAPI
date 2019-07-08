
package hello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Category {

    private List<String> armour = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public List<String> getArmour() {
        return armour;
    }

    public void setArmour(List<String> armour) {
        this.armour = armour;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
