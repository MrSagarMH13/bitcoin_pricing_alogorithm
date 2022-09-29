package com.cyphertek.controller.api.v1;

import com.cyphertek.service.IUserService;
import com.cyphertek.service.dto.ServiceResponse;
import com.cyphertek.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO userDTO) {
        ServiceResponse<UserDTO> serviceResponse = userService.createUser(userDTO);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }

    @DeleteMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceResponse<Void>> deleteUser(@Valid @PathVariable String userId) {
        ServiceResponse<Void> serviceResponse = userService.deleteUser(userId);
        return new ResponseEntity<>(serviceResponse, serviceResponse.getStatusCode());
    }
}
