package screens;

import services.MySqlService;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryScreen extends JFrame {

    private MySqlService mySqlService = null;

    public CategoryScreen() {
        super("Category List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        mySqlService = new MySqlService(
            "localhost:3306",
            "javadb",
            "root",
            ""
        );

        initUI();
    }

    public void initUI() {
        JPanel pContent = new JPanel();
        pContent.setLayout(new FlowLayout());

        JButton btnCategories = new JButton("Category List");
        btnCategories.addActionListener(e -> {
            Statement stm = null;
            try {
                stm = mySqlService.getConnection();
                ResultSet resultSet = stm.executeQuery("SELECT * FROM categories;");
                while (resultSet.next()) {
                    System.out.println(
                        "id: " + resultSet.getInt(1) +
                        ", name: " + resultSet.getString(2)
                    );
                }
                mySqlService.closeConnection();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        pContent.add(btnCategories);

        JButton btnAddCategory = new JButton("New Category");
        btnAddCategory.addActionListener(e -> {
            Statement stm = null;
            try {
                stm = mySqlService.getConnection();
                String sql = "INSERT INTO categories(`name`) VALUES('Water');";
                int result = stm.executeUpdate(sql);
                System.out.println("Inserted = " + result);

                mySqlService.closeConnection();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        pContent.add(btnAddCategory);

        JButton btnEditCategory = new JButton("Edit Category");
        btnEditCategory.addActionListener(e -> {
            Statement stm = null;
            try {
                stm = mySqlService.getConnection();
                String sql = "UPDATE categories SET name='Water1' WHERE id=1";
                int result = stm.executeUpdate(sql);
                System.out.println("Updated = " + result);

                mySqlService.closeConnection();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        pContent.add(btnEditCategory);

        JButton btnDeleteCategory = new JButton("Delete Last Category");
        btnDeleteCategory.addActionListener(e -> {
            Statement stm = null;
            try {
                stm = mySqlService.getConnection();
                ResultSet lastRecordSet = stm.executeQuery("SELECT * FROM categories ORDER BY id desc LIMIT 1;");
                int deletedId = 0;
                while (lastRecordSet.next()) {
                    deletedId = lastRecordSet.getInt(1);
                }
                if (deletedId > 0) {
                    String sql = "DELETE FROM categories WHERE id=" + deletedId;
                    int result = stm.executeUpdate(sql);
                    System.out.println("Deleted = " + result);
                }

                mySqlService.closeConnection();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        pContent.add(btnDeleteCategory);

        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        borderLayout.setVgap(10);
        super.setLayout(borderLayout);
        super.add(pContent, BorderLayout.CENTER);
    }

    public void display() {
        super.setVisible(true);
    }
}
