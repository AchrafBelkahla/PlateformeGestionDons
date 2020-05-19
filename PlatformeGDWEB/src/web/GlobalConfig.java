package web;

import web.GlobalConfig.Protocol;

public class GlobalConfig 
{
	public static final int recordsPerPage = 7;
	public enum Protocol {
	    SMTP,
	    SMTPS,
	    TLS
	}
	public static int port = 465;
	public static String host = "smtp.gmail.com";
	public static String from = "gestiondons2020@gmail.com";
	public static  boolean auth = true;
	public static boolean secureConnection = true;
	public static String username = "gestiondons2020@gmail.com";
	public static String password = "gestiondons123$";
	public static GlobalConfig.Protocol protocol = Protocol.SMTPS;
//	private boolean debug = true;

}
