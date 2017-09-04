package hello;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.bo.EventData;
import hello.bo.IMRequest;
import hello.bo.Parameter;
import it.sella.bg.poll.dto.PollMessage;

@Controller
public class HelloWorldController {

	Map<String, List<PollMessage>> map = new HashMap<String, List<PollMessage>>();

	@RequestMapping(value="/chatresult", method = {RequestMethod.POST})
	public @ResponseBody String chatresult(@RequestBody IMRequest imRequest){

		System.out.println(imRequest.getAction());
		System.out.println(imRequest.getChatid());
		System.out.println(imRequest.getIdevent());
		final List<EventData> datas = imRequest.getEventdata();
		if(datas!=null){
			System.out.println("Event Data -->");
			for (final EventData eventData : datas) {
				System.out.println(eventData.getName()+"="+eventData.getValue());
			}
		}


		final List<Parameter> parameters = imRequest.getParameters();
		if(parameters!=null){
			System.out.println("parameter -->");
			for (final Parameter parameter : parameters) {
				System.out.println(parameter.getName()+"="+parameter.getValue());
			}
		}
		System.out.println("##################################################");

		List<PollMessage> polls = this.map.get(imRequest.getChatid());
		if(polls==null){
			polls = new ArrayList<PollMessage>();
			this.map.put(imRequest.getChatid(), polls);
		}

		for (final EventData eventData : imRequest.getEventdata()) {
			if("message".equals(eventData.getName())){
				if(imRequest.getChatid()!=null){
					final PollMessage pollMessage = new PollMessage();
					pollMessage.setSender("BOT");
					pollMessage.setMessage((String)eventData.getValue());
					polls.add(pollMessage);
				}
			}
		}

		return "OK -->"+LocalDateTime.now();
	}

	@RequestMapping(value="/message", method = {RequestMethod.POST})
	public @ResponseBody String message(@RequestBody IMRequest imRequest){
		List<PollMessage> polls = this.map.get(imRequest.getChatid());
		if(polls==null){
			polls = new ArrayList<PollMessage>();
			this.map.put(imRequest.getChatid(), polls);
		}

		final List<EventData> eventDatas = imRequest.getEventdata();
		if(eventDatas!=null){
			for (final EventData eventData : eventDatas) {
				final PollMessage pollMessage = new PollMessage();
				pollMessage.setSender("Client");
				pollMessage.setMessage((String)eventData.getValue());
				final List<PollMessage> pollMessages = this.map.get(imRequest.getChatid());
				pollMessages.add(pollMessage);
			}}

		return "OK -->"+LocalDateTime.now();
	}

	@RequestMapping(value="/poll", method = {RequestMethod.POST})
	public @ResponseBody List<PollMessage> poll(@RequestBody IMRequest imRequest){
		System.out.println("Inside poll -->");
		return (List<PollMessage>) this.map.get(imRequest.getChatid());
	}


}
