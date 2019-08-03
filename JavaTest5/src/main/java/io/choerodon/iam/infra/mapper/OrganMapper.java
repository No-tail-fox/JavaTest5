package io.choerodon.iam.infra.mapper;

import io.choerodon.iam.infra.dto.OrganizationDTO;
import io.choerodon.iam.infra.dto.ProjectDTO;
import io.choerodon.iam.infra.dto.UserDTO;
import io.choerodon.mybatis.common.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface OrganMapper  {
    OrganizationDTO queryById(Long id);
    int insertOrgan(OrganizationDTO OrganizationDTO);
    ArrayList<ProjectDTO> queryProject();
    void insertProject(ArrayList<ProjectDTO> list);
}