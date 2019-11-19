/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. */
package br.com.onsys.util;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.Transient;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.lang3.text.WordUtils;
import org.jdal.util.BeanUtils;
import org.reflections.ReflectionUtils;

import com.google.common.collect.Lists;


public class ObjetoUtil <T extends Serializable> {

	private static HashMap descriptorCache = new HashMap();
	
	public static Object copiarAtributosObjetoParaNovaInstancia(Object b) throws Exception {
		try {
			
			
			Object a = new ObjetoUtil <Serializable>().novaInstanciaComfilhos((Serializable) b);
			
			Field[] fieldsFromFirstClass = a.getClass().getDeclaredFields();
			Field[] fieldsFromSecondClass = b.getClass().getDeclaredFields();
	
			for (Field currentFieldFromTheFirstClass : fieldsFromFirstClass) {
				if (!currentFieldFromTheFirstClass.getName().equalsIgnoreCase("serialVersionUID")) {
					for (Field currentFieldFromTheSecondClass : fieldsFromSecondClass) {
						if (!currentFieldFromTheSecondClass.getName().equalsIgnoreCase("serialVersionUID")) {
							String nameOfTheFirstField = currentFieldFromTheFirstClass.getName();
							String nameOfTheSecondField = currentFieldFromTheSecondClass.getName();
	
							if (nameOfTheFirstField.equals(nameOfTheSecondField)) {
								currentFieldFromTheFirstClass.setAccessible(true);
								currentFieldFromTheSecondClass.setAccessible(true);
	
								currentFieldFromTheFirstClass.set(a,currentFieldFromTheSecondClass.get(b));
							}
						}
					}
				}
			}
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

	public static Serializable copiarAtributosObjetoParaNovaInstancia2(Object b) throws Exception {
		try {
			
			
			Object a = new ObjetoUtil <Serializable>().novaInstanciaComfilhos((Serializable) b);
			
			Field[] fieldsFromFirstClass = a.getClass().getDeclaredFields();
			Field[] fieldsFromSecondClass = b.getClass().getDeclaredFields();
	
			for (Field currentFieldFromTheFirstClass : fieldsFromFirstClass) {
				if (!currentFieldFromTheFirstClass.getName().equalsIgnoreCase("serialVersionUID")) {
					for (Field currentFieldFromTheSecondClass : fieldsFromSecondClass) {
						if (!currentFieldFromTheSecondClass.getName().equalsIgnoreCase("serialVersionUID")) {
							String nameOfTheFirstField = currentFieldFromTheFirstClass.getName();
							String nameOfTheSecondField = currentFieldFromTheSecondClass.getName();
	
							if (nameOfTheFirstField.equals(nameOfTheSecondField)) {
								currentFieldFromTheFirstClass.setAccessible(true);
								currentFieldFromTheSecondClass.setAccessible(true);
	
								currentFieldFromTheFirstClass.set(a,currentFieldFromTheSecondClass.get(b));
							}
						}
					}
				}
			}
			return (Serializable) a;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	


	

	@SuppressWarnings("unchecked")
	public T novaInstanciaComfilhos(T entidade) throws Exception {
		try {
		
			T instanciaEntidade = this.instanciar(entidade);
			
			Set<Method> getters = ReflectionUtils.getAllMethods(instanciaEntidade.getClass(),
				      ReflectionUtils.withModifier(Modifier.PUBLIC), ReflectionUtils.withPrefix("get"));
			
			Map <String,Class<?>> atributos = new LinkedHashMap <String,Class<?>> ()  ;
			
			for(Method metodo : getters){
				
				List <Field> campos = Lists.newArrayList(ReflectionUtils.getFields(metodo.getDeclaringClass(), ReflectionUtils.withModifier(Modifier.PRIVATE)));
				
				if(!BeanUtils.isSimpleValueType(metodo.getReturnType()) && campos.get(0).isAnnotationPresent((Class<? extends Annotation>) Transient.class) == false && !metodo.getReturnType().getSimpleName().equals("List")){
					
					atributos.put(WordUtils.uncapitalize(metodo.getName().replaceFirst("get", "")), metodo.getReturnType());
				}
			}
			
		
			return this.atribuirNovasInstancias(instanciaEntidade,atributos);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	private T atribuirNovasInstancias(T instanciaEntidade, Map <String,Class<?>> atributos) throws Exception {
		try {
		
			for (Map.Entry<String, Class<?>> parametro : atributos.entrySet()){
				
				boolean filtrar = this.filtrarTipo(parametro.getValue());
				
				if(filtrar == false){
				
					/**
					 * aatribuindo uma nova instancia
					 */
					T instanciaGetter = (T) ObjetoUtil.instanciar(parametro.getValue());
					
					/**
					 * pegando o meto set do objeto entidadeFinal
					 */							
					Method metodoSetter = instanciaEntidade.getClass().getDeclaredMethod("set"+WordUtils.capitalize(parametro.getKey().replaceAll("get", "")),new Class[] {instanciaGetter.getClass()});
					
					/**
					 * invocando o metodo set
					 */
					metodoSetter.invoke(instanciaEntidade, new Object[]{instanciaGetter});

				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return instanciaEntidade;
	}


	private boolean filtrarTipo(Class<?> value)throws Exception {
		boolean filtrar = false;
		try {
	
			if(value.isInterface() || value.isArray()){
				filtrar = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return filtrar;
	}


	@SuppressWarnings("unchecked")
	public T instanciar(T entidade) throws Exception {
		try {
			Constructor <T> constructor = (Constructor<T>) entidade.getClass().getConstructor(new Class[] {});			
			return constructor.newInstance(new Object[] {});	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Object instanciar(Class <?> clazz) throws Exception {
		try {
			Constructor <Object> constructor = (Constructor<Object>) clazz.getConstructor(new Class[] {});			
			return constructor.newInstance(new Object[] {});	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static <T> Object getValorCampoObjeto(Serializable obj, String atributo) throws Exception {
		try {
			return getNestedProperty(obj,atributo);
	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Get specified nested property value
	 * @throws Exception 
	 */
	private static Object getNestedProperty(Object bean, String property) throws Exception {
		try {


			if (property.indexOf('.') > 0) {
				String[] path = property.split("\\.");
				for (int i = 0; i < path.length && bean != null; i++) {
					bean = getProperty(bean, path[i]);
				}
				return bean;
			} else {
				return getProperty(bean, property);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	/**
	 * Get specified property value
	 */
	private static Object getProperty(Object bean, String property)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor descriptor = getPropertyDescriptor(bean.getClass(), property);
		if (descriptor == null)
			throw new NoSuchMethodException("Cannot find property " + bean.getClass().getName() + "." + property);
		Method method = descriptor.getReadMethod();
		if (method == null)
			throw new NoSuchMethodException("Cannot find getter for " + bean.getClass().getName() + "." + property);
		return method.invoke(bean, null);
	}
	
	/**
	 * Get specified property descriptor
	 */
	private static PropertyDescriptor getPropertyDescriptor(Class clazz, String property) {
		return (PropertyDescriptor) getPropertyDescriptors(clazz).get(property);
	}
	/**
	 * Get map with property descriptors for the specified bean class
	 */
	private static Map getPropertyDescriptors(Class clazz) {
		HashMap map = (HashMap) descriptorCache.get(clazz);
		if (map == null) {
			BeanInfo beanInfo = null;
			try {
				beanInfo = Introspector.getBeanInfo(clazz);
			} catch (IntrospectionException e) {
				return Collections.EMPTY_MAP;
			}
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			if (descriptors == null)
				descriptors = new PropertyDescriptor[0];
			map = new HashMap(descriptors.length);
			for (int i = 0; i < descriptors.length; i++)
				map.put(descriptors[i].getName(), descriptors[i]);
			descriptorCache.put(clazz, map);
		}
		return map;
	}
}
