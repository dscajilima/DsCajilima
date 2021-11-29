package com.AppScooter.model

import javax.persistence.*

@Entity
@Table(name = "usuarios")

class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var CI:  String? = null
    var usuario: String? = null
}