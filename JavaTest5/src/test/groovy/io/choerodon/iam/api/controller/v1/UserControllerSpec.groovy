package io.choerodon.iam.api.controller.v1

import io.choerodon.core.domain.Page
import io.choerodon.core.exception.ExceptionResponse
import io.choerodon.iam.infra.dto.UserDTO
import io.choerodon.iam.infra.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.multipart.MultipartFile
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

/**
 * @author dengyouquan
 * */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Stepwise
class TaskControllerTest extends Specification {
    private static final String BASE_PATH = "/v1/tasks"
    @Autowired
    private TestRestTemplate restTemplate
    @Autowired
    private UserMapper userMapper
    @Shared
    def needInit = true
    @Shared
    def needClean = false

    def setup() {

    }

    def cleanup() {

    }


}
