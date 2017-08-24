package hello;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.bo.EventData;
import hello.bo.IMRequest;
import hello.bo.Parameter;

@Controller
@RequestMapping("/chatresult")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String webhook(@RequestBody IMRequest imRequest){

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
		return "OK -->"+LocalDateTime.now();
	}


}
