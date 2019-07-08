
package hello;

// import java.util.HashMap;
// import java.util.Map;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Stash {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responseId")
    Response response;

    private String accountName;
    private String lastCharacterName;
    
    @Id
    private String id;
    private String stash;
    private String stashType;
    @OneToMany(targetEntity=Item.class, mappedBy="stash", fetch=FetchType.LAZY)
    private List<Item> items = null;
    private Boolean _public;
    // private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLastCharacterName() {
        return lastCharacterName;
    }

    public void setLastCharacterName(String lastCharacterName) {
        this.lastCharacterName = lastCharacterName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStash() {
        return stash;
    }

    public void setStash(String stash) {
        this.stash = stash;
    }

    public String getStashType() {
        return stashType;
    }

    public void setStashType(String stashType) {
        this.stashType = stashType;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    // public Map<String, Object> getAdditionalProperties() {
    //     return this.additionalProperties;
    // }

    // public void setAdditionalProperty(String name, Object value) {
    //     this.additionalProperties.put(name, value);
    // }
}
