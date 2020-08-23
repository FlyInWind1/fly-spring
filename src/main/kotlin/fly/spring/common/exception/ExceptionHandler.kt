package fly.spring.common.exception

import com.fasterxml.jackson.core.JsonParseException
import fly.spring.common.pojo.R
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class ExceptionHandler {
    companion object {
        val log = KotlinLogging.logger { }
    }

    @ExceptionHandler(JsonParseException::class, org.springframework.boot.json.JsonParseException::class)
    fun jsonParseException(exception: Exception): Mono<R<String?>> {
        log.warn(exception.message, exception)
        return R.failed(exception.message)
    }

    @ExceptionHandler(Exception::class)
    fun exception(exception: Exception): Mono<R<String?>> {
        log.warn(exception.message, exception)
        return R.failed(exception.message)
    }
}