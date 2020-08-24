package fly.spring.common.pojo

import fly.spring.common.constant.CommonConstants
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.io.Serializable

/**
 * base response entity
 */
open class R<T> : Serializable {
    var code: Int? = null
    var msg: String? = null
    var data: T? = null

    companion object {
        private const val serialVersionUID = 1L

        fun <T> create(data: T, code: Int, msg: String?): Mono<R<T>> {
            return R<T>().apply {
                this.code = code
                this.msg = msg
                this.data = data
            }.toMono()
        }

        fun <T> ok(): Mono<R<T?>> {
            return create(null, CommonConstants.SUCCESS, null)
        }

        fun <T> ok(data: T): Mono<R<T>> {
            return create(data, CommonConstants.SUCCESS, null)
        }

        fun <T> ok(data: T, msg: String): Mono<R<T>> {
            return create(data, CommonConstants.SUCCESS, msg)
        }

        fun <T> failed(): Mono<R<T?>> {
            return create(null, CommonConstants.FAIL, null)
        }

        fun <T> failed(data: T): Mono<R<T>> {
            return create(data, CommonConstants.FAIL, null)
        }

        fun <T> failed(data: T, msg: String): Mono<R<T>> {
            return create(data, CommonConstants.FAIL, msg)
        }
    }
}