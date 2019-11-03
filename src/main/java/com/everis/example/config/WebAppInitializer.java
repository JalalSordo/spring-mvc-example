package com.everis.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ControllerConfig.class);
		appContext.register(ModelConfig.class);
		appContext.register(ServiceConfig.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));
		
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		ServletRegistration.Dynamic servlet = servletContext
			    .addServlet("h2-console", new WebServlet());
			  servlet.setLoadOnStartup(2);
			  servlet.addMapping("/h2-console/*");

	}
}
