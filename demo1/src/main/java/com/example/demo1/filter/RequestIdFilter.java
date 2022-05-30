package com.example.demo1.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Order(30)
@Component
@WebFilter(urlPatterns = "/*", description = "Set request id in MDC")
public class RequestIdFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
// Nothing to do
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String requestId = ((HttpServletRequest) request).getHeader("Request-Id");
		if (ObjectUtils.isEmpty(requestId)) {
			requestId = UUID.randomUUID().toString();
			log.warn("Request Id not passed. {} is generating requestId {}", RequestIdFilter.class.getSimpleName(),
					requestId);
		}

		MDC.put("requestId", requestId);

		try {
			chain.doFilter(request, response);
		} finally {
			MDC.remove("requestId");
		}
	}

	@Override
	public void destroy() {
// Nothing to do
	}

}