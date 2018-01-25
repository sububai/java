package com.myapp.config;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import com.myapp.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/custom/**");
/*		Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/custom/**");*/
	}

}
