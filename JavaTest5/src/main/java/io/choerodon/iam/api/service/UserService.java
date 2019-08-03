package io.choerodon.iam.api.service;

import io.choerodon.iam.infra.dto.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDTO queryByid(long id);
    void insertUser(UserDTO userDTO);
}
