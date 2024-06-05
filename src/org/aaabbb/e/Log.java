package org.aaabbb.e;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Log
{	
	public static final Log This = ShareCreate();
	
	private static Log ShareCreate()
	{
		return new Log();
	}
	
	public int Info(String message)
	{
		ExecuteLog(new Status(IStatus.INFO, Plugin.PLUGIN_ID, message, null));
		return 0;
	}

	public int Error(String message, Exception ex)
	{
		ExecuteLog(new Status(IStatus.ERROR, Plugin.PLUGIN_ID, message, ex));
		return 0;
	}

	private int ExecuteLog(IStatus status)
	{
		Plugin p;
		p = Plugin.This();
		p.getLog().log(status);
		return 0;
	}
}