package io.choerodon.iam;

import io.choerodon.base.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients("io.choerodon")
@EnableEurekaClient
@SpringBootApplication
@EnableChoerodonResourceServer
//@RestController
public class IAMServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IAMServiceApplication.class, args);
        
    }
}
