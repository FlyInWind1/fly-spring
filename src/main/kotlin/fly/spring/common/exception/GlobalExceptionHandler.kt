package fly.spring.common.exception

import com.fasterxml.jackson.core.JsonParseException
import fly.spring.common.pojo.R
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class GlobalExceptionHandler {
    companion object {
        val log = KotlinLogging.logger { }
    }

    @ExceptionHandler(JsonParseException::class, org.springframework.boot.json.JsonParseException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun jsonParseException(exception: Exception): Mono<R<String?>> {
        log.warn("JsonParse exception:\n {}", exception.message, exception)
        return R.failed(exception.message)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun exception(exception: Exception): Mono<R<String?>> {
        log.warn("Global exception:\n {}", exception.message, exception)
        return R.failed(exception.message)
    }
}