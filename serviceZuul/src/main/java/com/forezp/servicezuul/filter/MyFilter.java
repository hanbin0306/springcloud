package com.forezp.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/19 11:07
 * @Version 1.0
 **/
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    
    /**
     * @Author hb
     * @Description
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @Date 11:10 2019/3/19
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * @Author hb
     * @Description filterOrder：过滤的顺序
     * @Date 11:11 2019/3/19
     * @Param []
     * @return int
     **/
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * @Author hb
     * @Description shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @Date 11:11 2019/3/19
     * @Param []
     * @return boolean
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * @Author hb
     * @Description 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @Date 11:11 2019/3/19
     * @Param []
     * @return java.lang.Object
     **/
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
