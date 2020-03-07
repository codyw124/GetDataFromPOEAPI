package com.example.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountName",
    "lastCharacterName",
    "id",
    "stash",
    "stashType",
    "items",
    "public"
})
public class Stash {


    @ManyToOne
    @JoinColumn
    public StashPage stashPage; 

    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("lastCharacterName")
    private String lastCharacterName;
    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("stash")
    private String stash;
    @JsonProperty("stashType")
    private String stashType;
    @JsonProperty("public")
    private Boolean _public;
    
    @OneToMany(mappedBy = "stash", cascade = CascadeType.ALL)
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("accountName")
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty("accountName")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @JsonProperty("lastCharacterName")
    public String getLastCharacterName() {
        return lastCharacterName;
    }

    @JsonProperty("lastCharacterName")
    public void setLastCharacterName(String lastCharacterName) {
        this.lastCharacterName = lastCharacterName;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("stash")
    public String getStash() {
        return stash;
    }

    @JsonProperty("stash")
    public void setStash(String stash) {
        this.stash = stash;
    }

    @JsonProperty("stashType")
    public String getStashType() {
        return stashType;
    }

    @JsonProperty("stashType")
    public void setStashType(String stashType) {
        this.stashType = stashType;
    }

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stash.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountName");
        sb.append('=');
        sb.append(((this.accountName == null)?"<null>":this.accountName));
        sb.append(',');
        sb.append("lastCharacterName");
        sb.append('=');
        sb.append(((this.lastCharacterName == null)?"<null>":this.lastCharacterName));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("stash");
        sb.append('=');
        sb.append(((this.stash == null)?"<null>":this.stash));
        sb.append(',');
        sb.append("stashType");
        sb.append('=');
        sb.append(((this.stashType == null)?"<null>":this.stashType));
        sb.append(',');
        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null)?"<null>":this.items));
        sb.append(',');
        sb.append("_public");
        sb.append('=');
        sb.append(((this._public == null)?"<null>":this._public));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.lastCharacterName == null)? 0 :this.lastCharacterName.hashCode()));
        result = ((result* 31)+((this.accountName == null)? 0 :this.accountName.hashCode()));
        result = ((result* 31)+((this._public == null)? 0 :this._public.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.items == null)? 0 :this.items.hashCode()));
        result = ((result* 31)+((this.stashType == null)? 0 :this.stashType.hashCode()));
        result = ((result* 31)+((this.stash == null)? 0 :this.stash.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stash) == false) {
            return false;
        }
        Stash rhs = ((Stash) other);
        return ((((((((this.lastCharacterName == rhs.lastCharacterName)||((this.lastCharacterName!= null)&&this.lastCharacterName.equals(rhs.lastCharacterName)))&&((this.accountName == rhs.accountName)||((this.accountName!= null)&&this.accountName.equals(rhs.accountName))))&&((this._public == rhs._public)||((this._public!= null)&&this._public.equals(rhs._public))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))
         &&((this.items == rhs.items)||((this.items!= null)&&this.items.equals(rhs.items)))
        )&&((this.stashType == rhs.stashType)||((this.stashType!= null)&&this.stashType.equals(rhs.stashType))))&&((this.stash == rhs.stash)||((this.stash!= null)&&this.stash.equals(rhs.stash))));
    }

}
