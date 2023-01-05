
//Ido Elmakies 316476340
public class HeavyWorker 
{
	private MySemaphore SemToSect1 = new MySemaphore(3);
	private MySemaphore SemToSect2 = new MySemaphore(1);
	private MySemaphore SemToWorkB = new MySemaphore(0);
	public void section1() 
	{
		System.out.println(Thread.currentThread().getName() + " is in section1");
		try 
		{
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section1");
	}
	
	public void section2()
	{
		System.out.println(Thread.currentThread().getName() + " is in section2");
		try 
		{
			/* sleep to simulate some work... */
			Thread.sleep(500);
		}
		catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section2");
	}
	
	public void workA() 
	{
		System.out.println(Thread.currentThread().getName() + " doing workA");
		
		SemToSect1.down();
		/* section1() can be called from up to 3 threads at the same time */
		section1();
		SemToSect2.down();
		/* section2() can be called from one thread out of the 3 above    */		
		section2();
		SemToSect2.up();
		SemToSect1.up();
		SemToWorkB.up();
		
	}
	
	public void workB() 
	{
		SemToWorkB.down();
		/* this will be printed only after workA() done at least once */
		System.out.println(Thread.currentThread().getName() + " doing workB");
	}
	
}
