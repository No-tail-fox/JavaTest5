package io.choerodon.iam.api.controller.v1;

import com.github.pagehelper.PageHelper;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.iam.api.service.OrganService;
import io.choerodon.iam.api.service.UserService;
import io.choerodon.iam.infra.dto.OrganizationDTO;
import io.choerodon.iam.infra.dto.ProjectDTO;
import io.choerodon.iam.infra.feign.UserFeignClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/v1/organ")
public class OrganController {
    @Autowired
    private OrganService organService;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/queryinsertorgan")
    @Permission(permissionPublic=true,type = ResourceType.SITE)
    @ApiOperation(value = "查询插入的组织信息")
    private ResponseEntity<OrganizationDTO> queryinsertbyId(@RequestParam Long orgId) {
        System.out.println("正在获取组织插入信息");
        OrganizationDTO organizationDTO=organService.queryByid(orgId);
        //return new ResponseEntity<>(result, HttpStatus.OK);
        System.out.println("获取到组织插入信息"+organizationDTO.toString());
        return new ResponseEntity<>(organizationDTO,HttpStatus.OK);
    }

    @GetMapping("/queryproject")
    @Permission(permissionPublic=true,type = ResourceType.SITE)
    @ApiOperation(value = "分页查询项目")
    private ResponseEntity queryOrganbyId(@RequestParam int page,@RequestParam int pagesize) {
        PageHelper.startPage(page,pagesize);
        System.out.println("正在获取项目分页信息");
        ArrayList<ProjectDTO> list=organService.queryProject(page,pagesize);
        //return new ResponseEntity<>(result, HttpStatus.OK);
        System.out.println("获取到项目分页信息 大小为 "+list.size());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/queryorgbyid")
    @Permission(permissionPublic=true)
    @ApiOperation(value = "查询组织Id为1的组织详情")
    private ResponseEntity queryOrgbyId(@RequestParam Long orgId) throws IOException {
        System.out.println("正在获取组织信息");
        OrganizationDTO organizationDTO=userFeignClient.organQueryById(orgId);
        organService.insertOrgan(organizationDTO);
        ArrayList<ProjectDTO> list=organizationDTO.getProjects();
        organService.insertProject(list);
        System.out.println("获取到组织信息 : "+organizationDTO.toString());
        return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }
}
