package br.developermobile.model.dao.impl;

import br.developermobile.db.DB;
import br.developermobile.db.DbException;
import br.developermobile.model.dao.DepartmentDao;
import br.developermobile.model.entities.Department;
import br.developermobile.model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    "INSERT INTO department "
                            + "(Name) "
                            + "VALUES "
                            + "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, department.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE department "
                            + "SET Name = ? "
                            + "WHERE Id = ?");

            st.setString(1, department.getName());
            st.setInt(2, department.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1, id);

            int rows = st.executeUpdate();

            if (rows == 0) {
                throw new DbException("Id inexistente!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department "
                            + "WHERE department.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {

                return instantiateDepartment(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department "
                            + "ORDER BY Name");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();

            while (rs.next()) {
                Department department = instantiateDepartment(rs);
                list.add(department);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        return new Department(
                rs.getInt("Id"),
                rs.getString("Name"));
    }
}
