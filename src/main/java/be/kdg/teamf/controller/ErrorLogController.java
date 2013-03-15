package be.kdg.teamf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 13/03/13
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ErrorLogController  {
    private static final Logger log = LoggerFactory.getLogger(ErrorLogController.class);
    @ExceptionHandler(value = Exception.class)
    public void handleExceptions(Exception e) {
        log.error(e.getMessage());
    }
}