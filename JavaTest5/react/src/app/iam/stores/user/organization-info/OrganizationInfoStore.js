import { action, computed, observable } from 'mobx';
import { axios, store } from '@choerodon/boot';
import queryString from 'query-string';

@store('OrganizationInfoStore')
class OrganizationInfoStore {
  @observable myOrganizationData = [];
  @observable organizationRolesData = [];
  @observable loading = false;
  @observable sidebarVisible = false;
  @observable pagination = {
    current: 1,
    pageSize: 10,
    total: 0,
  };
  @observable params = [];
  @observable showSize = 10;

  refresh(id) {
    this.loadData(id, { current: 1, pageSize: 10 }, []);
  }

  @action
  setShowSize(size) {
    this.showSize = size;
  }

  @action
  showSideBar() {
    this.sidebarVisible = true;
  }

  @action
  hideSideBar() {
    this.sidebarVisible = false;
  }

  @action
  loadMyOrganizations() {
    this.loading = true;
    return axios.get(`/iam/v1/users/self/organizations/paging_query?${queryString.stringify({
      page: 1,
      size: 20,
      enabled: true,
    })}`).then(action((result) => {
      const { failed, list } = result;
      if (!failed) {
        this.myOrganizationData = list || result;
      }
      this.loading = false;
    }))
      .catch(action((error) => {
        Choerodon.handleResponseError(error);
        this.loading = false;
      }));
  }

  @action
  loadData(id, pagination = this.pagination, params = this.params) {
    this.loading = true;
    this.params = params;
    return axios.get(`/iam/v1/users/${id}/organization_roles?${queryString.stringify({
      page: pagination.current,
      size: pagination.pageSize,
      params: params.join(','),
    })}`)
      .then(action(({ failed, list, total }) => {
        if (!failed) {
          this.organizationRolesData = list;
          this.pagination = {
            ...pagination,
            total,
          };
        }
        this.loading = false;
      }))
      .catch(action((error) => {
        Choerodon.handleResponseError(error);
        this.loading = false;
      }));
  }
}

const organizationInfoStore = new OrganizationInfoStore();
export default organizationInfoStore;
