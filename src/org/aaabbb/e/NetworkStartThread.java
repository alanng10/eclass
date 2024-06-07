package org.aaabbb.e;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class NetworkStartThread extends Thread
{
	public final Semaphore Phore = new Semaphore(0);
	
	public void run()
	{
		ServerSocket server;
		server = null;
		Socket socket;
		socket = null;
		try
		{
			server = new ServerSocket(58501);
		}
		catch (IOException e)
		{
			Log.This().Error("Network Start cannot start server", e);
		}
		
		if (!(server == null))
		{
			try
			{
				socket = server.accept();
			} catch (IOException e)
			{
				Log.This().Error("Network Start cannot get peer", e);
			}
			
        	if (!(socket == null))
			{
				try
				{
					socket.close();
				} catch (IOException e)
				{
					Log.This().Error("Network Start cannot close peer", e);
				}
			}

			try
			{
				server.close();
			} catch (IOException e)
			{
				Log.This().Error("Network Start cannot close server", e);
			}
		}
		
		if (!(server == null) & !(socket == null))
		{
			this.Phore.release();
		}
	}
}
