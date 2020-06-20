/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmuhatia.library.library.usermanagement.entities;

import com.cm.projects.spring.resource.chasis.annotations.EditDataWrapper;
import com.cm.projects.spring.resource.chasis.annotations.EditEntity;
import com.cm.projects.spring.resource.chasis.annotations.EditEntityId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cornelius
 */
@Entity
@Table(name = "temp_edited_record")
public class TempEditedRecord implements Serializable {

    private static final long serialVersionUID = 1592648671L;
    @Id
    @Basic(optional = false)
    @GenericGenerator(
            name = "temp_edit_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "temp_edit_seq")
                    ,
                    @Parameter(name = "initial_value", value = "0")
                    ,
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "temp_edit_seq")
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "entity")
    @EditEntity
    private String entity;
    @Size(max = 20)
    @Column(name = "entity_id")
    @EditEntityId
    private String entityId;
    @Column(name = "record")
    @EditDataWrapper
    private String record;
    @Basic(optional = false)
    @Column(name = "creation_date", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public TempEditedRecord() {
    }

    public TempEditedRecord(Long id) {
        this.id = id;
    }

    public TempEditedRecord(Long id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TempEditedRecord)) {
            return false;
        }
        TempEditedRecord other = (TempEditedRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TempEditedRecord[ id=" + id + " ]";
    }

}
