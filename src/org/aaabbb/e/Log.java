package org.aaabbb.e;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Log extends Any
{	
	public static Log This()
	{
		return This_D;
	}
	
	private static final Log This_D = ShareCreate();
	
	private static Log ShareCreate()
	{
		Log share;
		share = new Log();
		Any a;
		a = share;
        a.Init();
		return share;
	}
	
	public boolean Info(String message)
	{
		ExecuteLog(new Status(IStatus.INFO, Plugin.PLUGIN_ID, message, null));
		return true;
	}

	public boolean Error(String message, Exception ex)
	{
		ExecuteLog(new Status(IStatus.ERROR, Plugin.PLUGIN_ID, message, ex));
		return true;
	}

	private boolean ExecuteLog(IStatus status)
	{
		Plugin p;
		p = Plugin.This();
		p.getLog().log(status);
		return true;
	}
}