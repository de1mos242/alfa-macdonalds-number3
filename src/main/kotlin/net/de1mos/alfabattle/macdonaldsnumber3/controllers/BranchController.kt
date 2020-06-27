package net.de1mos.alfabattle.macdonaldsnumber3.controllers

import net.de1mos.alfabattle.macdonaldsnumber3.repositories.BranchRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class GetBranchByIdResponse(val id: Int, val title: String?, val lon: Float?, val lat: Float?, val address: String?)
data class NotFoundResponse(val status: String)

@RestController
@RequestMapping("/branches")
class BranchController(private val branchRepository: BranchRepository) {

    @GetMapping("/{branchId}")
    fun getBranchById(@PathVariable("branchId") branchId: Int): ResponseEntity<Any> {
        val branch = branchRepository.findById(branchId)
        return when {
            branch.isPresent -> ResponseEntity.ok(branch.map { GetBranchByIdResponse(it.id, it.title, it.lon, it.lat, it.address) })
            else -> ResponseEntity(NotFoundResponse("branch not found"), HttpStatus.NOT_FOUND)
        }
    }
}