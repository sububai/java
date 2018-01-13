package chapter5;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

public class Favorites {
	private Map<Class<?>, Object> favorites = new HashMap<>();
	
	//Class.cast()返回Class的类型参数所表示的类的对象
	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null)
			throw new NullPointerException();
		favorites.put(type, type.cast(instance));
	}
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass);
	}
	
	
	//use of asSubclass to safely cast to a bounded type token
	static Annotation getAnnotation(AnnotatedElement element, String annotation) {
		Class<?> annotationType = null;
		try {
			annotationType = Class.forName(annotation);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
	}
}
