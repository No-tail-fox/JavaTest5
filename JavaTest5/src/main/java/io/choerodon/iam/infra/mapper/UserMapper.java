package io.choerodon.iam.infra.mapper;

import io.choerodon.mybatis.common.Mapper;
import io.choerodon.iam.infra.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper{
    UserDTO queryById(Long id);
    int insertUser(UserDTO userDTO);
}