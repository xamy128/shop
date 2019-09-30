package com.sample.shop.common.controller;

import com.sample.shop.common.service.CoreService;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/*
 * An abstract Rest Controller for providing CRUD methods.
 *
 * @author Ammarah Shakeel
 */
@Component
@NoArgsConstructor
public abstract class RestfulController<TEnt, TKey, TRep extends JpaRepository<TEnt, TKey>> {
    private CoreService<TEnt, TKey, TRep> service;
    private RestResponse<TEnt> restResponse;

    public RestfulController(CoreService<TEnt, TKey, TRep> coreService, RestResponse<TEnt> restResponse) {
        this.service = coreService;
        this.restResponse = restResponse;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody TEnt entity)
    {
        Response response = restResponse.createSuccessful(service.create(entity));
        return new ResponseEntity<>(response, response.getStatus());
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable TKey key, @RequestBody TEnt entity)
    {
        Response response = restResponse.updateSuccessful(service.update(key, entity));
        return new ResponseEntity<>(response, response.getStatus());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable TKey key) {
        service.delete(key);
        Response response = restResponse.deleteSuccessful();
        return new ResponseEntity<>(response, response.getStatus());
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll()
    {
        service.deleteAll();
        Response response =  restResponse.deleteSuccessful();
        return  new ResponseEntity<>(response, response.getStatus());
    }
}
