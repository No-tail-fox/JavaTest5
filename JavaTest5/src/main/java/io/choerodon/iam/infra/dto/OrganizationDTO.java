package io.choerodon.iam.infra.dto;

import io.choerodon.mybatis.entity.BaseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;


public class OrganizationDTO extends BaseDTO {
    private int ID;
    private String name;
    private String code;
    private String address;
    private String ownerLoginName;
    private String ownerRealName;
    private String ownerEmail;
    private ArrayList<ProjectDTO> projects=null;

    public ArrayList<ProjectDTO> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", ownerLoginName='" + ownerLoginName + '\'' +
                ", ownerRealName='" + ownerRealName + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", innerMap=" + innerMap +
                '}';
    }

    public void setProjectList(ArrayList<ProjectDTO> projects) {
        this.projects = projects;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerLoginName() {
        return ownerLoginName;
    }

    public void setOwnerLoginName(String ownerLoginName) {
        this.ownerLoginName = ownerLoginName;
    }

    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

}
