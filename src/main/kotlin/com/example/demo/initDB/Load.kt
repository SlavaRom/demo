package com.example.demo.initDB

import com.example.demo.entity.Feedback
import com.example.demo.repository.FeedbackRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
internal class Load {
    @Bean
    fun initDatabase(repository: FeedbackRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            log.info("Preloading " + repository.save(
                    Feedback("1",
                            "test message")))
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(Load::class.java)
    }
}
