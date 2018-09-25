package com.futurice.freesound.mvi

import timber.log.Timber

class Logger {

    fun log(tag: String, logEvent: LogEvent) {
        when (logEvent) {
            is LogEvent.Event -> Timber.d("MVI|$tag| Event => $logEvent")
            is LogEvent.Action -> Timber.d("MVI|$tag| Action => $logEvent")
            is LogEvent.Result -> Timber.d("MVI|$tag| Result => $logEvent")
            is LogEvent.Reduce -> Timber.d("MVI|$tag| Reduce => $logEvent")
            is LogEvent.State -> Timber.d("MVI|$tag| State => $logEvent")
            is LogEvent.Error -> Timber.d("MVI|$tag| Error => $logEvent")
        }
    }
}

sealed class LogEvent {
    data class Event(val event: com.futurice.freesound.mvi.Event) : LogEvent()
    data class Action(val action: com.futurice.freesound.mvi.Action) : LogEvent()
    data class Result(val result: com.futurice.freesound.mvi.Result) : LogEvent()
    data class Reduce(val result: com.futurice.freesound.mvi.Result, val prevState: com.futurice.freesound.mvi.State) : LogEvent()
    data class State(val state: com.futurice.freesound.mvi.State) : LogEvent()
    data class Error(val t: Throwable) : LogEvent()
}