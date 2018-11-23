package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ContInterceptor implements HandlerInterceptor {
	private Logger logger = Logger.getLogger(ContInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("进入拦截器afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("进入拦截器postHandle");
		logger.info(arg0.getRequestURI());
		logger.info(arg2.toString());//请求的方法，具体到类路径
		/*for (String key : arg3.getModel().keySet()) {
			logger.info(key+"----"+arg3.getModel().get(key));
		}*/
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		logger.info("进入预处理拦截器preHandle");
		return true;
	}

}
