package br.com.Stressly.data.datasource

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class RegistroDiarioRealm : RealmObject {
    @PrimaryKey
    var id: String = ""
    var data: String = "" // salvar como ISO-8601 (ex: "2025-05-22")
    var emoji: String = ""
    var estadoEmocional: String = ""
    var cargaTrabalho: String = ""
}
