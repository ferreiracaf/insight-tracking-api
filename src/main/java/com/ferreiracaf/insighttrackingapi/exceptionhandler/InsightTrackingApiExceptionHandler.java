package com.ferreiracaf.insighttrackingapi.exceptionhandler;

import com.ferreiracaf.insighttrackingapi.service.exception.RecursoInexistenteException;
import com.ferreiracaf.insighttrackingapi.service.exception.UsuarioJaExistenteException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class InsightTrackingApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String msgUsr = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String msgDev = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
        List<Erro> erros = Arrays.asList(new Erro(msgUsr, msgDev));
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
//        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = criarListaDeErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers, status, request);
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
        String msgUsr = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List <Erro> erros = Arrays.asList(new Erro(msgUsr, msgDev));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({UsuarioJaExistenteException.class})
    public ResponseEntity<Object> handleUsuarioJaExistenteException(UsuarioJaExistenteException ex){
        String msgUsr = messageSource.getMessage("usuario.ja-existente", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List <InsightTrackingApiExceptionHandler.Erro> erros = Arrays.asList(new InsightTrackingApiExceptionHandler.Erro(msgUsr, msgDev));
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler({RecursoInexistenteException.class})
    public ResponseEntity<Object> handleUsuarioInexistenteException(RecursoInexistenteException ex){
        String msgUsr = messageSource.getMessage("recurso.inexistente", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List <InsightTrackingApiExceptionHandler.Erro> erros = Arrays.asList(new InsightTrackingApiExceptionHandler.Erro(msgUsr, msgDev));
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
    public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, WebRequest request) {

        String userMessage = messageSource.getMessage("mensagem.violacao-de-integridade", null, LocaleContextHolder.getLocale());
        String developerMessage = ExceptionUtils.getRootCauseMessage(ex);

        List<Erro> errors = Arrays.asList(new Erro(userMessage, developerMessage));

        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {

        String userMessage = messageSource.getMessage("recurso.operacao-nao-permitida", null, LocaleContextHolder.getLocale());
        String developerMessage = ExceptionUtils.getRootCauseMessage(ex);

        List<Erro> erros = Arrays.asList(new Erro(userMessage, developerMessage));

        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private List<Erro> criarListaDeErros(BindingResult bindingResult) {
        List<Erro> erros = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()){
            String msgUsr = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String msgDev = fieldError.toString();
            erros.add(new Erro(msgUsr, msgDev));
        }
        return erros;
    }

    public static class Erro{
        private String msgUsr;
        private String msgDev;

        public Erro(String msgUsr, String msgDev) {
            this.msgUsr = msgUsr;
            this.msgDev = msgDev;
        }

        public String getMsgUsr() {
            return msgUsr;
        }

        public String getMsgDev() {
            return msgDev;
        }
    }
}
