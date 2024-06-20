package org.alanng10.eclass;

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

        this.Continue(true);
        
        this.ClassRead = new ClassRead();
        this.ClassRead.Init();

        this.SizeData = new byte[4];
        return true;
    }

    public Semaphore Phore()
    {
        return this.Phore_D;
    }

    protected Semaphore Phore_D;

    public Object Lock()
    {
        return this.Lock_D;
    }

    protected Object Lock_D;

    public LinkedList<Document> Queue()
    {
        return this.Queue_D;
    }

    private LinkedList<Document> Queue_D;

    public boolean Continue()
    {
        return this.Continue_D;
    }
    
    public boolean Continue(boolean value)
    {
    	this.Continue_D = value;
    	return true;
    }

    protected boolean Continue_D;
    
    public String ClassServerFilePath()
    {
        return this.ClassServerFilePath_D;
    }
    
    public boolean ClassServerFilePath(String value)
    {
        this.ClassServerFilePath_D = value;
        return true;
    }
    
    protected String ClassServerFilePath_D;
    
    public int NetworkPortServer()
    {
        return this.NetworkPortServer_D;
    }
    
    public boolean NetworkPortServer(int value)
    {
        this.NetworkPortServer_D = value;
        return true;
    }
    
    protected int NetworkPortServer_D;
    
    private ServerSocket NetworkServer;
    private Socket Network;
    
    private Process Process;

    private OutputStream Out;
    private InputStream Inn;

    private ClassRead ClassRead;

    private int Status;

    private byte[] SizeData;

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
	
	                        classRead.Data(dataA);
	
	                        classRead.Execute();	                        

	                        Root a;
	                        a = new Root();
	                        a.Init();
	
	                        Class varClass;
	                        varClass = classRead.Class();
	
//	                        Log.This().Info("DocumentThread class read is null: " + (varClass == null));
	                        
	                        a.Class(varClass);
	
	                        oo.Load().Root(a);
	
	                        classRead.Class(null);
	                        classRead.Data(null);
	                        
                            if (!(varClass == null))
                            {
                                this.SetCompLabel(varClass.Comp());
                            }
	                        
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
    
    private boolean SetCompLabel(Comp[] array)
    {
        Infra infra;
        infra = Plugin.This().Infra();
        
        int count;
        count = array.length;
        int i;
        i = 0;
        while (i < count)
        {
            Comp a;
            a = array[i];
            
            String name;
            name = infra.NameLabel(a.Name());
            
            String varClass;
            varClass = infra.ClassLabel(a.Class());
            
            String label;
            label = name + " : " + varClass;
            
            a.Label(label);
            
            i = i + 1;
        }
        
        return true;
    }

    private boolean UpdateOutline(Document o)
    {
        OutlineUpdateJob job;
        job = new OutlineUpdateJob();
        job.Init();
        job.Document(o);

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
    
    private boolean InnReadData(byte[] data, int index, int count)
    {
        int indexA;
        int countA;
        indexA = index;
        countA = count;
        
        while (0 < countA)
        {
            int ka;
            ka = 0;
            try
            { 
                ka = this.Inn.read(data, indexA, countA);
                
            } catch (IOException e)
            {
                Log.This().Error("Network inn read data exception error", e);
                this.Status = 11;
                return false;
            }
            
            if (ka == -1)
            {
                Log.This().Error("Network inn read data end of file error", null);
                this.Status = 12;
                return false;
            }
            
            indexA = indexA + ka;
            countA = countA - ka;
        }
        
        return true;
    }

    private byte[] InnRead()
    {
        boolean b;
        b = this.InnReadData(this.SizeData, 0, this.SizeData.length);
        if (!b)
        {
            return null;
        }

        ByteBuffer o;
        o = ByteBuffer.wrap(this.SizeData);

        o.order(ByteOrder.LITTLE_ENDIAN);

        int count;
        count = o.getInt(0);

        byte[] data;
        data = new byte[count];

        b = this.InnReadData(data, 0, data.length);
        if (!b)
        {
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
    	
        String aa;
        aa = this.ClassServerFilePath();
        
    	String k;
    	k = String.valueOf(this.NetworkPortServer());
    	
    	ArrayList<String> list;
    	list = new ArrayList<String>();
    	
    	list.add(aa);
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
        	
            server = new ServerSocket(this.NetworkPortServer());

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
