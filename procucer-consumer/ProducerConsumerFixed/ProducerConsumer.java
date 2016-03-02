import java.util.Random;

/**
 * ProducerConsumer class
 */
public class ProducerConsumer 
{
	public static void main (String args[])
	{
		MySharedResource resource = new MySharedResource();
		
		Thread producer = new Thread(new Producer(resource), "Producer");	
		Thread consumer = new Thread(new Consumer(resource), "Consumer");
		
		producer.start();
		consumer.start();
	}
}

/**
 * Producer class
 */
class Producer implements Runnable
{
	MySharedResource resource;
	private static Random generator = new Random();

	public Producer(MySharedResource resource)
	{
		this.resource = resource;
	}

	public void run()
	{
		int countA = 0, countB = 0, countC = 0;
		
		while(true)
		{	
			try 
			{
				synchronized (resource) {
					
					while (resource.isEmpty() == false) {
						resource.wait();
					}
					
					resource.setFieldA(countA); Thread.sleep(generator.nextInt(5000));
					resource.setFieldB(countB); Thread.sleep(generator.nextInt(5000));
					resource.setFieldC(countC); Thread.sleep(generator.nextInt(5000));
					resource.setEmpty(false);
					
					resource.notifyAll();
					System.out.println("Produced: " + countA + " " + countB + " " + countC);
				}
				
				countA++; countB++; countC++;
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}

/**
 * Consumer class
 */
class Consumer implements Runnable
{
	MySharedResource resource;
	private static Random generator = new Random();

	public Consumer(MySharedResource resource)
	{
		this.resource = resource;
	}
	
	public void run()
	{
		int countA = 0, countB = 0, countC = 0;
		
		while(true)
		{	
			try 
			{
				synchronized (resource) {
					while (resource.isEmpty()) {
						resource.wait();
					}
					
					countA = resource.getFieldA(); Thread.sleep(generator.nextInt(5000));
					countB = resource.getFieldB(); Thread.sleep(generator.nextInt(5000));
					countC = resource.getFieldC(); Thread.sleep(generator.nextInt(5000));
					resource.setEmpty(true);
					
					resource.notifyAll();
					System.out.println("Consumed: " + countA + " " + countB + " " + countC);
				}
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}