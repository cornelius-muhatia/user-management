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
//@Configuration
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
        statusRepository.saveAll(List.of(Status.ACTIVE, Status.COMPLETED, Status.FAILED, Status.EXPIRED, Status.LOCKED));
    }
}
