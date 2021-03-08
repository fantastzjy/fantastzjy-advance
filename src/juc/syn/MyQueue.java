package juc.syn;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyQueue {

	private Object obj;
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

	/***
	 * 读取屏幕信息
	 */
	public void readObj() {
		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " \t" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.readLock().unlock();
		}
	}

	/***
	 * 修改屏幕信息
	 * 
	 * @param obj
	 */
	public void writeObj(Object obj) {
		rwLock.writeLock().lock();
		try {
			this.obj = obj;
			System.out.println(Thread.currentThread().getName() + "writeThread: \t" + obj);

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.writeLock().unlock();
		}
	}

}
