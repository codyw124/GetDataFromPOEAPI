package com.example.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "verified",
    "w",
    "h",
    "icon",
    "support",
    "league",
    "id",
    "name",
    "typeLine",
    "identified",
    "ilvl",
    "properties",
    "additionalProperties",
    "requirements",
    "secDescrText",
    "explicitMods",
    "descrText",
    "frameType",
    "socket",
    "colour"
})
public class SocketedItem {
   
    @ManyToOne
    @JoinColumn
    public Item item; 

    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("w")
    private Integer w;
    @JsonProperty("h")
    private Integer h;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("support")
    private Boolean support;
    @JsonProperty("league")
    private String league;

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("typeLine")
    private String typeLine;
    @JsonProperty("identified")
    private Boolean identified;
    @JsonProperty("ilvl")
    private Integer ilvl;

    @Column(length = 511)
    @JsonProperty("secDescrText")
    private String secDescrText;
    @Column(length = 511)
    @JsonProperty("descrText")
    private String descrText;

    @JsonProperty("frameType")
    private Integer frameType;
    @JsonProperty("socket")
    private Integer socket;
    @JsonProperty("colour")
    private String colour;

    
    
    @ElementCollection
    @JsonProperty("explicitMods")
    private List<String> explicitMods = new ArrayList<String>();


    
    @OneToMany(mappedBy = "socketedItem", cascade = CascadeType.ALL)
    @JsonProperty("properties")
    private List<Property> properties = new ArrayList<Property>();
    @OneToMany(mappedBy = "socketedItem", cascade = CascadeType.ALL)
    @JsonProperty("additionalProperties")
    private List<AdditionalProperty> additionalProperties = new ArrayList<AdditionalProperty>();
    @OneToMany(mappedBy = "socketedItem", cascade = CascadeType.ALL)
    @JsonProperty("requirements")
    private List<Requirement> requirements = new ArrayList<Requirement>();

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("w")
    public Integer getW() {
        return w;
    }

    @JsonProperty("w")
    public void setW(Integer w) {
        this.w = w;
    }

    @JsonProperty("h")
    public Integer getH() {
        return h;
    }

    @JsonProperty("h")
    public void setH(Integer h) {
        this.h = h;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("support")
    public Boolean getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Boolean support) {
        this.support = support;
    }

    @JsonProperty("league")
    public String getLeague() {
        return league;
    }

    @JsonProperty("league")
    public void setLeague(String league) {
        this.league = league;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("typeLine")
    public String getTypeLine() {
        return typeLine;
    }

    @JsonProperty("typeLine")
    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    @JsonProperty("identified")
    public Boolean getIdentified() {
        return identified;
    }

    @JsonProperty("identified")
    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }

    @JsonProperty("ilvl")
    public Integer getIlvl() {
        return ilvl;
    }

    @JsonProperty("ilvl")
    public void setIlvl(Integer ilvl) {
        this.ilvl = ilvl;
    }

