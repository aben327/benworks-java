package benworks.java.lang.annotation.iteye;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明:所有的Annotation会自动继承java.lang.annotation这一个接口,所以不能再去继承别的类或是接口. <br>
 * 最重要的一点,Annotation类型里面的参数该怎么设定: <br>
 * 第一,只能用public或默认(default)这两个访问权修饰.例如,String value();这里把方法设为defaul默认类型. <br>
 * 第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型<br>
 * 和String,Enum,Class,annotations等数据类型,以及这一些类型的数组.例如,String value();这里的参数成员就为String. <br>
 * 第三,如果只有一个参数成员,最好把参数名称设为"value",后加小括号.例:上面的例子就只有一个参数成员. <br>
 * @author Roc
 * @date 2015年10月19日上午10:02:31
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
	String value();
}
