package com.learning.storejavafxjdbc.model.dao.impl;

import com.learning.storejavafxjdbc.db.DB;
import com.learning.storejavafxjdbc.db.DbException;
import com.learning.storejavafxjdbc.model.dao.DepartmentDao;
import com.learning.storejavafxjdbc.model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES " +
                            "(?)",
                        Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, department.getName());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE department SET Name = ? WHERE Id = ?"
            );

            st.setString(1, department.getName());
            st.setInt(2, department.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT department.* FROM department WHERE department.Id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("Id"));
                department.setName(rs.getString("Name"));
                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatment(st);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT department.* FROM department ORDER BY Name");

            rs = st.executeQuery();

            List<Department> departments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("Id"));
                department.setName(rs.getString("Name"));
                departments.add(department);
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatment(st);
        }
    }
}
