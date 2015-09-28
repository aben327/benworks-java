/**
 * 《java程序性能优化》--让你的java程序更快，更稳定
 */
package benworks.java.util.concurrent.deadlock.demo2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ben
 * @date 2015年10月2日下午4:10:05
 */
public class DeadLockCar extends Thread {
	protected Object myDirect;
	public static ReentrantLock sourth = new ReentrantLock();//
	public static ReentrantLock north = new ReentrantLock();//
	public static ReentrantLock west = new ReentrantLock();//
	public static ReentrantLock east = new ReentrantLock();//

	public DeadLockCar(Object obj) {
		this.myDirect = obj;
		if (myDirect == sourth) {
			this.setName("sourth");
		}
		if (myDirect == north) {
			this.setName("north");
		}
		if (myDirect == west) {
			this.setName("west");
		}
		if (myDirect == east) {
			this.setName("east");
		}
	}

	@Override
	public void run() {

		// sourth

		if (myDirect == sourth) {
			try {
				west.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}

				sourth.lockInterruptibly();
				System.out.println("car to sourth has passed");
			} catch (Exception e) {
				System.out.println("car to sourth is killed");
			} finally {
				if (west.isHeldByCurrentThread()) {
					west.unlock();
				}
				if (sourth.isHeldByCurrentThread()) {
					sourth.unlock();
				}
			}
		}

		// north

		if (myDirect == north) {
			try {
				east.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}

				north.lockInterruptibly();
				System.out.println("car to north has passed");
			} catch (Exception e) {
				System.out.println("car to north is killed");
			} finally {
				if (east.isHeldByCurrentThread()) {
					east.unlock();
				}
				if (north.isHeldByCurrentThread()) {
					north.unlock();
				}
			}
		}

		// west

		if (myDirect == west) {
			try {
				north.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}

				west.lockInterruptibly();
				System.out.println("car to west has passed");
			} catch (Exception e) {
				System.out.println("car to west is killed");
			} finally {
				if (north.isHeldByCurrentThread()) {
					north.unlock();
				}
				if (west.isHeldByCurrentThread()) {
					west.unlock();
				}
			}
		}

		// east

		if (myDirect == east) {
			try {
				sourth.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}

				east.lockInterruptibly();
				System.out.println("car to east has passed");
			} catch (Exception e) {
				System.out.println("car to east is killed");
			} finally {
				if (sourth.isHeldByCurrentThread()) {
					sourth.unlock();
				}
				if (east.isHeldByCurrentThread()) {
					east.unlock();
				}
			}
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		DeadLockCar car2sourth = new DeadLockCar(sourth);
		DeadLockCar car2north = new DeadLockCar(north);
		DeadLockCar car2west = new DeadLockCar(west);
		DeadLockCar car2east = new DeadLockCar(east);
		car2sourth.start();
		car2north.start();
		car2west.start();
		car2east.start();

		Thread.sleep(1000);
		car2north.interrupt();
	}
}
