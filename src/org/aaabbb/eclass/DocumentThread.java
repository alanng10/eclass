package org.aaabbb.eclass;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class DocumentThread extends Thread
{
    public boolean Init()
    {
        this.Phore_D = new Semaphore(0);

        this.Lock_D = new Object();

        this.Queue_D = new LinkedList<Document>();

        this.ContinueSet(true);
        
        this.ClassRead = new ClassRead();
        this.ClassRead.Init();

        this.SizeData = new byte[4];
        
        this.ServerPort = 58500;
        return true;
    }

    public Semaphore Phore()
    {
        return this.Phore_D;
    }

    private Semaphore Phore_D;

    public Object Lock()
    {
        return this.Lock_D;
    }

    private Object Lock_D;

    public LinkedList<Document> Queue()
    {
        return this.Queue_D;
    }

    private LinkedList<Document> Queue_D;

    public boolean Continue()
    {
        return this.Continue_D;
    }
    
    public boolean ContinueSet(boolean value)
    {
    	this.Continue_D = value;
    	return true;
    }

    protected boolean Continue_D;
    
    private ServerSocket NetworkServer;
    private Socket Network;

    private int ServerPort;
    
    private Process Process;

    private OutputStream Out;
    private InputStream Inn;

    private ClassRead ClassRead;

    private int Status;

    private byte[] SizeData;

    private int N;

    @SuppressWarnings("unused")
    private void runA()
    {
        boolean b;
        b = false;

        while (!b)
        {
            try
            {
                this.Phore().acquire();
            } catch (InterruptedException e)
            {
            }

            Document oo;
            oo = null;
            synchronized (this.Lock())
            {
                oo = this.Queue().poll();
            }

            if (!(oo == null))
            {
                Root k;
                k = new Root();
                k.Init();

                Class a;
                a = new Class();
                a.Init();
                
                ClassName name;
                name = new ClassName();
                name.Init();
                name.ValueSet("Hoasg" + this.N);
                
                BaseName base;
                base = new BaseName();
                base.Init();
                base.ValueSet("DeuM");
                
                a.Name(name);
                a.Base(base);
                
                Comp[] ak;
                ak = new Comp[3];
                
                a.Comp(ak);

                Comp aa;
                aa = new Comp();
                aa.Init();
                aa.KindSet(0);
                aa.NameSet("Count");
                aa.ClassSet("Int");

                Comp ac;
                ac = new Comp();
                ac.Init();
                ac.KindSet(1);
                ac.NameSet("Execute");
                ac.ClassSet("Bool");
                
                Comp ab;
                ab = new Comp();
                ab.Init();
                ab.KindSet(0);
                ab.NameSet("Index");
                ab.ClassSet("String");

                ak[0] = aa;
                ak[1] = ac;
               	ak[2] = ab;

                k.ClassSet(a);

                oo.Load().RootSet(k);

                this.N = this.N + 1;

                this.UpdateOutline(oo);
            }
        }
    }

    public void run()
    {
//        Log.This().Info("DocumentThread Execute Start");
    	
    	try
    	{
    		this.Execute();
    	}
    	catch (Exception e)
    	{
    		Log.This().Error("DocumentThread Execute thrown exception: " + e.getMessage(), e);
    	}
        
        if (!(this.Status == 0))
        {
        	Log.This().Error("DocumentThread exit with status: " + this.Status, null);
        }
        
//        Log.This().Info("DocumentThread Execute End");	
        return;
    }
    
    private boolean Execute()
    {
        boolean b;
        
        b = this.Start();
        if (!b)
        {
            return false;
        }

        while (this.Continue())
        {
            try
            {
//            	Log.This().Info("DocumentThread Phore 1111");
            	
                this.Phore().acquire();

//            	Log.This().Info("DocumentThread Phore 2222");
            } catch (InterruptedException e)
            {
            }
            
            if (this.Continue())
            {
//            	Log.This().Info("DocumentThread Queue Lock 1111");

	            Document oo;
	            oo = null;
	            synchronized (this.Lock())
	            {
	                oo = this.Queue().poll();
	            }

//            	Log.This().Info("DocumentThread Queue Lock 2222");

	            if (!(oo == null))
	            {
//	            	Log.This().Info("DocumentThread Document Polled Not Null");

	                String text;
	                text = oo.Load().Text();
	
	                byte[] data;
	                data = this.OutData(text);
	                
	                boolean ba;
	                ba = this.OutWrite(data);
	
	                if (ba)
	                {
	                    byte[] dataA;
	                    dataA = this.InnRead();
	
	                    if (!(dataA == null))
	                    {
	                        ClassRead classRead;
	                        classRead = this.ClassRead;
	
	                        classRead.DataSet(dataA);
	
	                        classRead.Execute();	                        

	                        Root a;
	                        a = new Root();
	                        a.Init();
	
	                        Class varClass;
	                        varClass = classRead.Class();
	
//	                        Log.This().Info("DocumentThread class read is null: " + (varClass == null));
	                        
	                        a.ClassSet(varClass);
	
	                        oo.Load().RootSet(a);
	
	                        classRead.ClassSet(null);
	                        classRead.DataSet(null);
	                        classRead.StatusSet(0);
	                        
	                        this.UpdateOutline(oo);
	                    }
	                }
	            }
            }
        }

        b = this.End();
        if (!b)
        {
            return false;
        }
        
        return true;
    }

    private boolean UpdateOutline(Document o)
    {
        OutlineUpdateJob job;
        job = new OutlineUpdateJob();
        job.Init();
        job.DocumentSet(o);

        job.Schedule(0);
        return true;
    }
    
    private boolean OutWrite(byte[] data)
    {
        try
        {
//            Log.This().Info("DocumentThread OutWrite 1111");
        	
            this.Out.write(data, 0, data.length);
            
//            Log.This().Info("DocumentThread OutWrite 2222");
        } catch (IOException e)
        {
            Log.This().Error("Network out cannot write data", e);
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
//            Log.This().Info("DocumentThread InnRead 1111");
        	
            ka = this.Inn.read(this.SizeData, 0, this.SizeData.length);
            
//            Log.This().Info("DocumentThread InnRead 2222");
        } catch (IOException e)
        {
            Log.This().Error("Network inn read data count get error", e);
            this.Status = 11;
            return null;
        }

        if (ka < this.SizeData.length)
        {
            Log.This().Error("Network inn read data count get error", null);
            this.Status = 12;
            return null;
        }

        ByteBuffer o;
        o = ByteBuffer.wrap(this.SizeData);

        o.order(ByteOrder.LITTLE_ENDIAN);

        int count;
        count = o.getInt(0);

//        Log.This().Info("InnRead count: " + count);
        
        byte[] data;
        data = new byte[count];

        try
        {
//            Log.This().Info("DocumentThread InnRead 3333");
        	
            ka = this.Inn.read(data, 0, data.length);
            
//            Log.This().Info("DocumentThread InnRead 4444");
        } catch (IOException e)
        {
            Log.This().Error("Network inn read data error", e);
            this.Status = 13;
            return null;
        }

        if (ka < count)
        {
            Log.This().Error("Network inn read data error", null);
            this.Status = 14;
            return null;
        }

        return data;
    }
    
    private byte[] OutData(String text)
    {
        int charCount;
        charCount = text.length();
        
        int byteCount;
        byteCount = charCount * 2;
        
        int dataCount;
        dataCount = byteCount + 4;
        
        byte[] data;
        data = new byte[dataCount];
        
        ByteBuffer o;
        o = ByteBuffer.wrap(data);

        o.order(ByteOrder.LITTLE_ENDIAN);
        
        o.putInt(0, byteCount);
        
//        Log.This().Info("OutData count: " + byteCount);
        
        Infra infra;
        infra = Plugin.This().Infra();
        
        infra.DataGetString(data, 4, text);
        
        return data;
    }

    private boolean Start()
    {
        boolean b;

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

    private boolean ProcessInit()
    {
//    	Log.This().Info("Process Init Start");
    	
    	String k;
    	k = String.valueOf(this.ServerPort);
    	
    	ArrayList<String> list;
    	list = new ArrayList<String>();
    	
    	list.add("C:\\Users\\aaabb\\Project\\ClassServer\\Out\\net8.0\\ClassServer.Console-ExeCon.exe");
    	list.add("localhost");
    	list.add(k);
    	
        ProcessBuilder builder;
        builder = new ProcessBuilder(list);

//        Log.This().Info("Process Init 1111");
        
        Process process;
        process = null;
        try
        {
//            Log.This().Info("Process Init 2222");
            
        	process = builder.start();
            
//            Log.This().Info("Process Init 3333");
        } catch (IOException e)
        {
            Log.This().Error("ClassServer process cannot be started", e);
            this.Status = 1;
            return false;
        }

        this.Process = process;
        
//        Log.This().Info("Process Init End");
        return true;
    }

    private boolean NetworkInit()
    {
//    	Log.This().Info("Network Init Start");
        
    	ServerSocket server;
        server = null;
        try
        {
//            Log.This().Info("Network Init 1111");
        	
            server = new ServerSocket(this.ServerPort);

//            Log.This().Info("Network Init 2222");
        } catch (IOException e)
        {
            Log.This().Error("Network server cannot be started", e);
            this.Status = 5;
            return false;
        }

        Socket socket;
        try
        {
//            Log.This().Info("Network Init 3333");

            socket = server.accept();
            
//            Log.This().Info("Network Init 4444");
        } catch (IOException e)
        {
            Log.This().Error("Network server cannot get peer", e);
            this.Status = 6;
            return false;
        }

        OutputStream out;
        try
        {
//            Log.This().Info("Network Init 5555");

            out = socket.getOutputStream();
            
//            Log.This().Info("Network Init 6666");
        } catch (IOException e)
        {
            Log.This().Error("Network peer get out error", e);
            this.Status = 7;
            return false;
        }

        InputStream inn;
        try
        {
//            Log.This().Info("Network Init 7777");

            inn = socket.getInputStream();
            
//            Log.This().Info("Network Init 8888");
        } catch (IOException e)
        {
            Log.This().Error("Network peer get inn error", e);
            this.Status = 8;
            return false;
        }

        this.NetworkServer = server;
        this.Network = socket;

        this.Out = out;
        this.Inn = inn;
        
//    	Log.This().Info("Network Init End");
        return true;
    }

    private boolean NetworkFinal()
    {
        try
        {
            this.Network.close();
        } catch (IOException e)
        {
            Log.This().Error("Network cannot be closed", e);
            this.Status = 60;
            return false;
        }

        try
        {
            this.NetworkServer.close();
        } catch (IOException e)
        {
            Log.This().Error("Network server cannot be closed", e);
            this.Status = 61;
            return false;
        }

        return true;
    }
    
    private boolean ProcessFinal()
    {
        this.Process.destroyForcibly();
        return true;
    }
}
