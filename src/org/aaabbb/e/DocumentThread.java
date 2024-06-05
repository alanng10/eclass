package org.aaabbb.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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
	
	private ClassRead ClassRead;
	
	private int Status;
	
	private byte[] SizeData = new byte[4];
	
	public boolean Init()
	{
		this.ClassRead = new ClassRead();
		this.ClassRead.Init();
		return true;
	}
	
	public void run()
	{
		this.Start();
		
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
			
			if (!(oo == null))
			{	
				String text;
				text = oo.Text;
				
				byte[] data;
				data = text.getBytes();
				
				boolean ba;
				
				ba = this.OutWrite(data);
				
				if (ba)
				{
					byte[] dataA;
					dataA = this.InnRead();
					
					if (!(dataA == null))
					{
						this.ClassRead.Data = dataA;
						
						this.ClassRead.Execute();
						
						Class varClass;
						varClass = this.ClassRead.Class;
						
						this.ClassRead.Class = null;
						this.ClassRead.Data = null;
					}
				}
			}
		}
		
		this.End();
	}
	
	private boolean OutWrite(byte[] data)
	{
		try
		{
			this.Out.write(data, 0, data.length);
		} catch (IOException e)
		{
			Log.This.Error("Network out cannot write data", e);
			this.Status = 10;
			return false;
		}
		return true;
	}
	
	private byte[] InnRead()
	{
		int ka;
		try
		{
			ka = this.Inn.read(this.SizeData, 0, this.SizeData.length);
		} catch (IOException e)
		{
			Log.This.Error("Network inn read data count get error", e);
			this.Status = 11;
			return null;
		}
		
		if (ka < this.SizeData.length)
		{
			Log.This.Error("Network inn read data count get error", null);
			this.Status = 12;
			return null;
		}
		
		ByteBuffer o;
		o = ByteBuffer.wrap(this.SizeData);
		
		o.order(ByteOrder.LITTLE_ENDIAN);
		
		int count;
		count = o.getInt(0);
		
		byte[] data;
		data = new byte[count];
		
		try
		{
			ka = this.Inn.read(data, 0, data.length);
		} catch (IOException e)
		{
			Log.This.Error("Network inn read data error", e);
			this.Status = 13;
			return null;
		}
		
		if (ka < count)
		{
			Log.This.Error("Network inn read data error", null);
			this.Status = 14;
			return null;
		}
		
		return data;
	}
	
	private boolean Start()
	{
		boolean b;

		b = this.NetworkStart();
		if (!b)
		{
			return false;
		}
		
		b = this.ProcessInit();
		if (!b)
		{
			return false;
		}
		
		b = this.NetworkInit();
		if (!b)
		{
			return false;
		}
		
		return true;
	}
	
	private boolean End()
	{
		boolean b;
		
		b = this.NetworkFinal();
		if (!b)
		{
			return false;
		}
		
		b = this.ProcessFinal();
		if (!b)
		{
			return false;
		}
		
		return true;
	}
	
	private boolean NetworkStart()
	{
		Plugin.This().NetworkStartThread().start();
		
		return true;
	}
	
	private boolean NetworkInit()
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
			this.Status = 5;
			return false;
		}
		
		Socket socket;
		try
		{
			socket = server.accept();
		} catch (IOException e)
		{
			Log.This.Error("Network server cannot get peer", e);
			this.Status = 6;
			return false;
		}
		

		OutputStream out;
		try
		{
			out = socket.getOutputStream();
		} catch (IOException e)
		{
			Log.This.Error("Network peer get out error", e);
			this.Status = 7;
			return false;
		}
		
		InputStream inn;
		try
		{
			inn = socket.getInputStream();
		} catch (IOException e)
		{
			Log.This.Error("Network peer get inn error", e);
			this.Status = 8;
			return false;
		}
		
		this.NetworkServer = server;
		this.Network = socket;
		
		this.Out = out;
		this.Inn = inn;
		return true;
	}
	
	private boolean ProcessInit()
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
			this.Status = 1;
			return false;
		}
		
		this.Process = process;		
		return true;
	}
	
	private boolean ProcessFinal()
	{	
		this.Process.destroyForcibly();	
		return true;
	}
	
	private boolean NetworkFinal()
	{
		try
		{
			this.Network.close();
		} catch (IOException e)
		{
			Log.This.Error("Network cannot be closed", e);
			this.Status = 60;
			return false;
		}
		
		try
		{
			this.NetworkServer.close();
		} catch (IOException e)
		{
			Log.This.Error("Network server cannot be closed", e);
			this.Status = 61;
			return false;
		}
		
		return true;
	}
}
