package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@javax.persistence.Table(name="generic_values")
public class Values {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private AdditionalProperty additionalProperty;
    
    @ManyToOne
    @JoinColumn
	private NextLevelRequirement nextLevelRequirement;
    
    @ManyToOne
    @JoinColumn
	private Property property;
    
    @ManyToOne
    @JoinColumn
	private Requirement requirement;

    @JsonProperty
    private String _value;
    
    @JsonProperty
    private Integer valueTypes;

    
    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        this._value = value;
    }

    public Integer getValueType() {
        return valueTypes;
    }

    public void setValueType(Integer valueTypes) {
        this.valueTypes = valueTypes;
    }
}
