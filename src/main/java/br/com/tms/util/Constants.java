package br.com.tms.util;

public interface Constants {

    //API DESCRIPTION
    public static final String API_CREATE = "Creates a new terminal entity";
    public static final String API_UPDATE = "Updates an existing terminal entity";
    public static final String API_GET_ALL = "Get all terminal entities";
    public static final String API_GET = "Get a terminal entity by logic attribute";

    //ERROR
    public static final String ENTITY_DUPLICATED = "An entity with the same logic attribute already exists";
    public static final String ENTITY_NOT_FOUND = "An entity with this attribute <logic> cannot be found";
    public static final String PARSE_ERROR = "invalid payload, wrong format";
    public static final String UNKNOWN = "unknown error";
    public static final String INVALID_PAYLOAD = "invalid payload, wrong format";
    public static final String INVALID_JSON_SCHEMA = "your payload doesn't match the json schema";

}
