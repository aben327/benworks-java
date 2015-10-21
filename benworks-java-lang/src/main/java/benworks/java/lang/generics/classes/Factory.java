package benworks.java.lang.generics.classes;

/**
 * 比如说，假定你要写一个工具方法来进行一个数据库查询，给定一个SQL语句，并返回一个数据库中符合查询条件的对象集合(collection)。<br>
 * 一个方法时显式的传递一个工厂对象，像下面的代码：
 * @author Ben
 * @date 2015年10月21日下午4:26:08
 */
interface Factory<T> {

	public T[] make();

}