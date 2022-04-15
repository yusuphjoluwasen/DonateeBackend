package com.serverless.utils

import com.zaxxer.hikari.HikariDataSource
import org.koin.core.component.KoinComponent
import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import java.util.*
import java.util.logging.Logger
import javax.sql.DataSource


class DbUtil(private val hikariDataSource: HikariDataSource? = null) : KoinComponent{
    val logger = LoggerFactory.getLogger(DbUtil::class.java)

    private var TX_MANAGER: DataSourceTransactionManager? = null
    private var DATA_SOURCE: DataSource? = null
    private var JDBC_TEMPLATE: JdbcTemplate? = null
    var NAMED_JDBC_TEMPLATE: NamedParameterJdbcTemplate? = null
    var SIMPLE_JDBC_INSERT: SimpleJdbcInsert? = null

    private fun createDataSource(): HikariDataSource {
        val db = getKoin().getProperty<String>("datasource.url")
        logger.info("connection to $db")
            return HikariDataSource().apply {
            jdbcUrl = getKoin().getProperty("datasource.url")
            username = getKoin().getProperty("datasource.username")
            password = getKoin().getProperty("datasource.password")
            connectionTestQuery = getKoin().getProperty("datasource.hikari.connectionTestQuery")
            isAutoCommit = Objects.equals(getKoin().getProperty("datasource.defaultAutoCommit"), "true")
            transactionIsolation = getKoin().getProperty("datasource.hikari.transactionIsolation")
            maximumPoolSize = Integer.valueOf(getKoin().getProperty("datasource.hikari.maximumPoolSize"))
            minimumIdle = Integer.valueOf(getKoin().getProperty("datasource.hikari.minimumIdle"))
            driverClassName = getKoin().getProperty("datasource.driverClassName")
        }
    }

    init {
        DATA_SOURCE = hikariDataSource ?: createDataSource()
        TX_MANAGER = DataSourceTransactionManager(DATA_SOURCE!!)
        JDBC_TEMPLATE = JdbcTemplate(DATA_SOURCE!!)
        NAMED_JDBC_TEMPLATE = NamedParameterJdbcTemplate(DATA_SOURCE!!)
        SIMPLE_JDBC_INSERT = SimpleJdbcInsert(JDBC_TEMPLATE!!)
    }
}