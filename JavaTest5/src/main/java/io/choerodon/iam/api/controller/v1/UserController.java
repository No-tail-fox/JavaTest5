package io.choerodon.iam.api.controller.v1;

//省略 import
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import io.choerodon.iam.api.service.OrganService;
import io.choerodon.iam.api.service.UserService;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.iam.api.service.impl.UserServcieImpl;
import io.choerodon.iam.infra.dto.OrganizationDTO;
import io.choerodon.iam.infra.dto.ProjectDTO;
import io.choerodon.iam.infra.dto.UserDTO;
import io.choerodon.iam.infra.feign.UserFeignClient;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrganService organService;
    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/queryuserbyid")
    @Permission(type = ResourceType.SITE,permissionPublic=true)
    @ApiOperation(value = "查询用户Id为1的用户")
    private ResponseEntity queryUserbyId(@RequestParam Long orgId,@RequestParam Long userId) throws IOException {
        System.out.println("正在获取用户信息 "+ orgId+"  "+userId);
        UserDTO userDTO=userFeignClient.userQueryById(orgId,userId);
        userService.insertUser(userDTO);
        System.out.println("获取到用户信息"+userDTO.toString());
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping("/queryinsertuser")
    @Permission(type = ResourceType.SITE,permissionPublic=true)
    @ApiOperation(value = "查询插入的用户信息")
    private ResponseEntity<UserDTO> queryUserbyId(@RequestParam Long userId) {
        System.out.println("正在获取用户插入信息");
        UserDTO userDTO=userService.queryByid(userId);
        //return new ResponseEntity<>(result, HttpStatus.OK);
        System.out.println("获取到用户插入信息"+userDTO.toString());
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

}