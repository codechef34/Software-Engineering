package com.util.sql;

import java.awt.Font;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.*;
import java.util.*;
import java.sql.*;

/**
 * @author
 */
public class GetDbtables {

    private JTextArea output = null;

    public GetDbtables(JTextArea output) {
        this.output = output;
    }

    public static ArrayList<String> getListofTables() {
        DatabaseMetaData md = null;
        ResultSet rs = null;
        ArrayList<String> tables = null;
        try {
            md = DBconnection.getConnection().getMetaData();
            rs = md.getTables(null, null, "%", null);
            tables = new ArrayList<String>();
            while (rs.next()) {
                tables.add(rs.getString(3));
                //getTableData(rs.getString(3));
            }

        } catch (SQLException sqle) {

        } finally {
            DBconnection.closeCon();
            closeAll(rs, null, null);
        }
        return tables;
    }

    public void getTableData(String tableName) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select * from " + tableName;
            stmt = DBconnection.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<String> columnsdata = getColumnNames(rs);
            Font font = null;
            if (output != null) {
                output.setText("");
                font = output.getFont();
                output.setFont(font.deriveFont(Font.BOLD));
            }

            for (int i = 0; i < columnsdata.size(); i++) {
                if (output != null) {
                    output.append("" + columnsdata.get(i) + "\t\t\t");
                }
            }
            if (output != null) {
                output.setFont(font.deriveFont(Font.PLAIN));
            }

            while (rs.next()) {
                if (output != null) {
                    output.append("\n");
                }
                for (int i = 1; i <= columnsdata.size(); i++) {
                    // System.out.println(""+rs.getString(i));
                    if (output != null) {
                        output.append("" + rs.getString(i)+"\t\t\t");
                    }
                }
            }
        } catch (SQLException sqle) {

        } finally {
            DBconnection.closeCon();
            closeAll(rs, null, stmt);
        }
    }

    public static ArrayList<String> getColumnNames(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        ArrayList<String> columnNames = new ArrayList<String>();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
        for (int i = 1; i < numberOfColumns + 1; i++) {
            String columnName = rsMetaData.getColumnName(i);
            columnNames.add(rsMetaData.getColumnName(i));
     // String tableName = rsMetaData.getTableName(i);
            //System.out.println("column name=" + columnName + " table=" + tableName + "");
        }

        return columnNames;
    }

    public static void closeAll(ResultSet rs, PreparedStatement ps, Statement st) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (st != null) {
                st.close();
                st = null;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public static void main(String[] args) {
        getListofTables();
    }
}
