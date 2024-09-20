package thinh.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.PreparableStatement;

import quoc.dev.data.CategoryImpl;
import quoc.dev.data.Order_itemsImpl;
import quoc.dev.data.OrdersImpl;
import quoc.dev.data.ProductImpl;
import quoc.dev.data.UserImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class MainApp {

	public static void main(String[] args) {
		
		Connection conn = getConnection();
		CategoryImpl categoryImpl = new CategoryImpl(conn);
		categoryImpl.insert();
		categoryImpl.update();
		categoryImpl.delete();
		categoryImpl.select();
		categoryImpl.find();
		
		UserImpl userImpl = new UserImpl(conn);
//		userImpl.insert();
//		userImpl.update();
//		userImpl.delete(0);
//		userImpl.find(0);
//		userImpl.findAll();
		
		ProductImpl producImpl = new ProductImpl(conn);
//		producImpl.insert();
//		producImpl.update();
//		producImpl.delete(0);
//		producImpl.find(0);
//		producImpl.findAll();
//		producImpl.hot(0);
//		producImpl.findByCategory(0);
//		producImpl.filter(0, null, null);
		
		OrdersImpl ordersImpl =  new OrdersImpl(conn);
//		ordersImpl.insert(ordersImpl);
//		ordersImpl.delete(0);
//		ordersImpl.find(0);
//		ordersImpl.findAll();
//		ordersImpl.findByUser(0);
//		ordersImpl.findByCode(null);
//		ordersImpl.findByStatus(null);
		
		Order_itemsImpl order_itemsImpl = new Order_itemsImpl(conn);
		order_itemsImpl.insert();
		order_itemsImpl.delete(0);
		order_itemsImpl.find(0);
		order_itemsImpl.findAll();
		order_itemsImpl.findByOder(0);
		
	}

	private static Connection getConnection() {
		final String BD_URL = "jdbc:mysql://localhost:3306/shop";
		final String USER = "root";
		final String PASS = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(BD_URL, USER, PASS);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}