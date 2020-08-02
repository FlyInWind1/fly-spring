package fly.spring.common.service.impl

import fly.spring.common.service.RedisService
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisServiceImpl(
        private val template: RedisTemplate<Any, Any>,
        private val stringTemplate: StringRedisTemplate
) : RedisService {

    override fun set(key: Any, value: Any) {
        template.opsForValue().set(key, value)
    }

    override fun set(key: String, value: String) {
        stringTemplate.opsForValue().set(key, value)
    }

    override fun set(key: Any, value: Any, timeout: Long) {
        template.opsForValue().set(key, value, timeout, TimeUnit.SECONDS)
    }

    override fun set(key: String, value: String, timeout: Long) {
        stringTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS)
    }

    override fun del(key: Any): Boolean {
        return template.delete(key)
    }

    override fun del(key: String): Boolean {
        return stringTemplate.delete(key)
    }

    override fun del(keys: List<String>): Long {
        return stringTemplate.delete(keys)
    }

    override fun incr(key: Any, incr: Long): Long? {
        return template.opsForValue().increment(key, incr)
    }

    override fun get(key: Any): Any? {
        return template.opsForValue().get(key)
    }

    override fun get(key: String): String? {
        return stringTemplate.opsForValue().get(key)
    }

    override fun expire(key: Any, time: Long): Boolean {
        return template.expire(key, time, TimeUnit.SECONDS)
    }

    override fun getExpire(key: Any): Long {
        return template.getExpire(key)
    }

    override fun hasKey(key: Any): Boolean {
        return template.hasKey(key)
    }

    override fun hSet(key: Any, hashKey: Any, value: Any) {
        template.opsForHash<Any, Any>().put(key, hashKey, value)
    }

    override fun hSet(key: String, hashKey: String, value: String) {
        stringTemplate.opsForHash<String, String>().put(key, hashKey, value)
    }

    override fun hGet(key: Any, hashKey: Any): Any? {
        return template.opsForHash<Any, Any>().get(key, hashKey)
    }

    override fun hGet(key: String, hashKey: String): String? {
        return stringTemplate.opsForHash<String, String>().get(key, hashKey)
    }

    override fun template(): RedisTemplate<Any, Any> {
        return template
    }

    override fun stringTemplate(): StringRedisTemplate {
        return stringTemplate
    }
}