    @JsonProperty("properties")
    public List<Property> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @JsonProperty("additionalProperties")
    public List<AdditionalProperty> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonProperty("additionalProperties")
    public void setAdditionalProperties(List<AdditionalProperty> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("requirements")
    public List<Requirement> getRequirements() {
        return requirements;
    }

    @JsonProperty("requirements")
    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @JsonProperty("secDescrText")
    public String getSecDescrText() {
        return secDescrText;
    }

    @JsonProperty("secDescrText")
    public void setSecDescrText(String secDescrText) {
        this.secDescrText = secDescrText;
    }

    @JsonProperty("explicitMods")
    public List<String> getExplicitMods() {
        return explicitMods;
    }

    @JsonProperty("explicitMods")
    public void setExplicitMods(List<String> explicitMods) {
        this.explicitMods = explicitMods;
    }

    @JsonProperty("descrText")
    public String getDescrText() {
        return descrText;
    }

    @JsonProperty("descrText")
    public void setDescrText(String descrText) {
        this.descrText = descrText;
    }

    @JsonProperty("frameType")
    public Integer getFrameType() {
        return frameType;
    }

    @JsonProperty("frameType")
    public void setFrameType(Integer frameType) {
        this.frameType = frameType;
    }

    @JsonProperty("socket")
    public Integer getSocket() {
        return socket;
    }

    @JsonProperty("socket")
    public void setSocket(Integer socket) {
        this.socket = socket;
    }

    @JsonProperty("colour")
    public String getColour() {
        return colour;
    }

    @JsonProperty("colour")
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SocketedItem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("verified");
        sb.append('=');
        sb.append(((this.verified == null)?"<null>":this.verified));
        sb.append(',');
        sb.append("w");
        sb.append('=');
        sb.append(((this.w == null)?"<null>":this.w));
        sb.append(',');
        sb.append("h");
        sb.append('=');
        sb.append(((this.h == null)?"<null>":this.h));
        sb.append(',');
        sb.append("icon");
        sb.append('=');
        sb.append(((this.icon == null)?"<null>":this.icon));
        sb.append(',');
        sb.append("support");
        sb.append('=');
        sb.append(((this.support == null)?"<null>":this.support));
        sb.append(',');
        sb.append("league");
        sb.append('=');
        sb.append(((this.league == null)?"<null>":this.league));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("typeLine");
        sb.append('=');
        sb.append(((this.typeLine == null)?"<null>":this.typeLine));
        sb.append(',');
        sb.append("identified");
        sb.append('=');
        sb.append(((this.identified == null)?"<null>":this.identified));
        sb.append(',');
        sb.append("ilvl");
        sb.append('=');
        sb.append(((this.ilvl == null)?"<null>":this.ilvl));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null)?"<null>":this.properties));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        sb.append("requirements");
        sb.append('=');
        sb.append(((this.requirements == null)?"<null>":this.requirements));
        sb.append(',');
        sb.append("secDescrText");
        sb.append('=');
        sb.append(((this.secDescrText == null)?"<null>":this.secDescrText));
        sb.append(',');
        sb.append("explicitMods");
        sb.append('=');
        sb.append(((this.explicitMods == null)?"<null>":this.explicitMods));
        sb.append(',');
        sb.append("descrText");
        sb.append('=');
        sb.append(((this.descrText == null)?"<null>":this.descrText));
        sb.append(',');
        sb.append("frameType");
        sb.append('=');
        sb.append(((this.frameType == null)?"<null>":this.frameType));
        sb.append(',');
        sb.append("socket");
        sb.append('=');
        sb.append(((this.socket == null)?"<null>":this.socket));
        sb.append(',');
        sb.append("colour");
        sb.append('=');
        sb.append(((this.colour == null)?"<null>":this.colour));
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
        result = ((result* 31)+((this.secDescrText == null)? 0 :this.secDescrText.hashCode()));
        result = ((result* 31)+((this.typeLine == null)? 0 :this.typeLine.hashCode()));
        result = ((result* 31)+((this.requirements == null)? 0 :this.requirements.hashCode()));
        result = ((result* 31)+((this.league == null)? 0 :this.league.hashCode()));
        result = ((result* 31)+((this.explicitMods == null)? 0 :this.explicitMods.hashCode()));
        result = ((result* 31)+((this.verified == null)? 0 :this.verified.hashCode()));
        result = ((result* 31)+((this.h == null)? 0 :this.h.hashCode()));
        result = ((result* 31)+((this.icon == null)? 0 :this.icon.hashCode()));
        result = ((result* 31)+((this.ilvl == null)? 0 :this.ilvl.hashCode()));
        result = ((result* 31)+((this.descrText == null)? 0 :this.descrText.hashCode()));
        result = ((result* 31)+((this.colour == null)? 0 :this.colour.hashCode()));
        result = ((result* 31)+((this.identified == null)? 0 :this.identified.hashCode()));
        result = ((result* 31)+((this.w == null)? 0 :this.w.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.frameType == null)? 0 :this.frameType.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.socket == null)? 0 :this.socket.hashCode()));
        result = ((result* 31)+((this.support == null)? 0 :this.support.hashCode()));
        result = ((result* 31)+((this.properties == null)? 0 :this.properties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SocketedItem) == false) {
            return false;
        }
        SocketedItem rhs = ((SocketedItem) other);
        return (((((((((((((((((((((this.secDescrText == rhs.secDescrText)||((this.secDescrText!= null)&&this.secDescrText.equals(rhs.secDescrText)))&&((this.typeLine == rhs.typeLine)||((this.typeLine!= null)&&this.typeLine.equals(rhs.typeLine))))&&((this.requirements == rhs.requirements)||((this.requirements!= null)&&this.requirements.equals(rhs.requirements))))&&((this.league == rhs.league)||((this.league!= null)&&this.league.equals(rhs.league))))&&((this.explicitMods == rhs.explicitMods)||((this.explicitMods!= null)&&this.explicitMods.equals(rhs.explicitMods))))&&((this.verified == rhs.verified)||((this.verified!= null)&&this.verified.equals(rhs.verified))))&&((this.h == rhs.h)||((this.h!= null)&&this.h.equals(rhs.h))))&&((this.icon == rhs.icon)||((this.icon!= null)&&this.icon.equals(rhs.icon))))&&((this.ilvl == rhs.ilvl)||((this.ilvl!= null)&&this.ilvl.equals(rhs.ilvl))))&&((this.descrText == rhs.descrText)||((this.descrText!= null)&&this.descrText.equals(rhs.descrText))))&&((this.colour == rhs.colour)||((this.colour!= null)&&this.colour.equals(rhs.colour))))&&((this.identified == rhs.identified)||((this.identified!= null)&&this.identified.equals(rhs.identified))))&&((this.w == rhs.w)||((this.w!= null)&&this.w.equals(rhs.w))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.frameType == rhs.frameType)||((this.frameType!= null)&&this.frameType.equals(rhs.frameType))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.socket == rhs.socket)||((this.socket!= null)&&this.socket.equals(rhs.socket))))&&((this.support == rhs.support)||((this.support!= null)&&this.support.equals(rhs.support))))&&((this.properties == rhs.properties)||((this.properties!= null)&&this.properties.equals(rhs.properties))));
    }

}
