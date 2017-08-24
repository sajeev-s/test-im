package hello.bo;

public class EventData {

	String name;
	Object value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = null; 
		if(name!=null){
			builder = new StringBuilder();
			builder.append("");
		}
		
		
		
		return builder.toString();
	}
	
	

}
