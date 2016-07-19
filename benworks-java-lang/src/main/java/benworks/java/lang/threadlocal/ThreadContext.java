package benworks.java.lang.threadlocal;

/**
 * 在关联数据类中创建private static ThreadLocal<br>
 * http://blog.csdn.net/vking_wang/article/details/14225379<br>
 * @author Roc
 * @date 2016年6月14日下午6:04:33
 */
public class ThreadContext {

	private String userId;

	private Long transactionId;

	private static ThreadLocal threadLocal = new ThreadLocal() {
		@Override
		protected ThreadContext initialValue() {
			return new ThreadContext();
		}

	};

	public static ThreadContext get() {
		return (ThreadContext) threadLocal.get();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

}
