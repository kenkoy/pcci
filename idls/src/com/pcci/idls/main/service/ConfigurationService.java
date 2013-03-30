package com.pcci.idls.main.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;

public class ConfigurationService implements ServiceLifecycle {
	@Override
	public void init(Object arg0) throws ServiceException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	//authenticate
	public String getConfigService(String filename){
		String response = "";
		File file = new File("C:/config.xml");
		try {
			response = deserializeString(file);
		} catch (Exception e) {
			// TODO: handle exception
			response = "<serviceresponse><error><code>FileNotFound</code><message>Unable to locate config file</message></error></serviceresponse>";
		}
		
		
		return response;
	}
	
	public static String deserializeString(File file)
	  throws IOException {
	      int len;
	      char[] chr = new char[4096];
	      final StringBuffer buffer = new StringBuffer();
	      final FileReader reader = new FileReader(file);
	      try {
	          while ((len = reader.read(chr)) > 0) {
	              buffer.append(chr, 0, len);
	          }
	      } finally {
	          reader.close();
	      }
	      return buffer.toString();
	  }
}
