package be.kdg.teamf.controller;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 13/03/13
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 */
public class ErrorLogController extends AbstractHandlerExceptionResolver {
    private static final Logger logger = Logger.getLogger(ErrorLogController.class);
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.warn("uncaught exception in controllers/handlers", ex);
        return null;
    }
}
