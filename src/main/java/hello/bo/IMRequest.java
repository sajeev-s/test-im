package hello.bo;

import java.util.List;

public class IMRequest {

	private String idevent;
	private String chatid;
	private String action;
	private List<EventData> eventdata;
	private List<Parameter> parameters;


	public String getIdevent() {
		return this.idevent;
	}

	public void setIdevent(String idevent) {
		this.idevent = idevent;
	}

	public String getChatid() {
		return this.chatid;
	}

	public void setChatid(String chatid) {
		this.chatid = chatid;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<EventData> getEventdata() {
		return this.eventdata;
	}

	public void setEventdata(List<EventData> eventdata) {
		this.eventdata = eventdata;
	}

	public List<Parameter> getParameters() {
		return this.parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("$eventId-->").append(this.idevent).append("$chatId-->").append(this.chatid).append("$action-->")
		.append(this.action).append("$eventdata-->");
		for (final EventData eventData2 : this.eventdata) {

		}
		//		builder.

		return builder.toString();
	}

}
