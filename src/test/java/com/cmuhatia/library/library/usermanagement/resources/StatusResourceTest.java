/*
 * Copyright 2019 Cornelius M.
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

import com.cm.projects.spring.resource.chasis.wrappers.ActionWrapper;
import com.cm.projects.spring.resource.chasis.wrappers.ResponseWrapper;
import com.cmuhatia.library.library.usermanagement.entities.CustomPageImpl;
import com.cmuhatia.library.library.usermanagement.entities.Status;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cornelius M.
 * @version 1.0.0, 20/06/2020
 */
public class StatusResourceTest {

    /**
     * Rest test client
     */
    private final WebTestClient webClient;

    /**
     * Default constructor
     *
     * @param webClient {@link WebTestClient}
     */
    public StatusResourceTest(WebTestClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Handles all test cases:
     * <ul>
     *     <li>Creation {@link #testCreation()}</li>
     *     <li>Update {@link #testUpdate(Short)}</li>
     *     <li>Deletion {@link #testDeletion(Short)}</li>
     *     <li>Fetch {@link #testFetch()}</li>
     * </ul>
     */
    public void statusTests(){
        Short id = this.testCreation();
        this.testUpdate(id);
        this.testFetch();
        this.testDeletion(id);
    }

    /**
     * Handles create status request
     *
     * @param payload Request payload
     * @return {@link org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec}
     */
    private WebTestClient.ResponseSpec createStatus(Status payload){
        return this.webClient.post().uri("/status")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(payload), Status.class)
                .exchange();
    }

    /**
     * Status creation unit tests. Test cases include:
     * <ul>
     *     <li>Successful request</li>
     *     <li>Validation</li>
     *     <li>Conflict</li>
     * </ul>
     * @return status id
     */
    private Short testCreation(){
        Status status = new Status();
        //validation request tests
        this.createStatus(status).expectStatus().isBadRequest();
        //Success tests
        status.setDescription("Status description");
        status.setName("Junit Status");
        ResponseWrapper<Short> response = this.createStatus(status).expectStatus().isCreated().returnResult(
                new ParameterizedTypeReference<ResponseWrapper<Short>>() {
                }).getResponseBody().blockFirst();
        //Fields integrity
        Status newStatus = Objects.requireNonNull(this.getStatus(Objects.requireNonNull(response).getData()).expectStatus().isOk().returnResult(
                new ParameterizedTypeReference<ResponseWrapper<Status>>() {
                }).getResponseBody().blockFirst()).getData();
        assertEquals(status.getDescription(), newStatus.getDescription());
        assertEquals(status.getName(), newStatus.getName());
        assertNotNull(newStatus.getCreationDate());
        //Conflict status
        this.createStatus(status).expectStatus().isEqualTo(HttpStatus.CONFLICT);

        return response.getData();

    }

    /**
     * Fetch status using status id
     *
     * @param id status id
     * @return {@link WebTestClient.ResponseSpec}
     */
    private WebTestClient.ResponseSpec getStatus(Short id){
        return this.webClient.get().uri("/status/" + id)
                .exchange();
    }

    /**
     * Handles update status request
     *
     * @param payload Request payload
     * @return {@link org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec}
     */
    private WebTestClient.ResponseSpec updateStatus(Status payload){
        return this.webClient.put().uri("/status")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(payload), Status.class)
                .exchange();
    }

    /**
     * Status update tests. Unit tests:
     * <ul>
     *     <li>Bad request</li>
     *     <li>Conflict request</li>
     *     <li>Success request</li>
     *     <li>Field integrity tests</li>
     * </ul>
     * @param id status id
     */
    private void testUpdate(Short id){
        Status status = new Status(id);
        this.updateStatus(status).expectStatus().isBadRequest();
        //Test conflict request
        Status status2 = new Status();
        status2.setName("Junit Test2");
        status2.setDescription("Test description2");
        this.createStatus(status2).expectStatus().isCreated();
        status.setName(status2.getName());
        this.updateStatus(status).expectStatus().isEqualTo(HttpStatus.CONFLICT);
        //Success request test
        status.setName("Status Update");
        status.setDescription("Test description");
        this.updateStatus(status).expectStatus().isOk();
        //Test entity integrity
        Status updateStatus = Objects.requireNonNull(this.getStatus(id).expectStatus().isOk().returnResult(
                new ParameterizedTypeReference<ResponseWrapper<Status>>() {
                }).getResponseBody().blockFirst()).getData();
        assertEquals(status.getDescription(), updateStatus.getDescription());
        assertEquals(status.getName(), updateStatus.getName());
    }

    /**
     * Fetch statuses
     *
     * @return {@link WebTestClient.ResponseSpec}
     */
    private WebTestClient.ResponseSpec getStatuses(){
        return this.webClient.get().uri("/status")
                .exchange();
    }

    /**
     * Test fetch status. Test cases include:
     * <ul>
     *     <li>Successful request</li>
     * </ul>
     */
    private void testFetch(){
        ResponseWrapper<CustomPageImpl<Status>> response = this.getStatuses().expectStatus().isOk().returnResult(new ParameterizedTypeReference<ResponseWrapper<CustomPageImpl<Status>>>() {
        }).getResponseBody().blockFirst();

        assertTrue(Objects.requireNonNull(response).getData().getTotalElements() > 0);
    }

    /**
     * Handles update status request
     *
     * @param payload {@link ActionWrapper}
     * @return {@link org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec}
     */
    private WebTestClient.ResponseSpec deleteStatus(ActionWrapper<Short> payload){
        return this.webClient.method(HttpMethod.DELETE).uri("/status")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(payload), new ParameterizedTypeReference<>() {
                })
                .exchange();
    }

    /**
     * Status deletion tests. Test cases include:
     * <ul>
     *     <li>Bad request</li>
     *     <li>Success request</li>
     * </ul>
     * @param id status id
     */
    public void testDeletion(Short id){
        ActionWrapper<Short> payload = new ActionWrapper<>();
        //Test validation request
        this.deleteStatus(payload).expectStatus().isBadRequest();
        payload.setIds(new Short[]{Short.MAX_VALUE});
        payload.setNotes("Junit deletion test");
        this.deleteStatus(payload).expectStatus().isEqualTo(HttpStatus.MULTI_STATUS);
        payload.setIds(new Short[]{id});
        payload.setNotes(null);
        this.deleteStatus(payload).expectStatus().isBadRequest();
        //Test success request
        payload.setNotes("Junit deletion test");
        this.deleteStatus(payload).expectStatus().isOk();
        //Integrity field status
        Status updateStatus = Objects.requireNonNull(this.getStatus(id).expectStatus().isOk().returnResult(
                new ParameterizedTypeReference<ResponseWrapper<Status>>() {
                }).getResponseBody().blockFirst()).getData();
        assertNull(updateStatus);
    }


}
