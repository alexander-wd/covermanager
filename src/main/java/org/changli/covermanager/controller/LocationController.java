package org.changli.covermanager.controller;

import java.util.List;

import org.changli.covermanager.entity.Location;
import org.changli.covermanager.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

	@Autowired
	private LocationMapper locationMapper;
	
	@RequestMapping("/getLocations")
	/**
	 * 获取所有的位置信息Location
	 * @return Location 人员位置对象
	 */
	public List<Location> getLocations() {
		List<Location> locations=locationMapper.selectAll();
		return locations;
	}
	
    @RequestMapping("/getLocation")
	/**
	 * 根据人员编号personID来查找对应的人员
	 * @param personID 输入的人员编号
	 * @return 对应的人员位置Location
	 */
    public Location getLocation(@RequestParam(value = "personID")String personID) {
    	Location location=locationMapper.selectLocation(personID);
        return location;
    }
    
    @RequestMapping("/insertLocation")
	/**
	 * 插入一条人员位置信息Location
	 * @param location 人员位置
	 */
    public String insertLocation(Location location) {
    	if(location.isValid()) {		//检验数据是否合格
    		try {
    			locationMapper.insert(location);
    		}catch(Exception e) {		//捕获异常，由于外键引用以及唯一键约束
    			return "您添加的人员编号错误，请更改人员编号后重新尝试";
    		}
    		return "添加成功";
    	}else {
    		return "您添加的人员位置信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="updateLocation")
    /**
     * 更新一条人员位置信息Location
     * @param location 人员位置
     */
    public String update(Location location) {
    	if(location.isValid()) {		//检验数据是否合格
    		try {
    			locationMapper.update(location);
    		}catch(Exception e) {		//捕获异常，由于主键不能重复引起
    			return "您更改的人员编号不存在，请更改人员编号后重新尝试";
    		}
    		return "更改成功";
    	}else {
    		return "您更改的人员位置信息错误，请检查后重新尝试";
    	}
    }
    
    @RequestMapping(value="/delete/Location")
    /**
     * 根据personID来删除一条人员位置信息Location
     * @param personID 对应的人员编号
     */
    public Location delete(@RequestParam(value = "personID")String personID) {
    	Location location = locationMapper.selectLocation(personID);		//根据id进行查找
    	if(location==null){		//如果数据库中不存在
    		return null;
    	}else {
    		locationMapper.delete(personID);	//删除该数据
    		return location;		//返回被删除的数据信息
    	}
    }
	
}
