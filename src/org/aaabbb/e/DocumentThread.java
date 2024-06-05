package org.aaabbb.e;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class DocumentThread extends Thread
{
	public final Semaphore Phore = new Semaphore(0);
	
	public final Object Lock = new Object();
	
	public final LinkedList<DocumentLoad> Queue = new LinkedList<DocumentLoad>();
	
	public void run()
	{
		boolean b;
		b = false;
		
		while (!b)
		{
			try {
				this.Phore.acquire();
			} catch (InterruptedException e) {
			}
			
			DocumentLoad oo;
			
			synchronized (this.Lock)
			{
				oo = this.Queue.poll();
			}
		}
	}
}
