package net.de1mos.alfabattle.macdonaldsnumber3.models

import java.sql.Date
import java.sql.Time
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="queue_log")
data class QueueLog(@Id val id: Int,
                    val data: Date,
                    @Column(name = "start_time_to_wait") val startTimeToWait: Time,
                    @Column(name = "end_time_to_wait") val endTimeToWait: Time,
                    @Column(name = "end_time_to_service") val endTimeToService: Time,
                    @Column(name = "branches_id") val branchId: Int?)