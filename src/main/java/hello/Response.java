package hello;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Response {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    

    @JsonProperty("next_change_id")
    private String nextChangeId;
    @Transient
    private List<Stash> stashes = null;

    
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
}
