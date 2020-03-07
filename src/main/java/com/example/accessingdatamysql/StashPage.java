package com.example.accessingdatamysql;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "next_change_id",
    "stashes"
})
public class StashPage {

    @JsonProperty("next_change_id")
    private String nextChangeId;

    @OneToMany(mappedBy = "stashPage", cascade = CascadeType.ALL)
    @JsonProperty("stashes")
    private List<Stash> stashes = new ArrayList<Stash>();


    Date processDate;
    
    @Id
    private String myChangeId;

    @JsonProperty("next_change_id")
    public String getNextChangeId() {
        return nextChangeId;
    }

    @JsonProperty("next_change_id")
    public void setNextChangeId(String nextChangeId) {
        this.nextChangeId = nextChangeId;
    }

    @JsonProperty("stashes")
    public List<Stash> getStashes() {
        return stashes;
    }

    @JsonProperty("stashes")
    public void setStashes(List<Stash> stashes) {
        this.stashes = stashes;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getMyChangeId() {
        return myChangeId;
    }

    public void setMyChangeId(String myChangeId) {
        this.myChangeId = myChangeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StashPage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("nextChangeId");
        sb.append('=');
        sb.append(((this.nextChangeId == null)?"<null>":this.nextChangeId));
        sb.append(',');
        sb.append("stashes");
        sb.append('=');
        sb.append(((this.stashes == null)?"<null>":this.stashes));
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
        result = ((result* 31)+((this.nextChangeId == null)? 0 :this.nextChangeId.hashCode()));
        result = ((result* 31)+((this.stashes == null)? 0 :this.stashes.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StashPage) == false) {
            return false;
        }
        StashPage rhs = ((StashPage) other);
        return (((this.nextChangeId == rhs.nextChangeId)||((this.nextChangeId!= null)&&this.nextChangeId.equals(rhs.nextChangeId)))&&((this.stashes == rhs.stashes)||((this.stashes!= null)&&this.stashes.equals(rhs.stashes))));
    }

}
