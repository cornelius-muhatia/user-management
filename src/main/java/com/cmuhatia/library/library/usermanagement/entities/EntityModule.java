/*
 * Copyright 2020 Cornelius M.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.library.library.usermanagement.entities;

import com.cm.projects.spring.resource.chasis.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cornelius
 * @version 1.0.0
 */
@NickName(name = "Module")
@Entity
@Table(name = "entity_module")
public class EntityModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GenericGenerator(
            name = "module_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "module_seq")
                    ,
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0")
                    ,
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "module_seq")
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", unique = true)
    @ModifiableField
    @Searchable
    @Unique(fieldName = "Name")
    @RelEntityLabel
    @ExportField
    private String name;
    @Size(max = 2000)
    @Column(name = "description")
    @ModifiableField
    @Searchable
    @ExportField
    private String description;
    @Basic(optional = false)
    @Column(name = "creation_date", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Filter(isDateRange = true)
    @ExportField
    private Date creationDate;
    @Size(max = 3)
    @Column(name = "intrash")
    @JsonIgnore
    private String intrash;
//    @Basic(optional = false)
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<com.cmuhatia.usermanagement.entities.Entity> entities;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Filter
    @ExportField(entityField = @ExportFieldEntity(fieldName = "name"))
    private Status status;

    public EntityModule() {
    }

    public EntityModule(Short id) {
        this.id = id;
    }

    public EntityModule(Short id, String name, Status status, Date creationDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.creationDate = creationDate;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name.trim();
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
    }

//    @ApiModelProperty(hidden = true)
//    public List<com.cmuhatia.usermanagement.entities.Entity> getEntities() {
//        return entities;
//    }
//
//    public void setEntities(List<com.cmuhatia.usermanagement.entities.Entity> entities) {
//        this.entities = entities;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityModule)) {
            return false;
        }
        EntityModule other = (EntityModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityModule[ id=" + id + " ]";
    }

}