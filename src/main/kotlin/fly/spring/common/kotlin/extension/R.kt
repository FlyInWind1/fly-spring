package fly.spring.common.kotlin.extension

import fly.spring.common.pojo.R
import reactor.core.publisher.Mono

fun <T> T.rok(): Mono<R<T>> = R.ok(this)

fun <T> T.rok(msg: String): Mono<R<T>> = R.ok(this, msg)