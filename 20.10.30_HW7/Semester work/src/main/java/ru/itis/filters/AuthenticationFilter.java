package ru.itis.filters;

import ru.itis.services.UsersService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // преобразуем запросы к нужному виду
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        Boolean isAuthenticated = false;
        Boolean sessionExists = session != null;
        Boolean isLoginPage = request.getRequestURI().equals("/signIn");
        Boolean isRegisterPage = request.getRequestURI().equals("/signUp");

        if (sessionExists) {
            isAuthenticated = (Boolean) session.getAttribute("authenticated");

            if (isAuthenticated == null) {
                isAuthenticated = false;
            }
        }

        // если авторизован и запрашивает не логин или если не авторизован и запрашивает логин
        if (isAuthenticated && (!isLoginPage || !isRegisterPage) || !isAuthenticated && (isLoginPage || isRegisterPage)) {
            // отдаем ему то, что он хочет
            filterChain.doFilter(request, response);
        } else if (isAuthenticated && (isLoginPage || isRegisterPage)) {
            // пользователь аутенцифицирован и запрашивает страницу входа или регистрации
            // - отдаем ему корень
            response.sendRedirect("/");
        } else {
            // если пользователь не аутенцицицирован и запрашивает другие страницы
            response.sendRedirect("/signIn");
        }

    }

    @Override
    public void destroy() {

    }
}
