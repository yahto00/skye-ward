package com.hydra.skye.ward.framework.handler;

import com.alibaba.fastjson.JSON;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.model.result.FailResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yahto on 01/12/2017
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOGGER.error("", ex);
        ModelAndView mv = null;
        PrintWriter writer = null;
        if (request.getRequestURI().startsWith("/certificate-center/index")) {
            mv = new ModelAndView("error");
        } else if (request.getRequestURI().endsWith(".ajax")) {
            try {
                writer = response.getWriter();
                response.setContentType("text/html;charset=UTF-8");
                if (ex instanceof BusinessException) {
                    writer.print(JSON.toJSONString(new FailResult(ex.getMessage())));
                } else {
                    writer.print(JSON.toJSONString(new FailResult("未知错误")));
                }
                writer.flush();
            } catch (IOException e) {
                LOGGER.error("", e);
            } finally {
                if (writer != null) {
                    writer.close();
                    writer = null;
                }
            }
        }
        return mv;
    }
}
