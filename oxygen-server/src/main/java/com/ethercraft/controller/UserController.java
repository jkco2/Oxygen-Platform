package com.ethercraft.controller;

import com.ethercraft.dto.UserCreateDTO;
import com.ethercraft.result.Result;
import com.ethercraft.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户管理")
@Slf4j
@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "创建用户")
    @PostMapping
    public Result<Void> createUser(@RequestBody UserCreateDTO userCreateDTO) {

        userService.createUser(userCreateDTO);

        return Result.success();
    }

}
