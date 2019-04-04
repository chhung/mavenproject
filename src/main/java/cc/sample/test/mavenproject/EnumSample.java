package cc.sample.test.mavenproject;

import java.util.EnumSet;
import java.util.function.Consumer;

enum MapEnum {
	MIS(10), NET(22), DOCKER("docker"), BOOK("o'reilly"), LIGHT("ikea"), DESK(87), COMPUTER(1);
	
	private int value = 0;
	private String name = "";
	
	MapEnum(int v) {
		value = v;
	}
	
	MapEnum(String s) {
		name = s;
	}
	
	public String getDescription() {
		switch (this) {
		case MIS:
		case NET:
		case DESK:
		case COMPUTER:
			return String.valueOf(value);
			
		case DOCKER:
		case BOOK:
		case LIGHT:
			return name;
		}
		
		return "";
	}
}

enum VerEnum {
	V304("304"), V305("305"), V306("306"), V307("307");
	
	private String version = "";
	
	VerEnum(String s) {
		this.version = s;
	}
	
	public String getVersion() {
		return version;
	}
}

interface Features {
	// 只要定義基本行為, 供enum使用
	public String getVersion();
}

enum VerEnumV2 implements Features {
	V304, V305, V306, V307;

	@Override
	public String getVersion() {
		switch (this) {
		case V304 : return "304";
		case V305 : return "305";
		case V306 : return "306";
		case V307 : return "307";
		default :	return "didn't define in here.";
		}
	}
}

class Gothrough implements Consumer<MapEnum> {
	@Override
	public void accept(MapEnum t) {
		System.out.println(t.toString() + ":" + t.getDescription());
	}
}

public class EnumSample {

	public static void main(String[] args) {
		MapEnum m = MapEnum.MIS;
		System.out.println("toString() = " + m.toString());
		System.out.println("*******************************");
		
		System.out.println("toString() = " + VerEnum.V305.toString());
		System.out.println("getVersion() = " + VerEnum.V305.getVersion());
		System.out.println("*******************************");
		
		VerEnum v = VerEnum.V307;
		System.out.println("toString() = " + v.toString());
		System.out.println("getVersion() = " + v.getVersion());
		System.out.println("*******************************");
		
		for (VerEnumV2 e : VerEnumV2.values())
			System.out.println("getVersion() = " + e.getVersion());
		System.out.println("*******************************");
		
		EnumSet<VerEnumV2> t = EnumSet.allOf(VerEnumV2.class);
		System.out.println("is true = " + t.contains(VerEnumV2.V304));
		System.out.println("*******************************");
		
		EnumSet<MapEnum> t2 = EnumSet.of(MapEnum.DOCKER, MapEnum.NET, MapEnum.LIGHT, MapEnum.DESK);
		System.out.println("we add the command below: [constant:description]");
		t2.forEach(new Gothrough());
		System.out.println("---------------------");
		System.out.println("Is NET include in? " + t2.contains(MapEnum.NET));
		System.out.println("Is MIS include in? " + t2.contains(MapEnum.MIS));
		System.out.println("Is DOCKER include in? " + t2.contains(MapEnum.DOCKER));
		System.out.println("Is COMPUTER include in? " + t2.contains(MapEnum.COMPUTER));
		System.out.println("*******************************");
	}
}
