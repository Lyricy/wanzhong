package controller;
import model.TestMod;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
@ControllerAdvice
public class TestMethod implements ResponseBodyAdvice<Object> {
	private Logger logger = Logger.getLogger(TestMethod.class);
	@Override
	public Object beforeBodyWrite(Object arg0, MethodParameter arg1, MediaType arg2,
			Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse arg5) {
		// TODO Auto-generated method stub
		byte [] t = new byte[1024];
		String tString = "";
		try {
			while (arg4.getBody().read()!=-1) {
				arg4.getBody().read(t);
				
			}
			tString  = new String(t);
			logger.info("请求参数："+tString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("返回的数据："+arg0.toString());
		TestMod testMod = (TestMod) arg0;
		testMod.setId(22222222);
		return testMod;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	



}
