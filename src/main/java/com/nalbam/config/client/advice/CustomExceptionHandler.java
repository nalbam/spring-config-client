package com.nalbam.config.client.advice;

import com.nalbam.common.result.ResultModel;
import com.nalbam.common.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException", ex);

        final List<Map<String, Object>> errors = ResultUtil.getErrors(ex.getBindingResult());

        final ResultModel body = new ResultModel(HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다.", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(final HttpMessageNotReadableException ex) {
        log.error("HttpMessageNotReadableException", ex);

        final ResultModel body = new ResultModel(HttpStatus.BAD_REQUEST, "메시지 본문을 읽을 수 없습니다. 입력값 또는 형식을 확인해 주세요.");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex) {
        log.error("MethodArguemntTypeMismatchException", ex);

        final ResultModel body = new ResultModel(HttpStatus.BAD_REQUEST, String.format("'%s' 필드의 타입이 올바르지 않습니다.", ex.getName()));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Object> handleHttpMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException ex) {
        log.error("HttpMediaTypeNotSupportedException", ex);

        final ResultModel body = new ResultModel(HttpStatus.UNSUPPORTED_MEDIA_TYPE, String.format("지원하지 않는 content type : %s.", ex.getContentType()));
        return new ResponseEntity<>(body, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

}
