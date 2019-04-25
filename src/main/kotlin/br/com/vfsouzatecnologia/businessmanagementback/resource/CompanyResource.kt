package br.com.vfsouzatecnologia.businessmanagementback.resource

import br.com.vfsouzatecnologia.businessmanagementback.data.Company
import br.com.vfsouzatecnologia.businessmanagementback.repository.CompanyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

/**
 * @author vinicius
 * @since 24/04/19 12:51
 * @version : $<br/>
 *          : $
 *
 */
@RestController
@RequestMapping("/company")
class CompanyResource(
        private val companyRepository: CompanyRepository) {

    @GetMapping
    fun findAll() = companyRepository.findAll()

    @GetMapping("/{cnpj}")
    fun findByCnpj(@PathVariable cnpj: String): Company =
            companyRepository.findByIdOrNull(cnpj) ?: throw IllegalArgumentException("Company not found")

    @PostMapping
    fun addCompany(@RequestBody company: Company): Company =
            companyRepository.save(company)

    @DeleteMapping("/{cnpj}")
    fun delCompany(@PathVariable cnpj: String) =
            companyRepository.deleteById(cnpj)
}