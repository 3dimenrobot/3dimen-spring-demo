/**
 * @Description: TODO
 * @author zhengangwu
 */

package com.cnbmtech.apiadmin.config;

import cn.hutool.core.date.DateUtil;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwaggerBootstrapUI
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${spring.application.name}")
	private String appname;
	@Value("${termsOfServiceUrl}")
	private String termsOfServiceUrl;
	@Value("${version}")
	private String version;
	@Value("${buildTime}")
	private String buildTime;
	final String serveIp = "localhost";
	final String localhost = "localhost";
	
	@Bean
	public Docket userApi() {
		//.groupName(appname)
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.paths(userPaths()).build().ignoredParameterTypes(ApiIgnore.class).enableUrlTemplating(false);
	}

	Predicate<String> userPaths() {
		return PathSelectors.regex(".*");
	}

	String myAppname() {
       String  buildTimeTmp = DateUtil.offsetHour(DateUtil.parse(buildTime), 8).toString();
        return appname.replaceAll(localhost, serveIp) + " Ver " + version + " Build " + buildTimeTmp;
	}
	
	String myTermsOfServiceUrl() {
		return termsOfServiceUrl.replaceAll(localhost, serveIp);
	}
	
	ApiInfo apiInfo() {
		final String termsOfServiceUrl1 = myTermsOfServiceUrl();
		final String fullappname = myAppname();
		return new ApiInfoBuilder().title(fullappname).description(fullappname).termsOfServiceUrl(termsOfServiceUrl1)
				.version(version).build();
	}
}
