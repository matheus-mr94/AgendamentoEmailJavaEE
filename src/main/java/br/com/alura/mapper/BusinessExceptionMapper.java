package br.com.alura.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.alura.dto.MensagemErroDTO;
import br.com.alura.exception.BusinessException;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

	@Override
	public Response toResponse(BusinessException exception) {
		return Response
	            .status(Response.Status.BAD_REQUEST)
	            .entity(MensagemErroDTO.build(exception.getMensagens()))
	            .build();
	}
}
