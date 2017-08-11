package com.lanou.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.Message;
import com.lanou.mapper.MessageMapper;

@Controller
public class MainTest {
	@Resource
	public MessageMapper mapper;
	public Message message;

	@RequestMapping(value = "/")
	public String findPage() {

		Message message = mapper.selectByPrimaryKey(1);
		//

		System.out.println(message);

		return "messageBoard";
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Message> findAll() {
		List<Message> messageList = new ArrayList<Message>();

		messageList = mapper.serlectAllmessage();

		return messageList;
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public Map<String, Object> insertMessage(Message mess) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (mess.getContent().equals("") || mess.getContent() == null) {
			map.put("msg", "亲，内容不能为空");
			return map;

		} else {
			mess.setDown(0);
			mess.setUp(0);
			mapper.insert(mess);

			map.put("result", mess);
			map.put("msg", "添加成功");
			map.put("errorrCode", 0);

			return map;
		}
	}

	@RequestMapping(value = "/deletone")
	@ResponseBody
	public Map<String, Object> deledtMessag(@RequestParam("msdid") Integer id) {

		Integer num = mapper.deleteByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("obj", id);
		map.put("msg", "删除成功");
		map.put("errorrCode", num);

		return map;

	}

	@RequestMapping(value = "/up")
	@ResponseBody
	public Map<String, Object> turnUp(@RequestParam("upId") Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();

		Message message = mapper.selectByPrimaryKey(id);
		message.setUp(message.getUp() + 1);
		mapper.updateByPrimaryKey(message);
		map.put("message", message);
		return map;
	}

	@RequestMapping(value = "/down")
	@ResponseBody
	public Map<String, Object> turnDwon(@RequestParam("downId") Integer id) {

		Map<String, Object> map = new HashMap<String, Object>();

		Message mess = mapper.selectByPrimaryKey(id);
		mess.setDown(mess.getDown()+1);
		mapper.updateByPrimaryKey(mess);

		map.put("mess", mess);
		return map;
	}

	public MessageMapper getMapper() {
		return mapper;
	}

	public void setMapper(MessageMapper mapper) {
		this.mapper = mapper;
	}

}
