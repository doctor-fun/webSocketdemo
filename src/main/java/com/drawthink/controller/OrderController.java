package com.drawthink.controller;

import com.drawthink.common.vo.JsonResult;
import com.drawthink.pojo.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class OrderController {

//用模板发送命令
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;


	//交互
	@MessageMapping("/register")
	@SendTo("/topic/confirmMsg")
	public JsonResult receive(JsonResult jsonResult) throws Exception {
		HelloMessage data = (HelloMessage)jsonResult.getData();
		System.out.println(data.getName()+" 连上来了 ");

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String formatTime = sdf.format(date);
		JsonResult jsonResult1 = new JsonResult(0, "server2robot", new ConfirmMessage("Registration Successful", formatTime));
		return jsonResult1;
	}
	@MessageMapping("/locationReq")
	public void locationService(JsonResult jsonResult){
		//说明是正常的点的请求
		if(jsonResult.getState()==1) {
			LocationReq locationReq = (LocationReq) jsonResult.getData();
			//说明是正常的位置请求
			//处理它
			TaskPointDevice taskPointDevice = new TaskPointDevice(1, 1, "10.10.10.10:9000", "2020.03.17 19:25:20");
			List<TaskPointDevice> devices = new LinkedList<>();
			devices.add(taskPointDevice);
			TaskPointBean point1 = new TaskPointBean(locationReq.getLocationId(), 0.1, 0.1, 0.1, 40.0f, 10, "你好", 1, devices);

			simpMessagingTemplate.convertAndSend("/topic/locPublish", new JsonResult(1, "send first point1", point1));
		}

	}


	/**
	 * 先发要发送的节点个数
	 * @param
	 */

	@RequestMapping("/pointSend")
	@ResponseBody
	public void sendPoint(Integer number){

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String formatTime = sdf.format(date);
		JsonResult server2robot = new JsonResult(1, "begin", new ConfirmMessage(number.toString(), formatTime));
		simpMessagingTemplate.convertAndSend("/topic/locPublish",server2robot);

		//处理它
		TaskPointDevice taskPointDevice = new TaskPointDevice(1,1,"10.10.10.10:9000","2020.03.17 19:25:20");
		List<TaskPointDevice> devices=new LinkedList<>();
		devices.add(taskPointDevice);
		TaskPointBean point1 = new TaskPointBean(1, 0.1, 0.1, 0.1, 40.0f, 10, "你好", 1, devices);

		simpMessagingTemplate.convertAndSend("/topic/locPublish", new JsonResult(1,"send second point2",point1));


		String formatTime2 = sdf.format(date);
		JsonResult end = new JsonResult(1, "end", new ConfirmMessage("0", formatTime2));
		simpMessagingTemplate.convertAndSend("/topic/locPublish",server2robot);



	}


	@RequestMapping("/DirectionSend")
	@ResponseBody
	public void sendDirection(DirectionMove direction ){

		JsonResult suibian = new JsonResult(1, "suibian", direction);

		simpMessagingTemplate.convertAndSend("/topic/directionRec",suibian);
	}

}
