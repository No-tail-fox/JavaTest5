package io.choerodon.iam.infra.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class ProjectDTO {
    private static final String CODE_REGULAR_EXPRESSION =
            "^[a-z](([a-z0-9]|-(?!-))*[a-z0-9])*$";

    public static final String PROJECT_NAME_REG = "^[-—\\.\\w\\s\\u4e00-\\u9fa5]{1,32}$";
    private Long id;
    private String name;
    private String code;
    private Long organizationId;
    private String imageUrl;
    private Boolean enabled;
    private String type;
    private String category;
    private List<ProjectDTO> projects;
    private String typeName;
    private String organizationName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", organizationId=" + organizationId +
                ", imageUrl='" + imageUrl + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", projects=" + projects +
                ", typeName='" + typeName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
