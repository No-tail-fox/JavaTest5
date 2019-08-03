package io.choerodon.iam.api.service.impl;

import io.choerodon.iam.api.service.OrganService;
import io.choerodon.iam.infra.dto.OrganizationDTO;
import io.choerodon.iam.infra.dto.ProjectDTO;
import io.choerodon.iam.infra.dto.UserDTO;
import io.choerodon.iam.infra.mapper.OrganMapper;
import io.choerodon.iam.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("organServiceImpl")
public class OrganServiceImpl implements OrganService {
    @Autowired
    OrganMapper organMapper;
    @Override
    public OrganizationDTO queryByid(long id) {
        OrganizationDTO organizationDTO=organMapper.queryById(id);
        return organizationDTO;
    }

    @Override
    public void insertOrgan(OrganizationDTO organizationDTO) {
        organMapper.insertOrgan(organizationDTO);
    }

    @Override
    public ArrayList<ProjectDTO> queryProject(int page, int pagesize) {
        ArrayList list=organMapper.queryProject();
        return list;
    }

    @Override
    public void insertProject(ArrayList<ProjectDTO> list) {
        organMapper.insertProject(list);
    }


}
