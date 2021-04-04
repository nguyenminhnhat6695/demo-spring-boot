package com.laptrinhjavaweb.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/admin/*", "/decorators/admin.jsp")
				.addDecoratorPath("/user/*", "/decorators/web.jsp")
				.addDecoratorPath("/login", "/decorators/login.jsp");
				//.addExcludedPath("/access-denied");
	}
}
