package io.choerodon.iam.api.service;

import io.choerodon.iam.infra.dto.OrganizationDTO;
import io.choerodon.iam.infra.dto.ProjectDTO;
import io.choerodon.iam.infra.dto.UserDTO;

import java.util.ArrayList;

public interface OrganService {
    OrganizationDTO queryByid(long id);
    void insertOrgan(OrganizationDTO organizationDTO);
    ArrayList<ProjectDTO> queryProject(int page,int pagesize);
    void insertProject(ArrayList<ProjectDTO> list);
}