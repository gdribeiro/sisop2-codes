import java.util.Random;

class MyMonitor {
	
	private int data = 0;
	private int turn = 1;
    
<<<<<<< HEAD
	public void update(int id) throws InterruptedException {
		
        /* fix me */
=======
	public synchronized void update(int id) throws InterruptedException {
		
        /* fix me */
		while(id != turn){
			this.wait();
		}
		
>>>>>>> de6795a68cc35ff71c70d5817a84e53b3d86e831
		
        System.out.println("Thread ID = " + id + " vai atualizar ...");
        data++; Thread.currentThread().sleep(new Random().nextInt(3000));
        System.out.println("Thread ID = " + id + " atualizou...");		
		
<<<<<<< HEAD
        /* fix me */    
=======
        /* fix me */
		turn = (turn + 1)% 2;
		this.notify();     
>>>>>>> de6795a68cc35ff71c70d5817a84e53b3d86e831
	}
}

class MyThread extends Thread {
	
	int id;
	MyMonitor myMonitor;
	
	public MyThread(int id, MyMonitor myMonitor) {
		this.id = id;
		this.myMonitor = myMonitor;
	}
	
	public void run() {
		while (true) {
			try {
				myMonitor.update(id);
				Thread.currentThread().sleep(new Random().nextInt(3000));
			}
			catch (InterruptedException ie) { 
				ie.printStackTrace(); 
			}
		}
	}
}

public class MonitorTester {
	
	public static void main(String args[]) {
		
		MyMonitor myMonitor = new MyMonitor();
		
		MyThread t1 = new MyThread(0, myMonitor);
		MyThread t2 = new MyThread(1, myMonitor);
		
		t1.start();
		t2.start();		
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> de6795a68cc35ff71c70d5817a84e53b3d86e831
