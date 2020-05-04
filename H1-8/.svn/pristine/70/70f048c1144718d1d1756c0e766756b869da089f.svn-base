package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "WordsFilter",urlPatterns = "/*",initParams = { @WebInitParam(name = "CharsetEncoding", value = "utf-8") })
public class WordsFilter implements Filter {
    private static String encoding; // 定义变量接收初始化的值
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 设置字符编码
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //接收注解中的配置参数
        encoding = config.getInitParameter("CharsetEncoding");
        System.out.println(encoding+"过滤器启动");
    }

}
