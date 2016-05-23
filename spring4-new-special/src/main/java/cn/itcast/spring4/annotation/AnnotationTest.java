package cn.itcast.spring4.annotation;

import java.lang.annotation.Annotation;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

import cn.itcast.spring4.generic.ABService;

public class AnnotationTest {

	@Test
	public void getAnnoAnno() {
		// 获取注解的注解
		Annotation service = AnnotationUtils.findAnnotation(ABService.class, org.springframework.stereotype.Service.class);
		Annotation component = AnnotationUtils.getAnnotation(service, org.springframework.stereotype.Component.class);
		System.out.println(component.annotationType());
	}
	
	/**
	 * @Length.List(
        value = {
                @Length(min = 1, max = 2, groups = A.class),
                @Length(min = 3, max = 4, groups = B.class)
        		}
		)
		public void test() {}
		
		可以通过如下方式获取@Length：
		Method method = ClassUtils.getMethod(AnnotationTest.class, "test");
		Set<Length> set = AnnotationUtils.getRepeatableAnnotation(method, Length.List.class, Length.class);
	 */
}
