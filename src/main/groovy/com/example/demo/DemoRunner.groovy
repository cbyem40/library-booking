package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class DemoRunner{

    @Autowired
    LibraryBookingTask task

    @EventListener(ApplicationStartedEvent)
    void run() {
        task.decideWhomToBook()
        task.book()
        task.checkBooking()
        task.cleanup()
    }
}
