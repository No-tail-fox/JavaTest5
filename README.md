# JavaTest5
## 项目包含两个部分，分为Javatest5文件和apigateway文件，Javatest5是所写的服务，apigateway是本地的网关，运行时需要同时运行apigateway和javatest5两个程序，然后运行javatest5目录下的curl.sh脚本可以进行访问测试，
```
http://localhost:8080/study/v1/organ/queryorgbyid?orgId=1  查询组织信息并且插入
http://localhost:8080/study/v1/organ/queryinsertorgan?orgId=1   查询插入的组织信息
http://localhost:8080/study/v1/organ/queryproject?page=1\&pagesize=5  分页查询
http://localhost:8080/study/v1/users/queryuserbyid?orgId=1\&userId=1  查询用户信息并插入
http://localhost:8080/study/v1/users/queryuserbyid?orgId=1\&userId=1  查询插入的用户信息
```
## 程序运行的时候是基于本地的数据库，因此最开始需要初始化数据库，即修改javatest5目录下的init_mysql_databases.sh脚本中的数据库配置信息，以及javatest5中的application的数据库配置信息
## 因为远程的服务器刷新不了数据库，因此这里·访问的地址是本地网关地址，可在服务器尝试下面这种方式访问
```
TOKEN=$(curl 'http://api.dev.devopseasy.com/oauth/oauth/token?client_id=client&client_secret=secret&grant_type=password&password=YWRtaW4%3D&username=admin' -X POST -H 'Accept: application/json, text/plain, */*'|awk -F '"' '{print $4}')
echo $TOKEN
curl 'http://apigateway.address/choerodon-study-service-25236-wkj/api' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"

```
