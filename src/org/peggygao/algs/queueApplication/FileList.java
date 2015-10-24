package org.peggygao.algs.queueApplication;

import java.io.File;

import org.peggygao.algs.collections.Queue;

public class FileList
{

	
	public static void list(File dir,int level)
	{
		
		
		File[] files = dir.listFiles();
		
		for(File f:files)
		{
			
			if(f.isDirectory())
			{
				for(int i = 1; i < level; i++)
				{
					System.out.print("	");
				}
				System.out.println(f.getName());
				list(f,level+1);
			}
			else{
				for(int i = 1; i < level; i++)
				{
					System.out.print("	");
				}
				System.out.println(f.getName());
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		list(new File("D:\\movie"),1);
	}

}
