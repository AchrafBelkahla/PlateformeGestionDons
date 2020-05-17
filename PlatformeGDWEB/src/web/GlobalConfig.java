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
	public static String from = "achraf0587@gmail.com";
	public static  boolean auth = true;
	public static boolean secureConnection = true;
	public static String username = "achraf0587@gmail.com";
	public static String password = "infoenit46";
	public static GlobalConfig.Protocol protocol = Protocol.SMTPS;
//	private boolean debug = true;

}
