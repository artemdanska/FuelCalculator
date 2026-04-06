package util;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class LocalizationService {

    private Map<String, String> strings = new HashMap<>();

    public void loadStrings(String language) {
        strings.clear();

        String sql = "SELECT `key`, value FROM localization_strings WHERE language = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, language);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                strings.put(rs.getString("key"), rs.getString("value"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getString(String key) {
        return strings.getOrDefault(key, key);
    }
}
