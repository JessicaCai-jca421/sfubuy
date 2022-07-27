package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import domain.Lunbo;

public class LunboDao
{
	private QueryRunner qr=new TxQueryRunner();
	
	public void delete(String no) throws SQLException {
		String sql = "delete from 轮播图片表 where imageNo=?";
		qr.update(sql, no);
	}
	
	public List<Lunbo> lunBo() throws SQLException
	{
		String sql ="select * from 轮播图片表";        
		
     
        List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler());
        return toCartItemList(mapList);
	}
	
	public void add(Lunbo lunbo) throws SQLException
	{
		String sql = "insert into 轮播图片表(imageNo,image) values(?,?)";
		Object[] params = {lunbo.getImageNo(),lunbo.getImage()};
		qr.update(sql, params);
	}
	private Lunbo toCartItem(Map<String,Object> map) {
		if(map == null || map.size() == 0) return null;
		
		Lunbo lunbo = CommonUtils.toBean(map, Lunbo.class);
		
		return lunbo;
	}

	private List<Lunbo> toCartItemList(List<Map<String,Object>> mapList) {
		List<Lunbo> lunboList = new ArrayList<Lunbo>();
		for(Map<String,Object> map : mapList) {
			Lunbo lunbo = toCartItem(map);
			lunboList.add(lunbo);
		}
		return lunboList;
	}
}
