package net.de1mos.alfabattle.macdonaldsnumber3.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "branches")
data class Branch(@Id val id: Int,
                  val title: String?,
                  val lon: Float?,
                  val lat: Float?,
                  val address: String?) {
}