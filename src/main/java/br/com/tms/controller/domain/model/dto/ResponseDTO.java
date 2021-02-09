package br.com.tms.controller.domain.model.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ResponseDTO {
	
	private int status;
	private HttpStatus msg;
	private Object response;

	public ResponseDTO(HttpStatus httpStatus, Object objeto) {
		this.msg = httpStatus;
		this.status = httpStatus.value();
		this.response = objeto;

		if (objeto == null || objeto.toString().equals("[]")) {
			this.msg = HttpStatus.NOT_FOUND;
			this.status = HttpStatus.NOT_FOUND.value();
			this.response = "Nenhum registro encontrato.";
		}
	}

	public ResponseDTO(HttpStatus httpStatus) {
		this.msg = httpStatus;
		this.status = httpStatus.value();
	}
	
	public Object getResponse() {
		return response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HttpStatus getMsg() {
		return msg;
	}

	public void setMsg(HttpStatus msg) {
		this.msg = msg;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}