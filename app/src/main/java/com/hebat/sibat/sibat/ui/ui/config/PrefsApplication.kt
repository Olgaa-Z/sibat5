package com.hebat.sibat.sibat.ui.ui.config

import android.app.Application
import android.content.ContextWrapper
import com.pixplicity.easyprefs.library.Prefs


class PrefsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}