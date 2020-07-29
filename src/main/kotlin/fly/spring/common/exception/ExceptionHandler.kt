package fly.spring.common.exception

import com.fasterxml.jackson.core.JsonParseException
import fly.spring.common.core.pojo.R
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(JsonParseException::class, org.springframework.boot.json.JsonParseException::class)
    fun jsonParseException(exception: Exception): R<String> {
        return R.failed(exception.message)
    }

    @ExceptionHandler(Exception::class)
    fun exception(exception: Exception): R<String> {
        return R.failed(exception.message)
    }
}