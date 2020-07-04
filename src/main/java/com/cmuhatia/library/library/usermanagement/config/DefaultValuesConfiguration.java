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
package com.cmuhatia.library.library.usermanagement.config;

import com.cmuhatia.library.library.usermanagement.entities.Status;
import com.cmuhatia.library.library.usermanagement.repository.StatusRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Cornelius M.
 * @version 1.0.0, 20/06/2020
 */
@Configuration
public class DefaultValuesConfiguration {

    /**
     * Default constructor
     *
     * @param statusRepository {@link StatusRepository} bean
     */
    public DefaultValuesConfiguration(StatusRepository statusRepository){
        this.createDefaultStatuses(statusRepository);
    }

    /**
     * Create default statuses:
     * <ul>
     *     <li>Active Status</li>
     *     <li>Completed Status</li>
     *     <li>Failed Status</li>
     *     <li>Expired Status</li>
     *     <li>Locked Status</li>
     * </ul>
     *
     * @param statusRepository {@link StatusRepository} bean
     */
    public void createDefaultStatuses(StatusRepository statusRepository){
        if(statusRepository.findById(Status.NEW.getId()).isEmpty()){
            statusRepository.save(Status.NEW);
        }
        if(statusRepository.findById(Status.ACTIVE.getId()).isEmpty()){
            statusRepository.save(Status.ACTIVE);
        }
        if(statusRepository.findById(Status.UPDATED.getId()).isEmpty()){
            statusRepository.save(Status.UPDATED);
        }
        if(statusRepository.findById(Status.DEACTIVATE.getId()).isEmpty()){
            statusRepository.save(Status.DEACTIVATE);
        }
        if(statusRepository.findById(Status.DEACTIVATED.getId()).isEmpty()){
            statusRepository.save(Status.DEACTIVATED);
        }
        if(statusRepository.findById(Status.ACTIVATE.getId()).isEmpty()){
            statusRepository.save(Status.ACTIVATE);
        }
        if(statusRepository.findById(Status.LOCK.getId()).isEmpty()){
            statusRepository.save(Status.LOCK);
        }
        if(statusRepository.findById(Status.LOCKED.getId()).isEmpty()){
            statusRepository.save(Status.LOCKED);
        }
        if(statusRepository.findById(Status.UNLOCK.getId()).isEmpty()){
            statusRepository.save(Status.UNLOCK);
        }
        if(statusRepository.findById(Status.DELETED.getId()).isEmpty()){
            statusRepository.save(Status.DELETED);
        }
        if(statusRepository.findById(Status.COMPLETED.getId()).isEmpty()){
            statusRepository.save(Status.COMPLETED);
        }
        if(statusRepository.findById(Status.FAILED.getId()).isEmpty()){
            statusRepository.save(Status.FAILED);
        }
        if(statusRepository.findById(Status.EXPIRED.getId()).isEmpty()){
            statusRepository.save(Status.EXPIRED);
        }
    }
}
