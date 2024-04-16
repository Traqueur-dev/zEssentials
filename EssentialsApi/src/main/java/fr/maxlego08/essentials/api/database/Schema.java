package fr.maxlego08.essentials.api.database;

import fr.maxlego08.essentials.api.storage.DatabaseConfiguration;
import org.bukkit.Location;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public interface Schema {
    Schema uuid(String columnName);

    Schema uuid(String columnName, UUID value);

    Schema string(String columnName, int length);

    Schema text(String columnName);

    Schema longText(String columnName);

    Schema decimal(String columnName);

    Schema decimal(String columnName, int length, int decimal);

    Schema string(String columnName, String value);

    Schema decimal(String columnName, Number value);

    Schema date(String columnName, Date value);

    Schema bigInt(String columnName);
    Schema integer(String columnName);

    Schema bigInt(String columnName, long value);

    Schema bool(String columnName);

    Schema bool(String columnName, boolean value);

    Schema primary();

    Schema foreignKey(String referenceTable);
    Schema foreignKey(String referenceTable, String columnName, boolean onCascade);

    Schema createdAt();

    Schema updatedAt();

    Schema timestamps();

    Schema timestamp(String columnName);

    Schema autoIncrement(String columnName);

    Schema nullable();

    Schema defaultValue(String value);

    Schema location(String columnName, Location location);
    
    Schema where(String columnName, Object value);

    Schema where(String columnName, UUID value);

    Schema where(String columnName, String operator, Object value);

    void execute(Connection connection, DatabaseConfiguration databaseConfiguration, Logger logger) throws SQLException;

    List<Map<String, Object>> executeSelect(Connection connection, DatabaseConfiguration databaseConfiguration, Logger logger) throws SQLException;

    long executeSelectCount(Connection connection, DatabaseConfiguration databaseConfiguration, Logger logger) throws SQLException;

    <T> List<T> executeSelect(Class<T> clazz, Connection connection, DatabaseConfiguration databaseConfiguration, Logger logger) throws Exception;

    Migration getMigration();

}

