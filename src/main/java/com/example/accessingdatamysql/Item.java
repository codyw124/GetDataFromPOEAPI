package com.example.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
    "verified",
    "w",
    "h",
    "icon",
    "league",
    "id",
    "sockets",
    "name",
    "typeLine",
    "identified",
    "ilvl",
    "note",
    "properties",
    "requirements",
    "explicitMods",
    "flavourText",
    "frameType",
    "x",
    "y",
    "inventoryId",
    "socketedItems",
    "support",
    "additionalProperties",
    "nextLevelRequirements",
    "secDescrText",
    "descrText",
    "implicitMods",
    "utilityMods",
    "craftedMods"
})
public class Item {
   
    @ManyToOne
    @JoinColumn
    public Stash stash; 

    //properties
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("w")
    private Integer w;
    @JsonProperty("h")
    private Integer h;
    @JsonProperty("icon")
    private String icon;
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
    @JsonProperty("note")
    private String note;
    @JsonProperty("frameType")
    private Integer frameType;
    @JsonProperty("x")
    private Integer x;
    @JsonProperty("y")
    private Integer y;
    @JsonProperty("inventoryId")
    private String inventoryId;
    @JsonProperty("support")
    private Boolean support;
    
    @Column(length = 511)
    @JsonProperty("secDescrText")
    private String secDescrText;
    @Column(length = 511)
    @JsonProperty("descrText")
    private String descrText;
    
    @Column(length = 511)
    @ElementCollection
    @JsonProperty("explicitMods")
    private List<String> explicitMods = new ArrayList<String>();
    @ElementCollection
    @JsonProperty("flavourText")
    private List<String> flavourText = new ArrayList<String>();
    @ElementCollection
    @JsonProperty("implicitMods")
    private List<String> implicitMods = new ArrayList<String>();
    @ElementCollection
    @JsonProperty("utilityMods")
    private List<String> utilityMods = new ArrayList<String>();
    @ElementCollection
    @JsonProperty("craftedMods")
    private List<String> craftedMods = new ArrayList<String>();



    //onetomany
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonProperty("nextLevelRequirements")
    private List<NextLevelRequirement> nextLevelRequirements = new ArrayList<NextLevelRequirement>();
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonProperty("additionalProperties")
    private List<AdditionalProperty> additionalProperties = new ArrayList<AdditionalProperty>();
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonProperty("socketedItems")
    private List<SocketedItem> socketedItems = new ArrayList<SocketedItem>();
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonProperty("requirements")
    private List<Requirement> requirements = new ArrayList<Requirement>();
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonProperty("properties")
    private List<Property> properties = new ArrayList<Property>();
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonProperty("sockets")
    private List<Socket> sockets = new ArrayList<Socket>();

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

    @JsonProperty("sockets")
    public List<Socket> getSockets() {
        return sockets;
    }

    @JsonProperty("sockets")
    public void setSockets(List<Socket> sockets) {
        this.sockets = sockets;
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

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("properties")
    public List<Property> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @JsonProperty("requirements")
    public List<Requirement> getRequirements() {
        return requirements;
    }

    @JsonProperty("requirements")
    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @JsonProperty("explicitMods")
    public List<String> getExplicitMods() {
        return explicitMods;
    }

    @JsonProperty("explicitMods")
    public void setExplicitMods(List<String> explicitMods) {
        this.explicitMods = explicitMods;
    }

    @JsonProperty("flavourText")
    public List<String> getFlavourText() {
        return flavourText;
    }

    @JsonProperty("flavourText")
    public void setFlavourText(List<String> flavourText) {
        this.flavourText = flavourText;
    }

    @JsonProperty("frameType")
    public Integer getFrameType() {
        return frameType;
    }

    @JsonProperty("frameType")
    public void setFrameType(Integer frameType) {
        this.frameType = frameType;
    }

    @JsonProperty("x")
    public Integer getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(Integer x) {
        this.x = x;
    }

    @JsonProperty("y")
    public Integer getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(Integer y) {
        this.y = y;
    }

    @JsonProperty("inventoryId")
    public String getInventoryId() {
        return inventoryId;
    }

    @JsonProperty("inventoryId")
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    @JsonProperty("socketedItems")
    public List<SocketedItem> getSocketedItems() {
        return socketedItems;
    }

    @JsonProperty("socketedItems")
    public void setSocketedItems(List<SocketedItem> socketedItems) {
        this.socketedItems = socketedItems;
    }

    @JsonProperty("support")
    public Boolean getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Boolean support) {
        this.support = support;
    }

