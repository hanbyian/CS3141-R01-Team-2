package com.example.CS3141R01Team2.Security.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MySimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request,
                        HttpServletResponse response,
                        Authentication authentication)
    throws IOException{
        String targetURL = determineTargetURL(authentication);

        if (response.isCommitted()){
            logger.debug(
                    "Response has already been committed. Unable to redirect to: "
                    + targetURL
            );
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetURL);

    }

    protected String determineTargetURL(final Authentication authentication){
        Map<String, String> roleTargetURLMap = new HashMap<>();
        roleTargetURLMap.put("USER", "/users/showusers");
        roleTargetURLMap.put("ADMIN", "/studyset/showstudyset");

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(final GrantedAuthority grantedAuthority : authorities){
            String authorityName = grantedAuthority.getAuthority();
            if(roleTargetURLMap.containsKey(authorityName)){
                return roleTargetURLMap.get(authorityName);
            }
        }

        throw new IllegalStateException();
    }
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

    }
}
