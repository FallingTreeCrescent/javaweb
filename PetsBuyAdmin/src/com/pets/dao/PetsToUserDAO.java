package com.pets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pets.dto.OrderDTO;
import com.pets.dto.PetsDTO;
import com.pets.dto.PetsToUserDTO;
import com.pets.dto.UserDTO;
import com.pets.service.UserService;
import com.pets.utls.JDBCUtils;

public class PetsToUserDAO {
	

	

	public static PetsToUserDTO toModel(ResultSet rs) throws SQLException
	{
		PetsToUserDTO petsUser = new PetsToUserDTO();
	    petsUser.setIsDeleted(rs.getBoolean("isDeleted"));
        petsUser.setUsername(rs.getString("username"));
        petsUser.setPetsName(rs.getString("petsname"));
        petsUser.setAddress(rs.getString("address"));
        petsUser.setLocal(rs.getString("local"));
        petsUser.setPhone(rs.getString("phone"));
        petsUser.setRname(rs.getString("rname"));
        petsUser.setSale(rs.getString("sale"));
        petsUser.setId(rs.getLong("id"));
        return petsUser;
	}

	
	public PetsToUserDTO[] getAll() {

		List<PetsToUserDTO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_petstousers where  isDeleted = false");
			while (rs.next()) {
				list.add(toModel(rs));
			}
			return list.toArray(new PetsToUserDTO[list.size()]);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeAll(rs);
		}
		/*
		 * select a.* from t_admins u left join t_addresses a on u.id=a.adminid where adminid = 1
		 */
		/*
		 * #选中 所有商品
select p.*,u.name from t_orders o left join t_pets p on p.id = o.petsid
left join t_users u on u.id = o.userid
where o.isDeleted = false
		 */
		/*
		 * select p.*,u.name as username from t_orders o 
left join t_pets p on p.id = o.petsid
left join t_users u on u.id = o.userid
left join t_addresses a on a.userid = u.id
where o.isDeleted = false and a.isEnable = true

		 */
		/*
		sb.append("  select p.*,a.*,u.name as username from t_orders o ");
		sb.append(" left join t_pets p on p.id = o.petsid  ");
		sb.append(" left join t_users u on u.id = o.userid  ");
		sb.append(" left join t_addresses a on a.userid = u.id where ");
		sb.append(" o.isDeleted = false and  a.isEnable = true");
		List<PetsToUserDTO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery(sb.toString());
			while (rs.next()) {
				list.add(toModel(rs));
			}
			return list.toArray(new PetsToUserDTO[list.size()]);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeAll(rs);
		}

		*/
		
		
		
		
	}


	public void fahuo(Long id) {
		if(id==null)
		{
			throw new IllegalArgumentException("错误");
		}
        try {
			JDBCUtils.executeNonQuery("update t_petstousers set isDeleted = true where id =?",id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	
	
}
