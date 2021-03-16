package org.changli.covermanager.controller;

import java.util.List;

import org.changli.covermanager.entity.MapResult;
import org.changli.covermanager.mapper.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunctionController {

	@Autowired
	private FunctionMapper functionMapper;
	
	@RequestMapping("/allCoverAlarm")
	/**
	 * 获取所有的井盖cover
	 * @return MapResult列表
	 */
	public List<MapResult> allCover() {
		List<MapResult> users=functionMapper.selectAll();
		return users;
	}
	
	@RequestMapping("/coverAlarm")
	/**
	 * 获取所有的井盖cover
	 * @return MapResult
	 */
	public MapResult coverAlarm(@RequestParam(value = "coverID")String coverID) {
		MapResult users=functionMapper.selectOne(coverID);
		return users;
	}
	
}
