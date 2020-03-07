package com.example.accessingdatamysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "attr",
    "sColour"
})
public class Socket {
   
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn
    public Item item; 
    
    @JsonProperty("group")
    private Integer _group;
    @JsonProperty("attr")
    private String attr;
    @JsonProperty("sColour")
    private String sColour;

    @JsonProperty("group")
    public Integer getGroup() {
        return _group;
    }

    @JsonProperty("group")
    public void setGroup(Integer group) {
        this._group = group;
    }

    @JsonProperty("attr")
    public String getAttr() {
        return attr;
    }

    @JsonProperty("attr")
    public void setAttr(String attr) {
        this.attr = attr;
    }

    @JsonProperty("sColour")
    public String getsColour() {
        return sColour;
    }

    @JsonProperty("sColour")
    public void setsColour(String sColour) {
        this.sColour = sColour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Socket.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("group");
        sb.append('=');
        sb.append(((this._group == null)?"<null>":this._group));
        sb.append(',');
        sb.append("attr");
        sb.append('=');
        sb.append(((this.attr == null)?"<null>":this.attr));
        sb.append(',');
        sb.append("sColour");
        sb.append('=');
        sb.append(((this.sColour == null)?"<null>":this.sColour));
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
        result = ((result* 31)+((this.attr == null)? 0 :this.attr.hashCode()));
        result = ((result* 31)+((this._group == null)? 0 :this._group.hashCode()));
        result = ((result* 31)+((this.sColour == null)? 0 :this.sColour.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Socket) == false) {
            return false;
        }
        Socket rhs = ((Socket) other);
        return ((((this.attr == rhs.attr)||((this.attr!= null)&&this.attr.equals(rhs.attr)))&&((this._group == rhs._group)||((this._group!= null)&&this._group.equals(rhs._group))))&&((this.sColour == rhs.sColour)||((this.sColour!= null)&&this.sColour.equals(rhs.sColour))));
    }

}
