package org.aaabbb.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class DocumentThread extends Thread
{
	public final Semaphore Phore = new Semaphore(0);
	
	public final Object Lock = new Object();
	
	public final LinkedList<DocumentLoad> Queue = new LinkedList<DocumentLoad>();
	
	private ServerSocket NetworkServer;
	private Socket Network;
	
	private Process Process;
	
	private OutputStream Out;
	private InputStream Inn;
	
	public void run()
	{
		this.Init();
		
		boolean b;
		b = false;
		
		while (!b)
		{
			try {
				this.Phore.acquire();
			} catch (InterruptedException e) {
			}
			
			DocumentLoad oo;
			oo = null;
			synchronized (this.Lock)
			{
				oo = this.Queue.poll();
			}
			
			String text;
			text = oo.Text;
			
			byte[] data;
			data = text.getBytes();
			
			int o;
			
			o = this.OutWrite(data);
			
			if (!(o == 0))
			{
			}
		}
	}
	
	private int OutWrite(byte[] data)
	{
		try
		{
			this.Out.write(data, 0, data.length);
		} catch (IOException e)
		{
			Log.This.Error("Network out cannot write data", e);
			return 10;
		}
		return 0;
	}
	
	private int Init()
	{
		int o;

		o = this.NetworkStart();
		if (!(o == 0))
		{
			return o;
		}
		
		o = this.ProcessInit();
		if (!(o == 0))
		{
			return o;
		}
		
		o = this.NetworkInit();
		if (!(o == 0))
		{
			return o;
		}
		
		return 0;
	}
	
	private int NetworkStart()
	{
		Plugin.This().NetworkStartThread().start();
		
		return 0;
	}
	
	private int NetworkInit()
	{
		try
		{
			Plugin.This().NetworkStartThread().Phore.acquire();
		} catch (InterruptedException e)
		{
		}
		
		
		ServerSocket server;
		server = null;
		try
		{
			server = new ServerSocket(58500);
		}
		catch (IOException e)
		{
			Log.This.Error("Network server cannot be started", e);
			return 5;
		}
		
		Socket socket;
		try
		{
			socket = server.accept();
		} catch (IOException e)
		{
			Log.This.Error("Network server cannot get peer", e);
			return 6;
		}
		

		OutputStream out;
		try
		{
			out = socket.getOutputStream();
		} catch (IOException e)
		{
			Log.This.Error("Network peer get out error", e);
			return 7;
		}
		
		InputStream inn;
		try
		{
			inn = socket.getInputStream();
		} catch (IOException e)
		{
			Log.This.Error("Network peer get inn error", e);
			return 8;
		}
		
		this.NetworkServer = server;
		this.Network = socket;
		
		this.Out = out;
		this.Inn = inn;
		return 0;
	}
	
	private int ProcessInit()
	{
		ProcessBuilder builder;
		builder = new ProcessBuilder("C:\\Users\\aaabb\\Project\\ClassServer\\Out\\net8.0\\ClassServer.exe");

		Process process;
		process = null;
		try
		{
			process = builder.start();
		}
		catch (IOException e)
		{
			Log.This.Error("ClassServer process cannot be started", e);
			return 1;
		}
		
		this.Process = process;
		
		return 0;
	}
}
