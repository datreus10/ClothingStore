package net.dat.store.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)
	public ModelAndView handlleUnauthorizedEx(HttpServletRequest req, Exception ex) {
		ModelAndView view = new ModelAndView();
		view.addObject("msg", ex.getMessage());
		view.setViewName("login");
		view.setStatus(HttpStatus.UNAUTHORIZED);
		return view;
	}
}
