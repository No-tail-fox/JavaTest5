package io.choerodon.iam.api.service.impl;

import io.choerodon.iam.api.service.UserService;
import io.choerodon.iam.infra.dto.UserDTO;
import io.choerodon.iam.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServcieImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDTO queryByid(long id) {
        UserDTO userDto=userMapper.queryById(id);
        return userDto;
    }

    @Override
    public void insertUser(UserDTO userDTO) {
        userMapper.insertUser(userDTO);
    }
}
