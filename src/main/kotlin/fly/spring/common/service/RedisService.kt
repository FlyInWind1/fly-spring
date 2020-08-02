package fly.spring.common.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate

/**
 * option redis
 */
interface RedisService {

    /**
     * get value of a key
     */
    fun set(key: Any, value: Any)

    /**
     * get value of a key, string force
     */
    fun set(key: String, value: String)

    /**
     * get value of a key with timeout, unit is second
     */
    fun set(key: Any, value: Any, timeout: Long)

    /**
     * get value of a key with timeout, unit is second, string force
     */
    fun set(key: String, value: String, timeout: Long)

    /**
     * delete a key
     */
    fun del(key: Any): Boolean

    /**
     * delete a key
     */
    fun del(key: String): Boolean

    /**
     * delete some keys
     */
    fun del(keys: List<String>): Long

    /**
     * increment
     */
    fun incr(key: Any, delta: Long): Long?

    /**
     * get value of a key
     */
    fun get(key: Any): Any?

    /**
     * get value of a key, string force
     */
    fun get(key: String): String?

    /**
     * set timeout for a key
     */
    fun expire(key: Any, time: Long): Boolean

    /**
     * get timeout of a key
     */
    fun getExpire(key: Any): Long

    /**
     * check key is exist
     */
    fun hasKey(key: Any): Boolean

    /**
     * set value for key in a hash
     */
    fun hSet(key: Any, hashKey: Any, value: Any)

    /**
     * set value for key in a hash
     */
    fun hSet(key: String, hashKey: String, value: String)

    /**
     * get value in a hash by key
     */
    fun hGet(key: Any, hashKey: Any): Any?

    /**
     * get value in a hash by key
     */
    fun hGet(key: String, hashKey: String): String?

    /**
     * return redisTemplate
     */
    fun template(): RedisTemplate<Any, Any>

    /**
     * return stringRedisTemplate
     */
    fun stringTemplate(): StringRedisTemplate
}