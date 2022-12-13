package com.noir.webthingcontrol;

import com.noir.webthingcontrol.filters.ControlFilter;
import com.noir.webthingcontrol.services.GwService;
import com.noir.webthingcontrol.utils.ObjConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebthingcontrolApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(WebthingcontrolApplication.class, args);

		GwService gwService = context.getBean(GwService.class);

		gwService.init(
				ObjConstants.thingRfId, ObjConstants.getGW().getName(), ObjConstants.getGW().getHost(),
				ObjConstants.getGW().getApiLink(), ObjConstants.getGW().getGatewayId());

	}

	@Bean
	public FilterRegistrationBean<ControlFilter> ControlRegistrationBean() {
		FilterRegistrationBean<ControlFilter> registrationBean = new FilterRegistrationBean<>();
		ControlFilter controlFilter = new ControlFilter();
		registrationBean.setFilter(controlFilter);
		registrationBean.addUrlPatterns("/api/control-1/*");
		return registrationBean;
	}

}
