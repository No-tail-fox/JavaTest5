package io.choerodon.iam.infra.feign;

import io.choerodon.iam.infra.dto.OrganizationDTO;
import io.choerodon.iam.infra.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author dengyouquan
 **/
@FeignClient(value = "iam-service")
@Component
public interface UserFeignClient {
    @GetMapping("/v1/organizations/{organization_id}")
    OrganizationDTO organQueryById(@PathVariable("organization_id") long orgId);

    @GetMapping("/v1/organizations/{organization_id}/users/{id}")
    UserDTO userQueryById(@PathVariable("organization_id") long orgId, @PathVariable("id") long userId);
}
