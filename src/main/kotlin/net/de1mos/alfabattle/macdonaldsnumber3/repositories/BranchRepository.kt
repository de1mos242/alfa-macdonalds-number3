package net.de1mos.alfabattle.macdonaldsnumber3.repositories

import net.de1mos.alfabattle.macdonaldsnumber3.models.Branch
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BranchRepository : CrudRepository<Branch, Int> {
}