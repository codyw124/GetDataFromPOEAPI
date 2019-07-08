
package hello;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Stash {

    private String accountName;
    private String lastCharacterName;
    
    @Id
    private String id;
    private String stash;
    private String stashType;
    @Transient
    private List<Item> items = null;
    private Boolean _public;

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
}
