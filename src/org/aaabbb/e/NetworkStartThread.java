package org.aaabbb.e;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Semaphore;

public class NetworkStartThread extends Thread
{
	public final Semaphore Phore = new Semaphore(0);
	
	public void run()
	{
		ServerSocket server;
		server = null;
		try
		{
			server = new ServerSocket(58501);
		}
		catch (IOException e)
		{
			Log.This.Error("Network Start cannot start server", e);
			return;
		}
		
		try
		{
			server.accept();
		} catch (IOException e)
		{
			Log.This.Error("Network Start cannot get peer", e);
		}
		finally
		{
			try
			{
				server.close();
			} catch (IOException e)
			{
				Log.This.Error("Network Start cannot close server", e);
				return;
			}
		}
		
		this.Phore.release();
	}
}
