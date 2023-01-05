public class main {

	public static void main(String[] args) 
	{
		HeavyWorker worker = new HeavyWorker();
		
		for (int i=0; i<8; i++) 
		{
			new Thread() 
			{
				public void run() 
				{
					worker.workB();
				}
			}.start();
		}
		
		for (int i=0; i<8; i++) 
		{
			new Thread() 
			{
				public void run() 
				{
					worker.workA();
				}
			}.start();
		}
	}

}
