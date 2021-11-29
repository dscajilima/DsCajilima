package com.AppScooter.model

import javax.persistence.*

@Entity
@Table(name = "scooter")

class Scooter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var habilitado: String? = null
    var unidad: String? = null
}