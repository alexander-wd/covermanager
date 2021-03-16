package org.changli.covermanager.controller;

import java.util.List;

import org.changli.covermanager.entity.Work_record;
import org.changli.covermanager.mapper.Work_recordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Work_recordController {

	@Autowired
	private Work_recordMapper work_recordMapper;
	
	@RequestMapping("/getWork_records")
	/**
	 * 获取所有的工作记录信息Work_record
	 * @return Work_records 工作记录列表
	 */
	public List<Work_record> getWork_records() {
		List<Work_record> Work_records=work_recordMapper.selectAll();
		return Work_records;
	}
	
    @RequestMapping("/getWork_record")
	/**
	 * 根据维修编号maintenanceID来查找对应的维修记录
	 * @param maintenanceID 输入的维修编号
	 * @return 对应的维修记录Work_record
	 */
    public Work_record getWork_record(@RequestParam(value = "maintenanceID")String maintenanceID) {
    	Work_record Work_record=work_recordMapper.selectWork_record(maintenanceID);
        return Work_record;
    }
    
    @RequestMapping("/insertWork_record")
	/**
	 * 插入一条维修记录Work_record
	 * @param Work_record 维修记录
	 */
    public String insertWork_record(Work_record work_record) {
    	if(work_record.isValid()) {		//检验数据是否合格
    		try {
    			work_recordMapper.insert(work_record);
    		}catch(Exception e) {		//捕获异常，由于外键引用以及唯一键约束
    			return "您添加的维修编号错误，请更改维修编号后重新尝试";
    		}
    		return "添加成功";
    	}else {
    		return "您添加的维修记录错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="updateWork_record")
    /**
     * 更新一条维修记录Work_record
     * @param Work_record 维修记录
     */
    public String updateWork_record(Work_record work_record) {
    	if(work_record.isValid()) {		//检验数据是否合格
    		try {
    			work_recordMapper.update(work_record);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您更改的维修编号不存在，请更改维修编号后重新尝试";
    		}
    		return "更改成功";
    	}else {
    		return "您更改的维修记录错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="/delete/Work_record")
    /**
     * 根据维修编号maintenanceID来删除一条维修记录Work_record
     * @param maintenanceID 对应的维修编号maintenanceID
     */
    public Work_record delete(@RequestParam(value = "maintenanceID") String maintenanceID) {
    	Work_record work_record = work_recordMapper.selectWork_record(maintenanceID);		//根据id进行查找
    	if(work_record==null){		//如果数据库中不存在
    		return null;
    	}else {
    		work_recordMapper.delete(maintenanceID);	//删除该数据
    		return work_record;		//返回被删除的数据信息
    	}
    }
	
}
