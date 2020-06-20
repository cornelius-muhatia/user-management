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
package com.cmuhatia.library.library.usermanagement.resources;

import com.cm.projects.spring.resource.chasis.ChasisResource;
import com.cm.projects.spring.resource.chasis.utils.LoggerService;
import com.cm.projects.spring.resource.chasis.wrappers.ActionWrapper;
import com.cm.projects.spring.resource.chasis.wrappers.ResponseWrapper;
import com.cmuhatia.library.library.usermanagement.entities.Status;
import com.cmuhatia.library.library.usermanagement.entities.TempEditedRecord;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author Cornelius M.
 * @version 1.0.0, 20/06/2020
 */
@RestController
@RequestMapping("/status")
@ApiOperation(value = "Status Resource", notes = "Used to manage entity statuses")
public class StatusResource extends ChasisResource<Status, Short, TempEditedRecord> {

    public StatusResource(LoggerService loggerService, EntityManager entityManager) {
        super(loggerService, entityManager);
    }

    @Override
    @ApiIgnore
    public ResponseEntity<ResponseWrapper<List<String>>> approveActions(@Valid ActionWrapper<Short> actions) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported on this resource");
    }

    @Override
    @ApiIgnore
    public ResponseEntity<ResponseWrapper> declineActions(@Valid ActionWrapper<Short> actions) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException("Not supported on this resource");
    }

    @Override
    @ApiIgnore
    public ResponseEntity<ResponseWrapper<List<String>>> deactivateRecord(@Valid ActionWrapper<Short> actions) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported on this resource");
    }

    @Override
    @ApiIgnore
    public ResponseEntity<ResponseWrapper<List<String>>> activateRecord(@Valid ActionWrapper<Short> actions) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported on this resource");
    }

    @Override
    @ApiIgnore
    public ResponseEntity<ResponseWrapper<List<String>>> lockRecord(@Valid ActionWrapper<Short> actions) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported on this resource");
    }

    @Override
    @ApiIgnore
    public ResponseEntity<ResponseWrapper<List<String>>> unLockRecord(@Valid ActionWrapper<Short> actions) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported on this resource");
    }
}
