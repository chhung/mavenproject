package cc.sample.test.mavenproject;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class abc {
	public void method1() {
		System.out.println("this is method of parent");
	}
}

class network extends abc {
	public void method() {
		System.out.println("this is method of child");
	}
	
	@Override
	public void method1() {
		System.out.println("this is method1 of network");
	}
}

class Gen<T> {
	//static List<T> glist = new ArrayList<T>();
	
	public T getInfo(T t) {
		return t;
	}
}

enum Level {
	ABS, BALL, CLOS, DEL, EAT, FULL;
	
	public String getVersion() {
		String ver = "";
		
		switch (this) {
		case ABS:
			ver = "304";
			break;
			
		case BALL:
			ver = "305";
			break;
			
		case CLOS:
			ver = "306";
			break;
			
		case DEL:
			ver = "308";
			break;
			
		case EAT:
			ver = "309";
			break;
		
		case FULL:
			ver = "310";
			break;
		default:
			break;
		}
		
		return ver;
	}
}

enum ErrorCode {IO, NULLP, ILLEG_ARG, NET_CON_FAIL}


public class App {
	private static final Logger logger = LogManager.getLogger(HelloWorld.class);
	

	public void testEnumMap() {
		EnumMap<ErrorCode, String> errMsg = new EnumMap<ErrorCode, String>(ErrorCode.class);
		
		errMsg.put(ErrorCode.IO, "IO Execption");
		errMsg.put(ErrorCode.NULLP, "There is null pointer");
		errMsg.put(ErrorCode.ILLEG_ARG, "Wrong arguments");
		errMsg.put(ErrorCode.NET_CON_FAIL, "Network connection fail");
		
		for (ErrorCode s : ErrorCode.values()) {
			System.out.println(errMsg.get(s));
		}
	}
	
	public void testEnum(Level v) {
		System.out.println(v.toString());
		
	}
	
	public static void main( String[] args ) {
		
		new App().testEnumMap();
		
        new App().testEnum(Level.ABS);
        System.out.println(Level.valueOf(Level.class, "CLOS"));
        for (Level v : Level.values())
        	System.out.println(v.toString());
        
        for (Level v : Level.values())
        	System.out.println(v.getVersion());
        
        System.out.println(Level.EAT.getVersion());

        new App().testCasting(new network());
        
        List<String> list = new ArrayList<String>();
        list.add("1");
        List genList = list;
       // Integer i = (Integer) genList.get(0);
        //System.out.println("i = " + i);
        System.out.println(new Gen<String>().getInfo("knowing"));
    }
    
    public void testCasting(abc c) {
    	network net = (network)c;
    	net.method1();
    	logger.debug("test pass");
    }
}
