//package io.choerodon.iam.infra.config;
//
//
//import feign.RequestInterceptor;
//import feign.codec.Encoder;
//import io.choerodon.iam.infra.utils.FeignBasicAuthRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Feign配置注册（全局）
// *
// * @author simon
// * @create 2018-08-20 11:44
// **/
//@Configuration
//public class FeignSupportConfig {
//    /**
//     * feign请求拦截器
//     *
//     * @return
//     */
//    @Bean
//    public RequestInterceptor requestInterceptor(){
//        return new FeignBasicAuthRequestInterceptor();
//    }
//}