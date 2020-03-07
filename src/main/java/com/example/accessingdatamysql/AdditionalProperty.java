package com.example.accessingdatamysql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "values",
    "displayMode",
    "progress",
    "type"
})
public class AdditionalProperty {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn
    public Item item; 
   
    @ManyToOne
    @JoinColumn
    public SocketedItem socketedItem; 

    @JsonProperty("name")
    private String name;
    @JsonProperty("displayMode")
    private Integer displayMode;
    @JsonProperty("progress")
    private Double progress;
    @JsonProperty("type")
    private Integer type;
    
    @OneToMany(mappedBy = "additionalProperty", cascade = CascadeType.ALL)
    private List<Values> _values = new ArrayList<Values>();

    @Transient
    @JsonProperty("values")
    private List<List<String>> valuesFromJson = new ArrayList<List<String>>();

    public List<Values> getValues() {
        return _values;
    }

    public void setValues(List<Values> values) {
        this._values = values;
    }

    @JsonProperty("values")
    public List<List<String>> getValuesFromJson() {
        return valuesFromJson;
    }

    @JsonProperty("values")
    public void setValuesFromJson(List<List<String>>valuesFromJson) {
        this.valuesFromJson = valuesFromJson;
        for(List<String> currentValues : valuesFromJson){
            Values x = new Values();
            x.setValue(currentValues.get(0));
            x.setValueType(Integer.valueOf(currentValues.get(1)));
            this._values.add(x);
        }
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("displayMode")
    public Integer getDisplayMode() {
        return displayMode;
    }

    @JsonProperty("displayMode")
    public void setDisplayMode(Integer displayMode) {
        this.displayMode = displayMode;
    }

    @JsonProperty("progress")
    public Double getProgress() {
        return progress;
    }

    @JsonProperty("progress")
    public void setProgress(Double progress) {
        this.progress = progress;
    }

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdditionalProperty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("values");
        sb.append('=');
        sb.append(((this._values == null)?"<null>":this._values));
        sb.append(',');
        sb.append("displayMode");
        sb.append('=');
        sb.append(((this.displayMode == null)?"<null>":this.displayMode));
        sb.append(',');
        sb.append("progress");
        sb.append('=');
        sb.append(((this.progress == null)?"<null>":this.progress));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.progress == null)? 0 :this.progress.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.displayMode == null)? 0 :this.displayMode.hashCode()));
        result = ((result* 31)+((this._values == null)? 0 :this._values.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdditionalProperty) == false) {
            return false;
        }
        AdditionalProperty rhs = ((AdditionalProperty) other);
        return ((((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.progress == rhs.progress)||((this.progress!= null)&&this.progress.equals(rhs.progress))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.displayMode == rhs.displayMode)||((this.displayMode!= null)&&this.displayMode.equals(rhs.displayMode))))
        &&((this._values == rhs._values)||((this._values!= null)&&this._values.equals(rhs._values)))
        );
    }

}
