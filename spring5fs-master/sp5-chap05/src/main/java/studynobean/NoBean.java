package studynobean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // type 클래스만, method 등등 가능
//@Target(ElementType.METHOD)
public @interface NoBean {

}
