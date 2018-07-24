package com.example.demo.service.impl

import com.example.demo.entity.User
import com.example.demo.service.intl.LibraryBookingService
import geb.Browser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class DefaultLibraryBookingService implements LibraryBookingService {

    Logger logger = LoggerFactory.getLogger(this.getClass())

    @Value('${target.url:defaultUrl}')
    String targetUrl

    @Value('${target.booking.floor:2}')
    String bookingFloor

    @Value('${debug.mode:true}')
    Boolean debugMode

    @Override
    int getBookingCount(User user) {
        def bookingCount = 0
        logger.info "Checking user:" + user.getName() + "'s booking."
        try{
            Browser.drive {
                logger.info "Going to " + targetUrl
                go targetUrl
                Thread.sleep 500
                js.group_search()

                // 輸入帳號密碼
                Thread.sleep 500
                $("input", name: "userid").value(user.getId())
                $("input", name: "userpw").value(user.getBirthday())
                $("input", name: "usermail").value(user.getEmail())
                js.group_step3('4', '4')

                Thread.sleep 2000

                def rows = $("table table").find("td")
                def booking
                rows.dropRight(3).each{
                    if (it.text().trim() != ""){
                        booking = booking + " " + it.text()
                    }else{
                        logger.info booking
                        booking = ""
                        bookingCount ++
                    }
                }
                logger.info user.getName() + " booked: " + bookingCount + " slots."
            }
        } catch(Exception e) {
            logger.info e.message
            logger.error e.printStackTrace()
        }
        return bookingCount
    }

    @Override
    void bookMeetingRoom(User user) {
        try {
            Browser.drive {
                logger.info "Start booking task by user: " + user.getName()
                logger.info "Start time: " + LocalDateTime.now()

                logger.info "Going to " + targetUrl
                go targetUrl
                Thread.sleep(500)
                js.group_booking()
                Thread.sleep(500)
                js.group_step2()

                // input necessary information 
                Thread.sleep(500)
                $("input", name: "userid").value(user.getId())
                $("input", name: "userpw").value(user.getBirthday())
                $("input", name: "usermail").value(user.getEmail())
                js.group_step3('4', '1')

                // Choose second floor 
                Thread.sleep(2000)

                logger.info "Choosing meeting room..."
                $("td", 1).click()

                def rooms = $("table").find('a')
                (bookingFloor.toInteger() == 2) ? rooms.getAt(0).click() : rooms.getAt(1).click()

                // Choose the time slots 
                Thread.sleep(2000)

                logger.info bookingFloor + "F Meeting Room is available at : "
                def table = $("table")
                def availableSlots = []
                table.find('input[name=checkbox]').each{
                    logger.info it.attr("value")
                    availableSlots.push(it)
                }

                /**
                 * Sample: 2018-07-21 09:00~2018-07-21 12:00~2
                 * parse the available slot and book it if it weekday and it's from 9:00~12:00 or 13:00~16:00
                 */
                def bookingSlots = []
                availableSlots.each{
                    def slot = it.attr("value")
                    def dayOfWeek = LocalDate.parse(slot.split(" ").getAt(0)).getDayOfWeek()
                    def time = slot.reverse().take(1).reverse()

                    if ( dayOfWeek !=  DayOfWeek.SATURDAY && dayOfWeek !=  DayOfWeek.SUNDAY && time != 6.toString()){
                        // the available slot is in the day time during the week
                        logger.info "Going to Book: " + slot
                        it.click()
                        bookingSlots.add(slot)
                        Thread.sleep(200)
                    }
                }

                if (bookingSlots.size() >0) {
                    debugMode? logger.info("Skip booking"): js.group_step5('5', '2')
                }else
                    logger.info "BAD NEWS! No available meeting room...! :'("
                logger.info "Booking task finished at: " + LocalDateTime.now()
            }
        } catch (Exception e) {
            logger.info e.message
            logger.error e.printStackTrace()
        }
    }
}
