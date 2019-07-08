package hello;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Response {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    

    @JsonProperty("next_change_id")
    private String nextChangeId;
    @OneToMany(targetEntity=Stash.class, mappedBy="response", fetch=FetchType.LAZY)
    private List<Stash> stashes = null;
    
    // private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    public String getNextChangeId() {
        return nextChangeId;
    }
    
    public void setNextChangeId(String nextChangeId) {
        this.nextChangeId = nextChangeId;
    }
    
    public List<Stash> getStashes() {
        return stashes;
    }
    
    public void setStashes(List<Stash> stashes) {
        this.stashes = stashes;
    }
    
    // public Map<String, Object> getAdditionalProperties() {
    //     return this.additionalProperties;
    // }
    
    // public void setAdditionalProperty(String name, Object value) {
    //     this.additionalProperties.put(name, value);
    // }
}
