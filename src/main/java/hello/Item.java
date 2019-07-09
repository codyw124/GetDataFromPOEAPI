
package hello;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

    @Id
    private String id;

    private Boolean verified;
    private Integer w;
    private Integer h;
    private Integer ilvl;
    private String icon;
    private String league;
    private String name;
    private String typeLine;
    private Boolean identified;
    private String note;
    private Integer frameType;
    private Integer x;
    private Integer y;
    private String inventoryId;

    private String accountName;

    @Transient
    private List<String> explicitMods = null;

    private Integer totalResistances;

    public Integer getTotalResistances(){
        return totalResistances;
    }

    public void setTotalResistances(Integer totalResistances){
        this.totalResistances = totalResistances;
    }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }

    public List<String> getExplicitMods() {
        return explicitMods;
    }
    
    public void setExplicitMods(List<String> explicitMods) {
        this.explicitMods = explicitMods;
    }

    // private List<Socket> sockets = null;
    // private List<Property> properties = null;
    // private List<Requirement> requirements = null;
    // private Category category;
    // private List<Object> socketedItems = null;

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getIlvl() {
        return ilvl;
    }

    public void setIlvl(Integer ilvl) {
        this.ilvl = ilvl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getLeague() {
        return league;
    }
    
    public void setLeague(String league) {
        this.league = league;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    // public List<Socket> getSockets() {
    //     return sockets;
    // }
    
    // public void setSockets(List<Socket> sockets) {
    //     this.sockets = sockets;
    // }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public Boolean getIdentified() {
        return identified;
    }

    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    // public List<Property> getProperties() {
    //     return properties;
    // }
    
    // public void setProperties(List<Property> properties) {
    //     this.properties = properties;
    // }
    
    // public List<Requirement> getRequirements() {
    //     return requirements;
    // }
    
    // public void setRequirements(List<Requirement> requirements) {
    //     this.requirements = requirements;
    // }
    
    
    
    public Integer getFrameType() {
        return frameType;
    }
    
    public void setFrameType(Integer frameType) {
        this.frameType = frameType;
    }
    
    // public Category getCategory() {
    //     return category;
    // }
    
    // public void setCategory(Category category) {
    //     this.category = category;
    // }
    
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }
    
    public Integer getY() {
        return y;
    }
    
    public void setY(Integer y) {
        this.y = y;
    }
    
    public String getInventoryId() {
        return inventoryId;
    }
    
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
    
    // public List<Object> getSocketedItems() {
    //     return socketedItems;
    // }
    
    // public void setSocketedItems(List<Object> socketedItems) {
    //     this.socketedItems = socketedItems;
    // }
}
