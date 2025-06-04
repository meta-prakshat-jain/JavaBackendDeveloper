package Package;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Order { 
    private int orderId;
    private Timestamp orderDate;
    private double totalAmount;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

class CategoryWithCount { 
    private String categoryTitle;
    private int childCount;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }
}

public class JdbcAssignment {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/storefront";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }


    public static List<Order> getShippedOrdersForUser(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT order_id, created_at, total_amount " +
                "FROM orders " +
                "WHERE user_id = ? AND status = 'Shipped' " +
                "ORDER BY created_at ASC";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setOrderDate(rs.getTimestamp("created_at"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                orders.add(order);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching orders: " + e.getMessage());
        }

        return orders;
    }

    public static void insertProductImages(int productId, List<String> imageUrls) {
        String sql = "INSERT INTO image (product_id, image_url) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            conn.setAutoCommit(false);
            for (String imageUrl : imageUrls) {
                pstmt.setInt(1, productId);
                pstmt.setString(2, imageUrl);
                pstmt.addBatch();
            }

            int[] affectedRows = pstmt.executeBatch();

            conn.commit();
            System.out.println("Inserted " + affectedRows.length + " images.");

        } catch (SQLException e) {
            System.err.println("Error inserting images: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Transaction rolled back.");
                } catch (SQLException ex) {
                    System.err.println("Error rolling back transaction: " + ex.getMessage());
                }
            }

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true); 
                    conn.close(); 
                }
            } catch (SQLException ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
            }
        }
    }

    
    public static List<CategoryWithCount> getParentCategoriesWithChildCount() {
        List<CategoryWithCount> results = new ArrayList<>();
        String sql = "SELECT c1.name AS parent_title, COUNT(c2.category_id) AS child_count " +
                "FROM category c1 " +
                "LEFT JOIN category c2 ON c1.category_id = c2.parent_category_id " +
                "WHERE c1.parent_category_id IS NULL " +
                "GROUP BY c1.category_id " +
                "ORDER BY c1.name ASC";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CategoryWithCount categoryData = new CategoryWithCount();
                categoryData.setCategoryTitle(rs.getString("parent_title"));
                categoryData.setChildCount(rs.getInt("child_count"));
                results.add(categoryData);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching categories: " + e.getMessage());
        }

        return results;
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
             List<Order> shippedOrders = getShippedOrdersForUser(1);
             System.out.println("Shipped Orders for User 1: " + shippedOrders.size());

             List<String> imageURLs = new ArrayList<>();
             imageURLs.add("product1_image1.jpg");
             imageURLs.add("product1_image2.jpg");
             insertProductImages(1, imageURLs);

//             int deletedProducts = deleteUnorderedProducts();
//             System.out.println("Deleted Products: " + deletedProducts);

             List<CategoryWithCount> parentCategories = getParentCategoriesWithChildCount();
             System.out.println("Parent Categories: " + parentCategories.size());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}