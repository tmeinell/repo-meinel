package br.com.tms.resource;

import br.com.tms.controller.domain.model.TerminalModel;
import br.com.tms.service.exception.DataIntegrityException;
import br.com.tms.service.TerminalService;
import br.com.tms.util.Constants;
import br.com.tms.util.ResponseEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "TERMINAL API")
public class TerminalResource {

    @Autowired
    TerminalService terminalService;

    @GetMapping(value = {"/terminais"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(Constants.API_GET_ALL)
    public @ResponseBody ResponseEntity<?> getAll(@RequestParam("size") int size, @RequestParam("page") int page) {
        return ResponseEntityUtil.defaultResponse(terminalService.findAll(page, size), false);
    }

    @PostMapping(value = {"/terminais"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(Constants.API_CREATE)
    public @ResponseBody ResponseEntity<?> create(@Valid @RequestBody @NotNull String body) throws IOException {
        return ResponseEntityUtil.defaultResponse(terminalService.save(body), true);
    }

    @GetMapping(value = {"/terminais/{logic}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(Constants.API_GET)
    public @ResponseBody ResponseEntity<?> findAllByLogic(@PathVariable("logic") int logic) {
        return ResponseEntityUtil.defaultResponse(terminalService.findAllById(logic), false);
    }

    @PutMapping(value = {"/terminais/{logic}"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(Constants.API_UPDATE)
    public @ResponseBody ResponseEntity<?> update(@RequestBody @Valid @NotNull TerminalModel terminalModel, @PathVariable("logic") int logic) {
        return ResponseEntityUtil.defaultResponse(terminalService.update(terminalModel, logic), false);
    }
}
