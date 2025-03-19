package br.developermobile.application;

import br.developermobile.db.DB;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;

public class Program {
    public static void main(String[] args) throws IOException {
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}