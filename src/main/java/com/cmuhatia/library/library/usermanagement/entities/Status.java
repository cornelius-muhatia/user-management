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

import com.cm.projects.spring.resource.chasis.annotations.ModifiableField;
import com.cm.projects.spring.resource.chasis.annotations.Unique;
import com.cm.projects.spring.resource.chasis.utils.AppConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cornelius
 * @version 1.0.0, 20/06/2020
 */
@Entity
@Table(name = "status")
public class Status implements Serializable {

    private static final long serialVersionUID = 1592648712L;
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status ACTIVATE = new Status(AppConstants.STATUS_ID_ACTIVATE, "Activate");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status ACTIVE = new Status(AppConstants.STATUS_ID_ACTIVE, "Active");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status EXPIRED = new Status(AppConstants.STATUS_ID_EXPIRED, "Expired");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status NEW = new Status(AppConstants.STATUS_ID_NEW, "New");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status UPDATED = new Status(AppConstants.STATUS_ID_UPDATED, "Updated");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status LOCK = new Status(AppConstants.STATUS_ID_LOCK, "Lock");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status LOCKED = new Status(AppConstants.STATUS_ID_LOCKED, "Locked");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status UNLOCK = new Status(AppConstants.STATUS_ID_UNLOCK, "Unlock");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status DEACTIVATE = new Status(AppConstants.STATUS_ID_DEACTIVATE, "Deactivate");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status DEACTIVATED = new Status(AppConstants.STATUS_ID_DEACTIVATED, "Deactivated");
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status FAILED = new Status(AppConstants.STATUS_ID_FAILED, AppConstants.STATUS_FAILED);
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status COMPLETED = new Status(AppConstants.STATUS_ID_COMPLETED, AppConstants.STATUS_COMPLETED);
    /**
     * Initializes status with only the {@link #id} and {@link #name}. <br>
     * <b><i>NB</i></b> Entity is not managed
     */
    public static final Status DELETED = new Status(AppConstants.STATUS_ID_DELETED, "Deleted");

    @Id
    @Basic(optional = false)
    @GenericGenerator(
            name = "status_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "status_seq")
                    ,
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0")
                    ,
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "status_seq")
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    @Unique(fieldName = "Status Name")
    @ModifiableField(name = "Status Name")
    private String name;
    @Size(max = 2000)
    @Column(name = "description")
    @ModifiableField
    private String description;
    @Size(max = 3)
    @Column(name = "intrash")
    @JsonIgnore
    private String intrash = AppConstants.NO;
    @Basic(optional = false)
    @Column(name = "creation_date", updatable = false, insertable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Status() {
    }

    public Status(Short id) {
        this.id = id;
    }

    public Status(Short id, String name) {
        this.id = id;
        this.name = name;
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
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntrash() {
        return intrash;
    }

    public void setIntrash(String intrash) {
        this.intrash = intrash;
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Status[ id=" + id + " ]";
    }

}
