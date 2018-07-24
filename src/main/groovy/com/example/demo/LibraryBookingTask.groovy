package com.example.demo

import com.example.demo.entity.User
import com.example.demo.service.intl.LibraryBookingService
import geb.driver.CachingDriverFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class LibraryBookingTask {

    Logger logger = LoggerFactory.getLogger(this.getClass())

    @Value('#{\'${booking.user.name}\'.split(\',\')}')
    List<String> nameList

    @Value('#{\'${booking.user.id}\'.split(\',\')}')
    List<String> idList

    @Value('#{\'${booking.user.birthday}\'.split(\',\')}')
    List<String> birthdayList

    @Value('#{\'${booking.user.email}\'.split(\',\')}')
    List<String> emailList

    def gangsterList =[]
    User bookingGangster

    @PostConstruct
    void init() {
        // put every gangster into the list
        for (def i=0 ; i<nameList.size(); i++){
            User user = new User(nameList.get(i), idList.get(i), birthdayList.get(i), emailList.get(i))
            gangsterList.push(user)
        }
    }

    @Autowired
    LibraryBookingService libraryBookingService

    @Scheduled(cron = "0 58 15 * * MON-SAT")
    void decideWhomToBook () {
        gangsterList.find{ user ->
            int count = libraryBookingService.getBookingCount(user)
            if (count <3) {
                logger.info "Booking gangster is " + user.getName()
                bookingGangster = user
                return true
            }
            return false
        }
    }

    @Scheduled(cron = "0 0 16 * * MON-SAT")
    void book () {
        libraryBookingService.bookMeetingRoom(bookingGangster)
    }

    @Scheduled(cron = "0 2 16 * * MON-SAT")
    void checkBooking () {
        libraryBookingService.getBookingCount(bookingGangster)
    }


    @Scheduled(cron = "0 3 16 * * MON-SAT")
    void cleanup () {
        logger.info "CLEANING UP!"
        CachingDriverFactory.clearCacheAndQuitDriver()
    }

}

