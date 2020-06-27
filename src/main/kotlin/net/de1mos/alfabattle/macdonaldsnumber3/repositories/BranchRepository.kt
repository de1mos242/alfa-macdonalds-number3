package net.de1mos.alfabattle.macdonaldsnumber3.repositories

import net.de1mos.alfabattle.macdonaldsnumber3.models.Branch
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface BranchDist {
    val branch: Branch
    val dist: Double
}

@Repository
interface BranchRepository : CrudRepository<Branch, Int> {

    @Query("""
            select br as branch, sqrt(pow(69.1 * (br.lat - :lat), 2) + 
                                pow(69.1 * (:lon - br.lon) * cos(br.lat / 57.3), 2)) as dist 
            from Branch br
            order by dist
            
    """)
    fun findNearest(lat: Float, lon: Float): List<BranchDist>
}