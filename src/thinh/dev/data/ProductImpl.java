package thinh.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl {
	private Connection conn;

	public ProductImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public ProductImpl(int id, String name, String description, String thumbnail, double price, int quantity, int view,
			int categoryId, Timestamp createdAt) {
		// TODO Auto-generated constructor stub
	}

	public int insert() {
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "Ao Nu");
            stmt.setString(2, "product Description");
            stmt.setString(3, "product Thumbnail");
            stmt.setDouble(4, 100);
            stmt.setInt(5, 10);
            stmt.setInt(6, 1);

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            return generatedKey;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
	public boolean update() {
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "product Name");
		    stmt.setString(2, "product Description");
		    stmt.setString(3, "product Thumbnail");
		    stmt.setDouble(4, 100);
		    stmt.setInt(5, 10);
		    stmt.setInt(6, 1);
            stmt.setInt(7,1);

            return stmt.execute();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);

            return stmt.execute();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	public void find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public void findAll() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public List<ProductImpl> hot(int limit) {
	    String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";
	    List<ProductImpl> proList = new ArrayList<>();
	    
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, limit);

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String description = rs.getString("description");
	            String thumbnail = rs.getString("thumbnail");
	            double price = rs.getDouble("price");
	            int quantity = rs.getInt("quantity");
	            int view = rs.getInt("view");
	            int categoryId = rs.getInt("category_id");
	            Timestamp createdAt = rs.getTimestamp("created_at");

	            // Create Product object and add it to proList
	            ProductImpl product = new ProductImpl(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt);
	            proList.add(product);

	            // Print out the product details
	            System.out.format("%d: %s: %s: %s: %.2f: %d: %d: %d: %s%n", 
	                    id, name, description, thumbnail, price, quantity, view, categoryId, createdAt);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return proList;
	}
	public void findByCategory(int categoryId) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public void filter(int categoryId, String propertyName, String order) {
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY ? ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, propertyName);
            stmt.setString(3, order);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