    @JsonProperty("additionalProperties")
    public List<AdditionalProperty> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonProperty("additionalProperties")
    public void setAdditionalProperties(List<AdditionalProperty> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("nextLevelRequirements")
    public List<NextLevelRequirement> getNextLevelRequirements() {
        return nextLevelRequirements;
    }

    @JsonProperty("nextLevelRequirements")
    public void setNextLevelRequirements(List<NextLevelRequirement> nextLevelRequirements) {
        this.nextLevelRequirements = nextLevelRequirements;
    }

    @JsonProperty("secDescrText")
    public String getSecDescrText() {
        return secDescrText;
    }

    @JsonProperty("secDescrText")
    public void setSecDescrText(String secDescrText) {
        this.secDescrText = secDescrText;
    }

    @JsonProperty("descrText")
    public String getDescrText() {
        return descrText;
    }

    @JsonProperty("descrText")
    public void setDescrText(String descrText) {
        this.descrText = descrText;
    }

    @JsonProperty("implicitMods")
    public List<String> getImplicitMods() {
        return implicitMods;
    }

    @JsonProperty("implicitMods")
    public void setImplicitMods(List<String> implicitMods) {
        this.implicitMods = implicitMods;
    }

    @JsonProperty("utilityMods")
    public List<String> getUtilityMods() {
        return utilityMods;
    }

    @JsonProperty("utilityMods")
    public void setUtilityMods(List<String> utilityMods) {
        this.utilityMods = utilityMods;
    }

    @JsonProperty("craftedMods")
    public List<String> getCraftedMods() {
        return craftedMods;
    }

    @JsonProperty("craftedMods")
    public void setCraftedMods(List<String> craftedMods) {
        this.craftedMods = craftedMods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Item.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("league");
        sb.append('=');
        sb.append(((this.league == null)?"<null>":this.league));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("sockets");
        sb.append('=');
        sb.append(((this.sockets == null)?"<null>":this.sockets));
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
        sb.append("note");
        sb.append('=');
        sb.append(((this.note == null)?"<null>":this.note));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null)?"<null>":this.properties));
        sb.append(',');
        sb.append("requirements");
        sb.append('=');
        sb.append(((this.requirements == null)?"<null>":this.requirements));
        sb.append(',');
        sb.append("explicitMods");
        sb.append('=');
        sb.append(((this.explicitMods == null)?"<null>":this.explicitMods));
        sb.append(',');
        sb.append("flavourText");
        sb.append('=');
        sb.append(((this.flavourText == null)?"<null>":this.flavourText));
        sb.append(',');
        sb.append("frameType");
        sb.append('=');
        sb.append(((this.frameType == null)?"<null>":this.frameType));
        sb.append(',');
        sb.append("x");
        sb.append('=');
        sb.append(((this.x == null)?"<null>":this.x));
        sb.append(',');
        sb.append("y");
        sb.append('=');
        sb.append(((this.y == null)?"<null>":this.y));
        sb.append(',');
        sb.append("inventoryId");
        sb.append('=');
        sb.append(((this.inventoryId == null)?"<null>":this.inventoryId));
        sb.append(',');
        sb.append("socketedItems");
        sb.append('=');
        sb.append(((this.socketedItems == null)?"<null>":this.socketedItems));
        sb.append(',');
        sb.append("support");
        sb.append('=');
        sb.append(((this.support == null)?"<null>":this.support));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        sb.append("nextLevelRequirements");
        sb.append('=');
        sb.append(((this.nextLevelRequirements == null)?"<null>":this.nextLevelRequirements));
        sb.append(',');
        sb.append("secDescrText");
        sb.append('=');
        sb.append(((this.secDescrText == null)?"<null>":this.secDescrText));
        sb.append(',');
        sb.append("descrText");
        sb.append('=');
        sb.append(((this.descrText == null)?"<null>":this.descrText));
        sb.append(',');
        sb.append("implicitMods");
        sb.append('=');
        sb.append(((this.implicitMods == null)?"<null>":this.implicitMods));
        sb.append(',');
        sb.append("utilityMods");
        sb.append('=');
        sb.append(((this.utilityMods == null)?"<null>":this.utilityMods));
        sb.append(',');
        sb.append("craftedMods");
        sb.append('=');
        sb.append(((this.craftedMods == null)?"<null>":this.craftedMods));
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
        result = ((result* 31)+((this.note == null)? 0 :this.note.hashCode()));
        result = ((result* 31)+((this.flavourText == null)? 0 :this.flavourText.hashCode()));
        result = ((result* 31)+((this.icon == null)? 0 :this.icon.hashCode()));
        result = ((result* 31)+((this.socketedItems == null)? 0 :this.socketedItems.hashCode()));
        result = ((result* 31)+((this.craftedMods == null)? 0 :this.craftedMods.hashCode()));
        result = ((result* 31)+((this.descrText == null)? 0 :this.descrText.hashCode()));
        result = ((result* 31)+((this.identified == null)? 0 :this.identified.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.sockets == null)? 0 :this.sockets.hashCode()));
        result = ((result* 31)+((this.typeLine == null)? 0 :this.typeLine.hashCode()));
        result = ((result* 31)+((this.requirements == null)? 0 :this.requirements.hashCode()));
        result = ((result* 31)+((this.implicitMods == null)? 0 :this.implicitMods.hashCode()));
        result = ((result* 31)+((this.league == null)? 0 :this.league.hashCode()));
        result = ((result* 31)+((this.explicitMods == null)? 0 :this.explicitMods.hashCode()));
        result = ((result* 31)+((this.verified == null)? 0 :this.verified.hashCode()));
        result = ((result* 31)+((this.h == null)? 0 :this.h.hashCode()));
        result = ((result* 31)+((this.ilvl == null)? 0 :this.ilvl.hashCode()));
        result = ((result* 31)+((this.nextLevelRequirements == null)? 0 :this.nextLevelRequirements.hashCode()));
        result = ((result* 31)+((this.utilityMods == null)? 0 :this.utilityMods.hashCode()));
        result = ((result* 31)+((this.w == null)? 0 :this.w.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.x == null)? 0 :this.x.hashCode()));
        result = ((result* 31)+((this.inventoryId == null)? 0 :this.inventoryId.hashCode()));
        result = ((result* 31)+((this.frameType == null)? 0 :this.frameType.hashCode()));
        result = ((result* 31)+((this.y == null)? 0 :this.y.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.support == null)? 0 :this.support.hashCode()));
        result = ((result* 31)+((this.properties == null)? 0 :this.properties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return ((((((((((((((((((((((((((((((this.secDescrText == rhs.secDescrText)||((this.secDescrText!= null)&&this.secDescrText.equals(rhs.secDescrText)))&&((this.note == rhs.note)||((this.note!= null)&&this.note.equals(rhs.note))))&&((this.flavourText == rhs.flavourText)||((this.flavourText!= null)&&this.flavourText.equals(rhs.flavourText))))&&((this.icon == rhs.icon)||((this.icon!= null)&&this.icon.equals(rhs.icon))))&&((this.socketedItems == rhs.socketedItems)||((this.socketedItems!= null)&&this.socketedItems.equals(rhs.socketedItems))))&&((this.craftedMods == rhs.craftedMods)||((this.craftedMods!= null)&&this.craftedMods.equals(rhs.craftedMods))))&&((this.descrText == rhs.descrText)||((this.descrText!= null)&&this.descrText.equals(rhs.descrText))))&&((this.identified == rhs.identified)||((this.identified!= null)&&this.identified.equals(rhs.identified))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.sockets == rhs.sockets)||((this.sockets!= null)&&this.sockets.equals(rhs.sockets))))&&((this.typeLine == rhs.typeLine)||((this.typeLine!= null)&&this.typeLine.equals(rhs.typeLine))))&&((this.requirements == rhs.requirements)||((this.requirements!= null)&&this.requirements.equals(rhs.requirements))))&&((this.implicitMods == rhs.implicitMods)||((this.implicitMods!= null)&&this.implicitMods.equals(rhs.implicitMods))))&&((this.league == rhs.league)||((this.league!= null)&&this.league.equals(rhs.league))))&&((this.explicitMods == rhs.explicitMods)||((this.explicitMods!= null)&&this.explicitMods.equals(rhs.explicitMods))))&&((this.verified == rhs.verified)||((this.verified!= null)&&this.verified.equals(rhs.verified))))&&((this.h == rhs.h)||((this.h!= null)&&this.h.equals(rhs.h))))&&((this.ilvl == rhs.ilvl)||((this.ilvl!= null)&&this.ilvl.equals(rhs.ilvl))))&&((this.nextLevelRequirements == rhs.nextLevelRequirements)||((this.nextLevelRequirements!= null)&&this.nextLevelRequirements.equals(rhs.nextLevelRequirements))))&&((this.utilityMods == rhs.utilityMods)||((this.utilityMods!= null)&&this.utilityMods.equals(rhs.utilityMods))))&&((this.w == rhs.w)||((this.w!= null)&&this.w.equals(rhs.w))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.x == rhs.x)||((this.x!= null)&&this.x.equals(rhs.x))))&&((this.inventoryId == rhs.inventoryId)||((this.inventoryId!= null)&&this.inventoryId.equals(rhs.inventoryId))))&&((this.frameType == rhs.frameType)||((this.frameType!= null)&&this.frameType.equals(rhs.frameType))))&&((this.y == rhs.y)||((this.y!= null)&&this.y.equals(rhs.y))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.support == rhs.support)||((this.support!= null)&&this.support.equals(rhs.support))))&&((this.properties == rhs.properties)||((this.properties!= null)&&this.properties.equals(rhs.properties))));
    }

}
