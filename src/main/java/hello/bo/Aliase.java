package hello.bo;

public class Aliase {

	String Concept;
	String token;
	String value;

	public String getConcept() {
		return Concept;
	}

	public void setConcept(final String concept) {
		Concept = concept;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("$Concept-->").append(Concept).append("$token-->").append(token).append("$value-->")
				.append(value);

		return builder.toString();
	}

}
