package com.example.demo.service.intl

import com.example.demo.entity.User
import org.springframework.stereotype.Service

@Service
interface LibraryBookingService {
    int getBookingCount (User user)
    void bookMeetingRoom (User user)
}
