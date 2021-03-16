package org.changli.covermanager.controller;

import java.util.List;

import org.changli.covermanager.entity.Alarm;
import org.changli.covermanager.mapper.AlarmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlarmController {

	@Autowired
	private AlarmMapper alarmMapper;
	
	@RequestMapping("/getAlarms")
	/**
	 * 获取所有的报警信息alarm
	 * @return Alarm列表
	 */
	public List<Alarm> getAlarms() {
		List<Alarm> alarms=alarmMapper.selectAll();
		return alarms;
	}
	
    @RequestMapping("/getAlarm")
	/**
	 * 根据井盖coverID来查找对应的报警信息，同一个ID可能存在多条报警信息
	 * @param coverID 输入的ID编号
	 * @return 对应的报警信息Alarm列表
	 */
    public List<Alarm> getAlarm(@RequestParam(value = "coverID")String id) {
    	List<Alarm> alarm=alarmMapper.selectAlarm(id);
        return alarm;
    }
    
    @RequestMapping("/getOneAlarm")
	/**
	 * 根据井盖coverID来查找对应的报警信息，同一个ID可能存在多条报警信息
	 * @param coverID 输入的ID编号
	 * @return 对应的报警信息Alarm列表
	 */
    public Alarm getAlarm(@RequestParam(value = "coverID")String id, @RequestParam(value = "current")String current) {
    	Alarm alarm=alarmMapper.selectOneAlarm(id, current);
        return alarm;
    }
    
    @RequestMapping("/insertAlarm")
	/**
	 * 插入一条报警信息Alarm，时间的形式 yyyy-MM-dd hh:mm:ss
	 * @param alarms 报警信息
	 */
    public String insertAlarm(Alarm alarms) {
    	if(alarms.isValid()) {		//检验数据是否合格
    		try {
    			alarmMapper.insert(alarms);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您添加报警信息的的井盖编号不存在，请更改井盖编号后重新尝试";
    		}
    		return "添加成功";
    	}else {
    		return "您添加的报警信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="updateAlarm")
    /**
     * 更新一条报警信息Alarm
     * @param alarms 报警信息
     */
    public String updateAlarm(Alarm alarms) {
    	if(alarms.isValid()) {		//检验数据是否合格
    		try {
    			alarmMapper.update(alarms);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您更改报警信息的井盖编号不存在，请更改井盖编号后重新尝试";
    		}
    		return "更改成功";
    	}else {
    		return "您更改的报警信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="/delete/OneAlarm")
    /**
     * 根据id和对应的时间来删除一条报警信息Alarm
     * @param id 对应的井盖编号
     * @param current 对应的时间
     */
    public Alarm deleteAlarm(@RequestParam(value = "coverID")String id, @RequestParam(value = "current")String current) {
    	Alarm alarm=alarmMapper.selectOneAlarm(id, current);		//根据id进行查找
    	if(alarm==null){		//如果数据库中不存在
    		return null;
    	}else {
    		alarmMapper.deleteOne(id, current);	//删除该数据
    		return alarm;		//返回被删除的数据信息
    	}
    }
    
    @RequestMapping(value="/delete/Alarms")
    /**
     * 根据id来删除id对应的一组报警信息
     * @param id 对应的井盖编号
     */
    public List<Alarm> deleteAlarm(@RequestParam(value = "coverID")String id) {
    	List<Alarm> alarm=alarmMapper.selectAlarm(id);		//根据id进行查找
    	if(alarm==null){		//如果数据库中不存在
    		return null;
    	}else {
    		alarmMapper.delete(id);	//删除该数据
    		return alarm;		//返回被删除的数据信息
    	}
    }
    
}
