package benworks.java.util.concurrent.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Roc
 * @Date 2015年11月2日上午12:10:58
 */
public class Resource4 {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();
 
    public void f() {
       // other operations should not be locked...
       System.out.println(Thread.currentThread().getName()
              + ":not synchronized in f()");
       lock1.lock();
       try {
           for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()
                     + ":synchronized in f()");
              try {
                  TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
           }
       } finally {
           lock1.unlock();
       }
    }
 
    public void g() {
       // other operations should not be locked...
       System.out.println(Thread.currentThread().getName()
              + ":not synchronized in g()");
       lock2.lock();
       try {
           for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()
                     + ":synchronized in g()");
              try {
                  TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
           }
       } finally {
           lock2.unlock();
       }
    }
 
    public void h() {
       // other operations should not be locked...
       System.out.println(Thread.currentThread().getName()
              + ":not synchronized in h()");
       lock3.lock();
       try {
           for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()
                     + ":synchronized in h()");
              try {
                  TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
           }
       } finally {
           lock3.unlock();
       }
    }
 
    public static void main(String[] args) {
       final Resource4 rs = new Resource4();
 
       new Thread() {
           public void run() {
              rs.f();
           }
       }.start();
 
       new Thread() {
           public void run() {
              rs.g();
           }
       }.start();
 
       rs.h();
    }
}