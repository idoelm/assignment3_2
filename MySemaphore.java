public class MySemaphore 
{	
	private int tickets;
	
	public MySemaphore(int tickets) 
	{
		this.tickets = tickets;
	}
	
	public synchronized void up() 
	{
		tickets++;
		notifyAll();
	}
	
	public synchronized void down() 
	{ 
		while (tickets <= 0) {
			try {
//				System.out.println(Thread.currentThread().getName() + " no have tickets");
				wait();
			} catch (Exception e) {}		
		}
		tickets--;
	}
}
