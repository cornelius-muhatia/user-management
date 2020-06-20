/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmuhatia.library.library.usermanagement.config;

import com.cm.projects.spring.resource.chasis.utils.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author cornelius
 */
@Service
public class LoggerServiceTemplate extends LoggerService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional
    public void log(String description, String entity, Object entityId, String activity, Short activityStatus, String notes) {

        this.log(description, entity, entityId, activity, activityStatus, notes, null);

    }

    @Override
    public boolean isInitiator(String Entity, Object entityId, Short statusId) {
        return false;
    }

    public void log(String description, String entity, Object entityId, String activity, Short activityStatus, String notes, @Nullable Long userId) {
        log.info("\n=========================> LOGGER SERVICE <==============================\n" +
                        "Description: {}\n" +
                        "Entity: {}\n" +
                        "Entity ID: {}\n" +
                        "Activity: {}\n" +
                        "Activity status: {}\n" +
                        "Notes: {}\n" +
                        "User: {}\n",
                description, entity, entityId, activity, activityStatus, notes, userId);

    }

    @Override
    public void logAuthentication(String description, String entity, Object entityId, Short activityStatus) {
        this.log(description, entity, entityId, "Authentication", activityStatus, "", (Long) entityId);
    }

}
