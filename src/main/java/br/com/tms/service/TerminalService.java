package br.com.tms.service;

import br.com.tms.controller.domain.model.TerminalModel;
import br.com.tms.service.exception.DataIntegrityException;
import br.com.tms.repository.TerminalRepository;
import br.com.tms.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import org.json.JSONException;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TerminalService {

    private static final Logger LOG = LoggerFactory.getLogger(TerminalService.class);

    @Autowired
    TerminalRepository terminalRepository;

    /**
     *
     * @param jsonSchema
     * @param obj
     * @return
     */
    public boolean validateSchema(JSONObject jsonSchema, JSONObject obj) {

        try {
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(obj);
            return true;
        } catch (ValidationException e) {
            return false;
        }
    }

    /**
     *
     * @param page
     * @param size
     * @return
     */
    public List<TerminalModel> findAll(int page, int size) {
        return terminalRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    /**
     *
     * @param payload
     * @return
     * @throws IOException
     */
    public TerminalModel save(String payload) throws IOException {

        try {
            JsonUtil jsonUtils = new JsonUtil();
            JSONObject jsonObj = jsonUtils.stringToJson(payload.split(";"));
            JSONObject jsonSchema = new JSONObject(new JSONTokener(JSONObject.class.getResourceAsStream("/Schema.json")));
            TerminalModel terminalModel = null;

            if (validateSchema(jsonSchema, jsonObj)) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
                terminalModel = objectMapper.readValue(jsonObj.toString(), TerminalModel.class);

                if (terminalRepository.findById(terminalModel.getLogic()) == null) {
                    terminalRepository.save(terminalModel);
                    return terminalModel;
                } else {
                    throw new DataIntegrityException(Constants.ENTITY_DUPLICATED);
                }
            } else {
                throw new DataIntegrityException(Constants.INVALID_JSON_SCHEMA);
            }

        } catch (IOException | JSONException | NumberFormatException e) {
            LOG.error("ERRO: ", e);
            LOG.error(e.toString());
            throw new DataIntegrityException(Constants.INVALID_PAYLOAD);
        }
    }

    /**
     * Find by id terminal
     *
     * @param logic
     * @return terminal
     */
    public TerminalModel findById(int logic) {
        return terminalRepository.findById(logic);
    }

    /**
     *
     * @param terminalModel
     * @param logic
     * @return
     */
    public TerminalModel update(TerminalModel terminalModel, int logic) {

        TerminalModel terminalmodel = terminalRepository.findById(logic);

        if (terminalmodel == null) {
            throw new DataIntegrityException(Constants.ENTITY_NOT_FOUND);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        try {
            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(terminalModel));
            JSONObject jsonSchema = new JSONObject(new JSONTokener(JSONObject.class.getResourceAsStream("/Schema.json")));
            JSONObject schema = new JSONObject(jsonSchema);

            if (validateSchema(schema, jsonObject)) {
                terminalRepository.save(terminalModel);
                return terminalModel;
            } else {
                throw new DataIntegrityException(Constants.INVALID_JSON_SCHEMA);
            }
        } catch (JsonProcessingException e) {
            LOG.error("ERRO: ", e);
            LOG.error(e.toString());
            throw new DataIntegrityException(Constants.PARSE_ERROR);
        }
    }
}
