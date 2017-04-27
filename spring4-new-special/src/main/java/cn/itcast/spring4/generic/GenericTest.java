package cn.itcast.spring4.generic;

import org.junit.Test;
import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Map;

/**
 *	Java泛型测试API	
 */
public class GenericTest {

	@Test
	public void getTypeGeneric() {
		ResolvableType resolvableType = ResolvableType .forClass(ABService.class) ;
		// 因为我们泛型信息放在 Service<A, B> 上，所以需要resolvableType1.getInterfaces()[0]得到
		// 通过getGeneric（泛型参数索引）得到某个位置的泛型；resolve()把实际泛型参数解析出来
		System.out.println(resolvableType.getInterfaces()[0].getGeneric(0).resolve());
		System.out.println(resolvableType.getInterfaces()[0].getGeneric(1).resolve());
		resolvableType.getInterfaces()[0].getGeneric(1).resolve() ;
	}
	
	@Test
	public void getFieldGeneric() {
		// 获取字段上的泛型类型
		ResolvableType resolvableType = ResolvableType.forField(ReflectionUtils.findField(DemoService.class, "cdService"));
		System.out.println(resolvableType.getGeneric(0).resolve());
		
		// 取List嵌套的泛型
		ResolvableType resolvableType1 = ResolvableType.forField(ReflectionUtils.findField(DemoService.class, "list"));
		System.out.println(resolvableType1.getGeneric(0).getGeneric(0).resolve()) ;
		
		// 或者
		System.out.println(resolvableType1.getGeneric(0, 0).resolve()) ; //List<List<String>> 即String
	
		// 取Map嵌套的泛型
		ResolvableType resolvableType2 =
                ResolvableType.forField(ReflectionUtils.findField(DemoService.class, "map"));
		System.out.println(resolvableType2.getGeneric(1).getGeneric(1).resolve());
		
		// 或者
		System.out.println(resolvableType2.getGeneric(1, 1).resolve());
	}
	
	@Test
	public void getMethodGeneric() {
		// 获取方法上泛型类型
		ResolvableType resolvableType =
                ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(DemoService.class, "method"));
		System.out.println(resolvableType.getGeneric(1, 0).resolve());
	}
	
	@Test
	public void getConstructGeneric() {
		// 获取构造器上的泛型
		// 得到第1个参数（ Map<String, Map<String, Integer>>）中的Integer
		ResolvableType resolvableType =
                ResolvableType.forConstructorParameter(ClassUtils.getConstructorIfAvailable(DemoService.class, List.class, Map.class), 1);
		System.out.println(resolvableType.getGeneric(1, 0).resolve());
	}
	
	@Test
	public void getArrayGeneric() {
		ResolvableType resolvableType =
                ResolvableType.forField(ReflectionUtils.findField(DemoService.class, "array"));
		boolean isArray = resolvableType.isArray();//判断是否是数组
		System.out.println(isArray);
		System.out.println(resolvableType.getComponentType().getGeneric(0).resolve());
	}
	
	/*
	 * ResolvableType.forClassWithGenerics(List.class, String.class)相当于创建一个List<String>类型；
	   ResolvableType.forArrayComponent(resolvableType8);：相当于创建一个List<String>[]数组；
	   resolvableType9.getComponentType().getGeneric(0).resolve()：得到相应的泛型信息；
	 */
	@Test
	public void getSelfGeneric() {
		ResolvableType resolvableType = ResolvableType.forClassWithGenerics(List.class, String.class);
        ResolvableType resolvableType1 = ResolvableType.forArrayComponent(resolvableType);
        System.out.println(resolvableType1.getComponentType().getGeneric(0).resolve());
        
        // 泛型类型的比较
		System.out.println(resolvableType.isAssignableFrom(resolvableType1));;
	}
}
