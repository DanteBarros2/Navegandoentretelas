package br.com.Stressly

import android.app.Application
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import br.com.Stressly.data.datasource.RegistroDiarioRealm

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val config = RealmConfiguration.Builder(
            schema = setOf(RegistroDiarioRealm::class)
        )
            .name("registro.realm")
            .schemaVersion(1)
            .build()

        realm = Realm.open(config)
    }

    companion object {
        lateinit var realm: Realm
    }
}
