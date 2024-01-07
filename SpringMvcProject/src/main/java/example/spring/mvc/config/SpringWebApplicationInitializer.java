package example.spring.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringWebApplicationInitializer implements WebApplicationInitializer {
	
	private WebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setConfigLocation("example"); // This is equivalant to @ComponentScan
		return ctx;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
//		This method is invoked when app is loaded
		WebApplicationContext webctx = getContext();
//		Instantiting DispatcherServlet based upon WebApplicationContext: webctx
		DispatcherServlet frontControllerServlet = new DispatcherServlet(webctx);
//		 Registering the DispatcherServlet using ServletContext: servletContext
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("frontController", frontControllerServlet );
//		Configuring frontController in such a way that it accept all incoming request
		dispatcher.addMapping("/");
		

	}

}
