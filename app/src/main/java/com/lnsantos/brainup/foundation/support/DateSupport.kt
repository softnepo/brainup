package com.lnsantos.brainup.foundation.support

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class DateSupport @Inject constructor() {

    companion object {
        const val PATTERN_ISO8610 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        const val DEFAULT_TIMEZONE = "UTC"
    }

    fun createDateInISO8610(): String {
        val format = SimpleDateFormat(PATTERN_ISO8610, Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone(DEFAULT_TIMEZONE)
        }
        return format.format(Date())
    }

}
