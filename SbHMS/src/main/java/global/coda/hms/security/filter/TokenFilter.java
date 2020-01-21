package global.coda.hms.security.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@ Component
@ Order(1)
public class TokenFilter implements Filter {
  Logger LOGGER = LogManager.getLogger(TokenFilter.class);
  UUID requestId = UUID.randomUUID();

  @ Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    LOGGER.info("Filter Class Reached " + requestId);
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    httpRequest.setAttribute("RequestId", requestId);
    // request.setAttribute("RequestId", requestId);
    chain.doFilter(request, response);
  }

  // other methods
}
