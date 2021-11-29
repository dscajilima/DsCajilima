package com.AppScooter.model

import javax.persistence.*

@Entity
@Table(name = "sistem")

class App {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var scooter: String? = null
    var distancia: String? = null
}